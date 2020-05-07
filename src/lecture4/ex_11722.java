package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
가장 긴 감소하는 부분 수열 (LIS).

 */

public class ex_11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int[] array = new int[N+1];
        int[] dp = new int[N+1];

        //array 배열 초기화
        for(int i=1; i<=N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        //dp
        for(int i=N; i>=1; i--){
            dp[i] = 0;
            for(int j=N; j>=i; j--){
                if(array[i] > array[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] == 0) {
                dp[i] = 1;
            }
        }

        //ans
        int ans = 0;
        for(int i=1; i<=N; i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);


    }
}
