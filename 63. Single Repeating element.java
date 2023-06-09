63. Single Repeating element

public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        //    Write your code here.
         int ans = 0;       
          for(int i = 0; i < arr.size(); i++) 
                ans ^= arr.get(i);               
            return ans;
    }