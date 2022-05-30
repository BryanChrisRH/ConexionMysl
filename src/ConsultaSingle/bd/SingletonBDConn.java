package ConsultaSingle.bd;

import java.sql.*;
import java.util.ResourceBundle;

public class SingletonBDConn {

    private  static Connection instanceConn=null;

    SingletonBDConn(){}

    public static Connection getInstanceConn() throws SQLException {
        if(instanceConn==null){
            ResourceBundle bundle=ResourceBundle.getBundle("JDBC");
            String user=bundle.getString("usr");
            String psw=bundle.getString("psw");
            String driver=bundle.getString("driver");
            String url= bundle.getString("url");
            String bd=bundle.getString("bd");
            instanceConn= DriverManager.getConnection(url+bd,user,psw);
        }
        return instanceConn;
    }
    public void Consulta() throws SQLException {
        Connection con=SingletonBDConn.getInstanceConn();
        try {
            String SQL = "SELECT * FROM dep";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(
                        rs.getString("depno")+", "+
                                rs.getString("dname") + ", " +
                                rs.getString("loc"));
            }

            rs.close();
            stmt.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}