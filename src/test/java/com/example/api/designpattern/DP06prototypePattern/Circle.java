package com.example.api.designpattern.DP06prototypePattern;

import org.apache.ibatis.type.Alias;

@Alias("designatternVer6Circle")
public class Circle extends Shape {
    private int x, y, r;

    public Circle(int x, int y, int r) {
        super();
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Circle copy() throws CloneNotSupportedException {
        Circle circle = (Circle) clone();
        circle.x += 1;
        circle.y += 1;
        return circle;
    }
}
