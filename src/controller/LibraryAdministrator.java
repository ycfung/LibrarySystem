package controller;

import java.sql.*;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Book;
import model.Borrower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LibraryAdministrator {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //����Ա����
    public static Connection getAdmConnection() {
        try {
            return (Connection) DriverManager.getConnection("jdbc:oracle:thin:@3.80.200.209:1521:library", "libadm", "123456");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    //�����ض����Դ����������ģ������ƥ���¼
    public static ObservableList<Book> queryByAtt(String att, String keyWord) {
        String sql = "select id,barcode,name,catego,author,press,address,state,price from barcode "
                + "natural join book natural join address where " + att + " like " + "'%" + keyWord + "%'";
        ObservableList books = FXCollections.observableArrayList();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = getAdmConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getString(1));
                book.setBarcode(rs.getString(2));
                book.setState(rs.getString(8));
                book.setName(rs.getString(3));
                book.setAuthor(rs.getString(5));
                book.setPress(rs.getString(6));
                book.setAddress(rs.getString(7));
                book.setCatego(rs.getString(4));
                book.setPrice(rs.getString(9));
                books.add(book);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
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
        return books;
    }

    //�������������ƥ����鱾������������ƥ���鱾����Ϣ
    public static String[] getBookInfoByBar(String barcode) {
        String sql = "select name,author,press,catego,address,price from"
                + " libadm.barcode natural join libadm.address where barcode=\'" + barcode + "\'";
        String Info[] = new String[6];
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = getAdmConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    Info[i] = rs.getString(i + 1);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
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
        return Info;
    }

    ;

    //������ => ��һ����Ľ��ļ�¼��ȡ��
    //1=>ʶ���룬2=>������3=>�������ڣ�4=>�������ڣ�5=>������id��6=>�û���
    public static LinkedList<String[]> getRecordByBarcode(String barcode) {
        String sql1 = "select bkid,barcode.name,bdate,brid,borrower.name from bbook "
                + "join book on(bbook.bkid=book.id) natural join barcode join"
                + " borrower on(bbook.brid=borrower.id) where barcode=\'" + barcode + "\'";
        String sql2 = "select bkid,barcode.name,bdate,rdate,brid,borrower.name from rbook "
                + "join book on(rbook.bkid=book.id) natural join barcode join"
                + " borrower on(rbook.brid=borrower.id) where barcode=\'" + barcode + "\'";
        LinkedList records = new LinkedList<String[]>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        try {
            con = getAdmConnection();
            stmt = con.createStatement();
            rs1 = stmt.executeQuery(sql1);
            while (rs1.next()) {
                String[] record = new String[6];
                record[0] = rs1.getString(1);
                record[1] = rs1.getString(2);
                record[2] = rs1.getString(3);
                record[4] = rs1.getString(4);
                record[5] = rs1.getString(5);
                records.add(record);
            }
            rs2 = stmt.executeQuery(sql2);
            while (rs2.next()) {
                String[] record = new String[6];
                for (int i = 0; i < 6; i++) {
                    record[i] = rs2.getString(i + 1);
                }
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs1 != null)
                    rs1.close();
                if (rs2 != null)
                    rs2.close();
                if (stmt != null)
                    stmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return records;
    }

    //ʶ���� => ��һ����Ľ��ļ�¼��ȡ��(1=>������2=>�������ڣ�3=>�������ڣ�4=>������id��5=>�û���)
    public static LinkedList<String[]> getRecordByID(String id) {
        String sql1 = "select barcode.name,bbook.bdate,borrower.id,borrower.name from bbook join"
                + " book on(bbook.bkid=book.id) join borrower on(bbook.brid=borrower.id) join"
                + " barcode on (book.barcode=barcode.barcode) where book.id=\'" + id + "\'";
        String sql2 = "select barcode.name,rbook.bdate,rbook.rdate,borrower.id,borrower.name from rbook join"
                + " book on(rbook.bkid=book.id) join borrower on(rbook.brid=borrower.id) join"
                + " barcode on (book.barcode=barcode.barcode) where book.id=\'" + id + "\'";
        LinkedList records = new LinkedList<String[]>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        try {
            con = getAdmConnection();
            stmt = con.createStatement();
            rs1 = stmt.executeQuery(sql1);
            while (rs1.next()) {
                String[] record = new String[5];
                record[0] = rs1.getString(1);
                record[1] = rs1.getString(2);
                record[3] = rs1.getString(3);
                record[4] = rs1.getString(4);
                records.add(record);
            }
            rs2 = stmt.executeQuery(sql2);
            while (rs2.next()) {
                String[] record = new String[5];
                for (int i = 0; i < 5; i++) {
                    record[i] = rs2.getString(i + 1);
                }
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs1 != null)
                    rs1.close();
                if (rs2 != null)
                    rs2.close();
                if (stmt != null)
                    stmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return records;

    }

    public static Borrower getUserInfo(String ID) {
        String sql = "select id,name,tel,balance from libadm.borrower where ID=\'" + ID + "\'";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Borrower borrower = null;
        try {
            con = getAdmConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                borrower = new Borrower(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        } catch (SQLException e) {
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
        return borrower;
    }

    //�û�id=>���û����ļ�¼
    //String(1=>������2=>�������ڣ�3=>��������)
    public static LinkedList<String[]> getRecordByUserID(String id) {
        String sql1 = "select barcode.name,bbook.bdate from bbook join book on(bbook.bkid=book.ID)"
                + " natural join barcode where bbook.brid=\'" + id + "\'";
        String sql2 = "select barcode.name,rbook.bdate ,rbook.rdate from rbook join book on(rbook.bkid=book.ID)"
                + " natural join barcode where rbook.brid=\'" + id + "\'";
        LinkedList records = new LinkedList<String[]>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        try {
            con = getAdmConnection();
            stmt = con.createStatement();
            rs1 = stmt.executeQuery(sql1);
            while (rs1.next()) {
                String[] record = new String[3];
                record[0] = rs1.getString(1);
                record[1] = rs1.getString(2);
                records.add(record);
            }
            rs2 = stmt.executeQuery(sql2);
            while (rs2.next()) {
                String[] record = new String[3];
                for (int i = 0; i < 3; i++) {
                    record[i] = rs2.getString(i + 1);
                }
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs1 != null)
                    rs1.close();
                if (rs2 != null)
                    rs2.close();
                if (stmt != null)
                    stmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return records;
    }

    //�����û����û�id���û��������롢�û��� => boolean���������ݿ⣩
    public static Boolean addUser(String id, String password, String name, String tel, String balance) {
        String sql = "insert into borrower(id,passwd,name,tel,balance) values(?,?,?,?,?)";
        Connection con = null;
        Boolean flag = false;
        PreparedStatement ptmt = null;
        try {
            con = getAdmConnection();
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, id);
            String passwd = encrypt.getMD5String(password);
            ptmt.setString(2, passwd);
            ptmt.setString(3, name);
            ptmt.setString(4, tel);
            ptmt.setString(5, balance);
            ptmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flag;
    }

    //ɾ���û����û�id =>boolean ��ɾ���û���Ϣ��
    public static Boolean delUser(String ID) {
        String sql = "delete from borrower where id=" + ID;
        Connection con = null;
        Boolean flag = false;
        Statement stmt = null;
        try {
            con = getAdmConnection();
            stmt = con.createStatement();
            int count = stmt.executeUpdate(sql);
            if (count == 1)
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static Boolean update(String id, String passwd, String name, String tel, String balance) {
        String sql = "update borrower set passwd=?,name=?,tel=?,balance=? where id=" + id;
        Connection con = null;
        PreparedStatement ptmt = null;
        Boolean flag = false;
        try {
            con = getAdmConnection();
            ptmt = con.prepareStatement(sql);
            String PASSWD = encrypt.getMD5String(passwd);
            ptmt.setString(1, PASSWD);
            ptmt.setString(2, name);
            ptmt.setString(3, tel);
            ptmt.setString(4, balance);
            int count = ptmt.executeUpdate();
            if (count == 1)
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flag;
    }

    //���ڵ��飺ʶ���롢������ =>bool���������ݿ⣩
    public static Boolean addExistBook(String id, String barcode, String state) throws SQLException{
        String sql = "insert into book(id,barcode,state) values(?,?,?)";
        Connection con = null;
        PreparedStatement ptmt = null;
        Boolean flag = false;
        try {
            con = getAdmConnection();
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, id);
            ptmt.setString(2, barcode);
            ptmt.setString(3, state);
            int count = ptmt.executeUpdate();
            if (count == 1)
                flag = true;
        } catch (SQLException e) {
            throw e;
        } finally {
            try {

                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flag;
    }

    //�����ڵ��飺�����롢״̬�����ߡ����⡢���ࡢ�����硢�۸�0�ɽ裬1�ѽ裬2��أ� =>bool���������ݿ⣩
    public static Boolean addBook(String barcode, String author, String name,
                                  String categories, String press, String price) {
        String sql = "insert into barcode(barcode,author,name,catego,press,price)"
                + " values(?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement ptmt = null;
        Boolean flag = false;
        try {
            con = getAdmConnection();
            ptmt = con.prepareStatement(sql);
            ptmt.setString(1, barcode);
            ptmt.setString(2, author);
            ptmt.setString(3, name);
            ptmt.setString(4, categories);
            ptmt.setString(5, press);
            ptmt.setString(6, price);
            int count = ptmt.executeUpdate();
            if (count == 1)
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flag;
    }

    //���ڵ��飺ʶ���� => bool��ɾ��һ��������ݣ�
    public static Boolean delBook(String id) {
        String sql = "delete from book where id=\'" + id + "\'";
        Connection con = null;
        Statement ptmt = null;
        Boolean flag = false;
        try {
            con = getAdmConnection();
            ptmt = con.createStatement();
            int count = ptmt.executeUpdate(sql);
            if (count == 1)
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static String[] getNewRecordByID(String id) {
        String sql = "select barcode,barcode.name,author,press,catego,"
                + "price,state,address,bdate,bdate+30,borrower.id,"
                + "borrower.name from  book natural join barcode"
                + " natural join address  join bbook on(book.id=bbook.bkid)"
                + "  join borrower on(borrower.id=bbook.brid) where book.id=\'" + id + "\'";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String[] record = new String[12];
        try {
            con = getAdmConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 12; i++) {
                    record[i] = rs.getString(i + 1);
                }
            }
        } catch (SQLException e) {
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
        return record;
    }

    public static String[][] getBookInfoByBarcode(String barcode) {
        String sql1 = "select name,author, press, catego, address,price"
                + " from barcode natural join address where barcode=\'" + barcode + "\'";
        String sql2 = "select state,id from book where barcode=\'" + barcode + "\'";
        String sql3 = "select count(*) from book where barcode=\'" + barcode + "\'";
        String[][] info = new String[8][];
        Connection con = null;
        Statement stmt = null;
        Statement stmt2 = null;
        Statement stmt3 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        try {
            con = getAdmConnection();
            stmt = con.createStatement();
            stmt2 = con.createStatement();
            stmt3 = con.createStatement();
            rs1 = stmt.executeQuery(sql1);
            rs2 = stmt2.executeQuery(sql2);
            rs3 = stmt3.executeQuery(sql3);
            int count = 0;
            while (rs3.next()) {
                count = rs3.getInt(1);
            }
            String[] state = null;
            String[] id = null;
            if (count != 0) {
                state = new String[count];
                id = new String[count];
            }
            info[6] = state;
            info[7] = id;
            while (rs1.next()) {
                for (int i = 0; i < 6; i++) {
                    String[] s = new String[1];
                    s[0] = rs1.getString(i + 1);
                    info[i] = s;
                }
            }
            int i = 0;
            while (rs2.next()) {
                state[i] = rs2.getString(1);
                id[i] = rs2.getString(2);
                i += 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (rs1 != null)
                    rs1.close();
                if (rs2 != null)
                    rs2.close();
                if (rs3 != null)
                    rs3.close();
                if (stmt != null)
                    stmt.close();
                if (stmt2 != null)
                    stmt.close();
                if (stmt3 != null)
                    stmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return info;
    }

    public static Boolean login(String ID, String PASSWD) {
        String sql = "select * from administrator where ID=? and PASSWD=?";
        Connection con = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        Boolean flag = false;
        try {
            con = getAdmConnection();
            ptmt = con.prepareStatement(sql);
            String ciphertext = encrypt.getMD5String(PASSWD);
            ptmt.setString(1, ID);
            ptmt.setString(2, ciphertext);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (rs != null)
                    rs.close();
                if (ptmt != null)
                    ptmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static void main(String[] args) throws SQLException {
			/*Connection con=getAdmConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select barcode,address from barcode natural join"
					+ " address where barcode="+"01");
			while(rs.next()) {
				System.out.println("address: "+rs.getString(2));
			}*/

        String sss[][] = getBookInfoByBarcode("05");
        System.out.println(sss[0][0]);
    }
}
