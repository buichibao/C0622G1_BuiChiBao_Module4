package com.example.service.impl;

import com.example.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String convert(String opera, double number1, double number2) {

        double result = 0;

        switch (opera){
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if(number2==0){
                    return "cannot be divided by 0";
                }
                result = number1/number2;
        }
        return String.valueOf(result);
    }
}
