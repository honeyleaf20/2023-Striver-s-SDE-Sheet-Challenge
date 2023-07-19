//131. Construct binary tree from inorder and postorder

 private static TreeNode<Integer> buildTreeHelper(int[] postOrder, int postStart, int postEnd, int[] inOrder,
                                                        int inStart, int inEnd) 
    {                                                         
        if (postStart > postEnd || inStart > inEnd) 
        {
            return null;
        }

        // Assign rootVal as postOrder[postEnd]
        int rootVal = postOrder[postEnd];
        
        TreeNode<Integer> root = new TreeNode<Integer>(rootVal);

        // Find parent element index from inOrder array.
        int k = 0;
        
        // Iterate i from inStart to inEnd
        for (int i = inStart; i <= inEnd; i++) 
        {
            if (rootVal == inOrder[i]) 
            {
                k = i;
                break;
            }
        }

        // Create recursive call for left and right subtree
        root.left = buildTreeHelper(postOrder, postStart, postStart + k - inStart - 1, inOrder, inStart, k - 1);
        root.right = buildTreeHelper(postOrder, postStart + k - inStart, postEnd - 1, inOrder, k + 1, inEnd);

        return root;
    }

    public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) 
    {
        int n = postOrder.length;

        int postStart = 0;
        int postEnd = n - 1;
        int inStart = 0;
        int inEnd = n - 1;

        // Call buildTreeHelper function 
        return buildTreeHelper(postOrder, postStart, postEnd, inOrder, inStart, inEnd);
    }

//132. Symmetric Tree

 public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        return root1.data.equals(root2.data)
            && isSymmetric(root1.left, root2.right)
            && isSymmetric(root1.right, root2.left);
    }

//133.Flatten binary tree to linkedlist

   public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root) {

        // Write your code here.

        flatten(root);

        prev = null;

        return root;

    } 

    static TreeNode<Integer> prev = null;

    static void flatten(TreeNode<Integer> root) {

        if (root==null)   

            return;  

       flatten(root.right);  

       flatten(root.left);  

       root.right = prev;  

       root.left = null;  

       prev = root;

    }

//134.Invert a binary tree

public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {

// Write your code here.

if(root == null) return root;

ArrayList<TreeNode<Integer>> st = new ArrayList<>();

boolean flag = findNode(root,leaf,st);

 

TreeNode<Integer> newHead = st.get(st.size()-1);

st.remove(st.size()-1);

TreeNode<Integer> parent = newHead;

TreeNode<Integer> cur=null;

while(st.size()>0){

cur = st.get(st.size()-1);

st.remove(st.size()-1);

parent.left = cur;

if(cur.left != parent){

cur.right = cur.left;

cur.left = null;

}

else {

cur.left = null;

}

parent = parent.left;

}

return newHead;

}

public static boolean findNode(TreeNode<Integer> root, TreeNode<Integer> leaf,ArrayList<TreeNode<Integer>> st){

st.add(root);

if(root.left == null && root.right == null) {

if(root.data.equals(leaf.data)) return true;

else {

st.remove(st.size()-1);

return false;

}

}

boolean left = false,right = false;

if(root.left!=null) left = findNode(root.left,leaf,st);

if(left == true) return true;

 

if(root.right!=null) right = findNode(root.right,leaf,st);

if(right == true) return true;

 

st.remove(st.size()-1);

return false;

 

}

//135. Children sum property

 public static void changeTree(BinaryTreeNode < Integer > root) {
        // Write your code here.

        traverse(root,Integer.MAX_VALUE);
    }
    
    public static int traverse(BinaryTreeNode<Integer> root,int parentVal){
        if(root==null)return Integer.MAX_VALUE;

        int temp = parentVal !=Integer.MAX_VALUE && parentVal>root.data ? parentVal : root.data;
        
        int left = traverse(root.left,temp);
        int right = traverse(root.right,temp);

        if(left==Integer.MAX_VALUE && right==Integer.MAX_VALUE){
            if(parentVal>=root.data){
                root.data=parentVal;
            }
        }else if(left==Integer.MAX_VALUE){
            root.data=right;
        }else if(right==Integer.MAX_VALUE){
            root.data=left;
        }else{
            root.data=left+right;
        }
        
        return root.data;
    }

//136. Connect nodes at same level

public static void connectNodes(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> dummy = new BinaryTreeNode<Integer>(null);
        while (root != null) {
            BinaryTreeNode<Integer> curr = root;
            BinaryTreeNode<Integer> next = dummy;
            while (curr != null) {
                if (curr.left != null) {
                    next = next.next = curr.left;
                }
                if (curr.right != null) {
                    next = next.next = curr.right;
                }
                curr = curr.next;
            }
            root = dummy.next;
            dummy.next = null;
        }
}

//137. Search in BST

public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		// Write your code here.
		BinaryTreeNode<Integer> temp = root;
		while (temp != null) {
			if (temp.data == x) {
				return true;
			} else if (temp.data > x) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		return false;
	}

//138.Convert sorted array to BST



    public static TreeNode<Integer> constructTree(ArrayList<Integer> arr, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        TreeNode<Integer> root = new TreeNode<>(arr.get(mid));

        root.left = constructTree(arr, low, mid - 1);
        root.right = constructTree(arr, mid + 1, high);

        return root;
    }
public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
        return constructTree(arr, 0, n - 1);
    }


//139. Construct BST from preorder trvaersal

 static int globalPtr = 0;
    
    public static TreeNode<Integer> preOrderTree(int[] preOrder) {
        //only keep the upper bound
         TreeNode<Integer> root =  createTree(preOrder,Integer.MAX_VALUE);
        //reset the ptr 
        globalPtr = 0;
        
        return root;
        
    }
    
    public static TreeNode createTree(int[] preOrder,int max){
        if(globalPtr >= preOrder.length || preOrder[globalPtr] > max)
                return null;
        
        TreeNode<Integer> node = new TreeNode<Integer>(preOrder[globalPtr++]);
        
        node.left   = createTree(preOrder, node.data);
        node.right = createTree(preOrder, max);
        
        return node;
    }


//140. Partial BST

 public static void inorder(BinaryTreeNode<Integer> root, List<Integer> arr) {
        if (root != null) {
            inorder(root.left, arr);
            arr.add(root.data);
            inorder(root.right, arr);
        }
    }

    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1) > arr.get(i)) {
                return false;
            }
        }
        return true;
    }

