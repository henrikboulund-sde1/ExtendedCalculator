package com.example.bll;

import java.util.ArrayList;

public class CalculatorLogic {
    LoggerLogic loggerLogic = new LoggerLogic();
    public double Calculate(ArrayList<Double> numbers, ArrayList<Character> operators)
    {
        for(int i = 0; i<=numbers.size()-1;i = i + 2)
        {
            double value1 = numbers.get(i);
            double value2 = numbers.get(i+1);
            char operator = operators.get(i);
            loggerLogic.Add(String.valueOf(value1) + operator + value2);


            switch (operator)
            {
                case '+':
                    return Add(value1, value2);
                case '-':
                    return Minus(value1, value2);
                case '*':
                    return Multiply(value1, value2);
                case '/':
                    return Divide(value1, value2);
            }
        }
        return -44.44;
    }

    private double Add(double value1, double value2)
    {
        return value1+value2;
    }

    private double Minus(double value1, double value2)
    {
        return value1-value2;
    }

    private double Multiply(double value1, double value2)
    {
        return value1*value2;
    }

    private double Divide(double value1, double value2)
    {
        return value1/value2;
    }
}
