
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
        kml = "<?xml version='1.0' encoding='UTF-8'?>\n" +
"<kml xmlns='http://www.opengis.net/kml/2.2'>\n" +
"	<Document>\n" +
"		<name>" + nome + "</name>\n";
    }
    
    public void adicionarBairro(String nomeBairro, int ocorrencias, String polygon) {
        int pigmentacao = 0;
        if(totalOcorrencias > 0){
            pigmentacao = (255 * ocorrencias) / totalOcorrencias;   // 255 é o limite da pigmentacao
        }
        
        String hex = Integer.toHexString(pigmentacao);
        
        kml += "<Placemark>\n" +
"           <name>" + nomeBairro + "</name>\n" +
"           <styleUrl>#poly-DB4436-1-" + pigmentacao + "-nodesc</styleUrl>\n" +
"           <ExtendedData>\n" +
"           </ExtendedData>" + polygon + "</Placemark>";
        
        styles.add("		<Style id='poly-DB4436-1-"+pigmentacao+"-nodesc-normal'>\n" +
"			<LineStyle>\n" +
"				<color>FF3644DB</color>\n" +
"				<width>1</width>\n" +
"			</LineStyle>\n" +
"			<PolyStyle>\n" +
"				<color>"+hex+"3644DB</color>\n" +
"				<fill>1</fill>\n" +
"				<outline>1</outline>\n" +
"			</PolyStyle>\n" +
"			<BalloonStyle>\n" +
"				<text><![CDATA[<h3>$[name]</h3>]]></text>\n" +
"			</BalloonStyle>\n" +
"		</Style>\n" +
"		<Style id='poly-DB4436-1-"+pigmentacao+"-nodesc-highlight'>\n" +
"			<LineStyle>\n" +
"				<color>"+hex+"3644DB</color>\n" +
"				<width>2.0</width>\n" +
"			</LineStyle>\n" +
"			<PolyStyle>\n" +
"				<color>"+hex+"3644DB</color>\n" +
"				<fill>1</fill>\n" +
"				<outline>1</outline>\n" +
"			</PolyStyle>\n" +
"			<BalloonStyle>\n" +
"				<text><![CDATA[<h3>$[name]</h3>]]></text>\n" +
"			</BalloonStyle>\n" +
"		</Style>\n" +
"		<StyleMap id='poly-DB4436-1-"+pigmentacao+"-nodesc'>\n" +
"			<Pair>\n" +
"				<key>normal</key>\n" +
"				<styleUrl>#poly-DB4436-1-"+pigmentacao+"-nodesc-normal</styleUrl>\n" +
"			</Pair>\n" +
"			<Pair>\n" +
"				<key>highlight</key>\n" +
"				<styleUrl>#poly-DB4436-1-"+pigmentacao+"-nodesc-highlight</styleUrl>\n" +
"			</Pair>\n" +
"		</StyleMap>");
    }
    
    public void finalizaKML() {    
        //kml += "</Folder>\n";
        
        for (String style : styles) {
            kml += style;
        }
        
        kml += "</Document>\n" +
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
