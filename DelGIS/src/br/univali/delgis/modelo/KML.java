
package br.univali.delgis.modelo;

public class KML {
    private String kml;
    private String descricao;
    
    private final String ZERO_OCORRENCIAS   = "#poly-0000FF-3-0-nodesc";
    private final String CINCO_OCORRENCIAS  = "#poly-0000FF-2-50-nodesc";
    private final String DEZ_OCORRENCIAS    = "#poly-0000FF-2-132-nodesc";
    private final String VINTE_OCORRENCIAS  = "#poly-0000FF-2-255-nodesc";

    public KML(String nome) {
        kml = "<?xml version='1.0' encoding='UTF-8'?>\n" +
"<kml xmlns='http://www.opengis.net/kml/2.2'>\n" +
"	<Document>\n" +
"		<name>" + nome + "</name>\n" +
"		<description><![CDATA[]]></description>\n" +
"		<Folder>\n" +
"			<name>DelGIS.kml</name>";
    }
    
    public void adicionarBairro(String polygon, int ocorrencias) {
        switch(ocorrencias) {
            case 0:
                kml += "<Placemark>\n" +
"				<name>Zero ocorrencias</name>\n" +
"				<styleUrl>" + ZERO_OCORRENCIAS + "</styleUrl>\n" +
"				<ExtendedData>\n" +
"				</ExtendedData>" + polygon + "</Placemark>";
                break;
                
            case 5:
                kml += "<Placemark>\n" +
"				<name>Zero ocorrencias</name>\n" +
"				<styleUrl>" + CINCO_OCORRENCIAS + "</styleUrl>\n" +
"				<ExtendedData>\n" +
"				</ExtendedData>" + polygon + "</Placemark>";
                break;
                
            case 10:
                kml += "<Placemark>\n" +
"				<name>Zero ocorrencias</name>\n" +
"				<styleUrl>" + DEZ_OCORRENCIAS + "</styleUrl>\n" +
"				<ExtendedData>\n" +
"				</ExtendedData>" + polygon + "</Placemark>";
                break;
                
            case 20:
                kml += "<Placemark>\n" +
"				<name>Zero ocorrencias</name>\n" +
"				<styleUrl>" + VINTE_OCORRENCIAS + "</styleUrl>\n" +
"				<ExtendedData>\n" +
"				</ExtendedData>" + polygon + "</Placemark>";
                break;
        }
    }
    
