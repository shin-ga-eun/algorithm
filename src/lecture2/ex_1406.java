package lecture2;

import java.io.*;
import java.util.Stack;

/*
1.
처음에 입력을 Scanner로 받았더니, 시간초과 문제가 발생하였다.
해결방법
BufferedReader, BufferedWriter를 사용한다.
왜?
Scanner는 공백을 모두 경계로 인식하여 가공하기 편리하지만, 많은 양의 데이터를 입력받을 경우 효율성이 떨어진다.
BufferedReader, BufferedWriter은 입력된 데이터가 바로 전달되지 않고 중간에 버퍼링이 된 후 간접적으로 입출력장치로 전달되기 때문에
시스템의 데이터처리 효율성을 높여주며, 버퍼스트림을 InputStreamReader, OutputStreamWriter를 같이 사용해서
버퍼링을 하게 디면 입출력 스트림으로부터 미리 버퍼에 데이터를 갖다 놓기 때문에 더 효율적인 입출력이 가능해진다.

2.
두번째로 입력을 BufferedReader, 출력을 BufferedWriter을 사용하였더니, 시간초과 문제가 발생하였다.
해결방법
BufferedReader, StringBuilder를 사용하였다.
출력시간순: String < StringBuffer < StringBuilder 순으로 성능이 좋다.
 */

public class ex_1406 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //선언
        String input = bf.readLine();
        int t = Integer.parseInt(bf.readLine());

        Stack<Character> left = new Stack<>(); //왼쪽스택
        Stack<Character> right = new Stack<>(); //오른쪽스택


        for(int i=0; i<input.length(); i++){
            left.push(input.charAt(i));
        }

        for(int i=0; i<t; i++){
            String command = bf.readLine();

            if(command.equals("L")){
                if(!left.empty()) {
                    right.push(left.pop());
                }
            }
            else if(command.equals("D")){
                if(!right.empty()){
                    left.push(right.pop());
                }
            }
            else if(command.equals("B")){
                if(!left.empty())
                    left.pop();
            }
            else if(command.contains("P")){
                left.push(command.charAt(2));
            }
        }

        while(!left.empty()){
            right.push(left.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!right.empty()){
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
