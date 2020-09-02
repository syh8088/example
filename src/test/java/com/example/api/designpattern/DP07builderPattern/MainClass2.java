package com.example.api.designpattern.DP07builderPattern;
/*


 */
public class MainClass2 {
    public static void main(String[] args) {

        // 매개변수가 늘어나면 가독성 줄어들고 유지보수가 힘들다.
        // Computer computer = new Computer("i7", "8g", "256g ssd");

        Computer computer = ComputerBuilder
                            .start()
                            .setCpu("i7")
                            .setRam("8g")
                            .setStorage("256g ssd")
                            .build();

        System.out.println(computer.toString());

    }

}