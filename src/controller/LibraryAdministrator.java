package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Book;

import java.util.LinkedList;

public class LibraryAdministrator {
    public static ObservableList<Book> queryByAtt(String att, String keyword) {
        ObservableList<Book> books = FXCollections.observableArrayList();
        Book book = new Book("111ss", "222", "设计模式", "计算机", "孙培港",
                "清华大学出版社", "计算机区", "已借出", "￥ 100");
        books.add(book);
        book = new Book("22334", "2222", "计算机网络", "计算机", "孙培港",
                "吉林大学出版社", "计算机区", "典藏", "￥ 800");
        books.add(book);
        return books;
    }

    public static String[] getNewRecodeByID(String id) {
        String[] s = new String[12];
        s[0] = "222";
        s[1] = "设计模式";
        s[2] = "孙培港";
        s[3] = "清华大学出版社";
        s[4] = "计算机";
        s[5] = "￥ 100";
        s[6] = "已借出";
        s[7] = "计算机区";
        s[8] = "2019年10月1日";
        s[9] = "2019年11月1日";
        s[10] = "55171029";
        s[11] = "ycfung";
        return s;
    }

    public String[] getBookInfoByBarcode(String barcode) {
        return null;
    }

    public static LinkedList<String[]> getRecodeByBarcode(String barcode) {
        return null;
    }
}
