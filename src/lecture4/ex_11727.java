package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2*n 타일링 2
 */
public class ex_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1]=1;
        dp[2]=3;


        for(int i=3; i<=input; i++){
            dp[i] = (dp[i-1] + dp[i-2]+dp[i-2])%10007;
        }

        System.out.println(dp[input]);

    }
}
