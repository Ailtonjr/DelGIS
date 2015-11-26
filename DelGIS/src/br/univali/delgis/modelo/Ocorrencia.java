package br.univali.delgis.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Ocorrencia {
    private int id;
    private String descricao;
    private double longitude;
    private double latitude;
    private int id_tipo;
    private Conexao con = new Conexao();

    public Ocorrencia(int id,String descricao, double longitude, double latitude, int tipoOcorrencia) {
        this.id = id;
        this.descricao = descricao;
        this.longitude = longitude;
        this.latitude = latitude;
        this.id_tipo = tipoOcorrencia;
    }
    
    public Ocorrencia(String descricao, double longitude, double latitude, int tipoOcorrencia) {
        this.descricao = descricao;
        this.longitude = longitude;
        this.latitude = latitude;
        this.id_tipo = tipoOcorrencia;
    }
    
    public Ocorrencia(int id) {
        this.id = id;
    }

    public Ocorrencia() {
    }
    
    public void salvarBanco(){
        String sql = "BEGIN;"
                + "INSERT INTO ocorrencia (descricao, id_tipo, coordenada) VALUES (?, ?, st_geomfromtext(?, 4674));"
                + "COMMIT";
        
        String point = "POINT(" + longitude + " " + latitude + ")";
        
        try {
            PreparedStatement statement = con.getConexao().prepareStatement(sql);
            statement.setString(1, descricao);
            statement.setInt(2, id_tipo);
            statement.setString(3, point);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ocorrencia cadastrada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar ocorrencia\n" + sql);
            ex.printStackTrace();
        }
        con.encerrarConexao();
    }
    
    public void atualizaBanco(){
        String sql = "BEGIN;"
                + "UPDATE ocorrencia SET descricao = ?, id_tipo = ?, coordenada = ? WHERE id = ?"
                + "COMMIT";
        
        String point = "POINT(" + longitude + " " + latitude + ")";
        
        try {
            PreparedStatement statement = con.getConexao().prepareStatement(sql);
            statement.setString(1, descricao);
            statement.setInt(2, id_tipo);
            statement.setString(3, point);
            statement.setInt(4, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ocorrencia " + id + " atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar ocorrencia " + id + "\n" + sql);
            ex.printStackTrace();
        }
        con.encerrarConexao();
    }
    
    public void excluiBanco(){
        String sql = "BEGIN;"
                + "DELETE FROM ocorrencia WHERE id = ?;"
                + "COMMIT";
        
        try {
            PreparedStatement statement = con.getConexao().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ocorrencia " + id + " excluida com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir ocorrencia " + id + ".\n" + sql);
            ex.printStackTrace();
        }
        con.encerrarConexao();
    }
    
    public ResultSet buscaOcorrencias(){
        String sql = "SELECT o.id, o.descricao, st_astext(coordenada), t.nome FROM ocorrencia o Join tipo_ocorrencia t ON (o.id_tipo = t.id) ORDER BY o.id";
        ResultSet rs = null;

        try {
            Statement statement = con.getConexao().createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar ocorrencias\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        con.encerrarConexao();
        return rs;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getTipoOcorrencia() {
        return id_tipo;
    }

    public void setTipoOcorrencia(int tipoOcorrencia) {
        this.id_tipo = tipoOcorrencia;
    }
}
