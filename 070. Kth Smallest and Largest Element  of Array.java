ArrayList<Integer> list =new ArrayList<>();           
Collections.sort(arr);         
Integer[] a1 = new Integer[arr.size()];       
a1 = arr.toArray(a1);       
list.add(a1[k-1]);       
list.add(a1[n-k]);       
return list;
