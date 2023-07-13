 public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {               //System.out.println(queries.size());       ArrayList<Integer> ans=new ArrayList<>(queries.size());        Collections.sort(arr);                ArrayList<ArrayList<Integer>> q=new ArrayList<ArrayList<Integer>>();        int index=0;        for(ArrayList<Integer> q1: queries )        {            ArrayList<Integer> tmp=new ArrayList<>();            tmp.add(q1.get(1));            tmp.add(q1.get(0));            tmp.add(index);            q.add(tmp);            index++;                    }        Collections.sort(q,(a,b)->a.get(0)-b.get(0));         int ind=0;         Trie trie=new Trie();         for(ArrayList<Integer> query: q) ans.add(-1);        for(ArrayList<Integer> query: q)        {                                  int num=query.get(1);            int numCheck=query.get(0);            int ind1=query.get(2);

           for(int i=ind;i<arr.size();i++)            {                if(arr.get(i)<=numCheck)                {                      insert(arr.get(i),trie.root);                                     }                else{                    break;                }                 ind++;            } //             if(ind!=0) //             { //               ind++;    //             }                                                         if(trie.root.children[0]==null && trie.root.children[1]==null )            {                ans.set(ind1,-1);                continue;            }

           int max= getMax(num,trie.root);           //  System.out.println(ans.size()+" "+ind1);            ans.set(ind1,max);          

       }      return ans;

} public static void insert(int num,TrieNode node) {

   for(int i=31;i>=0;i--)    {        int bit=(num>>i)&1;        if(node.children[bit]==null)        {            TrieNode child=new TrieNode();            node.children[bit]=child;

       }                 node=node.children[bit];    }                           }

public static int getMax(int num,TrieNode node)  {    int max=0;    //TrieNode node=root;    for(int i=31;i>=0;i--)    {        int bit=(num>>i)&1;        if(node.children[1-bit]!=null)        {            max=max|(1<<i);            node=(node.children[1-bit]);        }        else{            node=(node.children[bit]);        }    }

   return max; }

static class  Trie {    TrieNode root;    Trie()    {        root=new TrieNode();

   } } }

 

class TrieNode {    TrieNode[] children;     TrieNode()    {                this.children=new TrieNode[2];    } 
