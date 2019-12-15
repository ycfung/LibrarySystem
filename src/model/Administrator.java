package model;

import java.awt.SystemTray;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class Administrator {
    private String id = null;
    private String name = null;

    public Administrator(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Administrator() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static void main(String []args) throws ClassNotFoundException, SQLException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@3.80.200.209:1521:library","libadm","123456");
    	Statement stmt=connection.createStatement();
    	ResultSet rs=stmt.executeQuery("select id from borrower");
    	while(rs.next()) {
    		System.out.println(rs.getString(1));
    	}
    }

}
