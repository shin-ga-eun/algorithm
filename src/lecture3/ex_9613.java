package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
GCD 합.
양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램

자료형
long과 int

 */
public class ex_9613 {

    //최대공약수
    public static int gcd(int a, int b){

        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //테스트 개수
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int size = Integer.parseInt(st.nextToken());
            int[] array = new int[size];

            //array 배열 초기화
            int index=0;
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                array[index]=num;
                index++;
            }

            long sum = 0;
            for(int a=0; a<size; a++){
                for(int b=a+1; b<size; b++){
                    sum += gcd(array[a],array[b]);
                }

            }

            sb.append(sum+"\n");
        }

        System.out.println(sb);

    }
}
