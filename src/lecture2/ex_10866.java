package lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
덱문제
 */
public class ex_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        int front=0;
        int back=0;

        for(int i=0; i<t; i++){
            String command = br.readLine();
            StringTokenizer st = new StringTokenizer(command);
            command = st.nextToken();

            if(command.equals("push_front")){
                front = Integer.parseInt(st.nextToken());
                deque.addFirst(front);
            }
            else if(command.equals("push_back")){
                back = Integer.parseInt(st.nextToken());
                deque.addLast(back);
            }
            else if(command.equals("pop_front")){
                if(!deque.isEmpty())
                    System.out.println(deque.pollFirst());
                else
                    System.out.println(-1);

            }
            else if(command.equals("pop_back")){
                if(!deque.isEmpty())
                    System.out.println(deque.pollLast());
                else
                    System.out.println(-1);

            }
            else if(command.equals("size")){
                System.out.println(deque.size());
            }
            else if(command.equals("empty")){
                if(!deque.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(1);
            }
            else if(command.equals("front")){
                if(!deque.isEmpty())
                    System.out.println(deque.getFirst());
                else
                    System.out.println(-1);

            }
            else if(command.equals("back")){
                if(!deque.isEmpty())
                    System.out.println(deque.getLast());
                else
                    System.out.println(-1);
            }


        }


    }
}
