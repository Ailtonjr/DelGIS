
package br.univali.delgis.controle;

import br.univali.delgis.modelo.Tipo;


public class ControladorTipo {
    private Tipo tipo;

    public ControladorTipo() {
        
    }
    
    public void novoTipo(String nome) {
        tipo = new Tipo(nome);
        tipo.salvarBanco();
    }
    
    public void atualizarTipo(int id, String nome) {
        tipo = new Tipo(nome);
        tipo.atualizaBanco();
    }
}