
package br.univali.delgis.controle;

import br.univali.delgis.modelo.Tipo;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorTipo {
    private Tipo tipo;

    public ControladorTipo() {
        
    }
    
    public void novoTipo(String nome) {
        tipo = new Tipo(nome);
        tipo.salvarBanco();
    }
    
    public void atualizarTipo(int id, String nome) {
        tipo = new Tipo(id,nome);
        tipo.atualizaBanco();
    }
    
    public void excluirTipo(int id, String nome) {
        tipo = new Tipo(id,nome);
        tipo.excluiBanco();
    }
    
    public DefaultTableModel montaTabela(){
        tipo = new Tipo();
        ResultSet rs = tipo.buscaTipos();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        
        try {
            String vetor[] = new String[2];
            modelo.addColumn("ID");
            modelo.addColumn("Nome");

            while (rs.next()) {
                for (int i = 1; i <= vetor.length; i++) {
                    vetor[i - 1] = rs.getString(i);
                }
                modelo.addRow(vetor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao montar Tabela");
            ex.printStackTrace();
        }

        return modelo;
    }
    
        
    public DefaultComboBoxModel montaComboBox(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        tipo = new Tipo();
        ResultSet rs = tipo.buscaTipos();
        
        try {
            while (rs.next()) {
                model.addElement(rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao montar ComboBox");
            ex.printStackTrace();
        }
        return model;
    }
}