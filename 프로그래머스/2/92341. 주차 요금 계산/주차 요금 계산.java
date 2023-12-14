import java.util.*;

class Solution {
    
    static final int LAST_TIME = 23 * 60 + 59;
    
    class Time{
        int in;     // 입차시간
        int out;    // 출차시간
        int total;  // 누적 주차 시간
        Time(int in, int out, int total){
            this.in = in;
            this.out = out;
            this.total = total;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        // 차량별 입/출차 시간 정보 저장
        Map<String, Time> map = new HashMap<>();
        String[] tmp = new String[3];
        int tmpIn = 0;
        int tmpOut = 0;
        for(int i=0; i<records.length; i++){
            tmp = records[i].split(" ");   
            if(tmp[2].equals("IN")){
                tmpIn = Integer.parseInt(tmp[0].substring(0, 2)) * 60 + Integer.parseInt(tmp[0].substring(3, 5));
            }else{
                tmpOut = Integer.parseInt(tmp[0].substring(0, 2)) * 60 + Integer.parseInt(tmp[0].substring(3, 5));
            }
            // 만약 이전에 입/출차 기록이 있으면 total에 값을 넘김
            if(map.get(tmp[1]) != null){
                // 출차인 경우 -> 기존 입/출차 기록을 계산해서 누적에 담고, 입차 리셋
                if(map.get(tmp[1]).in != -1){
                    int tmpTotal = tmpOut - map.get(tmp[1]).in;
                    map.put(tmp[1], new Time(-1, tmpOut, map.get(tmp[1]).total + tmpTotal));
                    System.out.println("기존 차량 출차: " + tmp[1] + ", 누적 주차: " + (map.get(tmp[1]).total) + ", 입차: " + map.get(tmp[1]).in + ", 출차: " + tmpOut);
                }
                // 입차인 경우 -> 입차 시간 기록
                else{
                    map.put(tmp[1], new Time(tmpIn, -1, map.get(tmp[1]).total));
                    System.out.println("기존 차량 입차: " + tmp[1] + ", 누적 주차: " + map.get(tmp[1]).total + ", 입차: " + tmpIn + ", 출차: " + "-1");
                }
            }
            // 만약 이전에 입/출차 기록이 없으면
            else{
                System.out.println("신규 차량: " + tmp[1] + ", 입차: " + tmpIn );
                map.put(tmp[1], new Time(tmpIn, -1, 0));
            }
        }
        
        // 저장한 값으로 요금 계산해 2차원배열에 저장
        int[][] arr = new int[map.size()][2];
        int cnt = 0;
        for(String key : map.keySet()){
            int add = 0;
            // 누적 주차 시간
            int totalTime = map.get(key).total;
            // 입차 후 출차가 안된 경우
            if(map.get(key).in != -1){
                totalTime += LAST_TIME - map.get(key).in;
                System.out.println(key + " 누적주차: " + totalTime);
            }
            // 기본 요금을 넘은 경우 추가금 계산
            if(totalTime > fees[0]){
                add = (int)Math.ceil((float)(totalTime-fees[0]) / (float)fees[2]) * fees[3];
                System.out.println(key + " 누적주차: " + totalTime + " 추가시간: " + (totalTime-fees[0]) + " 단위요금: " + Math.ceil((float)(totalTime-fees[0]) / (float)fees[2]));
                System.out.println(key + " 추가요금: " + add);
            }
            int cost = fees[1] + add;
            System.out.println(key + " 기본요금: " + fees[1] + " 추가요금: " + add);
            // arr 저장
            arr[cnt][0] = Integer.parseInt(key);
            arr[cnt++][1] = cost;
        }
        
        // arr을 오름차순 정렬한 뒤 answer에 가격만 옮겨 담기
        Arrays.sort(arr, (o1, o2) -> o1[0]==o2[0] ? o1[1]-o1[1] : o1[0]-o2[0]);
        answer = new int[map.size()];
        for(int i=0; i<map.size(); i++){
            answer[i] = arr[i][1];
        }
        
        return answer;
    }
}