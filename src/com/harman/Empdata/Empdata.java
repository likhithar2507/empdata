package com.harman.Empdata;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Empdata {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("Select an option :");
            System.out.println("1 . Add an employee ");
            System.out.println("2 . view all employee ");
            System.out.println("3 . delete the employee ");
            System.out.println("4 . Exit");
            option = in.nextInt();
            switch (option){
                case 1 :
                    try {

                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
                        String empcode, empname, designation, salary, mobnum;
                        System.out.println("Enter the code :");
                        empcode = in.next();
                        System.out.println("Enter the name :");
                        empname = in.next();
                        System.out.println("Enter the designation :");
                        designation = in.next();
                        System.out.println("Enter the salary :");
                        salary = in.next();
                        System.out.println("Enter the phone :");
                        mobnum = in.next();
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `employee`( `empcode`, `empname`, `designation`, `salary`, `mobnum`)" +
                                " VALUES('" + empcode + "','" + empname + "','" + designation + "'," + salary + "," + mobnum + ")");
                        System.out.println("Inserted sucessfully");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2 :
                    System.out.println("View all employees selected");
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `id`, `empcode`, `empname`, `designation`, `salary`, `mobnum` FROM `employee` WHERE 1");
                        while (rs.next()){
                            System.out.println("name = " + rs.getString("empname"));
                            System.out.println("empcode = "+ rs.getInt("empcode"));
                            System.out.println("designation = "+ rs.getString("designation"));
                            System.out.println("salary = " + rs.getInt("salary"));
                            System.out.println("phone = "+ rs.getBigDecimal("mobnum"));
                        }
                    }

                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3 :try {
                    int empcode;
                    System.out.println("Enter the code to be deleted");
                    empcode = in.nextInt();
                    Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/company?autoReconnect=true&useSSL=false", "root", "");
                    Statement stmt = c.createStatement();
                    stmt.executeUpdate("DELETE FROM `employee` WHERE `empcode`=" +empcode);
                    System.out.println("Deleted sucessfully");


                }
                catch (Exception e){
                    System.out.println(e);
                }
                    break;
                case 4 :
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }



    }}

