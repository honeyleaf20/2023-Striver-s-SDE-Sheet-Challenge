 public static String completeString(int n, String[] a) {        // Write your code here.        Trie Node =new Trie();        for(int i=0;i<a.length;i++)        {            Node.insert(a[i]);        }               String out="";       for(int i=0;i<a.length;i++)       {           if(completeString(a[i],Node.root))           {            if(a[i].length()>out.length())            {                out=a[i];            }               if(a[i].length()==out.length() && a[i].compareTo(out)<0 )               {                   out=a[i];               }           }       }               if(out=="")        {            return "None";        }                return out;

 

   }

   public static boolean completeString(String a,TrieNode node) {

       for(int i=0;i<a.length();i++)        {            int index=a.charAt(i)-'a';            node=node.children[index];            if(node!=null && !node.isT)            {                return false;            }        }                return true;

        }

}

class Trie {

   static TrieNode root;

   Trie() {

       root = new TrieNode('\0');    }

   public static void insert(String word,TrieNode node) {        if(word.length()==0)        {            node.isT=true;            return ;        }

       int index=  word.charAt(0)-'a';        TrieNode child=node.children[index];        if(child==null)        {            child=new TrieNode(word.charAt(0));            node.children[index]=child;                    }        insert(word.substring(1),child);    }

   public static void insert(String word) {        insert(word,root)    ;    }


class TrieNode {    TrieNode[] children;    boolean isT;    char data;    TrieNode(char data)    {        this.data=data;        this.children=new TrieNode[26];    } }
