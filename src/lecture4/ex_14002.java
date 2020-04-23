package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
가장 긴 증가하는 부분 수열 4.
가장 긴 증가하는 부분 수열을 출력하고, 만약 수열이 여러가지인 경우 아무거나 출력한다.

dp[i] = A[i]를 최대로 하는 부분 수열이라는 점을 이용하여 해결

 */
public class ex_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int[] A = new int[N+1];
        int[] dp = new int[N+1]; //A[i]를 최댓값으로 하는 부분수열의 길이
        StringBuilder sb = new StringBuilder();

        // 배열 A 초기화
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            dp[i] = 1;
            for(int j=1; j<=i; j++){
                if(A[j] < A[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }

        int max_dp = dp[1];
        for(int i=2; i<dp.length; i++){
            max_dp = Math.max(max_dp, dp[i]);
        }

        System.out.println(max_dp);

        Stack<Integer> stack = new Stack<>();
        for(int i=N; i>0; i--){
            if(max_dp == dp[i]){
                stack.push(A[i]);
                max_dp--;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }

        System.out.println(sb);



    }
}
