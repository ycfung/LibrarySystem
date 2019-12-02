package model;

public class BorrowedRecord {
    private String ID;
    private String name;
    private String borrowDate;
    private String returnDate;
    private String borrowerID;
    private String borrowerName;

    public BorrowedRecord(String ID, String name, String borrowDate, String returnDate, String borrowerID, String borrowerName) {
        this.ID = ID;
        this.name = name;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.borrowerID = borrowerID;
        this.borrowerName = borrowerName;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getBorrowerID() {
        return borrowerID;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setBorrowerID(String borrowerID) {
        this.borrowerID = borrowerID;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
}
