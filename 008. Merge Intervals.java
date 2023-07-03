8. Merge Intervals

class IntervalComparator implements Comparator<Interval> {
     public int compare(Interval s1, Interval s2)

    {
      if (s1.start == s2.start)return 0;

        else if (s1.start > s2.start)return 1;

        else return -1;

    }

}
public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
		Arrays.sort(intervals,new IntervalComparator());;

        List<Interval> l= new ArrayList<>();
        l.add(new Interval(intervals[0].start,intervals[0].finish));

        int j=0;

        for(int i=1;i<intervals.length;i++){

            if(l.get(j).finish>=intervals[i].start){

                int maxfin=Math.max(l.get(j).finish,intervals[i].finish);

                int minstart=l.get(j).start;

                l.set(j,new Interval(minstart,maxfin));

            }else{

                l.add(new Interval(intervals[i].start,intervals[i].finish));

                j++;

            }

        }

        return l;

    }

    }
