package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최소공배수와 최대공약수
public class ex_2609 {
    //min
    public static int min (int a, int b){
        int min = a;
        if(min > b)
            min = b;

        return min;
    }


    //최대공약수
    public static int gcd(int a, int b){
        int g=1;
        for(int i=2; i<=min(a,b); i++){
            if(a%i==0 && b%i==0)
                g=i;
        }

        return g;
    }

    //최소공배수
    public static int lcm(int a, int b){
        int l=1;
        l = a*b/gcd(a,b);

        return l;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));


    }
}
