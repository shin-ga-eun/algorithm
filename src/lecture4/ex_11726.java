package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2*n 타일링

런타임에러: 배열 크기를 input+1로 했을 경우, input=1일때, dp[2]에서 오류가 나기 때문에 발생했다..
 */
public class ex_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1]=1;
        dp[2]=2;

        for(int i=3; i<=input; i++){
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }

        System.out.println(dp[input]);

    }
}
