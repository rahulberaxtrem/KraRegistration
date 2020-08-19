package KRA;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

/**
 *
 * @author Azim Charaniya
 * @version 1.0
 */
public class DBPool {

    //ADMIN
    public static final String FETCH_MENU_ITEMS = "{call proc_getMenuItems_admin(?) }";
    public static final String CHECK_KRA_STATUS = "{call proc_checkKRAStatus(?) }";
    public static String SP_PUSH_OCR_VALIDATION = "{call proc_validateBeforePushOCR_admin(?)}";
    
    public static String GET_EMAIL_SETTINGS = "{call proc_getmailSettings()}";

    //public static String DATABASE_IP = "172.168.10.88"; //LOCAL
    //public static String DATABASE_IP = "XPC-17\\SQLEXPRESS"; //LOCAL
    // public static String DATABASE_IP = "EKYC-TEST"; //LIVE
    //public static String DATABASE_IP = "43.242.213.114"; //LIVE
    // public static String DATABASE_IP = "172.168.10.12";//12
    // public static String DATABASE_PWD = "test";      // LOCAL
    // public static String DATABASE_PWD = "venxtrem";    
    /**
     * DATABASE CLASS NAME
     */
    public static final String DATABASE_CLASSNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    /**
     * DATABASE URL
     */
    //public static final String DATABASE_URL = "jdbc:sqlserver://" + DATABASE_IP + ";"  + "database=" + DATABASE_NAME;
    /**
     * Log
     */
    private static ArrayList<String> log = new ArrayList(1024);

//no of shared Connections
    static {
        try {
            Class.forName(DATABASE_CLASSNAME);
            log = new ArrayList(1024);

        } catch (Exception ex) {
            System.out.println(ex.toString());

        }
    }

    /**
     *
     * @return
     */
    public static Connection get() {
        try {
            
             DBPool dbPool = new DBPool();
            String dbIP = "NSL-LMS";//dbPool.getPropertyValues("DATABASE_IP");
            String dbName = "EkycWeb";//dbPool.getPropertyValues("DATABASE_NAME");
            String dbPort = "";//dbPool.getPropertyValues("DATABASE_PORT");
            String dbUserName = "xtremsoft";//dbPool.getPropertyValues("DATABASE_USERNAME");
            String dbPwd = "narxtrem";//dbPool.getPropertyValues("DATABASE_PWD");
            String DATABASE_URL = "jdbc:sqlserver://" + dbIP + ";" + "database=" + dbName;
            return DriverManager.getConnection(DATABASE_URL, dbUserName, dbPwd);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
            return null;
        }
    }

    public String getPropertyValues(String propName) throws IOException {
        Properties prop = new Properties();
        InputStream inputStream = null;

        inputStream = getClass().getClassLoader().getResourceAsStream("database.properties");
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file not found in the classpath");
        }

        return prop.getProperty(propName);
    }

    /**
     *
     * @param s
     */
    public static void log(String s) {
        log.add(s);
    }

    /**
     *
     * @param s
     */
    /*  public static void log(Exception s){
     try{
     Connection conn = get();
     CallableStatement cs = conn.prepareCall("{call proc_errorLog(?,?,?)}");
     cs.setString(1, s+"");
     cs.setString(2, pan);  
     cs.setString(3, occuredIn);  
     cs.execute();
     s.printStackTrace();
     }catch(Exception e){    
     e.printStackTrace();
     }
     }*/
    public static void log(Exception s, String pan, String occuredIn) {
        try {
            StringWriter errors = new StringWriter();
            s.printStackTrace(new PrintWriter(errors));

            Connection conn = get();
            CallableStatement cs = conn.prepareCall("{call proc_errorLog(?,?,?)}");
            cs.setString(1, errors.toString());
            cs.setString(2, pan);
            cs.setString(3, occuredIn);
            cs.execute();
            s.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void activitylog(String UserCode, String UserType, String Activity, String IpAddress, String pan, String ActivityOn, String imei) {
        Connection conn = null;
        try {
            conn = get();
            CallableStatement cs = conn.prepareCall("{call proc_ActivityLog(?,?,?,?,?,?,?)}");
            cs.setString(1, UserCode);      //RO ID
            cs.setString(2, UserType);      // LEAD Number
            cs.setString(3, Activity);
            cs.setString(4, IpAddress);     //IMEI
            cs.setString(5, pan);
            cs.setString(6, ActivityOn);    //DATETIME
            cs.setString(7, imei);
            cs.execute();

        } catch (Exception e) {
            DBPool.log(e, pan, Activity);
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }
    
    public static void close(Connection con, CallableStatement st) {
        try {

            if (st != null) {
                st.close();
            }
            close(con);
        } catch (SQLException e) {
            //GlobalClass.onError("Error in close method:" + className, e);
        }
    }
    
    public static void close(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            //GlobalClass.onError("Error in close method:" + className, e);
        }
    }

    /**
     *
     * @param out
     * @throws IOException
     */
    public static void printLog(Writer out) throws IOException {
        for (String s : log) {
            out.write(s + "<br />");
        }
        log.clear();
    }

}
