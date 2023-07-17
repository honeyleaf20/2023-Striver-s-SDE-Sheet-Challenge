//101.Roman Numeral to Integer

public static int romanToInt(String s) {     
  int n = s.length();      
int []nums= new int[n];     
for(int i=0;i<n;i++)      
  {          
    switch(s.charAt(i))       
      {           
        case 'M':               
          nums[i]=1000;              
          break;           
        case 'D':             
          nums[i]=500;            
          break;           
        case 'C':              
          nums[i]=100;              
          break;           
        case 'L':              
          nums[i]=50;            
          break;         
        case 'X' :              
          nums[i]=10;           
          break;         
        case 'V':            
          nums[i]=5;           
          break;       
        case 'I':         
          nums[i]=1;             
          break;                 
      }      
  }       
int sum=0;      
for(int i=0;i<n-1;i++){       
  if(nums[i]<nums[i+1])          
    sum-=nums[i];        
  else             
    sum+=nums[i];        
}      
return sum+nums[n-1];   
}

//102. Implement Atoi Function

public static int atoi(String s) {        // Write your code here. 
  int ans=0;     
for(int i=0;i<s.length();i++){       
  if(s.charAt(i)-'0'<0||s.charAt(i)-'0'>9)           
    continue;     
  else{          
    ans=ans*10+s.charAt(i)-'0';      
  }}      
if(s.charAt(0)=='-')          
  return -ans; 
return ans; 
}

//103.Longest Common Prefix

public static String longestCommonPrefix(String[] arr, int n) {  // Write your code here                

       Arrays.sort(arr,(a,b)->  a.compareTo(b));        

       String tmp1=arr[0];    
  String tmp2=arr[n-1];    
  String ans="";      
  for(int i=0;i<tmp1.length();i++)      
    {          
      if(tmp1.charAt(i)==tmp2.charAt(i))    
      {            
        ans+=tmp1.charAt(i);        
      }         
      else{              
        break;      
      }       
    }       
  return ans;        
}            

//104. Search Pattern (Rabin Karp)

  private static final int d = 256;
    private static final int q = 101;

    public static List<Integer> stringMatch(String txt, String pat) {
        List<Integer> res = new ArrayList<>();

        if (pat.length() > txt.length()) {
            return res;
        }

        int i, j;
        int p = 0; 
        int t = 0; 
        int h = 1;
        for (i = 0; i < pat.length() - 1; i++) {
            h = (h * d) % q;
        }
        for (i = 0; i < pat.length(); i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        for (i = 0; i <= txt.length() - pat.length(); i++) {
            if (p == t) {
                for (j = 0; j < pat.length(); j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }
                if (j == pat.length()) {
                    res.add(i + 1);
                }
            }
            if (i < txt.length() - pat.length()) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + pat.length())) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }

        return res;
    }

//105. Z algorithm

public static int zAlgorithm(String s, String p, int n, int m) { 
  int cnt=0;  for(int i=0;i<=n-m;i++){   
    String sub = s.substring(i, i+m);  
    if(sub.equalsIgnoreCase(p)){   
      cnt++;   }  } 
  return cnt;
}

//106. Find Pattern in String( KMP Algo)

public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
    if (words.length != pattern.length())
        return false;
    Map index = new HashMap();
    for (Integer i=0; i<words.length; ++i)
        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
            return false;
    return true;
    }

//107. Minimum Characters for palindrome

public static int fixJ(String str,int i,int j){   
  while(str.charAt(i)!=str.charAt(j)){            
    j--;    }   
  return j; }   
public static boolean checkPalindrome(String s,int i,int j){ 
  while(i<j) {          
    if(s.charAt(i++)!=s.charAt(j--)) {      
      return false;            }           
  }     
  return true;    
}   
public static int minCharsforPalindrome(String str) {      
  if(str.length()==0 || str.length()==1){return 0;}     
int i=0,j=str.length()-1;      
j=fixJ(str,i,j);      
while(j!=i){       
  if(checkPalindrome(str,i,j)){          
    return str.length()-j-1;      
  }                      
  j=fixJ(str,i,--j);         }        
return str.length()-j-1;         
}

//108. Check Permutation

  if(str1.length()!=str2.length())return false;
 char s1[] = str1.toCharArray();
  Arrays.sort(s1);
 str1 = new String(s1);
 char s2[]= str2.toCharArray();
 Arrays.sort(s2);
 str2 = new String(s2);
 return str1.equals(str2);
}

//109. Count and Say

public static String writeAsYouSpeak(int n) 

    {

        // Write your code here.
  String s="1";
 for(int i=1;i<n;i++){
 int count=1;
  StringBuilder sb=new StringBuilder();
 for(int j=1;j<s.length();j++){
 if(s.charAt(j-1)==s.charAt(j)){
 count++;
 }
else{
sb.append(count).append(s.charAt(j-1));
 count=1;
}} sb.append(count).append(s.charAt(s.length()-1));
 s=sb.toString();
 }
return s;
 }

//110. Compare Version Numbers.

public static int compareVersions(String a, String b) 
    {
        String[] ver1 = a.split("\\.");
        String[] ver2 = b.split("\\.");

        int i = 0;
        int n = ver1.length, m = ver2.length;

        while(i < n || i < m){
            if(i < n && i < m){
                if(Double.parseDouble(ver1[i]) < Double.parseDouble(ver2[i])){
                    return -1;
                }else if(Double.parseDouble(ver1[i]) > Double.parseDouble(ver2[i]))
                    return 1;
            }
            else if(i < n){
                if(Double.parseDouble(ver1[i]) != 0){
                    return 1;
                }    
            }
            else if(i < m){
                if(Double.parseDouble(ver2[i]) != 0){
                    return -1;
            }
            }
            i++;
        }
        return 0;
    }
