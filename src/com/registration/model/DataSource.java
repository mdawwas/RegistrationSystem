package com.registration.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mdawwas on 5/28/17.
 */
public class DataSource {
    private static DataSource instance;
    private static Object mutex = new Object();
    private static ArrayList<Connection> connections;
    private DataSource() {
        connections = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for(int  i = 0; i < 10 ; ++ i){
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chating","root","");
                connections.add(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static DataSource getInstance(){
        if(instance == null){
            synchronized (mutex){
                if(instance == null) instance= new DataSource();
            }
        }
        return instance;
    }

}
