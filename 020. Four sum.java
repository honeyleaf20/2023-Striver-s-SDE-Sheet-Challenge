20. Four sum

 public static String fourSum(int[] arr, int target, int n) {
      // Write your code here.
      Arrays.sort(arr);
      for(int i =0;i<n-3;i++){
            for(int j =i+1;j<n-2;j++){
                for (int k = j + 1, l = n - 1; k < l;){
                   if (arr[i] + arr[j] + arr[k] + arr[l] == target)
                    return "Yes";
                    else if (arr[i] + arr[j] + arr[k] + arr[l] > target)
                     l--;
                    else k++;
                }
                
            }
      }
      return "No";
  }
