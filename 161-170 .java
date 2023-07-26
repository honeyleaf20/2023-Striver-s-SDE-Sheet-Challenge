//161. Detect Cycle In A Directed Graph

public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {

    // Write your code here.
ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
  for(int i=0;i<=n;i++)

        {
          graph.add(new ArrayList<Integer>());

        }
for(int i=0;i<edges.size();i++)

        {
          graph.get(edges.get(i).get(0)).add(edges.get(i).get(1));
 }
int ind[]=new int[n+1];
  Arrays.fill(ind,0);
for(int i=1;i<=n;i++)

        {
          for(int j:graph.get(i))
 {
    ind[j]++;
 }

 }
  int count=0;
 Queue<Integer> q=new LinkedList<>();
for(int i=1;i<=n;i++)

        {
 if(ind[i]==0)
 {
 q.add(i);

            }

        }
while(!q.isEmpty())

        {
 int front=q.poll();
 count++;
 for(int i:graph.get(front))

 {

ind[i]--;
if(ind[i]==0)
{
q.add(i);
}
}
}
 if(count!=n){
return true;

        }
else{

   return false;

        }
 }

//162. Topological Sort

  public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int vtx, int edg) 
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<vtx; i++) {
           adj.add(new ArrayList<>()); 
        }

        int indegree[] = new int[vtx];
        for(int i=0; i<edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<vtx; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        ArrayList<Integer> out = new ArrayList<Integer>();
        int count = 0;
        while(!q.isEmpty()) {
            int u = q.poll();
            out.add(u);

            for(int t=0; t<adj.get(u).size(); t++) {
                int v = adj.get(u).get(t);
                indegree[v]--;
                if(indegree[v] == 0) q.add(v);
            }
        }

        return out;
    }


//163.Find Number Of Islands

 public static int getTotalIslands(int[][] mat) 
	{
        //Your code goes here
        int n=mat.length,m=mat[0].length,cnt=0;
        int vis[][] = new int[n][m];
        int dir[][]={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && mat[i][j]==1){
                    dfs(mat,vis,dir,i,j);
                    cnt++;
                }
            }
        }return cnt;
    }
    static void dfs(int[][] mat,int[][] vis,int[][] dir,int i, int j){
        vis[i][j]=1;
        for(int child[]:dir){
            int ni=i+child[0],nj=j+child[1];
            if(ni>=0 && ni<mat.length && nj>=0 
            && nj<mat[0].length && vis[ni][nj]==0 && mat[ni][nj]==1){
                dfs(mat, vis, dir, ni, nj);
            }
        }
    }

//164. Check Bipartite graph

static boolean bfs(int node,int m,ArrayList<ArrayList<Integer>> adj,int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        color[node]=0;
        while(!q.isEmpty()){
            Integer n=q.remove();
            for(Integer i:adj.get(n)){
                if(color[i]==-1){
                    color[i]=1-color[n];
                    q.add(i);
                }
                else if(color[i]==color[n]){
                     return false;
                }
               
            }
        }
        return true;
    }

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {

        // Write your code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        int n=edges.size();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(edges.get(i).get(j)==1 && i!=j)
                adj.get(i).add(j);
                adj.get(j).add(i);
            }
        }

        int[] color=new int[n];
        for(int i=0;i<n;i++) color[i]=-1;

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(bfs(i,n,adj,color)==false)
                return false;
            }
        }
        return true;
    }

//165. Strongly Connected Components (Tarjan’s Algorithm)

class UnionFind{
    final int[] parents;
    int count;
    
    public UnionFind(int n){
        this.parents = new int[n];
        reset();
    }
    
    public void reset(){
        for(int i =0;i<parents.length;i++){
            parents[i] = i;
        }
        count = parents.length;
    }
    
    public int find(int i){
        int parent = parents[i];
        if(parent == i){
            return i;
        }else{
            int root = find(parent);
            parents[i] = root;
            return root;
        }
    }
    
