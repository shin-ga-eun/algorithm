package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2진수를 8진수로 변환하는 문제.

2진수 입력을 string으로 받아서 런타임에러나 컴파일에러 피하ㅈ기
 */

public class ex_1373 {
    public static String change(String s){
        int result = 0;
        int two = 1;
        for(int i=s.length()-1; i>=0; i--){
            result += (s.charAt(i) - '0')*two;
            two*=2;
        }

        return ""+result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        int r = input.length()%3;

        if(r!=0){
            sb.append(change(input.substring(0,r)));
        }

        int count = 3;
        for(int i=r; i<input.length(); i+=count){
            sb.append(change(input.substring(i,i+count)));
        }

        System.out.println(sb);


    }
}
