
package br.univali.delgis.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexao {
    private String url;
    private String usuario;
    private String senha;
    private Connection conexao;

    public Conexao(String url, String usuario, String senha) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
        
        try {
            this.conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com " + url);
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados " + url);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados. Verifique se o banco foi iniciado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void encerrarConexao() {
        try {
            conexao.close();
            System.out.println("Conexão encerrada");
        } catch (SQLException ex) {
            System.out.println("Erro ao encerrar conexão com o banco " + url);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

}
