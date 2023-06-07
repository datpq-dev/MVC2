///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package datpq.util;
//
//import java.io.Serializable;
//import java.sql.Connection;
//import java.sql.SQLException;
//import javax.activation.DataSource;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//
///**
// *
// * @author ASUS
// */
//public class DBHelper implements Serializable {
//    public static Connection makeConnection() 
//        throws /*ClassNotFoundException,*/ SQLException, NamingException {
//        
//        //1.Find Current Context
//        Context context = new InitialContext();
//        //2. Find Tomcat context
//        Context tomcatContext = (Context)context.lookup("java:comp/env");
//        //3.Find data source
//        DataSource ds = (DataSource)tomcatContext.lookup("DaicaDatDS");
//        //4. Open Connection
////        Connection con = ds.getConnection();
//        
//        return null;
////        //1. Load Driver
////        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////        //2. Create Connection String
////        String url = "jdbc:sqlserver://localhost:1433;"
////                + "databaseName=datamanager";
////        //3. Open Connection
////        Connection con = DriverManager.getConnection(url, "sa", "1");
////        
////        return con;
//    }
//    }



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datpq.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBHelper implements Serializable {

    public static Connection makeConnection() throws NamingException, SQLException {

//        try {
//
//            //   1.load driver
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            // create Connection String
//            String url = "jdbc:sqlserver://localhost:1433;"
//                    + "databaseName=thangphq";
//            // 3.open connection
//            Connection con = DriverManager.getConnection(url, "sa", "1");
//            return con;
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//         return null;
       // 1. Find current context
        Context context = new InitialContext();
        //2. find Tomcat context
        Context tomcatContext = (Context) context.lookup("java:comp/env");
        // 3. tim Data Source 
        DataSource ds = (DataSource) tomcatContext.lookup("DaicaDatDS");
        // 4. Open connection
        Connection con = ds.getConnection();
        return con;
    }
}