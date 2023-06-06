16. Majority Element II

public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        // Write your code here.
        int[] nums = new int[arr.size()];
         for (int i = 0; i < arr.size(); i++)
            nums[i] = arr.get(i);
        Arrays.sort(nums);
        ArrayList<Integer> l= new ArrayList<>();
        int count=1, i=1;
        for( i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1])count++;
            else{
                if(count>nums.length/3)l.add(nums[i-1]);
                count=1;
            }
        }
        if(count>nums.length/3)l.add(nums[i-1]);
        return l;
            
    }