package coding_test;

import java.util.List;

public class 카카오_가을_인턴_2 {
    /*
     * Complete the 'countDuplicate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */

    public static int countDuplicate(List<Integer> numbers) {
    // Write your code here
    int[] count = new int[1001];

    for(int i=0; i<numbers.size(); i++){
        count[numbers.get(i)] += 1;
    }

    int res = 0;
    for(int i=0; i<count.length; i++){
        if(count[i]>1)
            res+=1;
    }

    return res;

    }

}

