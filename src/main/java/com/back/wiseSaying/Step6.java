package com.back.wiseSaying;

import java.util.Scanner;

public class Step6 {
    public void method1() {
        System.out.println("== 명언 앱 ==");
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        WiseSayings wiseSaying = new WiseSayings();

        while (loop) {
            System.out.print("명령) ");
            String input = scanner.nextLine().trim();

            if (input.contains("삭제?id=")) {
                long deleteKey = Long.parseLong(input.substring(input.indexOf("=") + 1));
                wiseSaying.deleteWiseSaying(deleteKey);
                continue;
            }

            switch (input) {
                case "종료" -> {
                    loop = false;
                }
                case "등록" -> {
                    System.out.print("명언 : ");
                    String content = scanner.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = scanner.nextLine().trim();

                    long num = wiseSaying.addWiseSaying(content, author);

                    if (num == -1) {
                        System.out.println("잘못된 입력입니다.");
                        continue;
                    }
                    System.out.printf("%d번 명언이 등록되었습니다.\n", num);
                }
                case "목록" -> {
                    wiseSaying.showWiseSaying();
                }
            }
        }

        scanner.close();
    }
}
