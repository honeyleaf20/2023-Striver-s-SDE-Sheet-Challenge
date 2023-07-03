22. Longest Subarray Zero Sum

public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
       
		// Write your code here.
		int currsum=0, max=0;
		HashMap<Integer,Integer> hm = new HashMap<>();        
		for(int i=0;i<arr.size();i++){            
			currsum+=arr.get(i);            
			if(currsum==0) max=i+1;

			else if(hm.get(currsum)!=null)                
			max= Math.max(max,i-hm.get(currsum)); 

			else                
			hm.put(currsum,i);        
			}       
			 return max; 
			 
		
	}
