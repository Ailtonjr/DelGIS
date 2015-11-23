
package br.univali.delgis.modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Bairro {
    private int id;
    private String nome;
    private List<Ponto> coordenadas = new ArrayList();

    public Bairro(int id, String nome, List<Ponto> coordenadas) {
        this.id = id;
        this.nome = nome;
        this.coordenadas = coordenadas;
    }
    
    public Bairro(String nome, List<Ponto> coordenadas) {
        this.nome = nome;
        this.coordenadas = coordenadas;
    }

    public Bairro() {
    }
    
    
    
    public void salvarBanco(){
        
    }
    
    public void atualizaBanco(){
        
    }
    
    public void excluiBanco(){
        
    }
    
    public ResultSet buscaBairros(){
        
        return null;
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
