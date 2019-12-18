package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import model.*;


import javafx.scene.image.Image;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;


@SuppressWarnings("unused")
public class UserController {

    @FXML
    private StackPane stackpane;

    @FXML
    private JFXTabPane pane2;
    
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
    private ImageView searchImageView;


    @FXML
    private JFXTreeTableView<Book> searchTableView;

    @FXML
    private JFXButton searchBorrowBtn;

    @FXML
    private Tab BorrowTab;

    @FXML
    private JFXTextField borrowTextField;

    @FXML
    private JFXButton borrowSearchBtn;

    @FXML
    private JFXButton borrowResetBtn;

    @FXML
    private JFXButton borrowBorrowBtn;

    @FXML
    private JFXButton borrowRenewBtn;

    @FXML
    private JFXTextArea borrowTextArea;

    @FXML
    private ImageView borrowImageView;

    @FXML
    private JFXTextField returnTextField;

    @FXML
    private JFXButton returnSearchBtn;

    @FXML
    private JFXButton returnResetBtn;

    @FXML
    private JFXButton returnReturnBtn;

    @FXML
    private JFXTextArea returnTestArea;

    @FXML
    private Tab historyTab;

    @FXML
    private JFXTreeTableView<history> historyTableView;

    @FXML
    private JFXButton historyRefreshBtn;

    @FXML
    private Tab InfoTab;

    @FXML
    private JFXTextField infoName;

    @FXML
    private JFXTextField infoID;

    @FXML
    private JFXTextField infoBalance;

    @FXML
    private JFXTextField infoExpired;

