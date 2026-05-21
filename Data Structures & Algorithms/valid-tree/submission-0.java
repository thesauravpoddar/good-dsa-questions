class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, -1});
        visited[0] = true;
        while(!q.isEmpty()) {
            int[] edge = q.poll();
            int at = edge[0];
            int parent = edge[1];
            // visited[at] = true;
            for(int to : adj.get(at)) {
               if(!visited[to]) {
                visited[to] = true;
                q.add(new int[]{to, at});
               } else if(to != parent) {
                return false;
               }
            }
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) return false;
        }                            
        return true;

    }
}
