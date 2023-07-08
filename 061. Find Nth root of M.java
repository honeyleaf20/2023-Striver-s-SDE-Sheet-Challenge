 static long power(int n, int exp){
        return (long) Math.pow(n, exp);
    }
    public static int NthRoot(int n, int m) {
        if(n == 1 || m == 1) return m;

        int low = 2, high = m - 1;

        while(low <= high){
            int mid = (low + high) >>> 1;

            long mult = power(mid, n);

            if(mult == m) return mid;
            if(mult < m) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }
