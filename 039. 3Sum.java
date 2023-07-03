39. 3Sum

public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {

	    // Write your code here.
		Arrays.sort(arr);

        HashSet<ArrayList<Integer>>map=new HashSet<>();

        for(int i=0;i<n;i++)

        {

            int left=i+1;

            int right=n-1;

            int sum=K-arr[i];

            while(left<right)

            {

                if((arr[left]+arr[right])==sum)

                {

                    ArrayList<Integer>one=new ArrayList<>();

                    one.add(arr[i]);

                    one.add(arr[left]);

                    one.add(arr[right]);

                    map.add(one);

                    left++;

                }

                else if((arr[left]+arr[right])<sum)

                {

                    left++;

                }

                else if((arr[left]+arr[right])>sum)

                {

                    right--;

                }

            }

        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        ans.addAll(map);

        return ans;

	}
