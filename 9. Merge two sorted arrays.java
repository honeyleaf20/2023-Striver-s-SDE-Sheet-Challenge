9. Merge two sorted arrays

 public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        // Write your code here.
        int[] res= new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
         if(arr1[i]<=arr2[j]){
             res[k]=arr1[i];
             i++;
             k++;
         }
         else{
             res[k]=arr2[j];
             j++;
             k++;
         }
        }
        if(i!=m){
            while(i<m){
                res[k]=arr1[i];
                i++;
                k++;
            }

        }
        if(j!=n){
             while(j<n){
                res[k]=arr2[j];
                j++;
                k++;
            }

        }
        return res;
    }
}