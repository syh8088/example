package com.example.api.designpattern.DP04factoryMethodPattern;

import com.example.api.designpattern.DP04factoryMethodPattern.concrete.HpCreator;
import com.example.api.designpattern.DP04factoryMethodPattern.concrete.MpCreator;
import com.example.api.designpattern.DP04factoryMethodPattern.framework.Item;
import com.example.api.designpattern.DP04factoryMethodPattern.framework.ItemCreator;
import org.apache.ibatis.type.Alias;

/*
    * 팩토리 메소드 패턴에서 템플릿 메소드 패턴의 사용됨을 안다.
    * 팩토리 메소드 패턴에서의 구조와 구현의 분리를 이해하고 구조와 구현의 분리의 장점을 안다.
    *
 */
@Alias("designatternVer4MainClass")
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