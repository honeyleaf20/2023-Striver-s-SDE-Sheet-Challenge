21. Longest Consecutive Sequence

 HashMap<Integer,Integer> hm= new HashMap<>();
        for(int x:arr){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        int max=0;
        for(int x: arr){
            if(hm.containsKey(x-1)==false){
            int elem = x;
            int c= 0;
            while(hm.containsKey(elem)){
                c++;
                elem++;
            }
            if(c>max){
                max= c;
            }
            }
        }
        return max;
    
