package com.example.calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {

    private List<Double> result=new ArrayList<>();

    public double calculate(T num1,T num2, OperatorType oper)
    {
        double x=num1.doubleValue();
        double y=num2.doubleValue();
        double res=0;
        switch(oper)
        {
            case ADD:
                res=x+y;
                break;
            case SUBTRACT:
                res=x-y;
                break;
            case MULTI:
                res=x*y;
                break;
            case DIV:
                if (y==0.0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                res=x/y;
                break;
            default:
                throw new IllegalArgumentException("연산식이 잘못되었습니다.");
        }
        result.add(res);
        return res;
    }
    public List<Double> getResult()
    {
        return result;
    }
    public void setResult(List<Double>result)
    {
        this.result=result;
    }
    public void removeResult() {
        if (!result.isEmpty())
            result.remove(0);
        else
            System.out.println("삭제할 결과는 없습니다");
    }
    public List<Double> getAtLeastResult(double value)
    {
        return result.stream().
                filter(v->v>value).collect(Collectors.toList());
    }
}