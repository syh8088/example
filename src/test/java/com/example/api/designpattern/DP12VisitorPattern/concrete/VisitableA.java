package com.example.api.designpattern.DP12VisitorPattern.concrete;

import com.example.api.designpattern.DP12VisitorPattern.contract.Visitable;
import com.example.api.designpattern.DP12VisitorPattern.contract.Visitor;

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