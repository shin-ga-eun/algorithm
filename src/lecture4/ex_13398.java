package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
연속합2. ********************
n개의 정수로 이루어진 임의의 수열이 주어진다.
이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
단, 수는 한 개 이상 선택해야 한다. 또, 수열에서 수를 하나 제거할 수 있다. (제거하지 않아도 된다)

dp를 구할 때, dp[i]를 i를 제거한 연속합이라고 정의하고 계산하면 데이터 개수가 10만이라면 10만^2이 되어서 시간초과가 발생한다.
그래서 dp를 i를 기준으로 왼쪽에서의 연속합, 오르쪽에서의 연속합을 더한 값이라고 생각해서 풀어야 한다.
그리고 답구할때도 제거하지 않았을 경우도 생각해야한다 참나
 */
public class ex_13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int[] array = new int[N+1];
        long[] dp_left = new long[N+1];
        long[] dp_right = new long[N+1];
        long ans = -1000;

        //배열 초기화
        for(int i=1; i<=N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        //크기가 1인 경우, 예외처리
        if(N==1){
            System.out.println(array[1]);
            return;
        }

        //dp_left
        dp_left[1] = array[1];
        for(int i=2; i<=N; i++){
            dp_left[i] = Math.max(array[i], dp_left[i-1]+array[i]);
        }

        //dp_right
        dp_right[N] = array[N];
        for(int i=N-1; i>=1; i--){
           dp_right[i] = Math.max(array[i], dp_right[i+1]+array[i]);
        }

        //ans
        for(int i=1; i<=N; i++){
            ans = Math.max(ans, dp_left[i]);
        }
        for(int i=2; i<=N-1; i++){
            ans = Math.max(ans, dp_left[i-1]+dp_right[i+1]);
        }
        System.out.println(ans);
    }
}

