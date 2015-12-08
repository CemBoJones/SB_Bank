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
public class UserDBAccess implements Serializable {

    boolean DEBUG = true;
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
     * Connects to the Personen DB and creates Person Objects in a list from the
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
            Logger.getLogger(UserDBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (connect != null) {
            // Abfrage-Statement erzeugen.
            Statement query;
            try {
                query = connect.createStatement();

                // Tabelle anzeigen
                String sql = "SELECT * FROM citycampus.personen";
                ResultSet result = query.executeQuery(sql);

                // Ergebnisstabelle durchforsten    
                while (result.next()) {
                    Person temp = new Person(
                            result.getInt("idPersonen"),
                            result.getString("geschlecht"),
                            result.getString("vorname"),
                            result.getString("nachname"),
                            result.getDate("geburtstag"),
                            result.getString("trainings_schwerpunkte"),
                            result.getString("geburtsland"),
                            result.getString("bemerkung"),
                            result.getBoolean("hat_lrs"),
                            result.getBoolean("hat_dys"),
                            result.getString("einschneidendes_erlebnis"),
                            result.getInt("NOTIZEN_idNOTIZEN"),
                            result.getInt("DOKUMENTE_idDOKUMENTE"),
                            result.getInt("FAMILIAERER_HINTERGRUND_idFAMILIAERER_HINTERGRUND"),
                            result.getInt("TELEKOMMUNIKATION_idTELEKOMMUNIKATION"),
                            result.getInt("TESTUNG_idTESTUNG"),
                            result.getInt("SCHULISCHER_HINTERGRUND_idSCHULISCHER_HINTERGRUND"),
                            result.getInt("FOERDERUNG_idFOERDERUNG"),
                            result.getInt("MEDIZINISCHER_HINTERGRUND_idMEDIZINISCHER_HINTERGRUND"),
                            result.getInt("PSYCHOLOGISCHER_HINTERGRUND_idPSYCHOLOGISCHER_HINTERGRUND"),
                            result.getInt("PAEDAGOGISCHE_TESTUNG_idPAEDAGOGISCHE_TESTUNG"),
                            result.getInt("TRAININGSSCHWERPUNKTE_idTRAININGSSCHWERPUNKTE")
                    );
                    if (DEBUG) {
                    }
                    personenListTemp.add(temp);
                }
            } catch (SQLException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return personenListTemp;
    }

    void deletePersonFromDB(int idPersonen) {
        //TODO write methode to delete a person from DB
    }

    void insertPersonenToDB(Person toAdd) {
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
                String terminalUnitType="";
                String cpuType = "";
                if (toAdd.getTerminalUnitType() == null) {
                    terminalUnitType="";
                }
                if(toAdd.getCpuType() == null){
                    cpuType = "";
                }
                String sql = "Insert Into personen(materialNr, picture, ProductGroup, ShortDescription, Type, FullTextDescription,TechnicalDetails, QuantityAI, QuantityAO, QuantityAX, QuantityDI, QuantityDO, QuantityDX, TerminalUnitType, Voltage, Amperage, Thermocouple, Transistor, Relay, Slotquantity,CPUType, isECO, hasEthernet, RAM, Accessoirtype, FieldBusType, TerminalBaseType, isXC, isSafety) VALUES ( \"" + toAdd.getMaterialNumber() + "\", \""
                        + toAdd.getPicture().substring(0, toAdd.getPicture().length() - 4) + "\", \"" + toAdd.getProductGroup() + "\", \""
                        + toAdd.getShortDescription() + "\", \"" + toAdd.getType() + "\", \""
                        + toAdd.getFullTextDescription() + "\", \"" + toAdd.getTechnicalDetailsPath() + "\", \""
                        + toAdd.getQuantityAI() + "\", \"" + toAdd.getQuantityAO() + "\", \""
                        + toAdd.getQuantityAX() + "\", \"" + toAdd.getQuantityDI() + "\", \""
                        + toAdd.getQuantityDO() + "\", \"" + toAdd.getQuantityDX() + "\", \""
                        + terminalUnitType + "\", \"" + toAdd.getVoltage() + "\", \""
                        + toAdd.getAmperage() + "\", \"" + toAdd.getThermocouple() + "\", \""
                        + toAdd.getTransistor() + "\", \"" + toAdd.getRelay() + "\", \""
                        + toAdd.getSlotquantity() + "\", \"" + cpuType + "\", \""
                        + (toAdd.getIsECO() ? 1 : 0) + "\", \"" + (toAdd.getHasEthernet() ? 1 : 0) + "\", \""
                        + toAdd.getRam() + "\", \"" + toAdd.getAccessoirtype() + "\", \""
                        + toAdd.getFildbusType() + "\", \"" + toAdd.getTerminalbaseType() + "\", \""
                        + (toAdd.getIsExtremCondition() ? 1 : 0) + "\", \"" + (toAdd.getIsSafety() ? 1 : 0) + "\");";
                int result = query.executeUpdate(sql);
            } catch (SQLException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

}

}
