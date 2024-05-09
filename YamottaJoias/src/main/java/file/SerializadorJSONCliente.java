/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import entities.Cliente;
import entities.Pedido;
import java.util.List;

/**
 *
 * @author wbo
 */
public class SerializadorJSONCliente {
    public String ToJSON(List<Cliente> lista_clientes){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(lista_clientes);
            return jsonString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Cliente> fromJSON(String jsonString){
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Cliente> lista_clientes = mapper.readValue(jsonString, new TypeReference<List<Cliente>>(){});
            return lista_clientes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
