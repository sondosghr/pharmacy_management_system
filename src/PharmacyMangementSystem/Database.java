/*package PharmacyMangementSystem;

import java.sql.*;

public class Database {
    //في بارت2    7:13 تم صناعة اتصال

    private String user = "user";
    private String pass = "#1#2#3#4#5";
    private String url = "jdbc:mysql://localhost/pharmacy";
    private Statement statement ;

    public Database(){
        try{
            Connection connection = DriverManager.getConnection(url,user,pass);
            statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Statement getStatement(){
        return statement ;
    }
}
*/




/*

package PharmacyMangementSystem;

import java.sql.*;

public class Database {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/pharmacy";
        String user = "user";
        String pass = "#1#2#3#4#5";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // الاتصال بقاعدة البيانات
            connection = DriverManager.getConnection(url, user, pass);

            // إنشاء كائن Statement
            statement = connection.createStatement();

           // statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            //هادي نستخدمها احسن لو نبي نتحرك بحرية اكثر

            /*- ResultSet.TYPE_FORWARD_ONLY: لا يمكنك الرجوع للخلف أو التنقل بحرية في النتائج. فقط resultSet.next() متاح.
- ResultSet.CONCUR_READ_ONLY: نفس القيمة اللي استخدمتها أنت، يعني لا يمكن تعديل النتائج.
             */



            // تنفيذ استعلام SQL
          /*  String query = "SELECT * FROM medicines"; // غيّر اسم الجدول حسب الموجود عندك
            resultSet = statement.executeQuery(query);

            // عرض النتائج
            while (resultSet.next()) {
                int id = resultSet.getInt("id"); // غيّر الأعمدة حسب الجدول
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
            }

        } catch (SQLException e) {
            System.out.println("خطأ في الاتصال أو الاستعلام:");
            e.printStackTrace();
        } finally {
            // إغلاق الموارد
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

*/


package PharmacyMangementSystem;

import java.sql.*;

public class Database {
    private String user = "root";
    private String pass = "" ;
    private String url = "jdbc:mysql://localhost/pharmacy";
    private Statement statement;

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            System.out.println("تم انشاء الاتصال ");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("خطأ أثناء إنشاء الاتصال ");
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }
}