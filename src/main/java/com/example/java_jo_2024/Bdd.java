package com.example.java_jo_2024;

import com.mysql.cj.xdevapi.Client;
import com.mysql.cj.xdevapi.Session;

import java.sql.*;
import java.util.ArrayList;

public class Bdd {
    private String jdbcURL = "jdbc:mysql://root:tribadri23@localhost:3306/jo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "tribadri23";
    private Connection jdbcConnexion;

    public void connect(){
        try{
            if(jdbcConnexion == null || jdbcConnexion.isClosed()){
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                jdbcConnexion = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
                System.out.println("MYSQL Connection Etablished");
            }
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect(){
        try{
            if(jdbcConnexion != null && !jdbcConnexion.isClosed()){
                jdbcConnexion.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<User> listAllUser() throws SQLException {
        connect();
        ArrayList<User> ListUser = new ArrayList<>();
        Statement statement = jdbcConnexion.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");
        while (resultSet.next()) {
            String nom = resultSet.getString("NOMCLIENT");
            String email = resultSet.getString("MAILCLIENT");
            User user = new User(nom, email);
            ListUser.add(user);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return ListUser;
    }
}
