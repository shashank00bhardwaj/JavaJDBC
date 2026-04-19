import java.sql.*;
import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        String url = "jdbc:mysql://localhost:3306/students";
        String user_name = "root";
        String password = "Shas@8165";
        try {
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //make connection
            Connection con = DriverManager.getConnection(url,user_name,password);
            //make statement
            Statement stmt = con.createStatement();

            //Section -- Inserting New Records
//            String query1 = "Insert into students values (5,'Deepak')";
            // rewriting query with input from user
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter student Id");
//            int id = Integer.parseInt(scanner.nextLine());
//            System.out.println("Enter student Name");
//            String name = scanner.nextLine();
//            scanner.close();
//            String query1 = "Insert into students values("+id+", '"+name+"')";
//            stmt.executeUpdate(query1);

            //Using prepared statements
            PreparedStatement ptmt = con.prepareStatement("insert into students values(?,?)");
            ptmt.setInt(1,7);
            ptmt.setString(2,"Krishna Soni");
//            ptmt.executeUpdate();


            //Section -- Updating existing records
            String query2 = "Update students set name = 'Deepak Rawat' where id = 5";
//            stmt.executeUpdate(query2);

            // Section -- Deleting a record from table
            String query3 = "Delete from students where id = 4";
//            stmt.executeUpdate(query3);


//            Section -- Fetching and Printing Records
            String query4 = "Select * from students";
            ResultSet rs = stmt.executeQuery(query4);
            while(rs.next()){
                int sid = rs.getInt(1);
                String sName = rs.getString(2);
                System.out.println("Student id : "+ sid + " --- Student Name : " + sName);
            }
            // relieving resources
//            rs.close();
//            stmt.close();
//            con.close();
        }catch(Exception e){
            System.out.println("An issues has occured while connecting to DB");
        }
    }
}