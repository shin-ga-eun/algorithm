package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
나머지연산.
(a+b)%m = ((a%m)+(b%m))%m
(a*b)%m = ((a%m)*(b%m))%m
(a-b)%m = ((a%m)-(b%m)+m)%m
나누기는 성립하지 않음
 */
public class ex_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println((a+b)%c);
        System.out.println((a%c+b%c)%c);
        System.out.println((a*b)%c);
        System.out.println((a%c * b%c)%c);


    }
}
