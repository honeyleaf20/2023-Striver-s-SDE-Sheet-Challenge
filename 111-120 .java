//111. Inorder Traversal

 public static List<Integer> getInOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    public static void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }

//112. PreOrder Traversal

  public static List<Integer> getPreOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        getPreOrderTraversal(root, ans);
        return ans;
    }
	public static void getPreOrderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.data);
        getPreOrderTraversal(root.left, ans);
        getPreOrderTraversal(root.right, ans);
    }
}

///113. PostOrder Traversal

  public static List<Integer> getPostOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        getPostOrderTraversal(root, ans);
        return ans;
    }
	public static void getPostOrderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.data);
        getPostOrderTraversal(root.left, ans);
        getPostOrderTraversal(root.right, ans);
    }
}

//114. Left View of binary tree

class Tree
{
  
  static void left(Node root, int level , ArrayList<Integer> ans){
      if(root == null) return ;
      if(level == ans.size()){
          ans.add(root.data);
      }
      
      left(root.left,level+1,ans);
      left(root.right,level+1,ans);
  }
   ArrayList<Integer> leftView(Node root){
   
       ArrayList<Integer> result = new ArrayList<>();
       if (root == null) {
           return result;
       }
       left(root,0,result);
       
       return result;
   }
}

//115. Bottom view of binary tree

  public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
         // Write your code here.    
          Queue<Pair>q=new ArrayDeque<>();
        Map<Integer,Integer>map=new TreeMap<>();
        
        q.add(new Pair(0,root));
        
        while(!q.isEmpty())
        {
            Pair cur=q.poll();
            
            // if(!map.containsKey(cur.hd))
            // {
            //     map.put(cur.hd,cur.node.data);
            // }
            
            map.put(cur.hd,cur.node.val);
            
            if(cur.node.left!=null)
            {
                q.add(new Pair(cur.hd-1,cur.node.left));
            }
             if(cur.node.right!=null)
            {
                q.add(new Pair(cur.hd+1,cur.node.right));
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }
    static class Pair
    {
        int hd;
        BinaryTreeNode node;
        public Pair(int hd,BinaryTreeNode node)
        {
            this.hd=hd;
            this.node=node;
        }
    }  

//116. Top View of binary tree

public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		Map<Integer, Integer> map = new TreeMap<>();
		ArrayList<Integer> list = new ArrayList<>();

		if(root == null) return list;

		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(root, 0));

		while(!q.isEmpty()){
			Pair curr = q.poll();
			BinaryTreeNode node = curr.node;
			int index = curr.index;

			if(!map.containsKey(index)) map.put(index, node.val);

			if(node.left != null) q.offer(new Pair(node.left, index - 1));
			if(node.right != null) q.offer(new Pair(node.right, index + 1));
		}

		for(int e: map.values()){
			list.add(e);
		}

		return list;
	}

//117. Tree Traversals

public static void inorder(List<Integer>inOrder,BinaryTreeNode<Integer> root){
       if(root==null)return;
       inorder(inOrder,root.left);
       inOrder.add(root.data);
       inorder(inOrder,root.right);
   }
   public static void preorder(List<Integer>preOrder,BinaryTreeNode<Integer> root){
       if(root==null)return;
       preOrder.add(root.data);
       preorder(preOrder,root.left);
       preorder(preOrder,root.right);
   }
   public static void postorder(List<Integer>postOrder,BinaryTreeNode<Integer> root){
       if(root==null)return ;
       postorder(postOrder,root.left);
       postorder(postOrder,root.right);
       postOrder.add(root.data);
   }
   
   public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
       List<List<Integer>>res = new ArrayList<List<Integer>>();
       List<Integer>inOrder = new ArrayList<>();
       List<Integer>preOrder = new ArrayList<>();
       List<Integer>postOrder = new ArrayList<>();
       inorder(inOrder,root);
       res.add(inOrder);
       preorder(preOrder,root);
       res.add(preOrder);
       postorder(postOrder,root);
       res.add(postOrder);
       return res;
   }

//118. Path in a Tree

public static void solve(TreeNode root,int x,ArrayList<Integer>ans){
        if(root == null){
            return;
        }
        ans.add(root.data);
        if(root.data == x)
         return;
         solve(root.left,x,ans);
         solve(root.right,x,ans);
         if(ans.get(ans.size()-1) != x){
             ans.remove(ans.size()-1);
         }
    }
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer>ans = new ArrayList<>();
        if(root == null){
            return new ArrayList<>(); 
        }
        solve(root,x,ans);
        return ans;
    }

//119. Vertical Order Traversals

public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) {

        if (root == null)

            return new ArrayList<Integer>();

 

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(0, root));

        HashMap<Integer, ArrayList<Integer>> ans = new HashMap<>();

 

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();

            int column = pair.column;

            TreeNode<Integer> node = pair.node;

 

            if (ans.containsKey(column)) {

                ans.get(column).add(node.data);

            } else {

                ArrayList<Integer> list = new ArrayList<>();

                list.add(node.data);

                ans.put(column, list);

            }

 

            if (node.left != null)

                queue.add(new Pair(column - 1, node.left));

            if (node.right != null)

                queue.add(new Pair(column + 1, node.right));

        }

 

        return sortAndFlatten(ans);

    }

 

    public static ArrayList<Integer> sortAndFlatten(HashMap<Integer, ArrayList<Integer>> ans) {

        ArrayList<Integer> result = new ArrayList<>();

        ArrayList<Integer> sortedKeys = new ArrayList<>(ans.keySet());

        Collections.sort(sortedKeys);

 

        for (int key : sortedKeys) {

            ArrayList<Integer> list = ans.get(key);

            result.addAll(list);

        }

 

        return result;

    }

}

//120. Maximum width in binary tree

public static int getMaxWidth(TreeNode root) {  
  if (root == null) {  
  return 0;  
  } 
  Queue<TreeNode> q = new LinkedList<>();
  q.add(root);

 int maxWidth = 0;

 while (!q.isEmpty()) {   
   int currWidth = q.size();  
   if (maxWidth < currWidth) { 
     maxWidth = currWidth;   }     
   while (currWidth > 0) {   
     TreeNode currNode = q.peek(); 
     q.poll();       
     if (currNode.left != null) {   
       q.add(currNode.left);    }   
     if (currNode.right != null) { 
       q.add(currNode.right);  
     }   
     currWidth = currWidth - 1;  
   }  }

 return maxWidth; 
   }
