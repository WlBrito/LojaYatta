/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadores;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entities.Cliente;
import file.FilePersistence;
import file.SerializadorCSVCliente;
import file.SerializadorJSONCliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wbo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GerenciadorCliente {

    private List<Cliente> lista_clientes;

    public GerenciadorCliente() {
        lista_clientes = new ArrayList<>();
    }

    public void add_cliente(Cliente cliente) {
        lista_clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso");
    }

    public void upt_cliente(String cpf, Cliente clienteNovo) {
        Cliente cliente_existente = find_cliente(cpf);
        if (cliente_existente != null) {
            int indice = lista_clientes.indexOf(cliente_existente);
            lista_clientes.set(indice, clienteNovo);
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente nao localizado");
        }
    }

    public boolean rem_cliente(String cpf) {
        for (Cliente cliente : lista_clientes) {
            if (cliente.getCpf_cliente().equals(cpf)) {
                lista_clientes.remove(cliente);
                System.out.println("Cliente removido!");
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Cliente cliente : lista_clientes) {
            saida.append(cliente.toString()).append("\n");
        }
        return saida.toString();
    }

    public Cliente find_cliente(String cpf) {
        for (Cliente cliente : lista_clientes) {
            if (cliente.getCpf_cliente().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void salvarNoArquivo(String pathFile) {
        SerializadorJSONCliente serializadorJSON = new SerializadorJSONCliente();
        String jsonData = serializadorJSON.ToJSON(this.lista_clientes);
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(jsonData, pathFile);
        System.out.println("Salvo com sucesso em " + pathFile);
    }

    public void carregarDoArquivo(String pathFile) {
        FilePersistence filePersistence = new FilePersistence();
        String jsonData = filePersistence.loadFromFile(pathFile);
        SerializadorJSONCliente desserializadorJson = new SerializadorJSONCliente();
        this.lista_clientes = desserializadorJson.fromJSON(jsonData);

        System.out.println("Pedidos carregados com sucesso de: " + pathFile);
    }
}
