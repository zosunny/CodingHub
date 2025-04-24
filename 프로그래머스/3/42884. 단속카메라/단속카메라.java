import java.util.*;

/*
    모든 차량이 1번은 단속 카메라 만나야 한다면 최소 몇대 설치?
*/

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        int n = routes.length;
        
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        
        int minE = routes[0][1];
        for(int i=1; i<n; i++){
            int s = routes[i][0];
            int e = routes[i][1];
            if(s <= minE) minE = Math.min(minE, e);
            else{
                answer++;
                minE = e;
            }
        }
        
        return answer;
    }
}