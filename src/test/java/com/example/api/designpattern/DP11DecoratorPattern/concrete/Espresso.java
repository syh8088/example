package com.example.api.designpattern.DP11DecoratorPattern.concrete;

import com.example.api.designpattern.DP11DecoratorPattern.abst.AbstAdding;
import com.example.api.designpattern.DP11DecoratorPattern.abst.IBeverage;

/**
 * <h2><b>Role : </b>ConcreteDecorator</h2>
 *  <p>
 *  실질적인 장식 인스턴스 및 정의이며, 책임이 추가되는 부분입니다.
 *  </p>
 */
public class Espresso extends AbstAdding {
    static protected int espressoCount = 0;

    public Espresso(IBeverage base) {
        super(base);
    }

    @Override
    public int getTotalPrice() {


        System.out.println("############# " + super.getTotalPrice()+" #################");

        return super.getTotalPrice()+getAddPrice();
    }

    /**
     * 에스프레소 추가가격
     * @return
     */
    private static int getAddPrice(){
        espressoCount +=1;
        int addPrice = 100;

        if(espressoCount > 1){
            addPrice = 70;
        }
        // System.out.println("############# " + addPrice + " #################");
        return addPrice;
    }
}
