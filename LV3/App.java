package com.example.calculator;
import java.util.InputMismatchException;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator=new ArithmeticCalculator<>();

        while(true)
        {
            double num1,num2;
            char kind;
            while(true)
            {
                try{
                    System.out.print("첫 번째 숫자를 입력하세요:");
                    num1 = sc.nextDouble();
                    break;
                }catch(InputMismatchException e)
                {
                    System.out.println("    잘못된 입력입니다. 숫자를 입력해주세요");
                    sc.next();
                }
            }

            while(true)
            {
                try{
                    System.out.print("두 번째 숫자를 입력하세요:");
                    num2 = sc.nextDouble();
                    break;
                }catch(InputMismatchException e)
                {
                    System.out.println("    잘못된 입력입니다. 숫자를 입력해주세요");
                    sc.next();
                }
            }

            while(true)
            {
                System.out.print("기호를 입력하세요:");
                String input=sc.next();
                // + - * / 의 기호를 제대로 입력했는지 조건 판단
                if (input.length()==1&&(input.charAt(0)=='+'||input.charAt(0)=='-'||input.charAt(0)=='*'||input.charAt(0)=='/')){
                    kind=input.charAt(0);
                    break;
                }
                else
                {
                    System.out.println("    잘못된 입력입니다. 기호를 입력해주세요");
                }
            }

            try {
                OperatorType operator=OperatorType.fromChar(kind);
                double result=calculator.calculate(num1,num2,operator);
                System.out.println("결과 : "+result);
            }catch(ArithmeticException e)
            {
                System.out.println(e.getMessage());
            }
            System.out.println("저장된 결과 목록: "+calculator.getResult());

            System.out.println("데이터를 삭제하시겠습니까? 맞다면 yes를 입력해주세요");
            String found=sc.next();
            if(found.equals("yes"))
            {
                calculator.removeResult();
                System.out.println("삭제 후 저장된 결과 목록: "+calculator.getResult());
            }

            System.out.println("특정 값보다 큰 결과 조회하시겠습니까? 맞다면 yes를 입력해주세요");
            found=sc.next();
            if(found.equals("yes"))
            {
                double value;
                while(true)
                {
                    try{
                        System.out.print("숫자를 입력하세요: ");
                        value=sc.nextDouble();
                        break;
                    }catch(InputMismatchException e)
                    {
                        System.out.println("    잘못된 입력입니다. 숫자를 입력해주세요");
                        sc.next();
                    }
                }
                System.out.println("특정 값보다 큰 결과는 아래와 같습니다.");
                System.out.println(calculator.getAtLeastResult(value));
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String check=sc.next();
            if (check.equals("exit"))break;
        }

    }
}
