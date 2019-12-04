package model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class Borrower extends RecursiveTreeObject<Borrower> {
    private String id = null;
    private String name = null;
    private String tel = null;
    private String balance = null;

    public Borrower(String id, String name, String tel, String balance) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.balance = balance;
    }

    public Borrower() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getBalance() {
        return balance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
