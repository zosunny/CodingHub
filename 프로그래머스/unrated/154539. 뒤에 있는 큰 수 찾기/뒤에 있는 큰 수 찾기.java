import java.util.*;
import java.io.*;


class Solution {
    public int[] solution(int[] numbers) {
        
        int len = numbers.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        
        // 일단 스택에 다 넣어
        Stack<Integer> copy = new Stack<>();
        for(int i=0; i<len; i++){
            copy.push(numbers[i]);
        }
        
        Stack<Integer> stack = new Stack<>();
        for(int i=len-1; i>=0; i--){
            int now = copy.pop();
            // 스택(오른쪽)에 아무것도 없으면 스택에 넣고 다음
            if(stack.size()==0){
                stack.push(now);
            }
            else{
                // 오른쪽 정수를 확인해서 크면 tmp에 큰 정수 담고, 작으면 계속 pop
                while(!stack.isEmpty()){
                    if(now < stack.peek()){
                        result[i] = stack.peek();
                        break;
                    }else{
                        stack.pop();
                    }
                }
                stack.push(now);
            }
        }
        return result;
    }
}