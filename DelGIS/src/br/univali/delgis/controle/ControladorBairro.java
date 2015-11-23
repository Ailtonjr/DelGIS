
package br.univali.delgis.controle;

import br.univali.delgis.modelo.Bairro;
import br.univali.delgis.modelo.Conexao;
import br.univali.delgis.modelo.Ponto;
import java.util.List;


public class ControladorBairro {
    private Bairro bairro;
    private Conexao con = new Conexao();

    public ControladorBairro() {
    }
    
    public void novoBairro(String nome, List<Ponto> poligono) {
        bairro = new Bairro(nome, poligono);
        bairro.salvarBanco();
    }
    
    public void atualizarBairro(int id,String nome, List coordenadas){
        bairro = new Bairro(id, nome, coordenadas);
        bairro.atualizaBanco();
    }
    
    public void excluirTipo(int id, String nome){
        bairro = new Bairro(id, nome, null);
        bairro.excluiBanco();
    }
    
}
