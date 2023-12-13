import java.util.*;

class Solution {
    
    static int len;
    static boolean[][] check;
    static Map<String, Integer> map;
    static String[] answer;
    
    // 부분집합 만드는 함수
    public static void subset(int cnt, boolean[] select, String[] dish, int len, int[] course){
        if(cnt==len){
            String makecourse = "";
            for(int i=0; i<len; i++){
                if(select[i]){
                    makecourse += dish[i];
                }
            }
            // course에 정의된 개수인지 확인
            int c = makecourse.length();
            boolean flag = false;
            for(int k=0; k<course.length; k++){
                if(c == course[k]){
                    flag = true;
                }
            }
            // 맞으면 map에 저장
            if(flag){
                map.put(makecourse, map.getOrDefault(makecourse, 0) + 1);
            }
            return;
        }
        subset(cnt+1, select, dish, len, course);
        select[cnt] = true;
        subset(cnt+1, select, dish, len, course);
        select[cnt] = false;
    }
    
    // 각 메뉴 비교해 같은 단품메뉴가 있는지 확인하는 함수
    public static void menu(int[] course){
        map = new HashMap<>();
        for(int i=0; i<len-1; i++){
            for(int j=1; j<len-i; j++){
                String tmp = "";
                for(int l=0; l<26; l++){
                    // 두 주문의 같은 단품메뉴 존재 확인
                    if(check[i][l] && check[i+j][l]){
                        tmp += Character.toString((char)(l + 'A'));
                    }
                }
                // 해당 tmp로 만들 수 있는 모든 부분집합
                int tmplen = tmp.length();
                boolean[] select = new boolean[tmplen];
                String[] dish = new String[tmplen];
                dish = tmp.split("");
                subset(0, select, dish, tmplen, course);
            }
        }
        
        // 각 코스 길이별 최대 길이 저장
        int[] maxCourse = new int[11];
        for(String key : map.keySet()){
            maxCourse[key.length()] = Math.max(maxCourse[key.length()], map.get(key));
        }
        // 최대 길이랑 같은 코스메뉴만 list에 옮겨담기
        ArrayList<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key) == maxCourse[key.length()]){
                list.add(key);
            }
        }
        // list에 있는 값 다시 answer에 담기
        answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        // 오름차순 정렬
        Arrays.sort(answer);
    }
    
    public String[] solution(String[] orders, int[] course) {
        
        len = orders.length;
        
        // 알파벳을 담을 배열 생성
        check = new boolean[len][26];
        
        // 단품메뉴의 주문 현황 체크
        for(int i=0; i<len; i++){
            for(int j=0; j<orders[i].length(); j++){
                // 알파벳을 숫자로 변환해 체크
                int tmp = orders[i].charAt(j) - 'A';
                check[i][tmp] = true;
            }
        }
        
        // 코스요리 메뉴 구성
        menu(course);
        
        return answer;
    }
}