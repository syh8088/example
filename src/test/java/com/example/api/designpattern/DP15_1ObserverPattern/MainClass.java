package com.example.api.designpattern.DP15_1ObserverPattern;

/*
    옵저버 패턴을 통해 이벤트 발생 후 객체 외부에서 처리 할 수 있다.

    키워드 : 객체 외부, 이벤트 처리

 */
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
