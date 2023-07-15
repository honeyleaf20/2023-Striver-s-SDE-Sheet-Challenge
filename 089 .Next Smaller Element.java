 static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> res=new ArrayList<>(n);
        st.push(-1);
        for(int i=n-1;i>=0;i--){
            int temp=arr.get(i);
            while(st.peek()>=temp){
                st.pop();
            }
            res.add(st.peek());
            st.push(temp);
        }
        Collections.reverse(res);
        return res;
    }
