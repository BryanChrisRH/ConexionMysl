package ConsultaSingle.bd;

import java.sql.SQLException;

public class TestBDSingleton {
    public static void main(String[] args) throws SQLException {
        SingletonBDConn conn=new SingletonBDConn();

        if(conn!=null){
            System.out.println("Conexión Establecida");
        }
        conn.Consulta();

    }
}