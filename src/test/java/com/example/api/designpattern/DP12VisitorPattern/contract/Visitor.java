package com.example.api.designpattern.DP12VisitorPattern.contract;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer12Visitor")
public interface Visitor {
    public void visit(Visitable visitable);
}