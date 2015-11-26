
package br.univali.delgis.controle;

import br.univali.delgis.modelo.Relatorio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ControleRelatorio {

    private Relatorio kml = new Relatorio();
    
    public ControleRelatorio() {
    }
    
    public void novoRelatorio() {
        kml.novoRelatorio();
        ResultSet rs = kml.consultaIntercecoes();
        String newLine = System.getProperty("line.separator");  
        
        try {
            while (rs.next()) {
                kml.getBw().append(rs.getString(1) + "\t\t" + rs.getString(2) + newLine);
            }
            kml.getBw().close();
            kml.getFw().close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatorio.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void novoKML() {
        kml.novoKML("DelGIS Map");
        
        ResultSet rs = kml.consultaIntercecoes();
        try {
            while (rs.next()) {
                kml.adicionarBairro(rs.getString(1), Integer.parseInt(rs.getString(2)), rs.getString(3));
                /*
                for (int i = 1; i <= 3; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
                */
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
