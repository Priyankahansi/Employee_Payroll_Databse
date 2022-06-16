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
            statement.execute("create table employee(id int auto_increment,name varchar(30),\n" +
                    "salary double,department varchar(30),Joining_Date date,\n" +
                    "primary key(id))");
            ResultSet resultSet =statement.executeQuery("desc employee");
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













