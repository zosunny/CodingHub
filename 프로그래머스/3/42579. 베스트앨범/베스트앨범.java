import java.util.*;

class Solution {
    
    static class Point{
        int num;
        int cnt;
        Point(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        
        // 1) 장르별 정보 저장
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Point>> mapList = new HashMap<>();
        for(int i=0; i<n; i++){
            String g = genres[i];
            int p = plays[i];
            // 총 재생횟수
            map.put(g, map.getOrDefault(g, 0) + p);
            // 개별 곡 저장
            mapList.putIfAbsent(g, new ArrayList<>());
            mapList.get(g).add(new Point(i, p));
        }
        
        // 2) 장르별 총 재생횟수 내림차순
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        // 3) 해당 장르에서의 개별 곡 재생횟수 내림차순, 고유번호 오름차순
        List<Integer> ans = new ArrayList<>();
        for(String s : keySet){
            List<Point> tmp = mapList.get(s);
            tmp.sort((o1, o2) -> {
                if(o1.cnt == o2.cnt) return o1.num - o2.num;
                else return o2.cnt - o1.cnt;
            });
            // 2개씩 저장하되, 곡이 1개인 경우도 고려
            for(int i=0; i<tmp.size() && i<2; i++){
                ans.add(tmp.get(i).num);
            }
        }
        
        int[] answer = ans.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}