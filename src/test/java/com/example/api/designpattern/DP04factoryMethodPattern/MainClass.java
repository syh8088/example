package com.example.api.designpattern.DP04factoryMethodPattern;

import com.example.api.designpattern.DP04factoryMethodPattern.concrete.HpCreator;
import com.example.api.designpattern.DP04factoryMethodPattern.concrete.MpCreator;
import com.example.api.designpattern.DP04factoryMethodPattern.framework.Item;
import com.example.api.designpattern.DP04factoryMethodPattern.framework.ItemCreator;

public class MainClass {

    public static void main(String[] args) {

        ItemCreator creator = new HpCreator();
        Item item = creator.create();

        item.use();

        creator = new MpCreator();
        creator.create();

        item.use();
    }

}
