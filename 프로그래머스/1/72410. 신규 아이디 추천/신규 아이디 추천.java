class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1. 대문자 -> 소문자
        answer = new_id.toLowerCase();
        // 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        // 3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        // 4. 마침표(.)가 처음이나 끝에 위치한다면 제거
        if(answer.substring(0, 1).equals(".")) answer = answer.substring(1);
        if(answer.length() > 0 && answer.substring(answer.length()-1, answer.length()).equals(".")) {
            answer = answer.substring(0, answer.length()-1);
        }
        // 5. 빈 문자열이라면, new_id에 "a"를 대입
        if(answer.length() == 0) answer = "a";
        // 6. 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        if(answer.length() >= 16) answer = answer.substring(0, 15);
        // 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
        if(answer.substring(answer.length()-1, answer.length()).equals(".")) answer = answer.substring(0, answer.length()-1);
        // 7. 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
        if(answer.length() <= 2) {
            while(answer.length() < 3){
                answer += answer.substring(answer.length()-1, answer.length());
            }
        }
        return answer;
    }
}