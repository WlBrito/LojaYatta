/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import entities.Pedido;
import entities.Produto;
import java.util.List;

/**
 *
 * @author wbo
 */
public class SerializadorJSONProduto {
    public String ToJSON(List<Produto> lista_produtos){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(lista_produtos);
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Produto> fromJSON(String jsonString){
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Produto> lista_produtos = mapper.readValue(jsonString, new TypeReference<List<Produto>>(){});
            return lista_produtos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
