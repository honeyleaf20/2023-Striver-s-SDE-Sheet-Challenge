11. Missing and Repeating numbers

public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        int[] res= new int[2];
        for (int i = 0; i < arr.size(); i++) {
            int abs_val = Math.abs(arr.get(i));
            if (arr.get(abs_val - 1) > 0)
                arr.set(abs_val - 1, -arr.get(abs_val - 1)) ;
            else
                res[1]=abs_val;
        }
 
        
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0)
                res[0]=i+1;
        }
    return res;

    }
