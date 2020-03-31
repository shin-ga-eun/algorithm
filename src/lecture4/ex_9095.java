package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1,2,3 더하기
 */
public class ex_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[] array = new int[11];

        array[1] = 1;
        array[2] = 2;
        array[3] = 4;

        for (int i = 4; i < 11; i++)
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];


        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(array[n]+"\n");
        }
        System.out.println(sb);
    }
}
