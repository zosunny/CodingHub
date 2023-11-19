import java.util.*;

class Solution {
    
    static int t;
    static int len;
    
    class Point{
        String name;
        int playtime;
        
        Point(String name, int playtime){
            this.name = name;
            this.playtime = playtime;
        }
    }
    
    public String[] solution(String[][] plans) {
        
        len = plans.length;
        String[] answer = new String[len];
        
        // 시간을 기준으로 오름차순 정렬
        Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));
        
        Stack<Point> st = new Stack<>();
        int cnt = 0;
        
        for(int i=0; i<len; i++){
            // 만약 마지막이면 비교하지 말고 바로 name 넣고 끝
            if(i == len-1){
                answer[cnt] = plans[i][0];
                cnt++;
                if(!st.isEmpty()){
                    while(!st.isEmpty()){
                        Point p = st.pop();
                        answer[cnt] = p.name;
                        cnt++;
                    }
                }
                break;
            }
            // i와 i+1 사이의 시간(t)을 계산해서
            String[] tmp1 = plans[i][1].split(":");
            String[] tmp2 = plans[i+1][1].split(":");
            int h1 = Integer.parseInt(tmp1[0]);
            int m1 = Integer.parseInt(tmp1[1]);
            int h2 = Integer.parseInt(tmp2[0]);
            int m2 = Integer.parseInt(tmp2[1]);
            t = (h2*60 + m2) - (h1*60 + m1);
            // i의 playtime
            int playtime = Integer.parseInt(plans[i][2]);
            
            // i의 playtime보다 t가 작으면 stack에 (playtime - t) 넣고 다음으로 넘어간다.
            if(playtime > t){
                st.add(new Point(plans[i][0], (playtime - t)));
                continue;
            }
            // i의 playtime이 t와 같으면 answer에 name을 담고 넘어간다.
            else if(playtime == t){
                answer[cnt] = plans[i][0];
                cnt++;
            }
            // i의 playtime보다 t가 크면 answer에 name을 담고,
            else if(playtime < t){
                answer[cnt] = plans[i][0];
                cnt++;
                t = t - playtime;
                while(!st.isEmpty()){
                    // stack에서 기존에 하던 과제 pop해
                    Point poped = st.pop();
                    // pop한 playtime이 t보다 크면 다시 playtime - t해서 stack에 넣고,
                    if(poped.playtime > t){
                        st.add(new Point(poped.name, (poped.playtime - t)));
                        t = 0;
                    }
                    // pop한 playtime이 t보다 작거나 같으면 answer에 name을 담고,
                    else if(poped.playtime <= t){
                        answer[cnt] = poped.name;
                        cnt++;
                        t -= poped.playtime;
                    }
                    // 시간이 다 소요된 경우 다음으로 넘어간다.
                    if(t == 0) break;
                }
            }
        }
        return answer;
    }
}