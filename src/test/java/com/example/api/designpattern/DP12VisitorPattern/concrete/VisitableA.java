package com.example.api.designpattern.DP12VisitorPattern.concrete;

import com.example.api.designpattern.DP12VisitorPattern.contract.Visitable;
import com.example.api.designpattern.DP12VisitorPattern.contract.Visitor;
import org.apache.ibatis.type.Alias;

@Alias("designatternVer12VisitableA")
public class VisitableA implements Visitable {

    int numberOfMember;

    public VisitableA(int numberOfMember) {
        this.numberOfMember = numberOfMember;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}