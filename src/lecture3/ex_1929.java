package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
에라토스테네스의 체를 이용한 소수찾기
수를 다 적고,
지워지지 않은 수의 배수를 제거.

배수 제거 시, 조건에 주의해서 시간초과 조심하기
for(int j=i+i; j<=m; j+=i)
 */
public class ex_1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] array = new boolean[m+1];
        //배열 초기화
        for(int i=2; i<=m; i++){
            array[i] = true;
        }

        for(int i=2; i<=m; i++) {
            if(array[i]){
                for (int j = i + i; j <= m; j+=i) {
                    array[j] = false;
                }
            }
        }

        //결과 출력
        for(int i=n; i<=m; i++) {
            if(array[i])
                System.out.println(i);

        }

        }
}
