//171.Maximum Product Subarray

public static int maximumProduct(ArrayList<Integer> arr, int n) {
		int prod1 = arr.get(0),prod2 = arr.get(0),result = arr.get(0);
        for(int i = 1 ; i < n ; i++ ){
        int temp = Math.max(arr.get(i),Math.max(prod1*arr.get(i),prod2*arr.get(i)));
       prod2 = Math.min(arr.get(i),Math.min(prod1*arr.get(i),prod2*arr.get(i)));
            prod1 = temp;
            result = Math.max(result,prod1);
        }

        return result;
	}



//172.  Longest Increasing Subsequence

 public static int longestIncreasingSubsequence(int arr[]){

        int n = arr.length;

        ArrayList<Integer> ans = new ArrayList<>();

    ans.add(arr[0]);

    int len = 1;

    for(int i = 1; i < n; i++)

    {

       if(ans.get(len-1) < arr[i])

       {

           ans.add(arr[i]);

           len++;

       }

       else

       {

           int ind = Collections.binarySearch(ans,arr[i]);

           if(ind < 0)

           {

               int realInd = (ind+1)*(-1);

               if( realInd > (len-1)  )

               {

                   ans.add(arr[i]);

                   len++;

               }

               else

               {

                   ans.set(realInd , arr[i]);

               }

            }

       }

    }

    return len;

    }

   

       

//173.Longest Common Subsequence

 public static int lcs(String s, String t) {

        //Your code goes here

        int m=s.length();

        int n=t.length();

        int a[][] = new int[m+1][n+1];

        

        for(int i=1;i<=m;i++){

            for(int j=1;j<=n;j++){

                if(s.charAt(i-1)==t.charAt(j-1)){

                    a[i][j] = a[i-1][j-1]+1;

                }

                else{

                    a[i][j] = Math.max(a[i-1][j],a[i][j-1]);

                }

            }

        }

        return a[m][n];

    }


//174. 0 1 Knapsack

public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
        int[][] dp = new int[n+1][w+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                int curr_val= values.get(i-1);
                int curr_wt= weights.get(i-1);
                if(curr_wt<=j){
                    int include = curr_val+dp[i-1][j-curr_wt];
                    int exclude = dp[i-1][j];
                    dp[i][j]=Math.max(include,exclude);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
	}


//175. Edit Distance

public static int editDistance(String str1, String str2) {

        //Your code goes here

        int ind1=str1.length();

        int ind2=str2.length();

 

        int [][]dp=new int [ind1][ind2];

        for(int []row:dp) Arrays.fill(row,-1);

 

        return memo(ind1-1,ind2-1,str1,str2,dp);

    }

    static int memo(int i,int j,String s,String t,int[][]dp) {

        if(i<0) return j+1;

        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==t.charAt(j)) return  dp[i][j]= memo(i-1,j-1,s,t,dp);

        return dp[i][j]= 1+ Math.min(memo(i,j-1,s,t,dp),Math.min(

                        memo(i-1, j, s, t,dp),

                        memo(i-1, j-1, s, t,dp)

                        ));

    }


//176. Maximum Sum Increasing Subsequence

 public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {        // Write your code here.
   int omax = Integer.MIN_VALUE;     
   int dp[] = new int[n];     
   for(int i =0; i<n; i++){    
     Integer max= null;       
     for(int j=0; j<i; j++){        
       if(rack.get(j) < rack.get(i)){     
         if(max == null){              
           max = dp[j];             
         }else if(dp[j] > max){          
           max = dp[j];                  
         }          
       }            }    
     if(max == null){          
       dp[i] = rack.get(i);      
     }else{      
       dp[i] = max + rack.get(i);       
     }        
     omax = Math.max(omax, dp[i]);        }      
   return omax;    
 } }


//177. Matrix Chain Multiplication

public static int matrixMultiplication(int[] arr , int N) {

// Write your code here

int dp[][]=new int[N][N];

        for(int i=N-1;i>=1;i--)

        {

            for(int j=i+1;j<N;j++)

            {

                int min=Integer.MAX_VALUE;

                

                for(int k=i;k<j;k++)

                {

                    int step=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];

                    

                    min=Math.min(min,step);

                }

                dp[i][j]=min;

            }

        }

        

        return dp[1][N-1];

 

}



//178. Minimum Path Sum
  public static int minSumPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = 0;

                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                } 
                else{
                    int left = grid[i][j], up = grid[i][j];
                    if(i > 0) up += dp[i-1][j];
                    else up += (int)1e9;

                    if(j > 0) left += dp[i][j-1];
                    else left += (int)1e9;
                    dp[i][j] = Math.min(left,up);
                }
            }
        }

        return dp[n-1][m-1];
    }


//179. Ways To Make Coin Change

public static long Count(int i,int denom[],int bal,long[][] dp){

        if(i==0){

            if(bal%denom[0]==0){

                return 1;

            }else{

                return 0;

            }

        }

        if(dp[i][bal]!=-1) return dp[i][bal];

        long include=0;

        if(denom[i]<=bal){

            include=Count(i,denom,bal-denom[i],dp);

        }

        long exclude=Count(i-1,denom,bal,dp);

        dp[i][bal]=include+exclude;

        return dp[i][bal];

    }

 

    public static long countWaysToMakeChange(int denominations[], int value){

        //write your code here

        int n=denominations.length;

        //why value+1 because of 0 balance

        long dp[][]=new long[n][value+1]; 

        for(long r[]:dp){

            Arrays.fill(r,-1);

        }

        long res=Count(n-1,denominations,value,dp);

        return res;     

 

    }

//180. Subset Sum Equal To K

 static int fun(int i ,int k,int[] arr,int[][] dp)

    {

        if(k==0) return 1;

 

        if(i==0) return (arr[i]==k)?1:0;

 

        if(dp[i][k]!=-1) return dp[i][k]; 

 

        int non=fun(i-1,k,arr,dp);

        int pick=0;

        if(k>=arr[i])

        pick=fun(i-1,k-arr[i],arr,dp);

 

        return dp[i][k]=non|pick;

    }

    public static boolean subsetSumToK(int n, int k, int arr[]){

        // Write your code here.

        int[][] dp = new int[n][k+1];

        for(int[] a:dp)

            Arrays.fill(a,-1);

        return fun(n-1,k,arr,dp)==1?true:false;

 

    }
