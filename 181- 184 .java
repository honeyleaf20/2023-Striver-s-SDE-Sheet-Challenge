//181. Rod Cutting Problem

public static int cutRod(int price[], int n){

         int prev[]=new int[n+1];

         for(int i=0; i<=n; i++){

            prev[i]=i*price[0];

        }

        for(int ind=1; ind<n; ind++){

            for(int length=0; length<=n; length++){

                int notTake=0+prev[length];

                int take=Integer.MIN_VALUE;

                int rodLength=ind+1;

                if(rodLength<=length){

                    take=price[ind]+prev[length-rodLength];

                }

                prev[length]=Math.max(notTake,take);   

            }

        }

         return prev[n];

     }

   

//182. Cut Logs

   public static int cutLogs(int k, int n) {
        
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return memoization(k, n, dp);
    }
    public static int memoization(int e, int f, int[][] dp) {
        
        if (f <= 1 || e == 1) {
            return f;
        }

        if (dp[e][f] != -1) {
            return dp[e][f];
        }
        int ans = Integer.MAX_VALUE;
        int start = 1, end = f;
        while (start <= end) {
            int mid = (start + end) / 2;

            int BREAK = memoization(e - 1, mid - 1, dp);
            int SURVIVE = memoization(e, f - mid, dp);
            ans = Math.min(ans, 1 + Math.max(BREAK, SURVIVE));

            if (BREAK < SURVIVE) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        dp[e][f] = ans;
        return ans;
    }

//183. Word Break

   public static Boolean wordBreak(String[] arr, int n, String target) {
        int i = 0;
        while(i < n){
            if(target.contains(arr[i])){
                target = target.replace(arr[i], "");
                i = 0;
            }
            else{
                i++;
            }
        }
        return target.isEmpty();
    }

//184. Palindrome Partitioning ll

public static int palindromePartitioning(String str) {
       int[][] dp=new int[str.length()][str.length()];
       for(int[] row:dp){
           Arrays.fill(row,-1);
       }
    return func(str,0,str.length()-1,dp);
}
   private static int func(String s,int i,int j,int[][] dp){
       if(i>=j) return 0;
       if(isPalindrome(s,i,j)) return 0;
       if(dp[i][j]!=-1) return dp[i][j];
       int mini=Integer.MAX_VALUE;
       
       for(int k=i;k<=j-1;k++){
           int temp=1+func(s,i,k,dp)+func(s,k+1,j,dp);
            mini=Math.min(temp,mini);
       }
       dp[i][j]=mini;
       return mini;
   }
   private static boolean isPalindrome(String s,int i,int j){
       while(i<j){
           if(s.charAt(i)==s.charAt(j)){
               i++;
               j--;
           }else {
               return false;
           }
       }
       return true;
   }

