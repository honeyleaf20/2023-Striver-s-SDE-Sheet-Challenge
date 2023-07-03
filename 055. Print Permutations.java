55. Print Permutations

public static List<String> findPermutations(String s) {
        // Write your code here.
          List<String> ans = new ArrayList<String>();       
           find(s, "", ans);        
           return ans;    
           }

   public static void find(String input, String curr, List<String> ans) {
               if (input.length() == 0) {           
                    ans.add(curr);            
                    return;        
                    }        
                    for (int i = 0; i < input.length(); i++) {           
                         char ch = input.charAt(i);            
                         String left= input.substring(0, i);           
                          String right= input.substring(i + 1);           
                           find(left + right, ch + curr, ans);       
                            }   
                     }
