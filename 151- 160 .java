//151.   Convert a binary tree to a doubly linkedlist

public class Solution {
	static BinaryTreeNode<Integer> head;
	static BinaryTreeNode<Integer> prev;
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
		
		head = null;
		prev = null;
		f(root);
		return head;
	}
	static void f(BinaryTreeNode<Integer> root){
		if(root==null) return;
		f(root.left);
		if(prev==null) head = root;
		else {
			prev.right= root;
			root.left = prev;
		}
		prev = root;
        f(root.right);
	}
	
}

//152. Mediam in a stream

 public static int[] findMedian(int[] arr, int n) {

        
        ArrayList<Integer> store = new ArrayList<Integer>();
        int[] medians = new int[n];

        for (int i = 0; i < n; i++) {
            store.add(arr[i]);
            Collections.sort(store);

            int median;
            if ((i + 1) % 2 == 0) {
                median = (store.get(i / 2) + store.get((i + 1) / 2)) / 2;

            }
            else {
                median = store.get(i / 2);

            }

            medians[i] = (median);

        }

        return medians;
    }

//153. Kth largest element in a stream

 PriorityQueue<Integer>pq=new PriorityQueue<Integer>();

    Comparator comp=pq.comparator();

    int k=0;

    Kthlargest(int k, int[] arr) {

        // Write your code here.

        for(int i=0;i<arr.length;i++){

            pq.add(arr[i]);

            if(pq.size()>k)

pq.poll();

        }

    }

 

    void add(int num) {

        // Write your code here.

        pq.offer(num);

        if(pq.size()>k)

pq.poll();

    }

 

    int getKthLargest() {

        // Write your code here.

        return pq.peek( );

        }

    

}

//154. Count distinct elements in every k size windows

public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {

 // Write your code here

HashMap<Integer, Integer> map = new HashMap<>();

ArrayList<Integer> count = new ArrayList<>();

 

for (int i = 0; i < k; i++) {

map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);

}

count.add(map.size());

 

int p = 0;

for (int i = k; i < arr.size(); i++) {

map.put(arr.get(p), map.getOrDefault(arr.get(p), 0) - 1);

if (map.get(arr.get(p)) == 0) {

map.remove(arr.get(p));

}

p++;

map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);

count.add(map.size());

}

return count;

}

//155. Kth largest element in unsorted array

static int kthLargest(ArrayList<Integer> arr, int size, int k) {
		// Write your code here.
		PriorityQueue<Integer> pq = new PriorityQueue<>(size, Collections.reverseOrder());
		for (int i : arr)
			pq.offer(i);
		for(int i =0;i<k-1;i++)
			pq.poll();
		return pq.peek();
	}

//156. Flood fill algorithm

  public static int[][] floodFill(int[][] image, int x, int y, int newColor)

    {

       if (newColor == image[x][y]) 

        {

            return image;

        }

        

        int rows = image.length;

        int cols = image[0].length;

        int source = image[x][y];

        

        dfs(image, x, y, newColor, rows, cols, source);

        return image;

    }

     private  static void dfs(int[][] image, int x, int y, int newColor, int rows, int cols, int source) 

    {

        if (x < 0 || x >= rows || y < 0 || y >= cols) 

        {

            return;

        } else if (image[x][y] != source) 

        {

            return;

        }

        

        image[x][y] = newColor;

        

        dfs(image, x - 1, y, newColor, rows, cols, source); // TOP

        dfs(image, x + 1, y, newColor, rows, cols, source); // DOWN

        dfs(image, x, y - 1, newColor, rows, cols, source); // LEFT

        dfs(image, x, y + 1, newColor, rows, cols, source); // RIGHT

}


//157. Clone graph

public static graphNode cloneGraph(graphNode node) {        

        graphNode noode=new graphNode(node.data,node.neighbours);

        return noode;

    }

//158. Max Depth of tree

 public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
    
        return Math.max(left, right) + 1;
    }

//159. Bfs in graph

public static ArrayList<Integer> BFS(int vertex, int edges[][]) {
		List<List<Integer>> adjacency = new ArrayList<List<Integer>>();
		for (int i = 0; i < vertex; i++) {
			adjacency.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < edges[0].length; i++) {
			adjacency.get(edges[0][i]).add(edges[1][i]);
			adjacency.get(edges[1][i]).add(edges[0][i]);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[vertex];
		for (int u = 0; u < vertex; u++) {
			if (visited[u]) {
				continue;
			}
			visited[u] = true;
			queue.offer(u);
			result.add(u);
			while (!queue.isEmpty()) {
				int u2 = queue.poll();
				ArrayList<Integer> subResult = new ArrayList<Integer>();
				for (int v : adjacency.get(u2)) {
					if (!visited[v]) {
						visited[v] = true;
						queue.offer(v);
						subResult.add(v);
					}
				}
				Collections.sort(subResult);
				result.addAll(subResult);
			}
		}
		return result;
	}


//160. Cycle detection in undirected graph

  public static String cycleDetection(int[][] edges, int n,int m) {

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        boolean vis[]=new boolean[n+1];

        for(int i=0;i<n+1;++i)

        {

            vis[i]=false;

            adj.add(new ArrayList<>());

        }

        for(int i=0;i<m;++i){

                adj.get(edges[i][0]).add(Integer.valueOf(edges[i][1]));

                adj.get(edges[i][1]).add(Integer.valueOf(edges[i][0]));

        }

 

        Queue<Pair> q=new LinkedList<Pair>();

        for(int i=1;i<=n;++i)

        {

            if(!vis[i] )

            {

                q.add(new Pair(i,-1));

                while(!q.isEmpty())

                {

                    Pair t=q.remove();

                    if(!vis[t.n]) 

                    {

                        vis[t.n]=true;

                        for(Integer j:adj.get(t.n))

                        {

                            if(!vis[j]) q.add(new Pair(j,t.n));

                        }

                    }

                    else return "Yes";

                }

            }

        }

        return "No";

    }
