
package br.univali.delgis.controle;

import br.univali.delgis.modelo.Bairro;
import br.univali.delgis.modelo.Conexao;
import br.univali.delgis.modelo.Ponto;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class ControladorBairro {
    private Bairro bairro;
    private Conexao con;

    public ControladorBairro() {
        con = new Conexao(null, null, null);
    }
    
    public void novoBairro(String nome, List<Ponto> poligono) {
        this.bairro = new Bairro(nome, poligono);

    }
    
}