    @FXML
    private JFXTextField infoBorrowCount;
    static public ObservableList<history> historylist = FXCollections.observableArrayList();
    static public ObservableList<Book> booklist = FXCollections.observableArrayList();
    @SuppressWarnings("unchecked")
	@FXML
    void initialize() {
        assert searchTab != null : "fx:id=\"searchTab\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert searchComboBox != null : "fx:id=\"searchChoiceBox\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert pane2 != null : "fx:id=\"pane1\" was not injected: check your FXML file 'UserUI.fxml'.";
		System.out.println(pane2==null);
        assert searchTextField != null : "fx:id=\"searchTextField\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert searchSearchBtn != null : "fx:id=\"searchSearchBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert searchTableView != null : "fx:id=\"searchTableView\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert searchBorrowBtn != null : "fx:id=\"searchBorrowBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert BorrowTab != null : "fx:id=\"BorrowTab\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert borrowTextField != null : "fx:id=\"borrowTextField\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert borrowSearchBtn != null : "fx:id=\"borrowSearchBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert borrowResetBtn != null : "fx:id=\"borrowResetBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert borrowBorrowBtn != null : "fx:id=\"borrowborrowBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert borrowRenewBtn != null : "fx:id=\"borrowRenewBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert borrowTextArea != null : "fx:id=\"borrowTextArea\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert returnTextField != null : "fx:id=\"returnTextField\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert returnSearchBtn != null : "fx:id=\"returnSearchBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert returnResetBtn != null : "fx:id=\"returnResetBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert returnReturnBtn != null : "fx:id=\"returnReturnBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert returnTestArea != null : "fx:id=\"returnTestArea\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert historyTab != null : "fx:id=\"historyTab\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert historyTableView != null : "fx:id=\"historyTableView\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert historyRefreshBtn != null : "fx:id=\"historyRefreshBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert InfoTab != null : "fx:id=\"InfoTab\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert infoName != null : "fx:id=\"infoName\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert infoID != null : "fx:id=\"infoID\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert infoBalance != null : "fx:id=\"infoBalance\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert infoBorrowCount != null : "fx:id=\"infoBorrowCount\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert stackpane != null : "fx:id=\"stackpane\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert infoExpired != null : "fx:id=\"infoExpired\" was not injected: check your FXML file 'UserUI.fxml'.";
        //JFXTreeTableColumn<Book, String> idCol = new JFXTreeTableColumn<>("识别码");
        JFXTreeTableColumn<Book, String> barcodeCol = new JFXTreeTableColumn<>("条形码");
        JFXTreeTableColumn<Book, String> nameCol = new JFXTreeTableColumn<>("书名");
        JFXTreeTableColumn<Book, String> authorCol = new JFXTreeTableColumn<>("作者");
        JFXTreeTableColumn<Book, String> pressCol = new JFXTreeTableColumn<>("出版社");
        JFXTreeTableColumn<Book, String> categoryCol = new JFXTreeTableColumn<>("类型");
        JFXTreeTableColumn<Book, String> priceCol = new JFXTreeTableColumn<>("价格");
        //JFXTreeTableColumn<Book, String> stateCol = new JFXTreeTableColumn<>("状态");
        JFXTreeTableColumn<Book, String> addressCol = new JFXTreeTableColumn<>("地点");
        //idCol.setPrefWidth(100);
        barcodeCol.setPrefWidth(150);
        nameCol.setPrefWidth(150);
        authorCol.setPrefWidth(150);
        pressCol.setPrefWidth(150);
        categoryCol.setPrefWidth(150);
        priceCol.setPrefWidth(150);
        //stateCol.setPrefWidth(80);
        addressCol.setPrefWidth(150);
        //idCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getId()));
        barcodeCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getBarcode()));
        nameCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getName()));
        authorCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getAuthor()));
        pressCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getPress()));
        categoryCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getCatego()));
        priceCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getPrice()));
        //stateCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getState()));
        addressCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getAddress()));
        searchTableView.getColumns().setAll(barcodeCol, nameCol, authorCol, pressCol, categoryCol, priceCol, addressCol);
        searchTableView.setShowRoot(false);
        searchComboBox.setItems(FXCollections.observableArrayList("按书名","按作者","按出版社"));
        System.out.println("User UI Initialized");
        String[] borrower = LibraryBorrower.getBorrowInfo(Main.user_id);
        infoName.setText(borrower[1]);
        infoID.setText(borrower[0]);
        infoBalance.setText(borrower[2]);
        infoBorrowCount.setText(borrower[3]);
        infoExpired.setText(borrower[4]);
        searchTableView.getSelectionModel().clearAndSelect(0);
        
        
        searchTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->{
        	TreeItem<Book>  book = searchTableView.getSelectionModel().getSelectedItem();
        	if(book!=null) {
				Book book1 = book.getValue();
				Image image = LibraryBorrower.getImage(book1.getBarcode());
				if(image!=null) {
					searchImageView.setImage(image);
				}

        	}
        });
        
        
        searchSearchBtn.setOnAction(new EventHandler<ActionEvent>() {   //查询按钮的监听器
			public void handle(ActionEvent event) {
				String att;
				String text;
				att = searchComboBox.getValue();
				if(att.equals("按书名")) {
					att="name";
				}
				else if(att.equals("按作者")){
					att="author";
				}
				else if(att.equals("按出版社")){
					att="press";
				}
				text = searchTextField.getText();
		        searchTableView.setEditable(true);
		        final String a = att;
		        booklist = LibraryBorrower.queryByAtt(a,text);	
		        TreeItem<Book> root = new RecursiveTreeItem<Book>(booklist, RecursiveTreeObject::getChildren);
			    searchTableView.setRoot(root);
				System.out.println(a);
			    searchTableView.getSelectionModel().clearAndSelect(0);
			    TreeItem<Book>  book = searchTableView.getSelectionModel().getSelectedItem();
			    if(book!=null) {
					Book book1 = book.getValue();
					Image image = LibraryBorrower.getImage(book1.getBarcode());
					if(image!=null) {
						searchImageView.setImage(image);
					}
						
		        }
			}
		});
        
        
        searchBorrowBtn.setOnAction(new EventHandler<ActionEvent>() {   //借阅按钮的监听器
			public void handle(ActionEvent event) {
				TreeItem<Book>  book = searchTableView.getSelectionModel().getSelectedItem(); 
				if(book!=null) {
					Book book1 = book.getValue();					
					if(LibraryBorrower.getIDByBar(book1.getBarcode())==null) {
						JOptionPane.showMessageDialog(null, "暂无此图书","提示",JOptionPane.WARNING_MESSAGE);
					}
					else {

						System.out.println(BorrowTab==null);
						pane2.getSelectionModel().select(BorrowTab);
						String barcodeString = LibraryBorrower.getIDByBar(book1.getBarcode());
						borrowTextField.setText(barcodeString);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "请选中一本书后进行借阅","提示",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
        
        
        borrowResetBtn.setOnAction(new EventHandler<ActionEvent>() {     //重置建监听器
			public void handle(ActionEvent event) {
				borrowTextField.clear();
			}
		});
        
        
        borrowSearchBtn.setOnAction(new EventHandler<ActionEvent>() {    //借阅界面搜索监听器
			public void handle(ActionEvent event) {
				borrowTextArea.clear();
				String id = borrowTextField.getText();
				if(!id.equals("")) {
					borrowTextArea.clear();
					Book book = null;
					book = LibraryBorrower.queryByID(id);
					System.out.println(book.getBarcode());
					Image image = LibraryBorrower.getImage(book.getBarcode());
					if(image!=null) {
						borrowImageView.setImage(image);
					}
					if(book!=null) {
						borrowTextArea.appendText("   识别码：  ");
						borrowTextArea.appendText(book.getId());
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("   条形码：  ");
						borrowTextArea.appendText(book.getBarcode());
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("   书名：  ");
						borrowTextArea.appendText(book.getName());
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("   作者：  ");
						borrowTextArea.appendText(book.getAuthor());
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("   出版社：  ");
						borrowTextArea.appendText(book.getCatego());
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("   类型：  ");
						borrowTextArea.appendText(book.getPress());
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("   价格：  ");
						borrowTextArea.appendText(book.getPrice());
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("   状态：  ");
						borrowTextArea.appendText(book.getState());
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("\n");
						borrowTextArea.appendText("   地点：  ");
						borrowTextArea.appendText(book.getAddress());
					}
					else { 
						JOptionPane.showMessageDialog(null, "未找到相关书籍","提示",JOptionPane.WARNING_MESSAGE);	
						borrowTextArea.clear();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "请输入识别码","提示",JOptionPane.WARNING_MESSAGE); 
					borrowTextArea.clear();
				}
			}
		});
        
        
        borrowBorrowBtn.setOnAction(new EventHandler<ActionEvent>() {   //借阅按钮监听器
			public void handle(ActionEvent event) {
				String id = borrowTextField.getText();
				boolean result = false;
				if(!id.equals("")) {
					result = LibraryBorrower.borrowBook(borrowTextField.getText(),Main.user_id);
					if(result) {
						JOptionPane.showMessageDialog(null, "借书成功","提示",JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "借书失败","提示",JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "请输入识别码","提示",JOptionPane.WARNING_MESSAGE);
				}
				System.out.println(Main.user_id);
			}
		});
        
        
        borrowRenewBtn.setOnAction(new EventHandler<ActionEvent>() {      //续借监听器
			public void handle(ActionEvent event) {
				String id = borrowTextField.getText();
				boolean result = false;
				if(!id.equals("")) { 
					if(LibraryBorrower.returnBook(borrowTextField.getText(),Main.user_id)) {
						result = LibraryBorrower.borrowBook(borrowTextField.getText(),Main.user_id);
					}
					if(result) {
						JOptionPane.showMessageDialog(null, "续借成功","提示",JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "续借失败","提示",JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "请输入识别码","提示",JOptionPane.WARNING_MESSAGE);
				}
				System.out.println(Main.user_id);
			}
		});
        
        
        returnSearchBtn.setOnAction(new EventHandler<ActionEvent>() {      //还书界面搜索按钮监听器
			public void handle(ActionEvent event) {
				String id = returnTextField.getText();
				returnTestArea.clear();
				if(!id.equals("")) {
					returnTestArea.clear();
					Book book = null;
					book = LibraryBorrower.queryByID(id);
					if(book!=null) {
						returnTestArea.appendText("   识别码：  ");
						returnTestArea.appendText(book.getId());
						returnTestArea.appendText("\n");
						returnTestArea.appendText("\n");
						returnTestArea.appendText("   条形码：  ");
						returnTestArea.appendText(book.getBarcode());
						returnTestArea.appendText("\n");
						returnTestArea.appendText("\n");
						returnTestArea.appendText("   书名：  ");
						returnTestArea.appendText(book.getName());
						returnTestArea.appendText("\n");
						returnTestArea.appendText("\n");
						returnTestArea.appendText("   作者：  ");
						returnTestArea.appendText(book.getAuthor());
						returnTestArea.appendText("\n");
						returnTestArea.appendText("\n");
						returnTestArea.appendText("   出版社：  ");
						returnTestArea.appendText(book.getCatego());
						returnTestArea.appendText("\n");
						returnTestArea.appendText("\n");
						returnTestArea.appendText("   类型：  ");
						returnTestArea.appendText(book.getPress());
						returnTestArea.appendText("\n");
						returnTestArea.appendText("\n");
						returnTestArea.appendText("   价格：  ");
						returnTestArea.appendText(book.getPrice());
						returnTestArea.appendText("\n");
						returnTestArea.appendText("\n");
						returnTestArea.appendText("   状态：  ");
						returnTestArea.appendText(book.getState());
						returnTestArea.appendText("\n");
						returnTestArea.appendText("\n");
						returnTestArea.appendText("   地点：  ");
						returnTestArea.appendText(book.getAddress());
					}
					else 
						JOptionPane.showMessageDialog(null, "未找到相关书籍","提示",JOptionPane.WARNING_MESSAGE);				
				}
				else {
					JOptionPane.showMessageDialog(null, "请输入识别码","提示",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
       
        
        returnResetBtn.setOnAction(new EventHandler<ActionEvent>() {      //还书界面重置按钮监听器
			public void handle(ActionEvent event) {
				returnTextField.clear();
			}
		});
        
        
        returnReturnBtn.setOnAction(new EventHandler<ActionEvent>() {     //还书界面归还按钮监听器
			public void handle(ActionEvent event) {
				String id = returnTextField.getText();
				if(!id.equals("")) {
					if(LibraryBorrower.returnBook(id,Main.user_id)) {
						JOptionPane.showMessageDialog(null, "还书成功","提示",JOptionPane.WARNING_MESSAGE);		
					}
					else
						JOptionPane.showMessageDialog(null, "还书失败","提示",JOptionPane.WARNING_MESSAGE);		
				}
				else if(id.equals(""))
					JOptionPane.showMessageDialog(null, "请输入识别码还书","提示",JOptionPane.WARNING_MESSAGE);				
			}
		});
        
        
        historyRefreshBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				historylist.clear();
				List<String[]> list = null;
				list = LibraryBorrower.borrowRecord(Main.user_id);
				if(list==null) {
					JOptionPane.showMessageDialog(null, "暂无借书记录","提示",JOptionPane.WARNING_MESSAGE);
				}
				else {
					for(int i =0;i<list.size();i++) {
						history h = new history(list.get(i));
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String dateStr = list.get(i)[6];
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						SimpleDateFormat now_df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						String now_data = df.format(new Date());// new Date()为获取当前系统时间
						try {
							Date data = simpleDateFormat.parse(dateStr);
							Date now = simpleDateFormat.parse(now_data);
							Calendar rightNow = Calendar.getInstance();
						    rightNow.setTime(data);
						    rightNow.add(Calendar.MONTH,1);
						    data = rightNow.getTime();
						    if(list.get(i)[7]==null){
						    	if(now.before(data)) {//未还
						    		h.setstate("未还");
						    	}
						    	else {
						    		h.setstate("逾期");
						    	}
						    }
						    else {
						    	h.setstate("已还");
						    }
						} catch (ParseException e) {
							e.printStackTrace();
						}

						
						historylist.add(h);
					}
				}
				JFXTreeTableColumn<history, String> hty_id = new JFXTreeTableColumn<>("ID");
		        JFXTreeTableColumn<history, String> hty_barcodeCol = new JFXTreeTableColumn<>("条形码");
		        JFXTreeTableColumn<history, String> hty_nameCol = new JFXTreeTableColumn<>("书名");
		        JFXTreeTableColumn<history, String> hty_categoryCol = new JFXTreeTableColumn<>("类型");
		        JFXTreeTableColumn<history, String> hty_price= new JFXTreeTableColumn<>("价格");
		        JFXTreeTableColumn<history, String> hty_addressclo = new JFXTreeTableColumn<>("地点");
		        JFXTreeTableColumn<history, String> hty_bdate = new JFXTreeTableColumn<>("借书日期");
		        JFXTreeTableColumn<history, String> hty_rdate = new JFXTreeTableColumn<>("还书日期");
		        JFXTreeTableColumn<history, String> hty_state = new JFXTreeTableColumn<>("状态");
		        hty_id.setPrefWidth(100);
		        hty_barcodeCol.setPrefWidth(100);
		        hty_nameCol.setPrefWidth(180);
		        hty_categoryCol.setPrefWidth(100);
		        hty_price.setPrefWidth(100);
		        hty_addressclo.setPrefWidth(100);
		        hty_bdate.setPrefWidth(180);
		        hty_rdate.setPrefWidth(180);
		        hty_state.setPrefWidth(100);
		        hty_id.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getid()));
		        hty_barcodeCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getbarcode()));
		        hty_nameCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getname()));
		        hty_categoryCol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getcategory()));
		        hty_price.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getprice()));
		        hty_addressclo.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getaddress()));
		        hty_bdate.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getbdate()));
		        hty_rdate.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getrdate()));
		        hty_state.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getstate()));
		        historyTableView.getColumns().setAll(hty_id,hty_barcodeCol,hty_nameCol,hty_categoryCol,hty_price,hty_addressclo,hty_bdate,hty_rdate,hty_state);
		        historyTableView.setShowRoot(false);
		        TreeItem<history> root = new RecursiveTreeItem<history>(historylist, RecursiveTreeObject::getChildren);
		        historyTableView.setRoot(root);
			}
		});
        
        
        
    }
}
