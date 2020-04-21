package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
가장 긴 증가하는 부분 수열 (최장증가수열 LIS) -> O(n^2) 풀이

dp[i] = A[i]를 가장 큰 수로 하는, A[1] ~ A[i]번째까지의 증가수열의 길이
 */

public class ex_11053 {
    public static int max (int a, int b){
        if(a < b)
            return b;
        else
            return a;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int[] A = new int[t+1];
        int[] dp = new int[t+1];

        //수열 A 초기화
        for(int test=1; test<=t; test++){
            A[test] = Integer.parseInt(st.nextToken());
        }

        //dp
        for(int i=1; i<=t; i++){
            dp[i] = 1;
            for(int j=1; j<=i; j++){
                if(A[j] < A[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        //정답 출력
        int answer = dp[1];
        for(int i=2; i<=t; i++){
            answer = max(answer,dp[i]);
        }
        System.out.println(answer);

    }
}
