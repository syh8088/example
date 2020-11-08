package com.example.api.designpattern.DP12VisitorPattern.contract;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer12Visitable")
public interface Visitable {
    public void accept(Visitor visitor);
}
