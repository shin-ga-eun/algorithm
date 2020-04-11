package naver_hackday;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

class ex2 {
    public static int solution(String[] id_list, int k) {
        int answer = 0;
        Map<String, Integer> map = new HashMap();
        Stack<String> isAlreadyToken = new Stack<>();

        for(int i=0; i<id_list.length; i++){
            StringTokenizer st = new StringTokenizer(id_list[i]);

            while(st.hasMoreTokens()) {
                String token = st.nextToken();
                if(!isAlreadyToken.contains(token))
                    isAlreadyToken.push(token);

                if(!map.containsKey(token)) {
                    map.put(token,0);
                }

            }

            while(!isAlreadyToken.empty()){
                String key = isAlreadyToken.pop();
                System.out.println(key);
                int value = map.get(key);
                if(value<k){
                    value++;
                    map.put(key, value);
                }
                else
                    continue;
            }

        }


        for(String key : map.keySet()){
            int value = map.get(key);
            answer+=value;
            System.out.println(key+" : "+value);
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"A B C D", "A D", "A B D", "B D"};
        int x = solution(id_list,2);
    }
}