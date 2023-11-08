package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    List<Quotation> quotations = new ArrayList<>();
    int nextQuotationNumber = 1;

    public void run() {
        int count= 0;
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");

            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();

                System.out.print("작가 : ");
                String authorName = scanner.nextLine();

                Quotation newQuotation = new Quotation(nextQuotationNumber, authorName, content);
                quotations.add(newQuotation);
                nextQuotationNumber++;
                System.out.println(nextQuotationNumber - 1 + "번 명언이 등록되었습니다.");



            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("------------------------");
                for (int i = quotations.size() - 1; i >=0; i--) {
                    Quotation quotation = quotations.get(i);
                    System.out.println(quotation.getNumber() + " / " + quotation.getAuthorName() + " / " + quotation.getContent());
                }
            }
        }
    }
}
