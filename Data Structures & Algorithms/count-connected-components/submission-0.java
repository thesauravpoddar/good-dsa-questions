class Solution {
    public int countComponents(int n, int[][] edges) {
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
            boolean[] visited = new boolean[n];
            int count = 0;
            for(int i =0; i< n; i++) {
                if(visited[i]) {
                    continue;
                } else {
                    count++;
                    dfs(n, edges, i, visited, adj);
                }
                
            }
            return count;
    }
        public void dfs(int n, int[][] edges, int num, boolean[] visited, List<List<Integer>> adj) {
            Queue<Integer> q = new LinkedList<>();
            q.add(num);
            visited[num] = true;
            while(!q.isEmpty()) {
                int at = q.poll();
                for(int to : adj.get(at)) {
                    if(!visited[to]) {
                        visited[to] = true;
                        q.add(to);
                    }
                }
            }
        }  
}
