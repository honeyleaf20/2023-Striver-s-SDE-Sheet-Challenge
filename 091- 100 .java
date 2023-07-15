//91. LFU Cache

  public class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if(count==min && lists.get(count).size()==0)
            min++;
        if(!lists.containsKey(count+1))
            lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return vals.get(key);
    }
    
    public void set(int key, int value) {
        if(cap<=0)
            return;
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        } 
        if(vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }

//92.Largest Rectangle in Histogram

  public static int largestRectangle(ArrayList < Integer > a) {
    // Write your code here.
      int maxArea=0;
        int ps[]=prevSmaller(a);
        int ns[]=nextSmaller(a);

        for(int i=0;i<a.size();i++)
        {
            int width=ps[i]-ns[i]-1;
            int area=a.get(i)*width;
            if(area>maxArea)
            {
                maxArea=area;
            }
        }

        return maxArea;
    }

    static int []prevSmaller(ArrayList<Integer>a)
    {
        int ps[]=new int[a.size()];
        Stack<Integer>s=new Stack<>();
        s.push(a.size()-1);

        ps[a.size()-1]=a.size();

        for(int i=a.size()-2;i>=0;i--)
        {
            while(s.size()>0&& a.get(s.peek())>=a.get(i))
            {
                s.pop();
            }
            if(s.size()==0)
            {
                ps[i]=a.size();
            }
            else{
                ps[i]=s.peek();
            }
            s.push(i);
        }

        return ps;
    }
     static int []nextSmaller(ArrayList<Integer>a)
    {
        int ns[]=new int[a.size()];
        Stack<Integer>s=new Stack<>();
        s.push(0);
        ns[0]=-1;
        for(int i=1;i<a.size();i++)
        {
            while(s.size()>0&&a.get(s.peek())>=a.get(i))
            {
                s.pop();
            }
            if(s.size()==0)
            {
                ns[i]=-1;
            }
            else
            {
                ns[i]=s.peek();
            }
            s.push(i);
        }

        return ns;
  }


//93.Maximum of Sliding Window size K.

  public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k)  {  //   Write your code here.  
  ArrayList<Integer> res = new ArrayList<>();            
  Deque<Integer> q = new ArrayDeque<>();       
  for(int i =0;i<nums.size();i++){     
    if(!q.isEmpty() && q.peek()==i-k) q.poll();            
    while(!q.isEmpty() && nums.get(q.peekLast())<nums.get(i))
      q.pollLast();       
      q.offer(i);                      
    if(i>=k-1){               
      res.add(nums.get(q.peek()));     
    }        
  }return res;      
} }

//94. Min Stack

public class Solution {

    static class MinStack {

        static int[] arr;
        static int[] mina;
        static int i;
        static int ci;
        static int min;
        MinStack() {
           arr=new int[100000];
           mina=new int[100000];
            min=Integer.MAX_VALUE;
            i=-1;
            ci=0;
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            mina[ci]=Math.min(min,num);
            min=mina[ci];
            arr[ci++]=num;
            i++;
        }
         boolean empty(){
             if(ci==0){
                 return true;
             }
             else{
               return  false;
             }
         }
        // Function to remove the top element of the stack.
        int pop() {
            if(!empty()){
                ci--;
                int b=arr[i];
                i--;
                if(i!=-1){
                    min=mina[i];
                }
                else{
                    min=Integer.MAX_VALUE;
                }
                return b;
            }
            return -1;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            if(!empty()){
            return arr[i];
            }
            return -1;
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
           if(!empty()){
               return min;
           }
            return -1;
        }
    }

//95. Rotting Oranges

 public static int minTimeToRot(int[][] grid, int n, int m) {

 

        

        

 

        Queue<Pair> q=new LinkedList<Pair>();

        int t=0;

        

 

        

        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){

                if(grid[i][j]==2){

                    q.add(new Pair(i,j,0));

                }

            }

        }

 

        int[] delRow=new int[]{-1,0,1,0};

        int[] delCol=new int[]{0,1,0,-1};

 

        while(!q.isEmpty()){

 

            int row=q.peek().first;

            int col=q.peek().second;

            int time=q.peek().time;

            q.remove();

            t= Math.max(time, t);

 

            for(int i=0;i<4;i++){

                int nRow=row+delRow[i];

                int nCol=col+delCol[i];

 

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1 && grid[nRow][nCol]!=2){

                    q.add(new Pair(nRow,nCol, time+1));

                    grid[nRow][nCol]=2;

                }

 

            }

 

        }

 

        for(int i=0; i<n; i++){

            for(int j=0;j<m;j++){

                if(grid[i][j]==1){

                    return -1;

                }

            }

        }

 

        return t;

        // Write your code here.

    }

 

}

 

    class Pair{

 

        int first;

        int second;

        int time;

        public Pair(int first,int second,int time){

            this.first=first;

            this.second=second;

            this.time=time;

        }

    }

