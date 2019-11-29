package sample;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab searchTab;

    @FXML
    private JFXComboBox<String> searchComboBox;

    @FXML
    private JFXTextField searchTextField;

    @FXML
    private JFXButton searchSearchBtn;

    @FXML
    private JFXTreeTableView<?> searchTableView;

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
    private JFXTextField BookInfoPublisher;

    @FXML
    private JFXTextField bookInfoAuthor;

    @FXML
    private JFXTextField BookInfoCategory;

    @FXML
    private JFXTextField bookInfoIsBorrowable;

    @FXML
    private JFXTextField bookInfostatus;

    @FXML
    private JFXTextField bookInfoBorrowDate;

    @FXML
    private JFXTextField bookInfoReturnDate;

    @FXML
    private Tab recordTab;

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

    @FXML
    void initialize() {
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
        assert BookInfoPublisher != null : "fx:id=\"BookInfoPublisher\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoAuthor != null : "fx:id=\"bookInfoAuthor\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert BookInfoCategory != null : "fx:id=\"BookInfoCategory\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoIsBorrowable != null : "fx:id=\"bookInfoIsBorrowable\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfostatus != null : "fx:id=\"bookInfostatus\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoBorrowDate != null : "fx:id=\"bookInfoBorrowDate\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert bookInfoReturnDate != null : "fx:id=\"bookInfoReturnDate\" was not injected: check your FXML file 'AdminUI.fxml'.";
        assert recordTab != null : "fx:id=\"recordTab\" was not injected: check your FXML file 'AdminUI.fxml'.";
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


        searchComboBox.setItems(FXCollections.observableArrayList("按标题","按xx","按yy"));
        System.out.println("Admin UI Initialized");
    }
}
