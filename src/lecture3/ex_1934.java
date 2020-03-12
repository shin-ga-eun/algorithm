package lecture3;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최소공배수
public class ex_1934 {

    public static int gcd (int a, int b){
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }

        return a;
    }


    public static int lcm (int a, int b){
        int l=1;
        l = a*b/gcd(a,b);

        return l;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(lcm(a,b));

        }




    }
}
