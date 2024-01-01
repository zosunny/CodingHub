import java.util.*;

class Solution {
    
    static int len1;
    static int len2;
    static Map<String, List<Integer>> map;
    
    // 코테 점수를 기준으로 이분탐색
    public static int binarySearch(String q, int score){
        
        // 존재하지 않을 때
        if(!map.containsKey(q)) return 0;
        
        int start = 0;
        int end = map.get(q).size();
        
        while(start < end){
            int mid = (start + end) / 2;
            
            // 중간값보다 왼쪽일 때
            if(score <= map.get(q).get(mid)){
                end = mid;
            }
            // 중간값보다 오른쪽일 때
            else{
                start = mid + 1;
            }
        }
        return map.get(q).size() - start;
    }
    
    // 현재 info로 만들 수 있는 모든 쿼리 생성
    public static void makequery(String[] tmp, String s, int cnt){
        if(cnt == 4){
            // map에 있는 쿼리면 기존 쿼리에 점수만 더해서 저장
            if(map.containsKey(s)){
                map.get(s).add(Integer.parseInt(tmp[4]));
            }
            // map에 없는 쿼리면 새로 저장
            else{
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(tmp[4]));
                map.put(s, list);
            }
            return;
        }
        makequery(tmp, s + "-", cnt+1);
        makequery(tmp, s + tmp[cnt], cnt+1);
    }
    
    public int[] solution(String[] info, String[] query) {
        
        len1 = info.length;
        len2 = query.length;
        int[] answer = new int[len2];
        
        // 1. info를 가지고 만들 수 있는 모든 쿼리 생성
        map = new HashMap<>();
        for(int i=0; i<len1; i++){
            String[] tmp = info[i].split(" ");
            makequery(tmp, "", 0);
        }

        // 2. 점수를 기준으로 오름차순 정렬
        for(List<Integer> x : map.values()){
            Collections.sort(x);
        }
        
        // 3. 문의조건 점수를 기준으로 이진탐색
        int cnt = 0;
        for(int i=0; i<len2; i++){
            String[] tmp1 = query[i].split(" and ");
            String[] tmp2 = tmp1[3].split(" ");
            String q = tmp1[0] + tmp1[1] + tmp1[2] + tmp2[0];
            int score = Integer.parseInt(tmp2[1]);
            
            answer[cnt++] = binarySearch(q, score);
        }
        
        return answer;
    }
}