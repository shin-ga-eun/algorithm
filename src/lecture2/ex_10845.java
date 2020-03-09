package lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ex_10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //선언
        int t = Integer.parseInt(br.readLine()); //테스트 개수
        Queue<Integer> queue = new LinkedList<Integer>();
        int rearValue =0;

        for(int i=0; i<t; i++){
            String command = br.readLine();

            if(command.contains("push")){
                rearValue = Integer.parseInt(command.substring(5));
                queue.offer(rearValue);
            }
            else if(command.equals("pop")){
                if(!queue.isEmpty()){
                    System.out.println(queue.poll());
                }
                else
                    System.out.println(-1);
            }
            else if(command.equals("size")){
                System.out.println(queue.size());
            }
            else if(command.equals("empty")){
                if(!queue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(1);
            }
            else if(command.equals("front")){
                if(!queue.isEmpty())
                    System.out.println(queue.peek());
                else
                    System.out.println(-1);
            }
            else if(command.equals("back")){
                if(!queue.isEmpty())
                    System.out.println(rearValue);
                else
                    System.out.println(-1);
            }

        }

    }
}
