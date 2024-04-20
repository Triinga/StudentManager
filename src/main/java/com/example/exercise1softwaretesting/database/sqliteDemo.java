package com.example.exercise1softwaretesting.database;

import com.example.exercise1softwaretesting.gui.studentController;

import java.sql.*;

public class sqliteDemo {
    public static void main(String[] args) {
        createTable();
    }
    static void createTable(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./demo1.db");
            Statement statement = connection.createStatement();
            String createTableStatement = "Create Table if not exists Student" +
                    "(Id Integer, " +
                    "Name Text, " +
                    "LastName Text, " +
                    "Address Text, " +
                    "Major Text, " +
                    "Primary Key(Id));";
            statement.execute(createTableStatement);
            statement.close();
            connection.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void insertData(int id, String name, String lastname, String address, String major) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./demo1.db");
            Statement statement = connection.createStatement();

            String insertDataStatement = "INSERT INTO Student VALUES (" +
                    id + ", '" + name + "', '" + lastname + "', '" + address + "', '" + major + "')";
            statement.execute(insertDataStatement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static public void selectAll(studentController controller){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./demo1.db");
            Statement statement = connection.createStatement();
            String selectStatement = "Select * from Student";
            ResultSet resultSet = statement.executeQuery(selectStatement);
            String students = new String();
            while (resultSet.next()) {
                students += "Id: " + resultSet.getString("Id") + "\n";
                students += "Name:" + resultSet.getString("Name") + "\n";
                students += "Lastname: " + resultSet.getString("LastName") + "\n";
                students += "Address: " + resultSet.getString("Address") + "\n";
                students += "Major:" + resultSet.getString("Major") + "\n";
                students += "\n";
            }
            resultSet.close();
            statement.close();
            connection.close();

            controller.setOutputAreaText(students.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static public void updateData(int id, String name, String lastname, String address, String major){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./demo1.db");
            Statement statement = connection.createStatement();

            String updateStatement = "UPDATE Student SET Name = '" + name + "', LastName = '" + lastname + "', Address = '" + address + "', Major = '" + major + "' WHERE Id = " + id;
            statement.executeUpdate(updateStatement);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static public void deleteData(int id){
        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./demo1.db");
            Statement statement = connection.createStatement();
            String deleteStatement = "DELETE FROM Student WHERE id = " + id;
            statement.executeUpdate(deleteStatement);

            statement.close();
            connection.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
