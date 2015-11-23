
package br.univali.delgis.modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Tipo {
    private String id;
    private String nome;
    private Conexao con;

    public Tipo(String nome) {
        this.nome = nome;
    }
    
    public Tipo(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public void salvarBanco() {
        String sql = "BEGIN;"
                + "INSERT INTO tipo (nome) VALUES (?);"
                + "COMMIT";
        
        try {
            PreparedStatement statement = con.getConexao().prepareStatement(sql);
            statement.setString(1, nome);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tipo " + nome + " inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir tipo " + nome + ". Verifique se este tipo já não existente\n" + sql);
            ex.printStackTrace();
        }
    }
    
    public void atualizaBanco() {
        String sql = "BEGIN;"
                + "UPDATE tipo SET nome = ? WHERE id = ?;"
                + "COMMIT";
        
        try {
            PreparedStatement statement = con.getConexao().prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tipo " + nome + " inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir tipo " + nome + ". Verifique se este tipo já não existente\n" + sql);
            ex.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Conexao getCon() {
        return con;
    }

    public void setCon(Conexao con) {
        this.con = con;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
