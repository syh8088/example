package com.example.api.designpattern.DP07builderPattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer7BluePrint")
public abstract class BluePrint {

    abstract public void setCpu();
    abstract public void setRam();
    abstract public void setStorage();
    abstract public Computer getComputer();
}