    public boolean union(int i, int j){
        int r1 = find(i);
        int r2 = find(j);
        if(r1 != r2){
            count--;
            parents[r1] = r2;
            return true;
        }else{
            return false;
        }
    }
    
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
       
        List<Integer>criticals = new ArrayList<>();
        List<Integer> pseduos = new ArrayList<>();
        
        Map<int[], Integer> map = new HashMap<>();
        for(int i =0;i<edges.length;i++){
            map.put(edges[i], i);
        }
        
        Arrays.sort(edges, (e1, e2)->Integer.compare(e1[2], e2[2]));
        int minCost = buildMST(n, edges, null, null);
        
        for(int i =0;i<edges.length;i++){
            int[] edge = edges[i];
            int index = map.get(edge);
            int costWithout = buildMST(n, edges, null, edge);
            if(costWithout > minCost){
                criticals.add(index);
            }else{
                int costWith = buildMST(n, edges, edge, null);
                if(costWith == minCost){
                    pseduos.add(index);
                }
            }
            
        }
        
        return Arrays.asList(criticals, pseduos);
    }
    
    private int buildMST(int n, int[][] edges, int[] pick, int[] skip){
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        if(pick != null){
            uf.union(pick[0], pick[1]);
            cost += pick[2];
        }
        
        for(int[] edge : edges){
            if(edge != skip && uf.union(edge[0], edge[1])){
                cost += edge[2];
            }
        }
        return uf.count == 1? cost : Integer.MAX_VALUE;
    }
}


//166.Dijkstra's shortest path

public static int Dijkstra(int[][] grid){
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.value-b.value);
        pq.add(new pair(0,0,grid[0][0]));
        int[][] distance={{-1,0},{1,0},{0,1},{0,-1}};
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<visited.length;i++){
            Arrays.fill(visited[i],false);
        }
        visited[0][0]=true;
        int min=Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            pair p=pq.poll();
            int x=p.x;
            int y=p.y;
            int value=p.value;
            if(value>min){
                min=value;
            }
            if(x==grid.length-1 && y==grid[0].length-1){
                return min;
            }
            for(int i=0;i<distance.length;i++){
                int nbr_x=x+distance[i][0];
                int nbr_y=y+distance[i][1];
                if(nbr_x>=0 && nbr_x<grid.length && nbr_y>=0 && nbr_y<grid[0].length && visited[nbr_x][nbr_y]==false){
                   
                    pq.add(new pair(nbr_x,nbr_y,grid[nbr_x][nbr_y]));
                     visited[nbr_x][nbr_y]=true;
                     
                }
            }
        }
        return min;

    }
}
class pair{
    int x;
    int y;
    int value;
    
    pair(int x,int y,int value){
        this.x=x;
        this.y=y;
        this.value=value;
    }
}

//167. Bellman Ford

static int bellmonFord(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {

      // Write your code here.

      int[] dist = new int[n+1];

      Arrays.fill(dist, (int)1e9);

      dist[src] = 0;

 

      for(int i=0; i<n-1; i++){

        for(ArrayList<Integer> e: edges){

          int u = e.get(0);

          int v = e.get(1);

          int wt = e.get(2);

 

          if(dist[u] != (int)1e9 && dist[u] + wt < dist[v]){

            dist[v] = dist[u] + wt;

          }

        }

      }

 

      return dist[dest];

    }

//168. Floyd Warshall

  static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
    int dist[][] = new int[n+1][n+1];
    int high = 1000000000;

    for(int i=0; i<=n; i++) {
      for(int j=0; j<= n; j++) {
        if(i == j) {
          dist[i][j] = 0;
        } else {
          dist[i][j] = high;
        }
      }
    }

    for(int i=0; i<m; i++) {
      int u = edges.get(i).get(0);
      int v = edges.get(i).get(1);
      int w = edges.get(i).get(2);
      dist[u][v] = w;
    }

    for(int k=1; k<=n; k++) {
      for(int u=1; u<=n; u++) {
        for(int v=1; v<= n; v++) {
          if((dist[u][k] != high && dist[k][v] != high) && dist[u][k] + dist[k][v] < dist[u][v]) {
            dist[u][v] = dist[u][k] + dist[k][v];
          }
        }
      }
    }

    boolean isCycle = false;
    for(int i=0; i<=n; i++) {
      for(int j=0; j<= n; j++) {
        if(i == j && dist[i][j] != 0) {
          isCycle = true;
        }
      }
    }

    if(isCycle) {
      return -1;
    }

    return dist[src][dest];
  }

