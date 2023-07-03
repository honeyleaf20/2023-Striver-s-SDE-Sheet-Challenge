23. Count Subarrays with given XOR

 HashMap<Integer,Integer> map = new HashMap<>(); 
        int sum = 0;
        int count = 0;
        for(int i =0;i<arr.size();i++){
            int elem = arr.get(i);
            sum = sum^elem;
            //find its subsequent to make x
            if(map.containsKey(x^sum)){
                count+= map.get(x^sum);
            }
            //sum will be formed
            if(sum==x)count++;        
            //check the sum frquency in map
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,1);
            } 
        }
        return count;
