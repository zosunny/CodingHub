import java.util.*;

class Solution {
    
    static int answer;
    static int len;
    static long tmp1;
    static long tmp2;
    static long sum;
    
    static Queue<Long> q1;
    static Queue<Long> q2;
    
    // sum보다 큰 큐에서 pop해 작은 큐에 insert하는 함수
    public static void calc(){
        int cnt = 0;
        while(true){
            // 어떤 방법으로도 만들 수 없을 때
            if(q1.isEmpty() || q2.isEmpty() || cnt > len*4){
                return;
            }
            // q1과 q2의 합이 같을 때
            if(tmp1 == tmp2){
                answer = cnt;
                return;
            }
            // q1이 sum보다 클 때
            else if(sum < tmp1){
                long tmp = q1.poll();
                q2.add(tmp);
                tmp1 -= tmp;
                tmp2 += tmp;
                cnt++;
                // System.out.println("tmp1: " + tmp1 + ", tmp2: " + tmp2 + ", cnt: " + cnt);
            }
            // q2가 sum보다 클 때
            else if(sum < tmp2){
                long tmp = q2.poll();
                q1.add(tmp);
                tmp2 -= tmp;
                tmp1 += tmp;
                cnt++;
                // System.out.println("tmp1: " + tmp1 + ", tmp2: " + tmp2 + ", cnt: " + cnt);
            }
        }
    }
    
    public int solution(int[] queue1, int[] queue2) {
        answer = -1;
        
        len = queue1.length;
        
        // 배열을 큐로 변환하고 각 큐의 합 구하기
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        for(int i=0; i<len; i++){
            q1.add((long)queue1[i]);
            q2.add((long)queue2[i]);
            tmp1 += (long)queue1[i];
            tmp2 += (long)queue2[i];
        }
        sum = (tmp1 + tmp2) / 2;
        // System.out.println(sum);
        // System.out.println("tmp1: " + tmp1 + ", tmp2: " + tmp2);
        
        // 계산
        calc();
        
        return answer;
    }
}