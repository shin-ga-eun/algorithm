package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
정수 삼각형.
        7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5
위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 문제.
아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
삼각형의 크기는 1 이상 500 이하이다.
삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

 */
public class ex_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n+1][n+1];
        long[][] dp = new long[n+1][n+1];

        //triangle 배열 초기화
        for(int i=1; i<=n; i++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            for(int j=1; j<=i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dp
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if(i==1){
                    dp[1][1] = triangle[1][1];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }

        long max = dp[n][1];
        for(int i=2; i<=n; i++){
            max = Math.max(max, dp[n][i]);
        }

        System.out.println(max);

    }
}
