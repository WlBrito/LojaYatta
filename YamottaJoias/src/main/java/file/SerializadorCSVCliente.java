/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import entities.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wbo
 */
public class SerializadorCSVCliente {
    public String toCSV(List<Cliente> lista_de_clientes){
        String csv = "Id;Nome;Cpf;Telefone;\n";
        for(Cliente cliente : lista_de_clientes){
            csv += cliente.getId_cliente() + ";"
                    + cliente.getNome_cliente() + ";"
                    + cliente.getCpf_cliente() + ";"
                    + cliente.getTelefone_cliente() + ";"
                    +";\n";
        }
        return csv;
    }
    
    public List <Cliente> fromCSV(String data){
        List <Cliente> lista_de_clientes = new ArrayList<>();
        String[] linhas = data.split("\n");
        for(int i = 1; i < linhas.length; i ++){
            String [] partes = linhas[i].split(";");
            if(partes.length >=4)
            {
                //ID/NOME/CPF/TELEFONE/
                Cliente cliente = new Cliente();
                cliente.setId_cliente(Integer.parseInt(partes[0]));
                cliente.setNome_cliente(partes[1]);
                cliente.setCpf_cliente(partes[2]);
                cliente.setTelefone_cliente(partes[3]);
                
                lista_de_clientes.add(cliente);
            }
        }
        return lista_de_clientes;
    }
}
