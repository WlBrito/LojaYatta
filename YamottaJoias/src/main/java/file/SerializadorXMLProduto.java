/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import gerenciadores.GerenciadorProdutos;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author wbo
 */
public class SerializadorXMLProduto {
    public String toXML (GerenciadorProdutos listaDeProdutos){
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorProdutos.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            StringWriter writer = new StringWriter();
            marshaller.marshal(listaDeProdutos, writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public GerenciadorProdutos fromXML(String xmlString){
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorProdutos.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);
            return (GerenciadorProdutos) unmarshaller.unmarshal(reader);
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
