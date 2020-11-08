package com.example.api.designpattern.DP13ChainOfResposibilityPattern.src;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer13SubCalculator")
public class SubCalculator extends Calculator {

    @Override
    protected boolean operator(Request request) {
        if(request.getOperator().equals("-")){

            int a = request.getA();
            int b = request.getB();
            int result = a - b;
            System.out.println(a +"-"+b+"="+ result);
        }
        return false;
    }


}