    public void finalizaKML() {
        kml += "</Folder>\n" +
"		<Style id='poly-0000FF-2-132-nodesc-normal'>\n" +
"			<LineStyle>\n" +
"				<color>ffFF0000</color>\n" +
"				<width>2</width>\n" +
"			</LineStyle>\n" +
"			<PolyStyle>\n" +
"				<color>84FF0000</color>\n" +
"				<fill>1</fill>\n" +
"				<outline>1</outline>\n" +
"			</PolyStyle>\n" +
"			<BalloonStyle>\n" +
"				<text><![CDATA[<h3>$[name]</h3>]]></text>\n" +
"			</BalloonStyle>\n" +
"		</Style>\n" +
"		<Style id='poly-0000FF-2-132-nodesc-highlight'>\n" +
"			<LineStyle>\n" +
"				<color>ffFF0000</color>\n" +
"				<width>3.0</width>\n" +
"			</LineStyle>\n" +
"			<PolyStyle>\n" +
"				<color>84FF0000</color>\n" +
"				<fill>1</fill>\n" +
"				<outline>1</outline>\n" +
"			</PolyStyle>\n" +
"			<BalloonStyle>\n" +
"				<text><![CDATA[<h3>$[name]</h3>]]></text>\n" +
"			</BalloonStyle>\n" +
"		</Style>\n" +
"		<StyleMap id='poly-0000FF-2-132-nodesc'>\n" +
"			<Pair>\n" +
"				<key>normal</key>\n" +
"				<styleUrl>#poly-0000FF-2-132-nodesc-normal</styleUrl>\n" +
"			</Pair>\n" +
"			<Pair>\n" +
"				<key>highlight</key>\n" +
"				<styleUrl>#poly-0000FF-2-132-nodesc-highlight</styleUrl>\n" +
"			</Pair>\n" +
"		</StyleMap>\n" +
"		<Style id='poly-0000FF-2-255-nodesc-normal'>\n" +
"			<LineStyle>\n" +
"				<color>ffFF0000</color>\n" +
"				<width>2</width>\n" +
"			</LineStyle>\n" +
"			<PolyStyle>\n" +
"				<color>FFFF0000</color>\n" +
"				<fill>1</fill>\n" +
"				<outline>1</outline>\n" +
"			</PolyStyle>\n" +
"			<BalloonStyle>\n" +
"				<text><![CDATA[<h3>$[name]</h3>]]></text>\n" +
"			</BalloonStyle>\n" +
"		</Style>\n" +
"		<Style id='poly-0000FF-2-255-nodesc-highlight'>\n" +
"			<LineStyle>\n" +
"				<color>ffFF0000</color>\n" +
"				<width>3.0</width>\n" +
"			</LineStyle>\n" +
"			<PolyStyle>\n" +
"				<color>FFFF0000</color>\n" +
"				<fill>1</fill>\n" +
"				<outline>1</outline>\n" +
"			</PolyStyle>\n" +
"			<BalloonStyle>\n" +
"				<text><![CDATA[<h3>$[name]</h3>]]></text>\n" +
"			</BalloonStyle>\n" +
"		</Style>\n" +
"		<StyleMap id='poly-0000FF-2-255-nodesc'>\n" +
"			<Pair>\n" +
"				<key>normal</key>\n" +
"				<styleUrl>#poly-0000FF-2-255-nodesc-normal</styleUrl>\n" +
"			</Pair>\n" +
"			<Pair>\n" +
"				<key>highlight</key>\n" +
"				<styleUrl>#poly-0000FF-2-255-nodesc-highlight</styleUrl>\n" +
"			</Pair>\n" +
"		</StyleMap>\n" +
"		<Style id='poly-0000FF-2-50-nodesc-normal'>\n" +
"			<LineStyle>\n" +
"				<color>ffFF0000</color>\n" +
"				<width>2</width>\n" +
"			</LineStyle>\n" +
"			<PolyStyle>\n" +
"				<color>32FF0000</color>\n" +
"				<fill>1</fill>\n" +
"				<outline>1</outline>\n" +
"			</PolyStyle>\n" +
"			<BalloonStyle>\n" +
"				<text><![CDATA[<h3>$[name]</h3>]]></text>\n" +
"			</BalloonStyle>\n" +
"		</Style>\n" +
"		<Style id='poly-0000FF-2-50-nodesc-highlight'>\n" +
"			<LineStyle>\n" +
"				<color>ffFF0000</color>\n" +
"				<width>3.0</width>\n" +
"			</LineStyle>\n" +
"			<PolyStyle>\n" +
"				<color>32FF0000</color>\n" +
"				<fill>1</fill>\n" +
"				<outline>1</outline>\n" +
"			</PolyStyle>\n" +
"			<BalloonStyle>\n" +
"				<text><![CDATA[<h3>$[name]</h3>]]></text>\n" +
"			</BalloonStyle>\n" +
"		</Style>\n" +
"		<StyleMap id='poly-0000FF-2-50-nodesc'>\n" +
"			<Pair>\n" +
"				<key>normal</key>\n" +
"				<styleUrl>#poly-0000FF-2-50-nodesc-normal</styleUrl>\n" +
"			</Pair>\n" +
"			<Pair>\n" +
"				<key>highlight</key>\n" +
"				<styleUrl>#poly-0000FF-2-50-nodesc-highlight</styleUrl>\n" +
"			</Pair>\n" +
"		</StyleMap>\n" +
"		<Style id='poly-0000FF-3-0-nodesc-normal'>\n" +
"			<LineStyle>\n" +
"				<color>ffFF0000</color>\n" +
"				<width>3</width>\n" +
"			</LineStyle>\n" +
"			<PolyStyle>\n" +
"				<color> 0FF0000</color>\n" +
"				<fill>1</fill>\n" +
"				<outline>1</outline>\n" +
"			</PolyStyle>\n" +
"			<BalloonStyle>\n" +
"				<text><![CDATA[<h3>$[name]</h3>]]></text>\n" +
"			</BalloonStyle>\n" +
"		</Style>\n" +
"		<Style id='poly-0000FF-3-0-nodesc-highlight'>\n" +
"			<LineStyle>\n" +
"				<color>ffFF0000</color>\n" +
"				<width>5.0</width>\n" +
"			</LineStyle>\n" +
"			<PolyStyle>\n" +
"				<color> 0FF0000</color>\n" +
"				<fill>1</fill>\n" +
"				<outline>1</outline>\n" +
"			</PolyStyle>\n" +
"			<BalloonStyle>\n" +
"				<text><![CDATA[<h3>$[name]</h3>]]></text>\n" +
"			</BalloonStyle>\n" +
"		</Style>\n" +
"		<StyleMap id='poly-0000FF-3-0-nodesc'>\n" +
"			<Pair>\n" +
"				<key>normal</key>\n" +
"				<styleUrl>#poly-0000FF-3-0-nodesc-normal</styleUrl>\n" +
"			</Pair>\n" +
"			<Pair>\n" +
"				<key>highlight</key>\n" +
"				<styleUrl>#poly-0000FF-3-0-nodesc-highlight</styleUrl>\n" +
"			</Pair>\n" +
"		</StyleMap>\n" +
"	</Document>\n" +
"</kml>";
    }
}
