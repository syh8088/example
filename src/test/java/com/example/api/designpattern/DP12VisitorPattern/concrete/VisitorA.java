package com.example.api.designpattern.DP12VisitorPattern.concrete;

import com.example.api.designpattern.DP12VisitorPattern.contract.Visitable;
import com.example.api.designpattern.DP12VisitorPattern.contract.Visitor;

public class VisitorA implements Visitor {

    private int number;

    public VisitorA() {
        this.number = 0;
    }

    @Override
    public void visit(Visitable visitable) {
        if(visitable instanceof VisitableA) {
            number += ((VisitableA) visitable).numberOfMember;
        } else {
            //...
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
