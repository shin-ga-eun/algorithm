package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
조합 0의 개수.
팩토리얼 0의 개수와 다르게 2의 개수>5의개수 라는 보장이 없으므로 두 개 다 구한 후 계산한다.
nCm = n! / m!(n-m)!
 */
public class ex_2004 {
    public static int min (int a, int b){
        if(a<b)
            return a;
        else
            return b;
    }
    public static int sumFIVE (long n){
        int FIVE = 5;
        int countFIVE = 0;

        for(long i=5; i<=n; i*=FIVE)
            countFIVE += n/i;

        return countFIVE;
    }

    public static int sumTWO (long n){
        int TWO = 2;
        int countTWO = 0;

        for(long i=2; i<=n; i*=TWO)
            countTWO += n/i;

        return countTWO;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        int two = sumTWO(n)-sumTWO(m)-sumTWO(n-m);
        int five = sumFIVE(n)-sumFIVE(m)-sumFIVE(n-m);

        System.out.println(min(two,five));
    }
}
