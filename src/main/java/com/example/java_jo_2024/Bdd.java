package com.example.java_jo_2024;

import com.mysql.cj.xdevapi.Client;
import com.mysql.cj.xdevapi.Result;
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
            String mdp = resultSet.getString("MDPCLIENT");
            Integer id = resultSet.getInt("IDCLIENT");
            User user = new User(nom, email, mdp, id);
            ListUser.add(user);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return ListUser;
    }

    public User createUser(String nom, String email, String mdp) throws SQLException {
        connect();
        Statement statement = jdbcConnexion.createStatement();
        statement.executeUpdate("INSERT INTO clients (NOMCLIENT,MAILCLIENT,MDPCLIENT) VALUES ('"+nom+"','"+email+"','"+mdp+"')");
        statement.close();
        disconnect();
        return new User(nom,email,mdp,null);
    }

    public User connexionUser(String email, String mdp) throws SQLException {
        connect();
        Statement statement = jdbcConnexion.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM clients WHERE MAILCLIENT = '"+email+"'AND MDPCLIENT = '"+mdp+"'");
        if (!resultSet.next()) {
            resultSet.close();
            statement.close();
            disconnect();
            return null;
        } else {
            String nom = resultSet.getString("NOMCLIENT");
            email = resultSet.getString("MAILCLIENT");
            mdp = resultSet.getString("MDPCLIENT");
            Integer id = resultSet.getInt("IDCLIENT");
            resultSet.close();
            statement.close();
            disconnect();
            return new User(nom, email, mdp, id);
        }
    }

    public boolean updateConcours(String userID, String win) throws SQLException {
        connect();
        Statement statement = jdbcConnexion.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT PARTICIP FROM CONCOURS WHERE IDCLIENT = '"+userID+"'");
        if (!resultSet.next()) {
            resultSet.close();
            statement.close();
            disconnect();
            return false;
        } else {
            String particip = resultSet.getString("PARTICIP");
            resultSet.close();
            if(particip == "1"){
                statement.close();
                disconnect();
                return false;
            }
        }
        resultSet = statement.executeQuery("UPDATE CONCOURS SET PARTICIP = true, GAGNANT = '"+win+"' WHERE IDCLIENT = '"+userID+"'");
        statement.close();
        disconnect();
        if(win == "True"){
            return true;
        }
        else return false;
    }

    }
