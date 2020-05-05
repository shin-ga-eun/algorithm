package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
가장 큰 증가 부분 수열.
수열 A가 주어졌을 때, 그 수열의 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 문제.

dp[i]: array[i]를 최대로 가지는 증가 수열의 합
 */

public class ex_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int[] array = new int[N+1];
        long[] dp = new long[N+1];

        //배열 array 초기화
        for(int i=1; i<=N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        //dp
        dp[1] = array[1];
        for(int i=1; i<=N; i++){
            long max = 0;
            for(int j=i-1; j>=1; j--){
                if(array[i] > array[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + array[i];
        }

        //정답 출력
        long ans = 0;
        for(int i=1; i<=N; i++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
