package coding_test;

import java.util.ArrayList;
import java.util.List;

class ICT_2차지원_1 {

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

    public static int countStudents(List<Integer> height)  {
        // Write your code here

        int size = height.size();
        int ans = 0;

        int[] origin = new int[size];
        int[] data = new int[size];

        // 초기화
        for(int i=0; i<size; i++){
            origin[i] = height.get(i);
            data[i] = height.get(i);
        }

        //호출
        ICT_2차지원_1 quick = new ICT_2차지원_1();
        quick.sort(data, 0, data.length-1);


        //비교
        for(int i=0; i<size; i++){
            System.out.println(i+": "+data[i]);
            if(origin[i] != data[i])
                ans++;
        }

        return ans;

    }


        public static void main(String[] args) {
        List<Integer> height = new ArrayList<>();
        height.add(4);
        height.add(3);
        height.add(2);
        height.add(1);

        int ans = countStudents(height);
        System.out.println("ans: "+ans);


    }
}
