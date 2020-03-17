package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
팩토리얼 0의 개수
끝자리가 0이라는 것은 팩토리얼 구할 때, 2*5의 값이 있다는 것.
팩토리얼에서 2의 개수 > 5의개수 이므로 5의 개수에 초점을 맞춰서 풀기
 */
public class ex_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count_five = 0; //5의 개수
        int FIVE = 5;

        for(int i=n; i>=1; i--){
            if(i%FIVE == 0) {
                int compareValue = i;
                while(compareValue % FIVE == 0) {
                    count_five++;
                    compareValue /= FIVE;
                }
            }
        }

        System.out.println(count_five);


    }
}
