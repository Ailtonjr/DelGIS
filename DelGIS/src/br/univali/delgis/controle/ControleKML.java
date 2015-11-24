
package br.univali.delgis.controle;

import br.univali.delgis.modelo.KML;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControleKML {

    private KML kml;
    
    public ControleKML() {
    }
    
    public void novoKML() {
        kml = new KML("DelGIS Map");
        
        ResultSet rs = kml.consultaIntercecoes();
        try {
            while (rs.next()) {
                for (int i = 1; i <= 3; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleKML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
