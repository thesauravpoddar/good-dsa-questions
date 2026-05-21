class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        int[] ind = new int[numCourses]; // indegree array
        for(int[] pre : prerequisites) {
            ind[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(ind[i] == 0) {
                q.add(i);
            }
        }
        if(q.isEmpty()) {
            return false;
        }
        int coursesTaken = 0;
        while(!q.isEmpty()) {
            int temp = q.poll();
            coursesTaken++;
            for(int[] pre : prerequisites) {
                if(pre[1] == temp) {
                    ind[pre[0]]--;
                    if (ind[pre[0]] == 0) {
                        q.add(pre[0]);
                    }
                } 
                
            }
        }
        return coursesTaken == numCourses;
        
    }

}