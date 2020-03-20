package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
숨바꼭질 6
수빈이의 거리에서 뺀 값의 최대공약수를 구하자.

 */
public class ex_17087 {

    //동생과 수빈이의 거리 차
    public static long diffrence (long S, long A){
        if(S>A)
            return S-A;
        else
            return A-S;
    }

    //최대공약수
    public static long gcd (long a, long b){
        while(b!=0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    //여러개의 최대공약수 구하기
    public static long greatestD(long[] diff){
        long D=diff[1];

        if(diff.length>=3)
            D=gcd(diff[1],diff[2]);

        for(int i=3; i<diff.length; i++){
            D = gcd(D,diff[i]);
        }

        return D;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken()); //동생 수
        long S = Integer.parseInt(st.nextToken()); //수빈이 위치

        input = br.readLine();
        st = new StringTokenizer(input);

        //An수열 동생위치 초기화
        long[] A = new long[N+1];
        for(int i=1; i<=N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }

        //수빈이와 동생 거리차 배열 초기화
        long[] diff = new long[N+1];
        for(int i=1; i<=N; i++){
            diff[i] = diffrence(S,A[i]);
        }

        //결과 출력
        System.out.println(greatestD(diff));
    }
}
