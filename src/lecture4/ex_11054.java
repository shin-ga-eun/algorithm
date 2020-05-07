package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
가장 긴 바이토닉 부분 수열.

수열 S가 어떤 수 Sk를 기준으로 왼쪽은 증가수열, 오른쪽은 감소수열을 이루는 수열 S의 부분 수열 중 길이가 가장 긴 수열의 길이를 구하는 문제.
 */
public class ex_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int[] array = new int[N+1];
        int[] dp = new int[N+1];
        int[] down_dp = new int[N+1];

        //array 배열 초기화
        for(int i=1; i<=N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        //dp
        for(int i=1; i<=N; i++){
            dp[i] = 0;

            for (int j = 1; j < i; j++) {
                if (array[i] > array[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

        }

        //down_dp
        for(int i=N; i>=1; i--){
            down_dp[i] = 0;

            for(int j=N; j>=i; j--){
                if(array[i] > array[j] && down_dp[i] < down_dp[j]+1){
                    down_dp[i] = down_dp[j]+1;
                }
            }
        }

        //ans
        int ans = 0;
        for(int i=1; i<=N; i++){
            ans = Math.max(ans, dp[i]+down_dp[i]+1);
        }
        System.out.println(ans);
    }
}
