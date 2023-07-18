//121. Level order traversal

 public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {    

ArrayList<Integer> ans = new ArrayList<>(); i

f(root==null){  return ans; }  

Queue<BinaryTreeNode> q = new LinkedList<>(); q.offer(root); while(!q.isEmpty()){  

BinaryTreeNode temp = q.poll();  ans.add(temp.val);  

if(temp.left!=null){   q.offer(temp.left);  }  

if(temp.right!=null){   q.offer(temp.right);  } } return ans;  }

//122. Height of binary tree

 public static int heightOfTheTree(int[] inorder, int[] levelOrder, int N) {
        int ans = 0;
        Queue<Node> queue = new LinkedList<>();

        Node root = new Node(0, 0, N - 1);
        queue.add(root);

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < N; i++) {
            mp.put(inorder[i], i);
        }

        for (int i = 0; i < N; i++) {
            Node temp = queue.poll();

            ans = Math.max(ans, temp.h);

            int li = temp.li, ri = temp.ri;
            int rootIndexOfSubTree = mp.get(levelOrder[i]);

            if (rootIndexOfSubTree - 1 >= li) {
                Node lst = new Node(temp.h + 1, li, rootIndexOfSubTree - 1);
                queue.add(lst);
            }

            if (rootIndexOfSubTree + 1 <= ri) {
                Node rst = new Node(temp.h + 1, rootIndexOfSubTree + 1, ri);
                queue.add(rst);
            }
        }

        return ans;
    }

    static class Node {
        int h;
        int li;
        int ri;

        Node(int h, int li, int ri) {
            this.h = h;
            this.li = li;
            this.ri = ri;
        }
    }

//123. Diameter of a binary tree

static int findDiameter(TreeNode<Integer> root, int[] max){
		if(root == null) return 0;

		int left = findDiameter(root.left, max);
		int right = findDiameter(root.right, max);
		max[0] = Math.max(max[0], left + right);
		return 1 + Math.max(left, right);
	}
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		int[] max = new int[]{-(int)1e9};
		findDiameter(root, max);
		return max[0];
	}

//124. Is height balanced in a binary tree

  static int maxDepth(BinaryTreeNode<Integer> root){
        if(root == null) return 0;

        int left = maxDepth(root.left);
        if(left == -1) return -1;
        int right = maxDepth(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
		return maxDepth(root) != -1;
  }

//125. LCA of binary tree

public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) 

    {

        if(root==null){

            return -1;

        }

        if(root.data==x || root.data==y){

            return root.data;

        }

        int leftLca=lowestCommonAncestor(root.left,x,y);

        int rightLca=lowestCommonAncestor(root.right,x,y);

        if(rightLca==-1){

            return leftLca;

        }

        if(leftLca==-1){

            return rightLca;

        }

        return root.data;

    }

//126.Check Identical trees

public static boolean identicalTrees(BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {    
  if (p == null && q == null) {       
    return true;        }     
  if (p == null || q == null) {     
    return false;        }          
  return p.data.equals(q.data) && identicalTrees(p.left, q.left) && identicalTrees(p.right, q.right);  
}

//127. Zig Zag traversal of binary tree

public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {    
         List<Integer> result = new ArrayList<Integer>();    
  if (root == null)       
    return result;     
  Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();   
  q.add(root);   
  boolean leftright = true;  
  while (q.size() > 0) {        
    int size = q.size();       
    List<Integer> ans = new ArrayList<>();        
    for(int i=0; i<size; i++){            
      BinaryTreeNode<Integer> front = q.peek();       
      q.poll();                        
      if(front.left != null)                 
        q.add(front.left);           
      if(front.right != null)               
        q.add(front.right);

               ans.add(front.data);        
    }            if(leftright == true){
      
    }            else{           
      Collections.reverse(ans);        
    }            for(int i=0; i<ans.size(); i++){     
      result.add(ans.get(i));            }     
    leftright = !(leftright);   
  }        return result;    } } 

//128. Boundary Traversal of binary tree
public static ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code he4re.

		ArrayList<Integer> ans=new ArrayList<>();
		if(root==null){
…			}
		}
		Collections.reverse(ans1);
		ans.addAll(ans1);
	}

//129. Maximum Path Sum

int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

//130. Construct binary tree from pre order traversal

public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
}

public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int inIndex = 0; // Index of current root in inorder
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == root.val) {
            inIndex = i;
        }
    }
    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
    return root;
}
