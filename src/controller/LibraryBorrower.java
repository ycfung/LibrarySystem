package controller;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import javax.imageio.ImageIO;
import model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
public class LibraryBorrower {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//借阅者连接
	public static Connection getBorConnection() {
		try {
			return (Connection)DriverManager.getConnection("jdbc:oracle:thin:@3.80.200.209:1521:library","libbro","123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//根据特定属性从条形码表中模糊查找匹配记录
	public static ObservableList<Book> queryByAtt(String att,String keyWord) {
		String sql="select barcode,name,author,press,address,"
				+ "price,catego from libadm.barcode natural join libadm.address "
				+ "where "+att+" like "+"'%"+keyWord+"%'";
		ObservableList books=FXCollections.observableArrayList();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=getBorConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Book book=new Book();
				book.setBarcode(rs.getString(1));
				book.setName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPress(rs.getString(4));
				book.setAddress(rs.getString(5));
				book.setPrice(rs.getString(6));
				book.setCatego(rs.getString(7));
				books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return books;
	}
	//根据条形码返回未被借阅图书ID
	public static String getIDByBar(String barcode) {
		String sql="select ID from libadm.book where barcode=\'"+barcode+"\' "
				+ " and state=0";
		String ID=null;
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=getBorConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				ID=rs.getString(1);
				break;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ID;
	}
	//根据条形码查找匹配的书本，并返回所有匹配书本的信息
	/*public static List<String[]> queryByBar(String barcode){
		String sql="select * from libadm.book where barcode="+barcode;
		List books=new LinkedList<String[]>();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=getBorConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String [] book=new String[3];
				for(int i=0;i<3;i++) {
					book[i]=rs.getString(i+1);
				}
				books.add(book);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}*/
	//根据书本ID查找书本
	public static Book queryByID(String ID){
		String sql="select catego,barcode,id,state,name ,author,press,price,address from libadm.book"
				+ " natural join libadm.barcode natural join libadm.address where ID=\'"+ID+"\'";
		Book book=new Book();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			con=getBorConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				book.setCatego(rs.getString(1));
				book.setBarcode(rs.getString(2));
				book.setId(rs.getString(3));
				book.setState(rs.getString(4));
				book.setName(rs.getString(5));
				book.setAuthor(rs.getString(6));
				book.setPress(rs.getString(7));
				book.setPrice(rs.getString(8));
				book.setAddress(rs.getString(9));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return book;
	}
	//借书
	public static Boolean borrowBook(String bkid,String brid) {
		String sql1="select balance from LIBADM.BORROWER where id=\'"+brid+"\'";
		String sql="insert into LIBADM.BBOOK values(?,?,sysdate)";
		Connection con=null;
		PreparedStatement ptmt=null;
		Statement stmt=null;
		ResultSet rs=null;
		Boolean flag=false;
		try {
			con=getBorConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql1);
			int balance=0;
			while(rs.next()) {
				String s=rs.getString(1);
				balance=Integer.parseInt(s);
			}
			if(balance<=0) {
				rs.close();
				stmt.close();
				con.close();
				return false;
			}
			ptmt=con.prepareStatement(sql);
			ptmt.setString(1, bkid);
			ptmt.setString(2, brid);
			ptmt.execute();
			flag=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(ptmt!=null)
					ptmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	//还书
	public static Boolean returnBook(String bkid,String brid) {
		String sql="delete from libadm.bbook where bkid=? and brid=?";
		Connection con=null;
		PreparedStatement ptmt=null;
		Boolean flag=false;
		try {
			con=getBorConnection();
			ptmt=con.prepareStatement(sql);
			ptmt.setString(1, bkid);
			ptmt.setString(2, brid);
			int count=ptmt.executeUpdate();
			if(count==1)
				flag=true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {

				if(ptmt!=null)
					ptmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	//输入借阅者ID,返回正在借阅的图书ID，barcode,name,category,price,address,bdate，rdate若书本还未归还，则rdate为null;
	public static List<String[]> borrowRecord(String brid){
		String sql1="select bkid,barcode,name,catego,price,address,bdate,bdate+30 from libadm.bbook "
				+ " join libadm.book on(libadm.bbook.bkid=libadm.book.id) natural join"
				+ " libadm.barcode natural join libadm.address where brid=\'"+brid+"\'";
		String sql2="select bkid,barcode,name,catego,price,address,bdate ,rdate from libadm.rbook "
				+ "join libadm.book on(libadm.book.id=libadm.rbook.bkid) natural join"
				+ " libadm.barcode natural join libadm.address where brid=\'"+brid+"\'";
		List borrowing_books=new LinkedList<String[]>();
		Connection con=null;
		Statement stmt=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		try {
			con=getBorConnection();
			stmt=con.createStatement();
			rs1=stmt.executeQuery(sql1);
			while(rs1.next()) {
				String []borrowing_book=new String[8];
				for(int i=0;i<7;i++) {
					borrowing_book[i]=rs1.getString(i+1);
				}
				borrowing_book[7]=null;
				borrowing_books.add(borrowing_book);
			}
			rs2=stmt.executeQuery(sql2);
			while(rs2.next()) {
				String []borrowing_book=new String[8];
				for(int i=0;i<8;i++) {
					borrowing_book[i]=rs2.getString(i+1);
				}
				borrowing_books.add(borrowing_book);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs1!=null)
					rs1.close();
				if(rs2!=null)
					rs2.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return borrowing_books;
	}
	//Borrower 返回ID，姓名，余额，电话，逾期图书数量
	public static String[] getBorrowInfo(String ID) {
		String sql="select id,name,balance,tel from libadm.borrower where ID=\'"+ID+"\'";
		String sql2="select bkid from libadm.due where brid=\'"+ID+"\'";
		Connection con=null;
		Statement stmt=null;
		Statement stmt2=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		String[] info=new String[5];
		try {
			con=getBorConnection();
			stmt=con.prepareStatement(sql);
			stmt2=con.createStatement();
			rs=stmt.executeQuery(sql);
			rs2=stmt2.executeQuery(sql2);
			int count=0;
			while(rs2.next()) {
				count+=1;
			}
			info[4]=""+count;
			while(rs.next()) {
				for(int i=0;i<4;i++) {
					info[i]=rs.getString(i+1);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {

				if(rs!=null)
					rs.close();
				if(rs2!=null)
					rs2.close();
				if(stmt!=null)
					stmt.close();
				if(stmt2!=null)
					stmt2.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return info;
	}
	public static Boolean login(String ID,String PASSWD) {
		String sql="select * from libadm.borrower where ID=? and PASSWD=?";
		Connection con=null;
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		Boolean flag=false;
		try {
			con=getBorConnection();
			ptmt=con.prepareStatement(sql);
			String ciphertext=encrypt.getMD5String(PASSWD);
			ptmt.setString(1, ID);
			ptmt.setString(2, ciphertext);
			rs=ptmt.executeQuery();
			while(rs.next()) {
				flag=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {

				if(rs!=null)
					rs.close();
				if(ptmt!=null)
					ptmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	//取图书图片
	public static Image getImage(String barcode) {
		String sql = "select image from libadm.barcode where barcode=" + barcode;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Image image = null;
		try {
			con = getBorConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Blob blob = rs.getBlob(1);
				InputStream is = blob.getBinaryStream();
				image = SwingFXUtils.toFXImage(ImageIO.read(is), null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return image;
	}
	public static void main(String []args) throws SQLException {
		String[] s=getBorrowInfo("02");
		for(int i=0;i<5;i++)
			System.out.println(s[i]);

	}
}
