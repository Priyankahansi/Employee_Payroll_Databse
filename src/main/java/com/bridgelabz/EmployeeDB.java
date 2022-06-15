package com.bridgelabz;

import java.sql.*;

public class EmployeeDB {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/payroll?useSSL=false";
        String username = "root";
        String password = "123456789";
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("cannot find the driver in the classpath!", e);
        }
        try {
            System.out.println("connecting to database:" + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("connection done successful!!" + con);

            Statement statement=con.createStatement();
            statement.execute("update employee set Gender='male' where id  between 1 and 3");
            ResultSet resultSet =statement.executeQuery("select * from employee");

//            Statement statement=con.createStatement();
//            statement.execute("alter table employee add column Gender varchar(7)");
//            ResultSet resultSet =statement.executeQuery("select * from employee");
//            while(resultSet.next()){
//                System.out.println("id:"+resultSet.getInt("id"));
//                System.out.println("name:"+resultSet.getString("name"));
//                System.out.println("salary:"+resultSet.getDouble("salary"));
//                System.out.println("department:"+resultSet.getString("department"));
//                System.out.println("Joining_Date:"+resultSet.getDate("Joining_Date"));
//            }
            PreparedStatement preparedStatement=con.prepareStatement("alter table employee add column " +
                    "Gender varchar(7)");
            ResultSet resultSet=preparedStatement.executeQuery("select * from employee");

            Statement statement=con.createStatement();
//            statement.execute("select name,salary from employee where name='Praju' ");
            ResultSet resultSet =statement.executeQuery("select * from employee where \n" +
                    "joining_date between '2017-11-08' and '2018-12-09'");
            while(resultSet.next()){
                System.out.println("id:"+resultSet.getInt("id"));
                System.out.println("name:"+resultSet.getString("name"));
                System.out.println("salary:"+resultSet.getDouble("salary"));
                System.out.println("department:"+resultSet.getString("department"));
                System.out.println("Joining_Date:"+resultSet.getDate("Joining_Date"));
                System.out.println("Gender:"+resultSet.getString("Gender"));
            }
        } catch (Exception e) {
            //  e.printStackTrace();
        }
    }

}













