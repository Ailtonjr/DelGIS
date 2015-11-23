package br.univali.delgis.controle;

import br.univali.delgis.modelo.Bairro;
import br.univali.delgis.modelo.Conexao;
import br.univali.delgis.modelo.Ocorrencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorBairro {

    private Bairro bairro;
    private Conexao con = new Conexao();

    public ControladorBairro() {
    }

    public void novoBairro(String nome, DefaultTableModel model) {
        bairro = new Bairro(nome);
        montaLista(model);
        if(bairro.getCoordenadas().size() > 0 
                && bairro.getCoordenadas().get(0).getLongitude() != bairro.getCoordenadas().get(bairro.getCoordenadas().size()-1).getLongitude() 
                && bairro.getCoordenadas().get(0).getLatitude()!= bairro.getCoordenadas().get(bairro.getCoordenadas().size()-1).getLatitude()){
            bairro.inserePonto(bairro.getCoordenadas().get(0).getLongitude(), bairro.getCoordenadas().get(0).getLatitude());
        }
        if (bairro.getCoordenadas().size() > 3) {
            bairro.salvarBanco();
        }else{
            JOptionPane.showMessageDialog(null, "São necessários no mínimo 3 pontos");
        }
        
        
    }

    public void atualizarBairro(int id, String nome, List coordenadas) {
        bairro = new Bairro(id, nome, coordenadas);
        bairro.atualizaBanco();
    }

    public void excluirBairro(int id, String nome) {
        bairro = new Bairro(id, nome, null);
        bairro.excluiBanco();
    }

    private void montaLista(DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount()-1; j++) {
                bairro.inserePonto(Double.parseDouble(model.getValueAt(i, j).toString()),Double.parseDouble(model.getValueAt(i, j+1).toString()));
                System.out.print(model.getValueAt(i, j) + "\t" + model.getValueAt(i, j+1));
                j++;
            }
            System.out.println("");
        }
    }
    
    public DefaultTableModel montaTabela(){
        bairro = new Bairro();
        ResultSet rs = bairro.buscaBairros();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        
        try {
            String vetor[] = new String[3];
            modelo.addColumn("ID");
            modelo.addColumn("Nome");
            modelo.addColumn("Coordenadas");

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
