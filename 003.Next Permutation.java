3. Next Permutation

public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		// Write your code here.
		int n = permutation.size(), ind = -1; 
        for (int i = n - 2; i >= 0; i--) {
            if (permutation.get(i) < permutation.get(i + 1)) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            Collections.reverse(permutation);
            return permutation;
        }

        for (int i = n - 1; i > ind; i--) {
            if (permutation.get(i) > permutation.get(ind)) {
                int temp = permutation.get(i);
                permutation.set(i, permutation.get(ind));
                permutation.set(ind, temp);
                break;
            }
        }
        List<Integer> ans= permutation.subList(ind + 1, n);
        Collections.reverse(ans);

        return permutation;
    

	}
