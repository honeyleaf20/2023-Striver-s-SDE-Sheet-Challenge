public static int search(int arr[], int key) {
        // Write your code here.

        int low = 0, high = arr.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid] == key) return mid;

            // checks if left part of mid element is sorted or not
            else if(arr[low] <= arr[mid]){
                if(arr[low] <= key && arr[mid] > key) high = mid-1;
                else low = mid+1; 
            }
            
            // now checking the right part is sorted or not
            else{
                if(arr[mid]<key && arr[high] >= key) low=mid+1;
                else high= mid - 1;
            }
        }

        return -1;
    }
