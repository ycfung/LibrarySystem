package controller;

import com.jfoenix.controls.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Book;
import model.BorrowedRecord;
import model.Borrower;
import model.Id;
import oracle.sql.NUMBER;
import sun.rmi.log.ReliableLog;


public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane tabpane;

    @FXML
    private StackPane stackpane;

    @FXML
    private Tab searchTab;

    @FXML
    private JFXComboBox<String> searchComboBox;

    @FXML
    private JFXTextField searchTextField;

    @FXML
    private JFXButton searchSearchBtn;

    @FXML
    private JFXTreeTableView<Book> searchTableView;

    @FXML
    private JFXButton searchBookInfo;

    @FXML
    private JFXButton searchBookRecord;

    @FXML
    private Tab bookInfoTab;

    @FXML
    private JFXTextField bookInfoTextField;

    @FXML
    private JFXButton bookInfoSearch;

    @FXML
    private JFXTextField bookInfoID;

    @FXML
    private JFXTextField bookInfoBarcode;

    @FXML
    private JFXTextField bookInfoTitle;

    @FXML
    private JFXTextField bookInfoPublisher;

    @FXML
    private JFXTextField bookInfoAuthor;

    @FXML
    private JFXTextField bookInfoCategory;

    @FXML
    private JFXTextField bookInfoIsBorrowable;

    @FXML
    private JFXTextField bookInfoLocation;

    @FXML
    private JFXTextField bookInfoBorrowDate;

    @FXML
    private JFXTextField bookInfoReturnDate;

    @FXML
    private JFXTextField bookInfoBorrowerID;

    @FXML
    private JFXTextField bookInfoBorrowerName;

    @FXML
    private JFXTextField bookInfoPrice;

    @FXML
    private Tab recordTab;

    @FXML
    private JFXComboBox<String> recordComboBox;

    @FXML
    private JFXTextField recordTextField;

    @FXML
    private JFXButton recordSearch;

    @FXML
    private JFXButton recordReset;

    @FXML
    private JFXTreeTableView<BorrowedRecord> recordTableView;

    @FXML
    private Tab addTab;

    @FXML
    private JFXTextField addtextField;

    @FXML
    private JFXButton addSearch;

    @FXML
    private JFXButton addReset;

    @FXML
    private JFXTextField addBarcode;

    @FXML
    private JFXTextField addTitle;

    @FXML
    private JFXTextField addPublisher;

    @FXML
    private JFXTextField addLocatioin;

    @FXML
    private JFXTextField addAuthor;

    @FXML
    private JFXTextField addcategory;

    @FXML
    private JFXTextField addPrice;

    @FXML
    private JFXCheckBox addIsBorrowable;

    @FXML
    private JFXTreeTableView<Id> addTableView;

    @FXML
    private JFXButton addAddBtn;

    @FXML
    private JFXButton addDeleteBtn;

    @FXML
    private Tab userInfoTab;

    @FXML
    private JFXComboBox<String> userInfoComboBox;

    @FXML
    private JFXTextField userInfoTextField;

    @FXML
    private JFXButton userInfoSearch;

    @FXML
    private JFXTreeTableView<BorrowedRecord> userInfoTableView;

    @FXML
    private JFXButton userInfoAdd;

    @FXML
    private JFXButton userInfoDelete;

    @FXML
    private JFXButton userInfoApply;

    @FXML
    private JFXButton addSaveBtn;

    @FXML
    private JFXTextField userInfoID;

    @FXML
    private JFXTextField userInfoName;

    @FXML
    private JFXTextField userInfoPhone;

    @FXML
    private JFXTextField userInfoBalance;

    @FXML
    private JFXButton userInfoReset;

    @FXML
    private JFXTextField userInfoPassword;

    @FXML
    private JFXButton addAddNewBookBtn;

    @FXML
    private JFXTextField addID;

    private String[] bookInfo = new String[13];
    private ObservableList<Id> ids = FXCollections.observableArrayList();
    private String id = null;
    private String[][] sss = null;

    @FXML
    void initialize() {
        assert stackpane != null : "fx:id=\"stackpane\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert tabpane != null : "fx:id=\"tabpane\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert searchTab != null : "fx:id=\"searchTab\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert searchComboBox != null : "fx:id=\"searchComboBox\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert searchTextField != null : "fx:id=\"searchTextField\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert searchSearchBtn != null : "fx:id=\"searchSearchBtn\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert searchTableView != null : "fx:id=\"searchTableView\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert searchBookInfo != null : "fx:id=\"searchBookInfo\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert searchBookRecord != null : "fx:id=\"searchBookRecord\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoTab != null : "fx:id=\"bookInfoTab\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoTextField != null : "fx:id=\"bookInfoTextField\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoSearch != null : "fx:id=\"bookInfoSearch\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoID != null : "fx:id=\"bookInfoID\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoBarcode != null : "fx:id=\"bookInfoBarcode\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoTitle != null : "fx:id=\"bookInfoTitle\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoPublisher != null : "fx:id=\"BookInfoPublisher\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoAuthor != null : "fx:id=\"bookInfoAuthor\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoCategory != null : "fx:id=\"BookInfoCategory\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoIsBorrowable != null : "fx:id=\"bookInfoIsBorrowable\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoLocation != null : "fx:id=\"bookInfoLocation\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoBorrowDate != null : "fx:id=\"bookInfoBorrowDate\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoReturnDate != null : "fx:id=\"bookInfoReturnDate\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoBorrowerID != null : "fx:id=\"bookInfoBorrowerID\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoBorrowerName != null : "fx:id=\"bookInfoBorrowerName\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoPrice != null : "fx:id=\"bookInfoPrice\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert recordTab != null : "fx:id=\"recordTab\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert recordComboBox != null : "fx:id=\"recordComboBox\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert recordTextField != null : "fx:id=\"recordTextField\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert recordSearch != null : "fx:id=\"recordSearch\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert recordReset != null : "fx:id=\"recordReset\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert recordTableView != null : "fx:id=\"recordTableView\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addTab != null : "fx:id=\"addTab\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addtextField != null : "fx:id=\"addtextField\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addSearch != null : "fx:id=\"addSearch\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addReset != null : "fx:id=\"addReset\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addBarcode != null : "fx:id=\"addBarcode\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addTitle != null : "fx:id=\"addTitle\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addPublisher != null : "fx:id=\"addPublisher\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addLocatioin != null : "fx:id=\"addLocatioin\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addAuthor != null : "fx:id=\"addAuthor\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addcategory != null : "fx:id=\"addcategory\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addPrice != null : "fx:id=\"addPrice\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addIsBorrowable != null : "fx:id=\"addIsBorrowable\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addTableView != null : "fx:id=\"addTableView\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addAddBtn != null : "fx:id=\"addAddBtn\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addDeleteBtn != null : "fx:id=\"addDeleteBtn\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoTab != null : "fx:id=\"userInfoTab\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoComboBox != null : "fx:id=\"userInfoComboBox\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoTextField != null : "fx:id=\"userInfoTextField\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoSearch != null : "fx:id=\"userInfoSearch\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoTableView != null : "fx:id=\"userInfoTableView\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoAdd != null : "fx:id=\"userInfoAdd\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoDelete != null : "fx:id=\"userInfoDelete\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoApply != null : "fx:id=\"userInfoApply\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addSaveBtn != null : "fx:id=\"addSaveBtn\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoID != null : "fx:id=\"userInfoID\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoName != null : "fx:id=\"userInfoName\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoPhone != null : "fx:id=\"userInfoPhone\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoBalance != null : "fx:id=\"userInfoBalance\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addAddNewBookBtn != null : "fx:id=\"addAddNewBookBtn\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addID != null : "fx:id=\"addID\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoReset != null : "fx:id=\"userInfoReset\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoPassword != null : "fx:id=\"userInfoPassword\" was not injected: check your FXML file 'AdminUI.fxml'.";


        // 搜索图书页面的表格构建
        JFXTreeTableColumn<Book, String> idCol = new JFXTreeTableColumn<>("识别码");
        JFXTreeTableColumn<Book, String> barcodeCol = new JFXTreeTableColumn<>("条形码");
        JFXTreeTableColumn<Book, String> nameCol = new JFXTreeTableColumn<>("书名");
        JFXTreeTableColumn<Book, String> authorCol = new JFXTreeTableColumn<>("作者");
        JFXTreeTableColumn<Book, String> pressCol = new JFXTreeTableColumn<>("出版社");
        JFXTreeTableColumn<Book, String> categoryCol = new JFXTreeTableColumn<>("类型");
        JFXTreeTableColumn<Book, String> priceCol = new JFXTreeTableColumn<>("价格");
        JFXTreeTableColumn<Book, String> stateCol = new JFXTreeTableColumn<>("状态");
        JFXTreeTableColumn<Book, String> addressCol = new JFXTreeTableColumn<>("地点");
        idCol.setPrefWidth(90);
        barcodeCol.setPrefWidth(90);
        nameCol.setPrefWidth(200);
        authorCol.setPrefWidth(100);
        pressCol.setPrefWidth(200);
        categoryCol.setPrefWidth(100);
        priceCol.setPrefWidth(70);
        stateCol.setPrefWidth(80);
        addressCol.setPrefWidth(100);
        idCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getId()));
        barcodeCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getBarcode()));
        nameCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getName()));
        authorCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getAuthor()));
        pressCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getPress()));
        categoryCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCatego()));
        priceCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getPrice()));
        stateCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getState()));
        addressCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getAddress()));
        searchTableView.getColumns().setAll(idCol, barcodeCol, nameCol, authorCol, pressCol, categoryCol, priceCol, stateCol, addressCol);
        searchTableView.setShowRoot(false);

        //借阅记录页面的表格构建
        JFXTreeTableColumn<BorrowedRecord, String> idCol1 = new JFXTreeTableColumn<>("识别码");
        JFXTreeTableColumn<BorrowedRecord, String> nameCol1 = new JFXTreeTableColumn<>("书名");
        JFXTreeTableColumn<BorrowedRecord, String> borrowDateCol1 = new JFXTreeTableColumn<>("借书日期");
        JFXTreeTableColumn<BorrowedRecord, String> returnDateCol1 = new JFXTreeTableColumn<>("还书日期");
        JFXTreeTableColumn<BorrowedRecord, String> borrowerIDCol1 = new JFXTreeTableColumn<>("借阅者ID");
        JFXTreeTableColumn<BorrowedRecord, String> borrowerNameCol1 = new JFXTreeTableColumn<>("借阅者用户名");
        idCol1.setPrefWidth(100);
        nameCol1.setPrefWidth(175);
        borrowDateCol1.setPrefWidth(250);
        returnDateCol1.setPrefWidth(250);
        borrowerIDCol1.setPrefWidth(100);
        borrowerNameCol1.setPrefWidth(175);
        idCol1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getID()));
        nameCol1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getName()));
        borrowDateCol1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getBorrowDate()));
        returnDateCol1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getReturnDate()));
        borrowerIDCol1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getBorrowerID()));
        borrowerNameCol1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getBorrowerName()));
        recordTableView.getColumns().setAll(idCol1, nameCol1, borrowDateCol1, returnDateCol1, borrowerIDCol1, borrowerNameCol1);
        recordTableView.setShowRoot(false);

        //管理图书页面的表格构建
        JFXTreeTableColumn<Id, String> idCol2 = new JFXTreeTableColumn<>("识别码");
        idCol2.setPrefWidth(280);
        idCol2.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getID()));
        addTableView.getColumns().setAll(idCol2);
        addTableView.setShowRoot(false);

        //用户信息页面的表格构建
        JFXTreeTableColumn<BorrowedRecord, String> nameCol3 = new JFXTreeTableColumn<>("书名");
        JFXTreeTableColumn<BorrowedRecord, String> borrowDateCol3 = new JFXTreeTableColumn<>("借书日期");
        JFXTreeTableColumn<BorrowedRecord, String> returnDateCol3 = new JFXTreeTableColumn<>("还书日期");
        nameCol3.setPrefWidth(200);
        borrowDateCol3.setPrefWidth(200);
        returnDateCol3.setPrefWidth(200);
        nameCol3.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getName()));
        borrowDateCol3.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getBorrowDate()));
        returnDateCol3.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getReturnDate()));
        userInfoTableView.getColumns().setAll(nameCol3, borrowDateCol3, returnDateCol3);
        userInfoTableView.setShowRoot(false);
        /**
         * 搜索图书页面
         */
        searchComboBox.setItems(FXCollections.observableArrayList("按书名", "按作者", "按出版社", "按类别"));

        searchSearchBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            searchTableView.setRoot(null);
            String att;
            if ("按书名".equals(searchComboBox.getValue())) {
                att = "name";
            } else if ("按作者".equals(searchComboBox.getValue())) {
                att = "author";
            } else if ("按出版社".equals(searchComboBox.getValue())) {
                att = "press";
            } else if ("按类别".equals(searchComboBox.getValue())) {
                att = "catego";
            } else {
                att = null;
            }
            if (att == null) {
                showMsgDialog("错误", "请选择搜索类型");
                return;
            }
            if ("".equals(searchTextField.getText())) {
                showMsgDialog("错误", "请输入关键字");
                return;
            }
            ObservableList<Book> books = LibraryAdministrator.queryByAtt(att, searchTextField.getText());
            if (books.isEmpty()) {
                showMsgDialog("", "抱歉，未找到相关书籍");
                return;
            }
            for (Book b : books) {
                if ("0".equals(b.getState())) {
                    b.setState("可借");
                } else if ("1".equals(b.getState())) {
                    b.setState("已借出");
                } else {
                    b.setState("典藏");
                }
            }
            TreeItem<Book> root = new RecursiveTreeItem<>(books, RecursiveTreeObject::getChildren);
            searchTableView.setRoot(root);
        });

        searchBookInfo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (null == bookInfo[0] || "".equals(bookInfo[0])) {
                showMsgDialog("出错", "请先选择一本书");
                return;
            }
            tabpane.getSelectionModel().select(bookInfoTab);
            String[] s = LibraryAdministrator.getNewRecordByID(bookInfo[0]);
            for (int i = 0; i < 12; i++) {
                bookInfo[i + 1] = s[i];
                if (s[i] == null) {
                    bookInfo[i + 1] = "暂无";
                }
            }
            if ("0".equals(bookInfo[7])) {
                bookInfo[7] = "可借";
            } else if ("1".equals(bookInfo[7])) {
                bookInfo[7] = "已借出";
            } else {
                bookInfo[7] = "典藏";
            }
            setBookInfo();
        });

        searchBookRecord.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (null == bookInfo[0] || "".equals(bookInfo[0])) {
                showMsgDialog("出错", "请先选择一本书");
                return;
            }
            tabpane.getSelectionModel().select(recordTab);
            LinkedList<String[]> linkedList = LibraryAdministrator.getRecordByID(bookInfo[0]);
            if (linkedList.isEmpty()) {
                showMsgDialog("", "抱歉，该书暂无借阅记录");
                return;
            }
            ObservableList<BorrowedRecord> borrowedRecords = FXCollections.observableArrayList();
            for (String[] s : linkedList) {
                s[2] = s[2] == null ? "暂未归还" : s[2];
                BorrowedRecord br = new BorrowedRecord(bookInfo[0], s[0], s[1], s[2], s[3], s[4]);
                borrowedRecords.add(br);
            }
            recordComboBox.setValue("识别码");
            recordTextField.setText(bookInfo[0]);
            TreeItem<BorrowedRecord> root = new RecursiveTreeItem<>(borrowedRecords, RecursiveTreeObject::getChildren);
            recordTableView.setRoot(root);
        });

        searchTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            bookInfo[0] = newValue != null ? newValue.getValue().getId() : null;
        });


        /**
         * 显示图书信息页面
         */
        bookInfoSearch.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if ("".equals(bookInfoTextField.getText())) {
                showMsgDialog("错误", "请输入识别码");
                return;
            }
            bookInfo[0] = bookInfoTextField.getText();
            String[] s = LibraryAdministrator.getNewRecordByID(bookInfo[0]);
            if (s[0] == null) {
                showMsgDialog("错误", "暂无该书");
                return;
            }
            for (int i = 0; i < 12; i++) {
                bookInfo[i + 1] = s[i];
                if (s[i] == null) {
                    bookInfo[i + 1] = "暂无";
                }
            }
            if ("0".equals(bookInfo[7])) {
                bookInfo[7] = "可借";
            } else if ("1".equals(bookInfo[7])) {
                bookInfo[7] = "已借出";
            } else {
                bookInfo[7] = "典藏";
            }
            setBookInfo();
        });


        /**
         * 借阅记录页面
         */
        recordComboBox.setItems(FXCollections.observableArrayList("识别码", "条形码"));

        recordSearch.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            recordTableView.setRoot(null);
            if (recordComboBox.getValue() == null) {
                showMsgDialog("错误", "请选择识别码/条形码");
                return;
            }
            if ("".equals(recordTextField.getText())) {
                showMsgDialog("错误", "请输入识别码/条形码");
                return;
            }
            if ("识别码".equals(recordComboBox.getValue())) {
                LinkedList<String[]> linkedList = LibraryAdministrator.getRecordByID(recordTextField.getText());
                if (linkedList.isEmpty()) {
                    showMsgDialog("", "抱歉，该书暂无借阅记录");
                    return;
                }
                ObservableList<BorrowedRecord> borrowedRecords = FXCollections.observableArrayList();
                for (String[] s : linkedList) {
                    s[2] = s[2] == null ? "暂未归还" : s[2];
                    BorrowedRecord br = new BorrowedRecord(recordTextField.getText(), s[0], s[1], s[2], s[3], s[4]);
                    borrowedRecords.add(br);
                }
                TreeItem<BorrowedRecord> root = new RecursiveTreeItem<>(borrowedRecords, RecursiveTreeObject::getChildren);
                recordTableView.setRoot(root);
            } else {
                LinkedList<String[]> linkedList = LibraryAdministrator.getRecordByBarcode(recordTextField.getText());
                if (linkedList.isEmpty()) {
                    showMsgDialog("", "抱歉，该类书暂无借阅记录");
                    return;
                }
                ObservableList<BorrowedRecord> borrowedRecords = FXCollections.observableArrayList();
                for (String[] s : linkedList) {
                    s[3] = s[3] == null ? "暂未归还" : s[3];
                    BorrowedRecord br = new BorrowedRecord(s[0], s[1], s[2], s[3], s[4], s[5]);
                    borrowedRecords.add(br);
                }
                TreeItem<BorrowedRecord> root = new RecursiveTreeItem<>(borrowedRecords, RecursiveTreeObject::getChildren);
                recordTableView.setRoot(root);
            }
        });

        recordReset.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            recordTableView.setRoot(null);
            recordComboBox.setValue("");
            recordTextField.setText("");
        });

        /**
         * 管理图书页面
         */
        addLocatioin.setDisable(true);
        addIsBorrowable.setDisable(true);
        addSearch.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            addTableView.setRoot(null);
            if ("".equals(addtextField.getText())) {
                showMsgDialog("错误", "请输入条形码");
                return;
            }
            sss = LibraryAdministrator.getBookInfoByBarcode(addtextField.getText());
            if (sss[0] == null) {
                showMsgDialog("错误", "不存在该书");
                return;
            }
            addBarcode.setText(addtextField.getText());
            addBarcode.setDisable(true);
            addTitle.setText(sss[0][0]);
            addTitle.setDisable(true);
            addAuthor.setText(sss[1][0]);
            addAuthor.setDisable(true);
            addPublisher.setText(sss[2][0]);
            addPublisher.setDisable(true);
            addcategory.setText(sss[3][0]);
            addcategory.setDisable(true);
            addLocatioin.setText(sss[4][0]);
            addPrice.setText(sss[5][0]);
            addPrice.setDisable(true);
            if (null == sss[6]) {
                addIsBorrowable.setDisable(false);
            } else if ("0".equals(sss[6][0]) || "1".equals(sss[6][0])) {
                addIsBorrowable.setDisable(true);
            } else {
                addIsBorrowable.setSelected(true);
                addIsBorrowable.setDisable(false);
            }
            if (sss[7] != null) {
                ids.clear();
                for (String s : sss[7]) {
                    Id id = new Id(s);
                    ids.add(id);
                }
                TreeItem<Id> root = new RecursiveTreeItem<>(ids, RecursiveTreeObject::getChildren);
                addTableView.setRoot(root);
                addBarcode.setDisable(true);
            }
        });

        addReset.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            addtextField.setText("");
            addBarcode.setText("");
            addTitle.setText("");
            addPublisher.setText("");
            addLocatioin.setText("");
            addAuthor.setText("");
            addPrice.setText("");
            addcategory.setText("");
            addID.setText("");
            addIsBorrowable.setSelected(false);
            addIsBorrowable.setDisable(true);
            addTableView.setRoot(null);
            addBarcode.setDisable(false);
            addTitle.setDisable(false);
            addPrice.setDisable(false);
            addPublisher.setDisable(false);
            addAuthor.setDisable(false);
            addcategory.setDisable(false);
        });

        addAddBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (!addBarcode.isDisable()) {
                showMsgDialog("错误", "请先搜索一本书");
                return;
            }
            if (null == addID.getText() || "".equals(addID.getText())) {
                showMsgDialog("错误", "请输入识别码");
                return;
            }
            String state;
            if (addIsBorrowable.isSelected()) {
                state = "2";
            } else {
                state = "0";
            }
            Boolean flag = false;
            try {
                flag = LibraryAdministrator.addExistBook(addID.getText(), addBarcode.getText(), state);
            } catch (SQLException e) {
                showMsgDialog("错误", "书库中已存在该标识码的书");
            }
            if (flag) {
                showMsgDialog("成功", "增加库存成功");
                sss = LibraryAdministrator.getBookInfoByBarcode(addtextField.getText());
                ids.clear();
                for (String s : sss[7]) {
                    Id id = new Id(s);
                    ids.add(id);
                }
                TreeItem<Id> root = new RecursiveTreeItem<>(ids, RecursiveTreeObject::getChildren);
                addTableView.setRoot(root);
            }
        });

        addDeleteBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (id == null) {
                showMsgDialog("错误", "请选择一行");
                return;
            }
            for (int i = 0; i < sss[7].length; i++) {
                if (sss[7][i].equals(id)) {
                    if ("1".equals(sss[6][i])) {
                        showMsgDialog("错误", "该书正在外借，暂时不可删除");
                        return;
                    }
                    break;
                }
            }
            Boolean flag = LibraryAdministrator.delBook(id);
            if (flag) {
                showMsgDialog("成功", "删除成功");
                sss = LibraryAdministrator.getBookInfoByBarcode(addtextField.getText());
                ids.clear();
                for (String s : sss[7]) {
                    Id id = new Id(s);
                    ids.add(id);
                }
                TreeItem<Id> root = new RecursiveTreeItem<>(ids, RecursiveTreeObject::getChildren);
                addTableView.setRoot(root);
                return;
            } else {
                showMsgDialog("失败", "删除失败，请重新选择");
            }
            id = null;
        });

        addAddNewBookBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (addBarcode.isDisable()) {
                showMsgDialog("错误", "请先清空");
                return;
            }
            if ("".equals(addBarcode.getText())) {
                showMsgDialog("错误", "请输入条形码");
                return;
            }
            if ("".equals(addTitle.getText())) {
                showMsgDialog("错误", "请输入书名");
                return;
            }
            if ("".equals(addPublisher.getText())) {
                showMsgDialog("错误", "请输入出版社");
                return;
            }
            if ("".equals(addAuthor.getText())) {
                showMsgDialog("错误", "请输入作者");
                return;
            }
            if ("".equals(addcategory.getText())) {
                showMsgDialog("错误", "请输入分类");
                return;
            }
            if ("".equals(addPrice.getText())) {
                showMsgDialog("错误", "请输入价格");
                return;
            }
            Boolean flag = LibraryAdministrator.addBook(addBarcode.getText(), addAuthor.getText(), addTitle.getText(),
                    addcategory.getText(), addPublisher.getText(), addPrice.getText());
            if (flag) {
                showMsgDialog("成功", "新书入库成功");
            } else {
                showMsgDialog("失败", "新书入库失败");
            }
        });

        addTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            id = newValue != null ? newValue.getValue().getID() : null;
        });

        /**
         * 管理用户界面
         */
        userInfoSearch.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            userInfoTableView.setRoot(null);
            if ("".equals(userInfoTextField.getText())) {
                showMsgDialog("错误", "请输入用户ID");
                return;
            }
            Borrower borrower = LibraryAdministrator.getUserInfo(userInfoTextField.getText());
            if (borrower == null) {
                showMsgDialog("错误", "没有该用户");
                return;
            }
            userInfoID.setText(borrower.getId());
            userInfoName.setText(borrower.getName());
            userInfoPhone.setText(borrower.getTel());
            userInfoBalance.setText(borrower.getBalance());
            LinkedList<String[]> linkedList = LibraryAdministrator.getRecordByUserID(userInfoTextField.getText());
            ObservableList<BorrowedRecord> borrowedRecords = FXCollections.observableArrayList();
            for (String[] s : linkedList) {
                if (s[2] == null) {
                    s[2] = "暂未归还";
                }
                BorrowedRecord br = new BorrowedRecord(null, s[0], s[1], s[2], null, null);
                borrowedRecords.add(br);
            }
            TreeItem<BorrowedRecord> root = new RecursiveTreeItem<>(borrowedRecords, RecursiveTreeObject::getChildren);
            userInfoTableView.setRoot(root);
            userInfoID.setDisable(true);
        });

        userInfoReset.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            userInfoTextField.setText("");
            userInfoID.setText("");
            userInfoName.setText("");
            userInfoPhone.setText("");
            userInfoBalance.setText("");
            userInfoID.setDisable(false);
            userInfoPassword.setText("");
            userInfoTableView.setRoot(null);
        });

        userInfoAdd.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (userInfoID.isDisable()) {
                showMsgDialog("错误", "已存在该用户ID，请先清空");
                return;
            }
            if ("".equals(userInfoID.getText())) {
                showMsgDialog("错误", "请输入用户ID");
                return;
            }
            if ("".equals(userInfoName.getText())) {
                showMsgDialog("错误", "请输入用户名");
                return;
            }
            if ("".equals(userInfoPhone.getText())) {
                showMsgDialog("错误", "请输入电话号码");
                return;
            }
            if ("".equals(userInfoPassword.getText())) {
                showMsgDialog("错误", "请输入密码");
                return;
            }
            if ("".equals(userInfoBalance.getText())) {
                showMsgDialog("错误", "请输入余额");
                return;
            }
            Boolean flag = LibraryAdministrator.addUser(userInfoID.getText(), userInfoPassword.getText(), userInfoName.getText(),
                    userInfoPhone.getText(), userInfoBalance.getText());
            if (flag) {
                showMsgDialog("成功", "添加新用户成功");
                userInfoTextField.setText(null);
                userInfoID.setText(null);
                userInfoName.setText(null);
                userInfoPhone.setText(null);
                userInfoBalance.setText(null);
                userInfoPassword.setText(null);
                userInfoID.setDisable(false);
            } else {
                showMsgDialog("错误", "添加新用户失败");
            }
        });

        userInfoDelete.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (!userInfoID.isDisable()) {
                showMsgDialog("错误", "请先搜索一个用户");
                return;
            }
            Boolean flag = LibraryAdministrator.delUser(userInfoID.getText());
            if (flag) {
                showMsgDialog("成功", "删除用户成功");
                userInfoTextField.setText("");
                userInfoID.setText("");
                userInfoName.setText("");
                userInfoPhone.setText("");
                userInfoBalance.setText("");
                userInfoPassword.setText("");
                userInfoID.setDisable(false);
            } else {
                showMsgDialog("错误", "删除用户失败");
            }
        });

        userInfoApply.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (!userInfoID.isDisable()) {
                showMsgDialog("错误", "请先搜索一个用户");
                return;
            }
            if (null == userInfoName.getText() || "".equals(userInfoName.getText())) {
                showMsgDialog("错误", "请输入新的用户名");
                return;
            }
            if (null == userInfoPhone || "".equals(userInfoPhone.getText())) {
                showMsgDialog("错误", "请输入新的电话号码");
                return;
            }
            if (null == userInfoPassword || "".equals(userInfoPassword.getText())) {
                showMsgDialog("错误", "请输入新的密码");
                return;
            }
            if (null == userInfoBalance || "".equals(userInfoBalance.getText())) {
                showMsgDialog("错误", "请输入新的余额");
                return;
            }
            Boolean flag = LibraryAdministrator.update(userInfoID.getText(), userInfoPassword.getText(), userInfoName.getText(),
                    userInfoPhone.getText(), userInfoBalance.getText());
            if (flag) {
                showMsgDialog("成功", "更新用户信息成功");
                userInfoTextField.setText("");
                userInfoID.setText("");
                userInfoName.setText("");
                userInfoPhone.setText("");
                userInfoBalance.setText("");
                userInfoPassword.setText("");
                userInfoID.setDisable(false);
                userInfoTableView.setRoot(null);
            } else {
                showMsgDialog("错误", "删除用户信息失败");
            }
        });
    }

    // 显示弹出信息框
    private void showMsgDialog(String heading, String msg) {
        JFXDialogLayout content = new JFXDialogLayout();
        Text t = new Text(heading);
        t.setFont(Font.font("Microsoft YaHei", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text m = new Text(msg);
        m.setFont(Font.font("Microsoft YaHei", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        content.setHeading(t);
        content.setBody(m);
        JFXButton btn = new JFXButton("OK");
        JFXDialog dialog = new JFXDialog(stackpane, content, JFXDialog.DialogTransition.CENTER);
        btn.setOnAction(event -> dialog.close());
        content.setActions(btn);
        dialog.show();
    }

    // bookInfoTab 页面显示信息
    private void setBookInfo() {
        bookInfoTextField.setText(bookInfo[0]);
        bookInfoID.setText(bookInfo[0]);
        bookInfoBarcode.setText(bookInfo[1]);
        bookInfoTitle.setText(bookInfo[2]);
        bookInfoPublisher.setText(bookInfo[4]);
        bookInfoAuthor.setText(bookInfo[3]);
        bookInfoCategory.setText(bookInfo[5]);
        bookInfoIsBorrowable.setText(bookInfo[7]);
        bookInfoLocation.setText(bookInfo[8]);
        bookInfoBorrowDate.setText(bookInfo[9]);
        bookInfoReturnDate.setText(bookInfo[10]);
        bookInfoBorrowerID.setText(bookInfo[11]);
        bookInfoBorrowerName.setText(bookInfo[12]);
        bookInfoPrice.setText(bookInfo[6]);
    }
}
