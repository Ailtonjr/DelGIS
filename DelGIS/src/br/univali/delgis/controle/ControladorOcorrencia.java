
package br.univali.delgis.controle;

import br.univali.delgis.modelo.Ocorrencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;



public class ControladorOcorrencia {
    private Ocorrencia ocorrencia;

    public ControladorOcorrencia() {
    }
    
    public void novaOcorrencia(String descricao, double longitude, double latitude, String tipoOcorrencia) {
        ocorrencia = new Ocorrencia(descricao, longitude, latitude, tipoOcorrencia);
        ocorrencia.salvarBanco();
    }
    
    public void atualizarOcorrencia(int id,String descricao, double longitude, double latitude, String tipoOcorrencia) {
        ocorrencia = new Ocorrencia(id, descricao, longitude, latitude, tipoOcorrencia);
        ocorrencia.atualizaBanco();
    }
    
    public void excluirOcorrencia(int id){
        ocorrencia = new Ocorrencia(id);
        ocorrencia.excluiBanco();
    }
    
    public DefaultTableModel montaTabela(){
        ocorrencia = new Ocorrencia();
        ResultSet rs = ocorrencia.buscaOcorrencias();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        
        try {
            String vetor[] = new String[4];
            modelo.addColumn("ID");
            modelo.addColumn("Descrição");
            modelo.addColumn("Coordenadas");
            modelo.addColumn("Tipo");

            while (rs.next()) {
                for (int i = 1; i <= vetor.length; i++) {
                    vetor[i - 1] = rs.getString(i);
                }
                modelo.addRow(vetor);
            }
        } catch (SQLException ex) {
            
        }

        return modelo;
    }
}
