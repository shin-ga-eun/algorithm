package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
제곱수의 합.
주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 문제.
 */
public class ex_1699 {
    static final int limit = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[limit+1];

        int max = 1;
        int min;
        for(int i=1; i<=N; i++){
            min = i;
            for(int j=1; j*j <= i; j++){
                max = j*j;
                if(min > dp[i-max]+1)
                     min = dp[i-max] + 1;
            }
            dp[i] = min;
        }
        System.out.println(dp[N]);
    }
}
