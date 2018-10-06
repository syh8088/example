package com.example.api.designpattern.DP15_1ObserverPattern;

public class MainClass {

    public static void main(String[] args) {

        Button button = new Button();


        button.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(Button button) {
                System.out.println(button+" is Clicked");
            }
        });

        button.onClick();

    }
}
