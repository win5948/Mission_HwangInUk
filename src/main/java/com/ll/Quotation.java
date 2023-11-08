package com.ll;

public class Quotation {
    private int number;
    private String author;
    private String content;

    public Quotation(int number, String author, String content) {
        this.number = number;
        this.author = author;
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public String getAuthorName() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
