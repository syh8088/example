package com.example.api.newLecOOP._1_캡슐화.after;

import org.apache.ibatis.type.Alias;

import java.util.Scanner;

@Alias("Test1Program")
public class Program {

    public static void main(String[] args) {

        ExamList list = new ExamList();
        ExamList.init(list);

        int menu;
        boolean keepLoop = true;

        while (keepLoop) {
            menu = inputMenu();

            switch (menu) {
                case 1:
                    ExamList.inputList(list);
                    break;
                case 2:
                    ExamList.printList(list);
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
