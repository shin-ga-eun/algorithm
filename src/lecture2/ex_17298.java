package lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*오큰수*/
public class ex_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        StringBuilder sb = new StringBuilder(); //선언
        int t = Integer.parseInt(br.readLine()); //테스트 개수

        int[] array = new int[t+1]; //input값 배열
        int[] result = new int[t+1]; //정답 배열
        Stack<Integer> stack = new Stack<>();

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        //수열 초기화
        for(int i=1; i<=t; i++) {
            int input = Integer.parseInt(st.nextToken());
            array[i] = input;
            result[i] = 0;
        }

        //오큰수찾기 (이 값이 오큰수가 될 수 있는가?)
        stack.push(1); //첫 값은 예외 (처음에 오큰수를 찾을 수 없으므로)
        for(int i=2; i<=t; i++){
            //오큰수를 찾은 경우
            while(!stack.isEmpty() && array[stack.peek()] < array[i]) {
                result[stack.peek()] = array[i];
                stack.pop();
            }
            stack.push(i);

        }
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }

        //정답출력
        for(int i=1; i<t; i++)
            sb.append(result[i]+" ");
        sb.append(result[t]);

        System.out.println(sb);

    }
}

