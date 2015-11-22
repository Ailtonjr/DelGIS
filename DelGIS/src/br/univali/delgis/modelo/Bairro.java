
package br.univali.delgis.modelo;

import java.util.ArrayList;
import java.util.List;


public class Bairro {
    private String nome;
    private List<Ponto> coordenadas = new ArrayList();

    public Bairro(String nome, List<Ponto> coordenadas) {
        this.nome = nome;
        this.coordenadas = coordenadas;
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
