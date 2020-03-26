package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
8진수를 2진수로 변환하는 문제.

왜 런타임에러가 일어나는지 모르겠다 ㅜㅜ
 */

public class ex_1212 {
    public static String change(char s){
        int input = s-'0';
        String[] array = {"0","0","0"};

        int index = 2;
        while(input>=2){
            int r = input%2;
            array[index] = ""+r;
            input /= 2;
            index--;
        }
        if(input>0)
            array[index]=""+input;

        return array[0]+array[1]+array[2];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        int i=0;
        for(i=0; i<input.length(); i++){
            sb.append(change(input.charAt(i)));
        }

        i=0;
        while(sb.charAt(i)=='0')
            i++;
        System.out.println(sb.substring(i));

    }
}
