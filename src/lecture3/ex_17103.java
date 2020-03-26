package lecture3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int ARRAY_SIZE = 1000000;
        boolean[] array = new boolean[ARRAY_SIZE+1];

        for(int i=2; i<array.length; i++){
            array[i] = true;
        }


        //에레 체
        for(int i=2; i<array.length; i++){
            if(array[i]){
                for(int j=i+i; j <=ARRAY_SIZE; j+=i){
                    array[j] = false;
                }
            }
        }

        //테스트
        for(int i=0; i<t; i++){
            int input = Integer.parseInt(br.readLine());
            int count = 0;

            for(int j=2; j<=input/2; j++){
                int a = j;
                if(array[a]){
                    if(array[input-a]) {
                        count++;
                        continue;
                    }
                }
            }

            //결과 출력
            sb.append(count+"\n");
        }

        System.out.println(sb);
    }
}
