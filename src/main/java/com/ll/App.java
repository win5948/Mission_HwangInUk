package com.ll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {
    List<Quotation> quotations = new ArrayList<>();
    int nextQuotationNumber = 1;

    public void run() {
        int count = 0;
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
                for (int i = quotations.size() - 1; i >= 0; i--) {
                    Quotation quotation = quotations.get(i);
                    System.out.println(quotation.getNumber() + " / " + quotation.getAuthorName() + " / " + quotation.getContent());
                }
            } else if (cmd.startsWith("삭제?id=")) {
                try {
                    String idString = cmd.substring(6);
                    int id = Integer.parseInt(idString);
                    boolean removed = false;
                    Iterator<Quotation> iterator = quotations.iterator();
                    while (iterator.hasNext()) {
                        Quotation quotation = iterator.next();
                        if (quotation.getNumber() == id) {
                            iterator.remove();
                            removed = true;
                            break;
                        }
                    }

                    if (removed) {
                        System.out.println(id + "번 명언이 삭제되었습니다.");
                    } else {
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 명령입니다. 명령 형식 삭제?id=<번호>");
                }
            } else if (cmd.startsWith("수정?id=")) {
                try {
                    String idString = cmd.substring(6);
                    int id = Integer.parseInt(idString);
                    boolean found = false;
                    Iterator<Quotation> iterator = quotations.iterator();

                    while (iterator.hasNext()) {
                        Quotation quotation = iterator.next();
                        if (quotation.getNumber() == id) {
                            System.out.print("명언(기존) : " + quotation.getContent() + "\n명언 : ");
                            String newContent = scanner.nextLine();

                            System.out.print("작가(기존) : " + quotation.getAuthorName() + "\n작가 : ");
                            String newAuthorName = scanner.nextLine();

                            quotation.content = newContent;
                            quotation.author = newAuthorName;
                            found = true;
                            System.out.println(id + "번 명언이 수정되었습니다.");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println(id + "번 명언을 찾을 수 없습니다.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 명령입니다. 명령 형식 수정?id=<번호>");

                }

            }
        }
    }
}
