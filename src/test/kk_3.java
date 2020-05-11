package test;

import java.util.HashMap;

//보석이 주어졌을 때 가장 최소 구간으로 모든 보석을 구매할 때 시작 인덱스가 가장 짧은 구간의 시작과 끝을 반환.

public class kk_3 {
    public static class Solution {
        public static int[] solution(String[] gems) {
            int[] answer = {3,7};
            int[] array = new int[gems.length+1]; //input
            int[] dp = new int[gems.length+1]; //dp i부터 시작해서 다 산 지점의 인덱스
            int min_index = 1;
            int max_index = gems.length;

            //보석 종류 map
            HashMap<String,Integer> map = new HashMap<>();
            int index = 0;
            for(int i=0; i<gems.length; i++){
                if(!map.containsKey(gems[i])){
                    map.put(gems[i],++index);
                }
            }

            //진열대 배열 array 초기화
            for(int i=1; i<=gems.length; i++){
                array[i] = map.get(gems[i-1]);
            }

            //예외처리 배열크기가 1일때
            if(map.size() == 1){
                answer[0] = 1;
                answer[1] = 1;
                return answer;
            }

            //dp
            int gems_size = map.size();
            boolean[] isBuy = new boolean[gems_size+1];

            for(int i=1; i<array.length; i++){
                //isBuy 초기화
                int temp_i = 0;
                int temp_j = 0;
                for(int k=1; k<=gems_size; k++){
                    isBuy[k] = false;
                }

                for(int j=i; j>=1; j--){
                    if(dp[i] == gems_size){
                        temp_i = i;
                        temp_j = j;
                        break;
                    }
                    if(!isBuy[array[j]]){
                        isBuy[array[j]] = true;
                        dp[i] += 1;
                    }
                }

                System.out.println(temp_i);
                System.out.println(temp_j);

                //index 비교 --다시
                if(temp_i != 0) {
                    if (temp_i - temp_j < max_index - min_index) {
                        max_index = temp_i;
                        min_index = temp_j;
                    } else if (temp_i - temp_j == max_index - min_index) {
                        if (temp_j < min_index) {
                            max_index = temp_i;
                            min_index = temp_j;
                        }
                    }
                }
            }

            //ans


            answer[0] = min_index;
            answer[1] = max_index;

            return answer;
        }
    }

    public static void main(String[] args){
//        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems = {"AA", "AB", "AC", "AA", "DD", "AC", "AB"};
//        String[] gems = {"XYZ", "XYZ", "XYZ"};
//        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
//        String[] gems = {"A","A","Aasdfas","C","C"};
        int[] ans = Solution.solution(gems);
        System.out.println(ans[0]+","+ans[1]);

    }
}
