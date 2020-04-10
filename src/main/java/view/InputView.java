package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputAction() {
        System.out.println("## 원하는 기능을 입력하세요.");
        return scanner.nextInt();
    }
}
