//141. LCA of 2 nodes in bst

public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> P, TreeNode<Integer> Q) {
        if (root == null) {
            return null;
        }
        int cur = root.data;
        if (cur < P.data && cur < Q.data) {
            return LCAinaBST(root.right, P, Q);
        } else if (cur > P.data && cur > Q.data) {
            return LCAinaBST(root.left, P, Q);
        } else {
            return root;
        }
    
}

//142. Predecessor and Successor in bst

public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		// Write your code here.
				ArrayList<Integer> ans = new ArrayList<>();
		ans.add(floorInBST(root, key));
		ans.add(findCeil(root, key));

		return ans;		
	}

	private static int floorInBST(BinaryTreeNode<Integer> root, int x) {
        //    Write your code here.
        int floor = -1;

        while(root!= null){
            if(root.data >= x){
                root = root.left;
            }else{
                floor = root.data;
                root = root.right;
            }
            
        }

        return floor;
    }
	private static int findCeil(BinaryTreeNode<Integer> root, int x) {

        // Write your code here
        int floor = -1;

        while(root!= null){
            if(root.data <= x){
                root = root.right;
            }else{
                floor = root.data;
                root = root.left;
            }
            
        }

        return floor;

    }

//143. Floor in BST

 public static int floorInBST(TreeNode<Integer> root, int X) {     
   TreeNode<Integer>res=null;      
   while(root!=null)        {      
     if(root.data==X)      
       return root.data;      
     else if(root.data>X)     
       root=root.left;        
     else{               
       res=root;             
       root=root.right;          
     }        }return res.data;  
 }

//144. Ceil from bst

  public  static int findCeil(TreeNode<Integer> node, int x) {
        int ceil = -1;
        while(node!=null){
            if(node.data == x){
                ceil = node.data;
                return ceil;
            }
            else if(node.data > x){
                ceil = node.data;
                node = node.left;
            }
            else if(node.data < x)
            {
                node = node.right;
            }
        }
        
        return ceil;
    }

//145. Kth largest number in bst

public static int KthLargestNumber(TreeNode<Integer> root, int k) {

        // Write your code here.

        ArrayList<TreeNode> list = new ArrayList<>();

        traverse(root , list);

        return list.get(list.size() - k).data;

    }

    private static void traverse(TreeNode root , ArrayList<TreeNode> list){

        if(root == null) return;

        traverse(root.left , list);

        list.add(root);

        traverse(root.right , list);

    }

//146. Kth smallest in bst


public int kthSmallest(TreeNode root, int k) {
      Stack<TreeNode> st = new Stack<>();
      
      while (root != null) {
          st.push(root);
          root = root.left;
      }
          
      while (k != 0) {
          TreeNode n = st.pop();
          k--;
          if (k == 0) return n.val;
          TreeNode right = n.right;
          while (right != null) {
              st.push(right);
              right = right.left;
          }
      }
      
      return -1; 
}

//147. Pair sum in bst

 public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }
    
    public boolean dfs(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)return false;
        if(set.contains(k - root.val))return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    } 

//148. BST iterator

static class BSTIterator{
      ArrayList<Integer> yash=new ArrayList<>();
        int i;
        BSTIterator(TreeNode<Integer> root){
            helper(root);
        }
void helper(TreeNode<Integer> root){
    if(root==null){
        return;
    }
    helper(root.left);
    yash.add(root.data);
    helper(root.right);
    
}
        int next(){
           return yash.get(i++);
            
            // Write your code here
        }

        boolean hasNext(){
          if(i<yash.size()){
              return true;
          }
            else{
               return false;
            }
           
        }
    }


//149. Size of Largest BST in Binary Tree

public static int largestBST(TreeNode<Integer> root) {

		return compute(root).size;

	}
	
	public static NodeValue compute(TreeNode<Integer> node){
		
		if(node == null) {
			return new NodeValue(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
		}
		
		NodeValue left = compute(node.left);
		NodeValue right = compute(node.right);

		if(node.data >= left.maxValue && node.data <= right.minValue){
			return new NodeValue(
				left.size + right.size + 1,
				Math.min(left.minValue,node.data),
				Math.max(node.data, right.maxValue)
			);
		}

		return new NodeValue(
			Math.max(left.size, right.size),
			Integer.MIN_VALUE,
			Integer.MAX_VALUE
		);
  }

//150. Serialize and Deserialize Binary Tree

public static boolean identicalTrees(BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {  
  if (p == null && q == null) {   
    return true;        }      
  if (p == null || q == null) {     
    return false;        }   
  return p.data.equals(q.data) && identicalTrees(p.left, q.left) && identicalTrees(p.right, q.right);   
}


