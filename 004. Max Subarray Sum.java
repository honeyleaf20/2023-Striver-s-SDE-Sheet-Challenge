4. Max Subarray Sum

public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
		if(n==0)return 0;
        long max= Long.MIN_VALUE, sum = 0;
        
        for(int i=0;i<n;i++){
            sum += arr[i];
            max = Math.max(sum,max);
            
            if(sum<0) sum = 0;
        }
        if(max<=0)return 0;
        return max;
	}
