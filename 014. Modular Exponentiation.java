14. Modular Exponentiation

 public static int modularExponentiation(int x, int n, int m) {
        // Write your code here. 
         return (int)find((long)x,(long)n,(long)m);      
    }
    public static long find(long x,long n,long m){
        if(n==0)return 1;
        long sq = find(x,n/2,m);
        long ans = (sq * sq)%m;
        if(n%2==1)return (ans*x)%m;
        return ans;
    }
