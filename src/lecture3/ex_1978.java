package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
주어진 수가 소수인지 판별하는 문제
N을 2~루트N으로 나누었을 때, 나누어지는 수가 없으면 소수라는 성질을 이용함
주의할 점은 1은 소수가 아니라는 점
 */
public class ex_1978 {
    //소수판별
    public static boolean isPrimeNum (int num){
        boolean isPrime = true;
        int i = 2;

        if(num == 1)
            return (!isPrime);

        while(i*i <= num){
            if(num%i == 0) {
                isPrime = false;
                break;
            }
            i++;
        }


        return isPrime;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int result = 0; //결과값

        for(int i=0; i<t; i++){
            int num = Integer.parseInt(st.nextToken());

            //소수이면
            if (isPrimeNum(num)){
                result++;
            }
        }

        System.out.println(result);

    }
}
