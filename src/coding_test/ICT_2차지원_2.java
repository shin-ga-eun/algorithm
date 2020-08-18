package coding_test;

import java.util.ArrayList;
import java.util.List;

public class ICT_2차지원_2 {

    public void sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];

        do{
            while(data[left] < pivot)
                left++;
            while(data[right] > pivot)
                right--;
            if(left <= right){
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while(left <= right);

        if(l < right)
            sort(data, l ,right);
        if(r > left)
            sort(data, left, r);
    }

    public static int[] charToInt (String str){
        int[] array = new int[str.length()];
        for(int i=0; i<str.length(); i++)
            array[i] = str.charAt(i) - '0'- 48;
        return array;
    }


    public static void commonSubstring(List<String> a, List<String> b) {
        // Write your code here
        int size = a.size();
        Boolean[] res = new Boolean[size];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<size; i++){
            res[i] = false;
        }

        for(int i=0; i<size; i++){
            int lengthA = a.get(i).length();
            int lengthB = b.get(i).length();

            int[] arrayA = charToInt(a.get(i));
            int[] arrayB = charToInt(b.get(i));

            ICT_2차지원_2 quick = new ICT_2차지원_2();
            quick.sort(arrayA, 0, arrayA.length-1);
            quick.sort(arrayB, 0, arrayB.length-1);

            if(arrayA[0] == arrayB[0]){
                res[i] = true;
                continue;
            }

            if(arrayA[0] > arrayB[0]){
                int index = 0;
                for(int j=0; j<lengthB; j++){
                   if(arrayB[j] < arrayA[0]) {
                       System.out.println(arrayB[j]+" < "+arrayA[0]+" continue");
                       continue;
                   }

                   if(arrayB[j] == arrayA[0]){
                       System.out.println(arrayB[j]+" == "+arrayA[0]);
                       res[i] = true;
                       break;
                   }

                   while(index < lengthA && arrayB[j] >= arrayA[index]) {
                       System.out.println(arrayB[j] + " > " + arrayA[index] + " whlie index " + index);

                       if (arrayB[j] == arrayA[index]) {
                           res[i] = true;
                           break;
                       }
                       index++;
                   }
               }

            }
            else if(arrayA[0] < arrayB[0]){
                System.out.println("222222222222");
                int index = 0;
                for(int j=0; j<lengthA; j++){
                    if(arrayA[j] < arrayB[0]) {
                        System.out.println(arrayA[j]+" < "+arrayB[0]+" continue");
                        continue;
                    }

                    if(arrayA[j] == arrayB[0]){
                        System.out.println(arrayA[j]+" == "+arrayB[0]);
                        res[i] = true;
                        break;
                    }
                    while(arrayA[j] > arrayB[index]){
                        System.out.println(arrayA[j]+" > "+arrayB[index]+" whlie index "+index);

                        if(arrayA[j] == arrayB[index]){
                            res[i] = true;
                            break;
                        }
                        index++;
                    }
                }
            }

        }


        for(int i=0; i<size; i++){
            if(res[i])
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        System.out.println(sb);

    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();

        a.add("hello");
        a.add("hi");

        b.add("world");
        b.add("bye");

        commonSubstring(a,b);
    }
}
