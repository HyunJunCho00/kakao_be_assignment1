import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorLv1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            int x,y;// 숫자 두개 입력
            char oper;// 기호 입력
            int result; // 결과 저장
            while(true)
            {
                try{
                    System.out.print("첫 번째 숫자를 입력하세요:");
                    x = sc.nextInt();
                    break;
                }catch(InputMismatchException e)
                {
                    System.out.println("\n잘못된 입력입니다. 숫자를 다시 입력해주세요\n");
                    sc.next();
                }
            }

            while(true)
            {
                try{
                    System.out.print("두 번째 숫자를 입력하세요:");
                    y = sc.nextInt();
                    break;
                }catch(InputMismatchException e)
                {
                    System.out.println("\n잘못된 입력입니다. 숫자를 다시 입력해주세요\n");
                    sc.next();
                }
            }

            while(true)
            {
                System.out.print("기호를 입력하세요:");
                String input=sc.next();
                // + - * / 의 기호를 제대로 입력했는지 조건 판단
                if (input.length()==1&&(input.charAt(0)=='+'||input.charAt(0)=='-'||input.charAt(0)=='*'||input.charAt(0)=='/')){
                    oper=input.charAt(0);
                    break;
                }
                else
                {
                    System.out.println("\n잘못된 입력입니다. 기호를 다시 입력해주세요\n");
                }
            }
            try {
                switch(oper)
                {
                    case '+':
                        result=x+y;
                        break;
                    case '-':
                        result=x-y;
                        break;
                    case '*':
                        result=x*y;
                        break;
                    case '/':
                        if (y==0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                        result=x/y;
                        break;
                    default:
                        throw new IllegalArgumentException("연산식이 잘못되었습니다.");
                }
                System.out.println("결과 : "+result);
            }catch(ArithmeticException e)
            {
                System.out.println("오류 : "+e.getMessage());
            }


            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String check=sc.next();
            if (check.equals("exit"))break;

        }
    }
}
