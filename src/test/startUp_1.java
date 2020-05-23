package test;

public class startUp_1 {
    public static Boolean IsBeauty(int p){
        Boolean[] IsAlreadyInt = new Boolean[11];
        int[] year = new int[4];

        for(int i=0; i<IsAlreadyInt.length; i++){
            IsAlreadyInt[i] = false;
        }

        year[0] = p/1000;
        year[1] = (p%1000)/100;
        year[2] = (p%100)/10;
        year[3] = (p%10);

        for(int i=0; i<year.length; i++){
            IsAlreadyInt[year[i]] = true;
        }

        int compare = 0;
        for(int i=0; i<IsAlreadyInt.length; i++){
            if(IsAlreadyInt[i])
                compare += 1;
        }

        if(compare == 4)
            return true;
        else
            return false;
    }

    public static int Solution (int p){
        int answer = 0;

        if(p==10000){
            return 10432;
        }

        p+=1;
        while(true){
            if(IsBeauty(p)){
                answer = p;
                break;
            }
            else {
                p+=1;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int Solution = Solution(10000);
        System.out.println(Solution);

    }



}
