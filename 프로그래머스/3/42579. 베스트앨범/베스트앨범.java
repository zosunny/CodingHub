import java.util.*;

/*
    장르 -> 많은 재생 횟수 -> 낮은 고유 번호
    장르별 2개만
    고유 번호 반환
    
    1) {장르: 재생횟수} 저장
    2) {장르: List<int[]> 고유번호, 재생횟수}
*/

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<int[]>> mapList = new HashMap<>();
        for(int i=0; i<n; i++){
            String g = genres[i];
            int p = plays[i];
            // 장르별 재생 총합 정보 저장
            map.put(g, map.getOrDefault(g, 0) + p);
            // 개별 곡 재생 정보 저장
            mapList.putIfAbsent(g, new ArrayList<>());
            mapList.get(g).add(new int[]{i, p});
        }
        
        // map 정렬 -> List
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        // 해당 장르에서 수록 기준에 따른 고유 번호 저장
        List<Integer> ans = new ArrayList<>();
        for(String s : keySet){
            List<int[]> tmp = mapList.get(s);
            tmp.sort((o1, o2) -> {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                else return o2[1] - o1[1];
            });
            // 곡이 한개인 경우도 고려
            for(int i=0; i<tmp.size() && i<2; i++){
                ans.add(tmp.get(i)[0]);
            }
        }
        
        int[] answer = ans.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}