
package br.univali.delgis.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Bairro {
    private int id;
    private String nome;
    private List<Ponto> coordenadas = new ArrayList();
    private Conexao con = new Conexao();

    public Bairro(int id, String nome, List<Ponto> coordenadas) {
        this.id = id;
        this.nome = nome;
        this.coordenadas = coordenadas;
    }
    
    public Bairro(String nome) {
        this.nome = nome;
    }

    public Bairro() {
    }
    
    public void salvarBanco(){
        String sql = "BEGIN;"
                + "INSERT INTO bairro(nome, coordenadas) VALUES(?, st_geomfromtext(?, 4674));"
                + "COMMIT";
        
        try {
            PreparedStatement statement = con.getConexao().prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, montaPoligono());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bairro cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar bairro\n" + sql);
            ex.printStackTrace();
        }
        con.encerrarConexao();
    }
    
    public void atualizaBanco(){
        String sql = "BEGIN;"
                + "UPDATE bairro SET nome = ?, coordenadas = st_geomfromtext(?, 4674) WHERE id = ?;"
                + "COMMIT";
        
        try {
            PreparedStatement statement = con.getConexao().prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, montaPoligono());
            statement.setInt(3, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bairro atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar bairro\n" + sql);
            ex.printStackTrace();
        }
        con.encerrarConexao();
    }
    
    public void excluiBanco(){
        String sql = "BEGIN;"
                + "DELETE FROM bairro WHERE id = ?;"
                + "COMMIT";
        
        try {
            PreparedStatement statement = con.getConexao().prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bairro " + nome + " excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir bairro " + nome + ".\n" + sql);
            ex.printStackTrace();
        }
        con.encerrarConexao();
    }
    
    public ResultSet buscaBairros(){
        String sql = "SELECT id, nome, st_astext(coordenadas) FROM bairro";
        ResultSet rs = null;

        try {
            Statement statement = con.getConexao().createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar bairros\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        con.encerrarConexao();
        return rs;
    }
    
    public String montaPoligono() {
        String polygon = "POLYGON((";
        int cont = 0;
        
        // 'POLYGON((6 15, 10 10, 20 10, 6 15))'
        for (Ponto coordenada : coordenadas) {
            if (cont != 0) polygon += ", ";
            polygon += coordenada.getLongitude() + " " + coordenada.getLatitude();
            cont++;
        }
        
        polygon += "))";
        
        return polygon;
    }
    
    public void inserePonto(double lon, double lat) {
        coordenadas.add(new Ponto(lon, lat));
    }
    
    public void deletaPonto(int i) {
        coordenadas.remove(i);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Ponto> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<Ponto> coordenadas) {
        this.coordenadas = coordenadas;
    }
}
