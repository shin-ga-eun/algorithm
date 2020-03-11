package lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class ex_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String input = br.readLine();

        //input값 받아오기
        StringTokenizer st = new StringTokenizer(input);
        Stack<Integer> inputStack = new Stack<>();
        int max = 0;
        for(int i=0; i<t; i++) {
            int num = Integer.parseInt(st.nextToken());
            inputStack.push(num);
            if(num > max)
                max = num;
        }

        //배열 초기화
        int[] countArray = new int[max+1]; //등장횟수 배열 countArray
        int[] inputArray = new int[t+1]; //입력 배열 inputArray
        int[] input_count = new int[t+1];

        int[] result = new int[t+1]; //결과값
        for(int i=1; i<=max; i++){
            countArray[i] = 0;
        }
        for(int i=1; i<=t; i++){
            inputArray[i] = 0;
            result[i] = 0;
            input_count[i] = 0;

        }

        int index = t; //inputArray인덱스 값 변수
        while(!inputStack.isEmpty()){
            int num = inputStack.pop();
            inputArray[index--] = num;
            countArray[num]++;

        }

        //inputArray 배열값을 등장횟수 배열값으로 변환
        for(int i=1; i<=t; i++){
            input_count[i] = countArray[inputArray[i]];
        }

        //오등큰수 찾기
        inputStack.clear();
        inputStack.push(1); //오등큰수를 못찾은 input_count배열의 인덱스를 저장할 스택
        for(int i=2; i<=t; i++){
            //오등큰수이면
            while(!inputStack.isEmpty() && input_count[inputStack.peek()]<input_count[i]){
                result[inputStack.peek()] = inputArray[i];
                inputStack.pop();
            }
            inputStack.push(i);
        }
        while(!inputStack.isEmpty()) {
            result[inputStack.pop()] = -1;
        }

        //결과출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<t; i++)
            sb.append(result[i]+" ");
        sb.append(result[t]);

        System.out.println(sb);




    }


}
