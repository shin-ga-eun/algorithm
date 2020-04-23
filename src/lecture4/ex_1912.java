package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
연속합.
n개의 정수로 이루어진 임의의 수열이 주어짐.
연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합은?

dp[i] = A[i]를 포함하는 합
연속이니까 dp[i-1]과 dp[i]의 관계를 이용
 */

public class ex_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int[] A = new int[n+1];
        int[] dp = new int[n+1]; //A[i]를 추가한 부분 수열의 합

        //배열 A 초기화
        for(int i=1; i<=n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            dp[i] = -1001;
        }

        //dp
        dp[1] = A[1];
        for(int i=2; i<=n; i++){
            dp[i] = A[i];
            if(dp[i] < dp[i-1] + dp[i]){
                dp[i] = dp[i-1] + dp[i];
            }
        }

        //정답 출력
        int max = dp[1];
        for(int i=2; i<=n; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
