
package br.univali.delgis.modelo;

import java.sql.ResultSet;
import java.util.List;

public class Ocorrencia {
    private int id;
    private String descricao;
    private double longitude;
    private double latitude;
    private String tipoOcorrencia;

    public Ocorrencia(int id,String descricao, double longitude, double latitude, String tipoOcorrencia) {
        this.id = id;
        this.descricao = descricao;
        this.longitude = longitude;
        this.latitude = latitude;
        this.tipoOcorrencia = tipoOcorrencia;
    }
    
    public Ocorrencia(String descricao, double longitude, double latitude, String tipoOcorrencia) {
        this.descricao = descricao;
        this.longitude = longitude;
        this.latitude = latitude;
        this.tipoOcorrencia = tipoOcorrencia;
    }

    public Ocorrencia() {
    }
    
    public void salvarBanco(){
        
    }
    
    public void atualizaBanco(){
        
    }
    
    public void excluiBanco(){
        
    }
    
    public ResultSet buscaOcorrencias(){
        
        return null;
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

    public String getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public void setTipoOcorrencia(String tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }
}
