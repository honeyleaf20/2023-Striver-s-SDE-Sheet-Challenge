19. Pair Sum

 public static List<int[]> pairSum(int[] arr, int s) {
        // Write your code here.
        Arrays.sort(arr);
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        List<int[]> l= new ArrayList<>();

          for(int i =0;i<arr.length; i++){
            map.putIfAbsent(arr[i], new HashSet<>());
            map.get(arr[i]).add(i);

        }
         for(int i =0; i<arr.length; i++){

            if(map.containsKey(arr[i])){
              map.get(arr[i]).remove(i);

            }
            if(map.containsKey(s-arr[i])){

                Set<Integer> value =map.get(s-arr[i]);
                int[] arr1 = new int[2];
                arr1[0]=arr[i];
                arr1[1]=s-arr[i];
                for(int j : value){
                    l.add(arr1);

                }
            }
         }
        return l;
    }
}
