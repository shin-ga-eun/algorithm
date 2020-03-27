package lecture4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1로 만들기...?!
 */

public class ex_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] memory = new int[input+1];
        memory[1] = 0;
        for(int i=2; i<=input; i++) {
            memory[i] = memory[i - 1] + 1;
            if (i % 2 == 0 && memory[i] > memory[i / 2] + 1) {
                memory[i] = memory[i / 2] + 1;
            }
            if (i % 3 == 0 && memory[i] > memory[i / 3] + 1) {
                memory[i] = memory[i / 3] + 1;
            }
        }

        System.out.println(memory[input]);
    }
}
