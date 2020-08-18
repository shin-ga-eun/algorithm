package coding_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ICT_2차지원_4 {

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

    public static int stockPairs(List<Integer> stocksProfit, long target) {

        int size = stocksProfit.size();
        int[] stocks = new int[size];
        int res = 0;
        int targ = Integer.parseInt(""+target);

        for(int i=0; i<size; i++)
            stocks[i] = stocksProfit.get(i);

        // sorting
        ICT_2차지원_4 quick = new ICT_2차지원_4();
        quick.sort(stocks, 0, stocks.length-1);

        for(int i=0; i<size; i++)
            System.out.print(stocks[i]+" ");
        System.out.println("");

        // pair check
        Stack<Integer> stack = new Stack<>();
        int find = 0;

        for(int i=0; i<size; i++) {
            int low = 0;
            int high = size-1;
            find = targ - stocks[i];

            if(!stack.isEmpty() && find == stack.peek())
                continue;

            System.out.println("\n"+targ + "-" + stocks[i] + "= find: " + find);

            while (low <= high) {
                int mid = (low + high) / 2;

                find = targ - stocks[i];

                if (stocks[mid] > find) {
                    System.out.println(stocks[mid] + " > " + find);
                    high = mid - 1;
                } else if (stocks[mid] < find) {
                    System.out.println(stocks[mid] + " < " + find);
                    low = mid + 1;
                } else if (stocks[mid] == find) {
                    System.out.println(stocks[mid] + " == " + find);

                    if(mid == i) {
                        System.out.println("제외 ");
                        break;
                    }

                    stack.push(find);
                    res++;
                    break;
                }
            }
        }

        if(res%2==0)
            res/=2;
        else
            res = res/2+1;

        return res;

    }

    public static void main(String[] args) {
        List<Integer> stocks = new ArrayList<>();
        stocks.add(6);
        stocks.add(6);
//        stocks.add(12)/;
        stocks.add(3);
        stocks.add(9);
        stocks.add(3);
        stocks.add(5);
        stocks.add(1);

        Long target = Long.parseLong(""+12);

        int res = stockPairs(stocks, target);
        System.out.println(res);

    }
}
