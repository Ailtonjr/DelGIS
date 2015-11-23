
package br.univali.delgis.controle;

import br.univali.delgis.modelo.Bairro;
import br.univali.delgis.modelo.Conexao;
import br.univali.delgis.modelo.Ponto;
import java.util.List;


public class ControladorBairro {
    private Bairro bairro;
    private Conexao con;

    public ControladorBairro() {
        con = new Conexao();
    }
    
    public void novoBairro(String nome, List<Ponto> poligono) {
        this.bairro = new Bairro(nome, poligono);
        
    }
    
}
