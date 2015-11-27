
package br.univali.delgis.modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Relatorio {
    private String kml;
    private String descricao;
    private Conexao con;
    private FileWriter fw;
    private BufferedWriter bw;
    private int totalOcorrencias = 0;
    private List<String> styles = new ArrayList();

    public Relatorio() {
        con = new Conexao();
        defineOcorrenciasTotais();
    }
    
    public void novoRelatorio() {
        try {
            fw = new FileWriter("DelGIS_Relatorio.txt");
            bw = new BufferedWriter(fw);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo KML", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void novoKML(String nome) {
        kml = "<?xml version='1.0' encoding='UTF-8'?>" +
"<kml xmlns='http://www.opengis.net/kml/2.2'>" +
"	<Document>" +
"		<name>" + nome + "</name>";
    }
    
    public void adicionarBairro(String nomeBairro, int ocorrencias, String polygon) {
        int pigmentacao = 0;
        if(totalOcorrencias > 0){
            pigmentacao = (255 * ocorrencias) / totalOcorrencias;   // 255 é o limite da pigmentacao
        }
        
        String hex = Integer.toHexString(pigmentacao);
        
        kml += "<Placemark>" +
"           <name>" + nomeBairro + "</name>" +
"           <styleUrl>#poly-DB4436-1-" + pigmentacao + "-nodesc</styleUrl>" +
"           <ExtendedData>" +
"           </ExtendedData>" + polygon + "</Placemark>";
        
        styles.add("		<Style id='poly-DB4436-1-"+pigmentacao+"-nodesc-normal'>" +
"			<LineStyle>" +
"				<color>ff3644DB</color>" +
"				<width>1</width>" +
"			</LineStyle>" +
"			<PolyStyle>" +
"				<color>"+hex+"3644DB</color>" +
"				<fill>1</fill>" +
"				<outline>1</outline>" +
"			</PolyStyle>" +
"			<BalloonStyle>" +
"				<text><![CDATA[<h3>$[name]</h3>]]></text>" +
"			</BalloonStyle>" +
"		</Style>" +
"		<Style id='poly-DB4436-1-"+pigmentacao+"-nodesc-highlight'>" +
"			<LineStyle>" +
"				<color>"+hex+"3644DB</color>" +
"				<width>2.0</width>" +
"			</LineStyle>" +
"			<PolyStyle>" +
"				<color>"+hex+"3644DB</color>" +
"				<fill>1</fill>" +
"				<outline>1</outline>" +
"			</PolyStyle>" +
"			<BalloonStyle>" +
"				<text><![CDATA[<h3>$[name]</h3>]]></text>" +
"			</BalloonStyle>" +
"		</Style>" +
"		<StyleMap id='poly-DB4436-1-"+pigmentacao+"-nodesc'>" +
"			<Pair>" +
"				<key>normal</key>" +
"				<styleUrl>#poly-DB4436-1-"+pigmentacao+"-nodesc-normal</styleUrl>" +
"			</Pair>" +
"			<Pair>" +
"				<key>highlight</key>" +
"				<styleUrl>#poly-DB4436-1-"+pigmentacao+"-nodesc-highlight</styleUrl>" +
"			</Pair>" +
"		</StyleMap>");
    }
    
    public void finalizaKML() {    
        for (String style : styles) {
            kml += style;
        }
        
        kml += "</Document>" +
            "</kml>";
        
        try {
            fw = new FileWriter("DelGIS.kml");
            bw = new BufferedWriter(fw);
            
            bw.append(kml);
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(null, "Arquivo KML salvo com sucesso.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo KML", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ResultSet consultaIntercecoes() {
        String sql = "SELECT * from ocorrencias_por_bairro;";
        ResultSet rs = null;

        try {
            Statement statement = con.getConexao().createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao analisar intersecoes\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        con.encerrarConexao();
        return rs;
    }
    
    private void defineOcorrenciasTotais() {
        String sql = "SELECT sum(qtd) FROM ocorrencias_por_bairro;";
        ResultSet rs = null;
        
        try {
            Statement statement = con.getConexao().createStatement();
            rs = statement.executeQuery(sql);
            rs.next();
            
            totalOcorrencias = rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao analisar intersecoes\n" + sql, "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    public FileWriter getFw() {
        return fw;
    }

    public void setFw(FileWriter fw) {
        this.fw = fw;
    }

    public BufferedWriter getBw() {
        return bw;
    }

    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

    
}
