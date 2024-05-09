/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import entities.Pedido;
import java.util.List;

/**
 *
 * @author wbo
 */
public class SerializadorJSONPedido {
    public String ToJSON(List<Pedido> lista_pedidos){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(lista_pedidos);
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Pedido> fromJSON(String jsonString){
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Pedido> lista_pedidos = mapper.readValue(jsonString, new TypeReference<List<Pedido>>(){});
            return lista_pedidos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
