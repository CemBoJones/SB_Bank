/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank.controller.dbaccess;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sse.sbbank.model.User;

/**
 *
 * @author Marco
 */
public class DBAccess implements Serializable {

    boolean DEBUG = false;
    private List<User> userListTemp = new LinkedList<User>();
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private final String db_host = "localhost";
    private final String db_port = "3306";
    private final String db_user = "root";
    private final String db_password = "";

    /**
     * Connects to the User DB and creates User Objects in a list from the
     * date records.
     *
     * @return PersonenList
     */
    public List<User> getUserListFromDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC Schnittstellen laden.

            // Verbindung zur JDBC-Datenbank herstellen.
            connect = DriverManager.getConnection("jdbc:mysql://" + db_host + ":" + db_port + "/mysql?" + "user=" + db_user + "&password=" + db_password);
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (connect != null) {
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = connect.createStatement();

                // Tabelle anzeigen
                String sql = "SELECT * FROM mydb.USER";
                ResultSet result = query.executeQuery(sql);

                // Ergebnisstabelle durchforsten    
                while (result.next()) {
                    User temp = new User(
                            result.getInt("idUSER"),
                            result.getString("vorname"),
                            result.getString("nachname"),
                            result.getString("username"),
                            result.getString("passwort"),
                            result.getDouble("kontostand"),
                            result.getBoolean("isAdmin")
                    );
                    if (DEBUG) {
                    }
                    userListTemp.add(temp);
                }
            } catch (SQLException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return userListTemp;
    }

    public void deletePersonFromDB(int idUser) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC Schnittstellen laden.

            // Verbindung zur JDBC-Datenbank herstellen.
            connect = DriverManager.getConnection("jdbc:mysql://" + db_host + ":" + db_port + "/mysql?" + "user=" + db_user + "&password=" + db_password);
        } catch (ClassNotFoundException e) {
            
        } catch (SQLException e) {
            
        }

        if (connect != null) {
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = connect.createStatement();

                String sql = "Delete From mydb.USER where idUser = \"" + idUser + "\";";
                int result = query.executeUpdate(sql);

            } catch (SQLException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void transfer(int sender, int destiny, double amount){
         try {
            Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC Schnittstellen laden.
            // Verbindung zur JDBC-Datenbank herstellen.
            connect = DriverManager.getConnection("jdbc:mysql://" + db_host + ":" + db_port + "/mysql?" + "user=" + db_user + "&password=" + db_password);
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        }
        if (connect != null) {
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = connect.createStatement();
                String sql = "call mydb.transfer ( "
                        + sender + ","
                        + destiny + ","
                        + amount + ");";
                query.executeUpdate(sql);
            } catch (SQLException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void insertPersonenToDB(User toAdd) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Datenbanktreiber für JDBC Schnittstellen laden.

            // Verbindung zur JDBC-Datenbank herstellen.
            connect = DriverManager.getConnection("jdbc:mysql://" + db_host + ":" + db_port + "/mysql?" + "user=" + db_user + "&password=" + db_password);
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }

        if (connect != null) {
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = connect.createStatement();

                String sql = "Insert Into mydb.USER(idUSER, vorname, nachname, username, passwort, kontostand, isAdmin) VALUES ( \""
                        + toAdd.getKontonummer() + "\", \""
                        + toAdd.getVorname() + "\", \""
                        + toAdd.getNachname() + "\", \""
                        + toAdd.getUsername() + "\", \""
                        + toAdd.getPasswort() + "\", \""
                        + toAdd.getKontostand() + "\", \""
                        + (toAdd.isIsAdmin()?1:0) + "\""
                        + ");";
                int result = query.executeUpdate(sql);
            } catch (SQLException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }
}
