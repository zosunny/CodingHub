import java.util.*;

class Solution {
    
    static class Point {
        String menu;
        int num;
        Point (String menu, int num){
            this.menu = menu;
            this.num = num;
        }
    }
    
    static int len;
    // static int maxNum = Integer.MIN_VALUE();
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
            // 2개 이상이고, course에 정의된 개수인지 확인
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
                // System.out.println("만들어진 코스: " + makecourse);
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
                // System.out.println("i: " + i + ", i+j: " + (i+j) + ", tmp: " + tmp);
                // 해당 tmp로 만들 수 있는 모든 부분집합
                int tmplen = tmp.length();
                boolean[] select = new boolean[tmplen];
                String[] dish = new String[tmplen];
                dish = tmp.split("");
                subset(0, select, dish, tmplen, course);
                // System.out.println("--------------------");
            }
        }
        
        // // map에 들은 거 출력
        // for(String key : map.keySet()){
        //     System.out.println("key: " + key + ", 개수: " + map.get(key));
        // }
        
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
        
        
//         // map에서 코스 길이별 최고빈도의 메뉴 구성만 선택
//         Point[] coursemenu = new Point[11];
//         for(int i=0; i<11; i++){
//             coursemenu[i] = new Point("", 0);
//         }
//         ArrayList<String> list = new ArrayList<>();
//         for(String key : map.keySet()){
//             // 만약 현재 저장한 빈도보다 더 큰 빈도라면 swap
//             if(coursemenu[key.length()].num < map.get(key)){
                
//                 coursemenu[key.length()] = new Point(key, map.get(key));
//             }
//             // 만약 현재 저장한 빈도와 같다면 answer에 저장
//             // else if(coursemenu[key.length()].num == map.get(key)){
//             //     list.add(key);
//             // }
//         }
        // // 선택된 메뉴들 리스트에 한 번 옮겨 담기
        // for(int i=0; i<11; i++){
        //     if(coursemenu[i].num != 0){
        //         list.add(coursemenu[i].menu);
        //     }
        // }
        // // answer 저장
        // answer = new String[list.size()];
        // for(int i=0; i<list.size(); i++){
        //     answer[i] = list.get(i);
        // }
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