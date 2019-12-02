package controller;

import com.jfoenix.controls.*;

import java.net.URL;
import java.nio.ByteOrder;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.ResourceBundle;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
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
import org.omg.Messaging.SYNC_WITH_TRANSPORT;


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
    private JFXTextField bookInfoPrice;

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
    private Tab recordTab;

    @FXML
    private JFXComboBox<?> recordComboBox;

    @FXML
    private JFXTextField recordTextField;

    @FXML
    private JFXButton recordSearch;

    @FXML
    private JFXButton recordReset;

    @FXML
    private JFXTreeTableView<?> recordTableView;

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
    private JFXTextField addAuthor;

    @FXML
    private JFXTextField addcategory;

    @FXML
    private JFXCheckBox addIsBorrowable;

    @FXML
    private JFXTreeTableView<?> addTableView;

    @FXML
    private JFXButton addAddBtn;

    @FXML
    private JFXButton addDeleteBtn;

    @FXML
    private Tab userInfoTab;

    @FXML
    private JFXComboBox<?> userInfoComboBox;

    @FXML
    private JFXTextField userInfoTextField;

    @FXML
    private JFXButton userInfoSearch;

    @FXML
    private JFXButton userInfoReset;

    @FXML
    private JFXTreeTableView<?> userInfoTableView;

    @FXML
    private JFXButton userInfoAdd;

    @FXML
    private JFXButton userInfoDelete;

    @FXML
    private JFXButton userInfoApply;

    private String[] bookInfo = new String[13];

    @FXML
    void initialize() {
        assert stackpane != null : "fx:id=\"stackpane\" was not injected: check your FXML file 'AdminUI.fxml'.";
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
        assert bookInfoBorrowDate != null : "fx:id=\"bookInfoBorrowDate\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoReturnDate != null : "fx:id=\"bookInfoReturnDate\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoBorrowerID != null : "fx:id=\"bookInfoBorrowerID\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoBorrowerName != null : "fx:id=\"bookInfoBorrowerName\" was not injected: check your FXML file 'AdminUI.fxml'.";
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
        assert addAuthor != null : "fx:id=\"addAuthor\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addcategory != null : "fx:id=\"addcategory\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addIsBorrowable != null : "fx:id=\"addIsBorrowable\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addTableView != null : "fx:id=\"addTableView\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addAddBtn != null : "fx:id=\"addAddBtn\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert addDeleteBtn != null : "fx:id=\"addDeleteBtn\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoTab != null : "fx:id=\"userInfoTab\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoComboBox != null : "fx:id=\"userInfoComboBox\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoTextField != null : "fx:id=\"userInfoTextField\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoSearch != null : "fx:id=\"userInfoSearch\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoReset != null : "fx:id=\"userInfoReset\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoTableView != null : "fx:id=\"userInfoTableView\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoAdd != null : "fx:id=\"userInfoAdd\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoDelete != null : "fx:id=\"userInfoDelete\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert userInfoApply != null : "fx:id=\"userInfoApply\" was not injected: check your FXML file 'AdminUI.fxml'.";

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
        categoryCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCategory()));
        priceCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getPrice()));
        stateCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getState()));
        addressCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getAddress()));
        searchTableView.getColumns().setAll(idCol, barcodeCol, nameCol, authorCol, pressCol, categoryCol, priceCol, stateCol, addressCol);
        searchTableView.setShowRoot(false);

        //借阅记录页面的表格构建
        JFXTreeTableColumn<BorrowedRecord, String> idCol1 = new JFXTreeTableColumn<>("识别码");
        JFXTreeTableColumn<BorrowedRecord, String> nameCol1 = new JFXTreeTableColumn<>("书名");
        /**
         * 搜索图书页面
         */
        searchComboBox.setItems(FXCollections.observableArrayList("按书名", "按作者", "按出版社", "按类型"));
        searchSearchBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            String att;
            if ("按书名".equals(searchComboBox.getValue())) {
                att = "name";
            } else if ("按作者".equals(searchComboBox.getValue())) {
                att = "author";
            } else if ("按出版社".equals(searchComboBox.getValue())) {
                att = "press";
            } else if ("按类别".equals(searchComboBox.getValue())) {
                att = "categories";
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
            TreeItem<Book> root = new RecursiveTreeItem<Book>(books, RecursiveTreeObject::getChildren);
            searchTableView.setRoot(root);
        });

        searchBookInfo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            tabpane.getSelectionModel().select(bookInfoTab);
            String[] s = LibraryAdministrator.getNewRecordByID(bookInfo[0]);
            for (int i = 0; i < 12; i++) {
                bookInfo[i + 1] = s[i];
                if (s[i] == null) {
                    bookInfo[i + 1] = "无";
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
            setBookInfo();
        });

        searchBookRecord.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            ObservableList<BorrowedRecord> borrowedRecords = FXCollections.observableArrayList();
            LinkedList<String[]> linkedList = LibraryAdministrator.getRecordByID(bookInfo[0]);
            for (String[] s : linkedList) {
                BorrowedRecord br = new BorrowedRecord(bookInfo[0], s[0], s[1], s[2], s[3], s[4]);
                borrowedRecords.add(br);
            }
        });

        searchTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            bookInfo[0] = newValue.getValue().getId();
        });

        /**
         * 显示图书信息页面
         */
        bookInfoSearch.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            bookInfo[0] = bookInfoTextField.getText();
            String[] s = LibraryAdministrator.getNewRecordByID(bookInfo[0]);
            for (int i = 0; i < 12; i++) {
                bookInfo[i + 1] = s[i];
                if (s[i] == null) {
                    bookInfo[i + 1] = "无";
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
