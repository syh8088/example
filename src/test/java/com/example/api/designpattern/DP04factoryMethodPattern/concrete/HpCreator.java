package com.example.api.designpattern.DP04factoryMethodPattern.concrete;

import com.example.api.designpattern.DP04factoryMethodPattern.framework.Item;
import com.example.api.designpattern.DP04factoryMethodPattern.framework.ItemCreator;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("designatternVer4HpCreator")
public class HpCreator extends ItemCreator {

    @Override
    protected void requestItemsInfo() {
        System.out.println("데이터베이스에서 체력 회복 물약의 정보를 가져옵니다." + new Date());
    }

    @Override
    protected void createItemLog() {
        System.out.println("체력 회복 물약을 새로 생성 했습니다." + new Date());
    }

    @Override
    protected Item createItem() {
        return new HpPotion();
    }
}