//96.Online Stock Span

 public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < price.size(); i++) {
            while (!stack.isEmpty() && price.get(stack.peek()) <= price.get(i))
                stack.pop();
            if (stack.isEmpty())
                res.add(i + 1);
            else
                res.add(i - stack.peek());
            stack.push(i);
        }
        return res;
    }

//97. Maximum of minimum of every window size

  public static int[] maxMinWindow(int[] a, int n) {
    int[] left=new int[n];
    int[] right=new int[n];   
    int[] ans = new int[n]; 
    for(int i = 0;i<n;i++){
        ans[i] = Integer.MIN_VALUE;
    }
    Stack<Integer> st=new Stack<>();
    left[0] = -1;
    st.push(0);
    for(int i=1;i<n;i++) {
        while(!st.empty() && a[st.peek()]>=a[i]) {
            st.pop();
        }
        left[i]=st.empty()?-1:st.peek();
        st.push(i);
    }
    while(!st.empty()) {
        st.pop();
    }
    right[n-1]=n;
    st.push(n-1);
    for(int i=n-2;i>=0;i--) {
        while(!st.empty() && a[st.peek()]>=a[i]) {
            st.pop();
        }
        right[i]=st.empty()?n:st.peek();
        st.push(i);
    }
    for(int i=0;i<n;i++) {
        int len=right[i]-left[i]-1;
        ans[len-1]=Math.max(ans[len-1],a[i]);
    }
    for(int i=n-2;i>=0;i--) {
        ans[i]=Math.max(ans[i],ans[i+1]);
    }
    return ans;
    }

//98.The Celebrity Problem

public static int findCelebrity(int n) {        

Stack<Integer> stack = new Stack<>();  

for(int i=0;i<n;i++){  stack.push(i);  }  

while(stack.size()>1){ 
  int a = stack.peek();  
  stack.pop();  
  int b = stack.peek();  
  stack.pop();
if(Runner.knows(a,b)){  
  stack.push(b);   }
else{  
  stack.push(a);  
}  }
int ans = stack.peek(); 
  stack.pop();
for(int i=0;i<n;i++){  
  if(i!=ans){  
    if(Runner.knows(ans,i)==true || Runner.knows(i,ans)==false){    
      return -1;   
    }   }  } 
  return ans;

   } }

//99.Reverse Words in a String

String[] words = str.split("\\s");
String outputString = "";
for (int i = words.length-1; i >= 0; i--)
 {
outputString = outputString + words[i] + " ";
 }
 return outputString;

//100.Longest Palindromic Sequence

public static String longestPalinSubstring(String str) {
 // Write your code here.
 if(str.length() == 0 || str == null){
  return str;
 }
 int n = str.length();
 char [] charArr = new char[2 * n + 1]; 
 int index = 0;
 charArr[index++] = '$';
 int max = 0;
 int maxIndex = 0;

 for(int k = 0; k < str.length(); k++){
  charArr[index++] = str.charAt(k);
  charArr[index++] = '#';
 }

 int l = 0, r = 0, c = 0, k = 0;
 int [] vals = new int[charArr.length];

 while(k < charArr.length){
  int mirror = 2 * c - k;
  if(r > k){
   vals[k] = Math.min(r - k, vals[mirror]);
  }
  int left = k - (vals[k] + 1);
  int right = k + (vals[k] + 1);
  while(left >= 0 && right < charArr.length && charArr[left] == charArr[right]){
   vals[k]++;
   left--;
   right++;
  }
  if(k + vals[k] > r){
   r = k + vals[k];
   c = k;
  }
  if(max < vals[k]){
   maxIndex = k;
   max = vals[k];
  }
  k++;
 }

 int start = (maxIndex - max)/2;
 int end = start + max;
 String result = str.substring(start, end);
 return result;
}
