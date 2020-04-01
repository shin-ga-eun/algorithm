package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
카드 구매하기 2.

 */
public class ex_16194 {
    public static int min (int a, int b){
        if(a<b)
            return a;
        else
            return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int[] p = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            p[i] = Integer.parseInt(st.nextToken());
            dp[i] = p[i];
        }

        //최솟값 구하기
        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                dp[i] = min(dp[i], dp[i-j]+p[j]);
            }
        }

        System.out.println(dp[N]);

    }
}
