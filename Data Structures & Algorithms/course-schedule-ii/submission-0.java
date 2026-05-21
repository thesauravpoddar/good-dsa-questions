class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
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
        // if(q.isEmpty()) {
        //     return false;
        // }
        int i = 0;
        int[] ans = new int[numCourses];
        int coursesTaken = 0;
        while(!q.isEmpty()) {
            int temp = q.poll();
            ans[i] = temp;
            i++;
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
        if(coursesTaken == numCourses) {
            return ans;
        } else return new int[0];
    }
}