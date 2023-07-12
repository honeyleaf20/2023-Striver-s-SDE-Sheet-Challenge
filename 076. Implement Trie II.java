import java.util.* ;
import java.io.*; 
class Node{   
  Node[] links = new Node[26];   
  int cntPrefix = 0;    int cntEndWith = 0;   
  public Node(){            }   
  public boolean containsKey(char ch){     
    return links[ch-'a']!=null;     }    
  public void put(char ch,Node node){       
    links[ch-'a'] = node;    }       
  public Node get(char ch){      
    return links[ch-'a'];    }       
  public void increseEnd(){      
    cntEndWith++;    }      
  public void incresePrefix(){       
    cntPrefix++;    }      
  public void deleteEnd(){      
    cntEndWith--;    }      
  public void reducePrefix(){       
    cntPrefix--;    }      
  public int getEnd(){      
    return cntEndWith;    }        
  public int getPrefix(){       
    return cntPrefix;    } } 
public class Trie {    private Node root;    public Trie() {        // Write your code here.      
  root = new Node();    }

   public void insert(String word) {        Node node = root;        for(int i = 0 ; i < word.length();i++){     
     if(!node.containsKey(word.charAt(i))){           
       node.put(word.charAt(i),new Node());            }          
     node = node.get(word.charAt(i));            node.incresePrefix();        }        // Write your code here.    
                                    node.increseEnd();    }

   public int countWordsEqualTo(String word) {        // Write your code here.      
     Node node = root;        for(int i = 0 ; i < word.length();i++){            if(node.containsKey(word.charAt(i))){           
       node = node.get(word.charAt(i));            }else{                    return 0;            }        }     
     return node.getEnd();    }

   public int countWordsStartingWith(String word) {        // Write your code here.     
     Node node = root;        for(int i = 0 ; i < word.length();i++){          
       if(node.containsKey(word.charAt(i))){                node = node.get(word.charAt(i));            }else{            
         return 0;            }         }        return node.getPrefix();    }

   public void erase(String word) {        // Write your code here.          
     Node node = root;        for(int i = 0 ; i < word.length();i++){     
       if(node.containsKey(word.charAt(i))){                node = node.get(word.charAt(i));       
                                            node.reducePrefix();            }else{                return;            }     }   
     node.deleteEnd();       } }  
