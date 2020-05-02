package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
포도주 시식.
포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 가장 많은 양의 포도주를 마실 수 있도록 하는 문제.

반례가 어려웠다,, 1 2 0 0 8 9 포도주를 2번 연속 안 먹을 경우이다.
[참고: https://mygumi.tistory.com/98]
 */

public class ex_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] glass = new int[n+1];
        long[] dp = new long[n+1];

        //glass 배열 초기화
        for(int i=1; i<=n; i++){
            int input = Integer.parseInt(br.readLine());
            glass[i] = input;
        }

        //dp
        dp[0] = 0;
        dp[1] = glass[1];

        for(int i=2; i<=n; i++){
            if(i==2){
                dp[2] = glass[1] + glass[2];
                continue;
            }
            dp[i] = Math.max(dp[i-3]+glass[i-1], dp[i-2]) + glass[i];
            dp[i] = Math.max(dp[i-1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}
