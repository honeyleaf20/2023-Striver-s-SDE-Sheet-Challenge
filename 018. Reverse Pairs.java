18. Reverse Pairs

 public static int reversePairs(ArrayList<Integer> nums) 
    {
        // Write your code here.
         
            if (nums == null || nums.size()< 2) return 0;
        return mergesort(nums, 0, nums.size()-1);
    }
	
	private static int mergesort(ArrayList<Integer> nums, int low, int high){
		if (low >= high) return 0;
		int mid = low + (high - low) / 2;
		int count = mergesort(nums, low, mid) + mergesort(nums, mid+1, high);
		for (int i = low, j = mid+1; i <= mid && j <= high;){
			if (nums.get(i) > (long) nums.get(j)* 2){
                count += mid - i + 1;
                j++;
            }
            else i++;
		}
		
		merge(nums, low, high);
		return count;
	}
	
	private static void merge(ArrayList<Integer> nums, int low, int high){
		int mid = low + (high - low) / 2;
		int[] arr = new int[high - low + 1];
		
		int i = low, j = mid + 1, k = 0;
		while (k < arr.length){
			int num1 = i > mid ? Integer.MAX_VALUE : nums.get(i);
			int num2 = j > high ? Integer.MAX_VALUE : nums.get(j);
			
			arr[k++] = num1 <= num2 ? nums.get(i++): nums.get(j++);
		}
		
		for (int p = 0; p < arr.length; p++) nums.set(p+low, arr[p]);
	  
            
    }
