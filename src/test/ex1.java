package test;

/*
    [문제1번]

    n종류의 상품이 있다.
    고객은 2종류의 상품을 주문한다.
    2종류 모두 재고가 있는 경우만 배송한다.
    없거나, 알지못하는 경우는 배송하지 않는다.
    1~n번 상품의 재고상태를 출력해라.
    입력값
    n = 7
    delivery = {{5,6,0},{1,3,1},{1,5,0},{7,6,0},{3,7,1},{2,5,0}}
    {첫번째 상품, 두번째 상품, 배송처리결과}

    출력값
    O?O?XXO
 */
public class ex1 {
    public static String solution(int n, int[][] delivery) {
        String answer = "";
        String[] result = new String[n+1];

        for(int i=1; i<n+1; i++){
            result[i] = "?";
        }

        //재고가 있는 상품을 먼저 추출
        for(int i=0; i<delivery.length; i++) {
            int first = delivery[i][0];
            int second = delivery[i][1];
            int isDelivery = delivery[i][2];

            if(isDelivery == 1){
                result[first] = "O";
                result[second] = "O";
            }
        }

        for(int i=0; i<delivery.length; i++){
            int first = delivery[i][0];
            int second = delivery[i][1];
            int isDelivery = delivery[i][2];


            if(isDelivery==0){
                if(result[first]=="O")
                    result[second]="X";
                if(result[second]=="O")
                    result[first]="X";
            }
        }


        for(int i=1; i<=n; i++)
            answer += result[i];

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        int[][] delivery = {{5,6,0},{1,3,1},{1,5,0},{7,6,0},{3,7,1},{2,5,0}};
        String solution = solution(7, delivery);

    }
}
