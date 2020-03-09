package lecture2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
조세퍼스문제
1~N번까지 사람이 원을 이우러 앉아있고, M번째 사람을 순서대로 제거하는 문제로,
N명이 모두 제거될 때까지 계속해서 제거하고, 그 순서를 조세퍼스 순열이라고 한다.
 */
public class ex_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //선
        StringBuilder sb = new StringBuilder(); //선언
        sb.append("<");

        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        //큐 초기화
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
            queue.offer(i);

        int count = 1;

        while(queue.size()>1){
            if(count % K == 0){
                int value = queue.poll();
                sb.append(value+", ");
                count = 1;
                continue;
            }
            queue.offer(queue.poll());
            count++;

        }
        sb.append(queue.poll()+">");
        System.out.println(sb);

    }
}
