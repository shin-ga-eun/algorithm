package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_15988 {
    static final int mod = 1000000009;
    static final int limit = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[limit+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int test=0; test<T; test++){
            int input = Integer.parseInt(br.readLine());

            for(int i=3; i<=input; i++){
                if(dp[i] > 0){
                    continue;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                    dp[i] %= mod;
                }
            }
            sb.append(dp[input]+"\n");
        }
        System.out.println(sb);


    }
}
