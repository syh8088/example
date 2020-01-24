package com.example.api.newLecOOP._23_25_추상클래스만들기_추상화_구현하기;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        ExamConsole list = new ExamConsole();

        int menu;
        boolean keepLoop = true;

        while (keepLoop) {
            menu = inputMenu();

            switch (menu) {
                case 1:
                    list.inputList();
                    break;
                case 2:
                    list.printList();
                    break;
                case 3:
                    System.out.println("Bye~~");

                    keepLoop = false;
                    break;

                default:
                    System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
            }
        }
    }

    static int inputMenu() {

        Scanner scan = new Scanner(System.in);

        System.out.println("┌────────────────────┐");
        System.out.println("│       메인 메뉴               │");
        System.out.println("└────────────────────┘");
        System.out.print("  1. 성적 입력\n");
        System.out.print("  2. 성적 출력\n");
        System.out.print("  3. 프로그램 종료\n");
        System.out.print("  선택 > ");
        int menu = scan.nextInt();

        return menu;
    }

}
