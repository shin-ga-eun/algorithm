package lecture1;

import java.util.Scanner;

public class ex_10953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();

        for(int i=0; i<Integer.parseInt(t); i++){
            String test = sc.nextLine();
            String[] array = test.split(",");

            System.out.println(Integer.parseInt(array[0]) + Integer.parseInt(array[1]));
        }

    }
}
