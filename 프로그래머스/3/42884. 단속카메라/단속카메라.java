import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        int len = routes.length;
        
        Arrays.sort(routes, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        
        int minE = routes[0][1];
        for(int i=1; i<len; i++){
            int ns = routes[i][0];
            int ne = routes[i][1];
            // 다음 차량의 이동경로가 이전 차량의 이동경로 안에 포함되면
            if(ns <= minE) minE = Math.min(minE, ne);
            else {
                answer++;
                minE = ne;
            }
        }
        
        return answer;
    }
}