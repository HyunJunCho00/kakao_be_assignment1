import java.util.ArrayList;
import java.util.List;

public class Calculator_Lv2 {
    private List<Integer> result=new ArrayList<>();
    public int calculate(int x,int y,char oper)
    {
        int res;
        switch(oper)
        {
            case '+':
                res=x+y;
                break;
            case '-':
                res=x-y;
                break;
            case '*':
                res=x*y;
                break;
            case '/':
                if (y==0)throw new ArithmeticException(("0으로 나눌 수 없습니다."));
                res=x/y;
                break;
            default:
                throw new IllegalArgumentException("연산식이 잘못되었습니다.");
        }
        result.add(res);
        return res;
    }
    public List<Integer> getResult()
    {
        return this.result;
    }
    public void setResult(List<Integer>result)
    {
        this.result=result;
    }
    public void removeResult() {
        if (!result.isEmpty())
            result.remove(0);
        else
            System.out.println("삭제할 결과는 없습니다");
    }

}
