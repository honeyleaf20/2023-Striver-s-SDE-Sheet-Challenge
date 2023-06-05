2.Pascal Triangle

public static ArrayList<ArrayList<Long>> printPascal(int n){
ArrayList<ArrayList<Long>>res= new ArrayList<>();
        
       for(int i=0;i<n;i++)
       {
           ArrayList<Long>in=new ArrayList<>();
           for(int j=0;j<=i;j++)
           {
               if(j==0||j==i)
               {
                   in.add(new Long(1));
               }
               else
               {
                   Long num=res.get(i-1).get(j-1)+res.get(i-1).get(j);
                   in.add(num);
               }
               
           }
           
           res.add(in);
           
       }
        return res;
}
