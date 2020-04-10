package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FUNCTION_LIST = "## 메인화면\n1 - 주문등록\n2 - 결제하기\n3 - 프로그램 종료\n";
    private static final String INPUT_FUNCTION_NUMBER_MESSAGE = "## 원하는 기능을 입력하세요.";

    public static String inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.next();
    }

    public static String inputAction() {
        System.out.println(FUNCTION_LIST);
        System.out.println(INPUT_FUNCTION_NUMBER_MESSAGE);
        //validate
        return scanner.next();
    }

    public static String inputMenu() {
        System.out.println("## 등록할 메뉴를 선택하세요");
        return scanner.next();
    }

    public static String inputCount() {
        System.out.println("## 메뉴의 수량을 입력하세요");
        return scanner.next();
    }
}
