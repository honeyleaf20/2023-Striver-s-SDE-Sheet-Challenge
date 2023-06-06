15.Majority element

public static int findMajority(int[] arr, int n) {
	HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : arr){
			map.put(i, map.getOrDefault(i, 0)+1);
		}

		int check = 0;
		for(int j : map.values()){
			if(check < j){
				check = j;
			}
		}

		for(int k : map.keySet()){
			if(map.get(k) == check && check > n/2){
				return k;
	}
		}
		return -1;
	}