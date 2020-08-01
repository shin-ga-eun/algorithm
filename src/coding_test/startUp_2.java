package coding_test;

public class startUp_2 {
    public static long threeMulti(long b){
        long three = 1;

        while(b > 0){
            three *= 3;
            b -= 1;
        }

        return three;
    }

    public static long Solution (long n) {
        long answer = 0;
        long[] dp = new long[100000000];
        long[] array = new long[100000000];

        for(int i=0; i<=n; i++){
            array[i] = threeMulti(i);
        }

        dp[0] = array[0];
        int index = 1;
        for(int i=1; i<n; i++){
            dp[i] = array[i];

            long value = 0;
            for(int j=0; j<i; j++){
                value += array[j];
                if(value > array[index]) {
                    value = array[index];
                    index += 1;
                    dp[i] = Math.min(dp[i], value);
                    break;
                }
                else {
                    value += array[j];
                }

                if(dp[i] > value && dp[i-1] < value) {
                    if(value < array[i])
                        dp[i] = Math.min(dp[i], value);
                    else
                        dp[i] = array[i];
                }

            }
            dp[i] = Math.min(dp[i], array[i]);
            System.out.println(i+" , "+dp[i]);
        }

        //n번째는 dp[n-1]
        answer = dp[(int)n-1];

        return answer;
    }

    public static void main(String[] args) {
        long s = Solution(4);
        System.out.println(s);
    }
}
