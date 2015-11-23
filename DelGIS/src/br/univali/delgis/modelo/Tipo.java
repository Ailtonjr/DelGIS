
package br.univali.delgis.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Tipo {
    private int id;
    private String nome;
    private Conexao con = new Conexao();;

    public Tipo(String nome) {
        this.nome = nome;
    }
    
    public Tipo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public void salvarBanco() {
        String sql = "BEGIN;"
                + "INSERT INTO tipo_ocorrencia (nome) VALUES (?);"
                + "COMMIT";
        
        try {
            PreparedStatement statement = con.getConexao().prepareStatement(sql);
            statement.setString(1, this.nome);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tipo " + nome + " inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir tipo " + nome + ". Verifique se este tipo já não existente\n" + sql);
            ex.printStackTrace();
        }
    }
    
    public void atualizaBanco() {
        String sql = "BEGIN;"
                + "UPDATE tipo_ocorrencia SET nome = ? WHERE id = ?;"
                + "COMMIT";
        
        try {
            PreparedStatement statement = con.getConexao().prepareStatement(sql);
            statement.setString(1, nome);
            statement.setInt(2, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tipo " + nome + " atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tipo " + nome + ".\n" + sql);
            ex.printStackTrace();
        }
    }

    public void excluiBanco() {
        String sql = "BEGIN;"
                + "DELETE FROM tipo_ocorrencia WHERE id = ?;"
                + "COMMIT";
        
        try {
            PreparedStatement statement = con.getConexao().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tipo " + nome + " excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir tipo " + nome + ".\n" + sql);
            ex.printStackTrace();
        }
    }
    
    public ResultSet buscaTipos() {
        String sql = "SELECT * FROM tipo_ocorrencia";
        ResultSet rs = null;

        try {
            Statement statement = con.getConexao().prepareStatement(sql);
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Tipos\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return rs;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
