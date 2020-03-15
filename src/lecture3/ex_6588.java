package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/*
골드바흐의 추측 증명하는 문제.

에라토스테네스의 체 사용하기
t = a + b
a에 소수를 대입하고, b=t-a값이 소수인지 확인하기
 */

public class ex_6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int a=0;
        int b=0;
        int ARRAY_SIZE = 1000000;
        boolean[] array = new boolean[ARRAY_SIZE+1];

        //배열 초기화
        for(int i=2; i<=ARRAY_SIZE; i++)
            array[i]=true;
        //에라토스테네스의 체를 통한 소수찾기
        for(int i=2; i<ARRAY_SIZE; i++) {
            if (array[i]) {
                for (int j = i + i; j <= ARRAY_SIZE; j += i) {
                    array[j] = false;
                }
            }
        }

        while(t!=0){
            for(int i=2; i<=ARRAY_SIZE; i++) {
                if (array[i]) {
                    a = i;
                    if(array[t-a]){
                        b = t-a;
                        break;
                    }
                    else
                        continue;
                }
            }
            if(a==0)
                System.out.println("Goldbach's conjecture is wrong.");
            else {
                System.out.println(t+" = "+a+" + "+b);
                a=0;
                b=0;
            }

            t = Integer.parseInt(br.readLine());
        }
    }
}
