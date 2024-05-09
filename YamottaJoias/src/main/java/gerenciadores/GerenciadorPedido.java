/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadores;

import entities.Pedido;
import file.FilePersistence;
import file.SerializadorJSONPedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wbo
 */
public class GerenciadorPedido {

    private List<Pedido> lista_pedidos;

    public GerenciadorPedido() {
        lista_pedidos = new ArrayList<>();
    }

    public void add_pedido(Pedido pedido) {
        lista_pedidos.add(pedido);
        System.out.println("Pedido cadastrado com sucesso");
    }
//    public void upt_pedido(String cpf, Pedido pedido_novo){
//        Pedido pedido_existente = ;
//        if(cliente_existente != null){
//            int indice = lista_clientes.indexOf(cliente_existente);
//            lista_clientes.set(indice, clienteNovo);
//            System.out.println("Pedido atualizado com sucesso!");
//        }else
//            System.out.println("Pedido nao localizado");
//    }

    public boolean rem_pedido(int id_pedido) {
        for (Pedido pedido : lista_pedidos) {
            if (pedido.getId() == id_pedido) {
                lista_pedidos.remove(pedido);
                System.out.println("Pedido removido!");
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Pedido pedido : lista_pedidos) {
            saida.append(pedido.toString()).append("\n");
        }
        return saida.toString();
    }

    public Pedido find_pedido(int id_pedido) {
        for (Pedido pedido : lista_pedidos) {
            if (pedido.getId() == id_pedido) {
                return pedido;
            }
        }
        return null;
    }

    public void salvarNoArquivo(String pathFile) {
        SerializadorJSONPedido serializadorJSON = new SerializadorJSONPedido();
        String jsonData = serializadorJSON.ToJSON(this.lista_pedidos);
        FilePersistence filePersistence = new FilePersistence();
        filePersistence.saveToFile(jsonData, pathFile);
        System.out.println("Salvo com sucesso em " + pathFile);
    }

    public void carregarDoArquivo(String pathFile) {
        FilePersistence filePersistence = new FilePersistence();
        String jsonData = filePersistence.loadFromFile(pathFile);
        SerializadorJSONPedido desserializadorJson = new SerializadorJSONPedido();
        this.lista_pedidos = desserializadorJson.fromJSON(jsonData);

        System.out.println("Pedidos carregados com sucesso de: " + pathFile);
    }
}