//169. Prim's MST

  public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {
        List<Map<Integer, Integer>> adj = new ArrayList<Map<Integer, Integer>>();
        for (int i = 0; i <= n; i++) {
            adj.add(new HashMap<Integer, Integer>());
        }
        for (ArrayList<Integer> edge : g) {
            Map<Integer, Integer> u = adj.get(edge.get(0));
            Map<Integer, Integer> v = adj.get(edge.get(1));
            if (!u.containsKey(edge.get(1)) || u.get(edge.get(1)) > edge.get(2)) {
                u.put(edge.get(1), edge.get(2));
                v.put(edge.get(0), edge.get(2));
            }
        }
        int[] weight = new int[n + 1];
        int[] parent = new int[n + 1];
        boolean[] inMst = new boolean[n + 1];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[1] = 0;
        // int[2] - (node, weight)
        Queue<int[]> queue = new PriorityQueue<int[]>((s1, s2) -> Integer.compare(s1[1], s2[1]));
        queue.offer(new int[] { 1, 0 });
        ArrayList<ArrayList<Integer>> mst = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            int[] uw = queue.poll();
            while (inMst[uw[0]]) {
                uw = queue.poll();
            }
            inMst[uw[0]] = true;
            if (i > 0) {
                ArrayList<Integer> edge = new ArrayList<Integer>();
                edge.add(uw[0]);
                edge.add(parent[uw[0]]);
                edge.add(weight[uw[0]]);
                mst.add(edge);
            }
            for (Map.Entry<Integer, Integer> vw : adj.get(uw[0]).entrySet()) {
                if (!inMst[vw.getKey()] && weight[vw.getKey()] > vw.getValue()) {
                    parent[vw.getKey()] = uw[0];
                    weight[vw.getKey()] = vw.getValue();
                    queue.offer(new int[] { vw.getKey(), vw.getValue() });
                }
            }
        }
        return mst;
    }


//170. Kruskal’s Minimum Spanning Tree Algorithm

    private static class Edge implements Comparable<Edge> {
        final int u, v, w;
        
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(w, edge.w);
        }
    }
    
    private static class DisjointSet {
        final int[] parent, rank;
        
        DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }
    }
    
    public static int kruskalMST(int n, int m, ArrayList<ArrayList<Integer>> graph) {
        DisjointSet set = new DisjointSet(n);
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            List<Integer> edge = graph.get(i);
            edges[i] = new Edge(edge.get(0), edge.get(1), edge.get(2));
        }
        Arrays.sort(edges);
        int w = 0;
        for (int i = 1, j = 0; i < n; j++) {
            Edge edge = edges[j];
            int u = find(set, edge.u);
            int v = find(set, edge.v);
            if (u != v) {
                union(set, u, v);
                w += edge.w;
                i++;
            }
        }
        return w;
    }
    
    private static int find(DisjointSet set, int u) {
        if (u != set.parent[u]) {
            set.parent[u] = find(set, set.parent[u]);
        }
        return set.parent[u];
    }
    
    private static void union(DisjointSet set, int u, int v) {
        int pU = set.parent[u];
        int pV = set.parent[v];
        if (set.rank[pU] < set.rank[pV]) {
            set.parent[pU] = pV;
        } else if (set.rank[pU] > set.rank[pV]) {
            set.parent[pV] = pU;
        } else {
            set.parent[pV] = pU;
            set.rank[pU]++;
        }
    }


