package model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class Book extends RecursiveTreeObject<Book> {
    private String id = null;
    private String barcode = null;
    private String name = null;
    private String category = null;
    private String author = null;
    private String press = null;
    private String address = null;
    private String state = null;
    private String price = null;

    public Book(String id, String barcode, String name, String category, String
            author, String press, String address, String state, String price) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.category = category;
        this.author = author;
        this.address = address;
        this.state = state;
        this.press = press;
        this.price = price;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatego() {
        return category;
    }

    public void setCatego(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
