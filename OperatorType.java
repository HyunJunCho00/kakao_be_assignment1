package com.example.calculator;

public enum OperatorType
{
    ADD('+'),SUBTRACT('-'),MULTI('*'),DIV('/');
    private final char symbol;
    OperatorType(char symbol)
    {
        this.symbol=symbol;
    }
    public char getSymbol() {
        return this.symbol;
    }
    public static OperatorType fromChar(char comp)
    {
        for (OperatorType op:values())
        {
            if (op.symbol==comp)
                return op;
        }
        throw new IllegalArgumentException("잘못된 연산 기호입니다: " + comp);
    }
}