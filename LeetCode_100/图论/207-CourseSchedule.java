class Solution {
    /*
    题目：207.课程表      
    你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

    在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
    其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

    例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
    请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
        思路：本题通过拓扑排序判断有向图中是否存在环：将课程视为节点，先修关系视为有向边，构建邻接表；
        使用三色标记 DFS（0=未访问，1=访问中，2=已完成）遍历图，若在 DFS 过程中遇到状态为 1 的节点，
        说明存在回边，即有环，无法完成所有课程；若全图遍历无环，则可以完成。
        */
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
        }

        int[] colors = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == 0 && dfs(i, g, colors)) {
                return false; // 有环
            }
        }
        return true; // 没有环
    }

    // 返回 true 表示找到了环
    private boolean dfs(int x, List<Integer>[] g, int[] colors) {
        colors[x] = 1; // x 正在访问中
        for (int y : g[x]) {
            // 情况一：colors[y] == 1，表示发生循环依赖，找到了环
            // 情况二：colors[y] == 0，未知，继续递归 y 获取信息
            // 情况三：colors[y] == 2，继续递归 y 只会重蹈覆辙，和之前一样无法找到环
            if (colors[y] == 1 || colors[y] == 0 && dfs(y, g, colors)) {
                return true; // 找到了环
            }
        }
        colors[x] = 2; // x 完全访问完毕，从 x 出发无法找到环
        return false; // 没有找到环
    }
}