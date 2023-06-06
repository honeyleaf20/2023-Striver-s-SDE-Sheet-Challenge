10. Find the duplicate in an array

 public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
        HashSet<Integer> hs= new HashSet<>();
        for(int i=0;i<arr.size();i++){
            if(hs.contains(arr.get(i)))return arr.get(i);
            hs.add(arr.get(i));
        }
        return 0;
    }
}