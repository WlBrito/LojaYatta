package gerenciadores;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entities.Produto;
import file.FilePersistence;
import file.SerializadorJSONProduto;
import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GerenciadorProdutos {
   
    private List<Produto> listaDeProdutos;

    public GerenciadorProdutos() {
        this.listaDeProdutos = new ArrayList<>();
    }

    public void addProduto(Produto produto) {
        listaDeProdutos.add(produto);
        System.out.println("Produto add com sucesso!");
    }

    public void atualizarProduto(int codigo, Produto produtoNovo) {
        Produto produtoExistente = buscarProduto(codigo);
        if (produtoExistente != null) {
            int indice = listaDeProdutos.indexOf(produtoExistente);
            listaDeProdutos.set(indice, produtoNovo);
            System.out.println("Produto atualizado com sucesso");
        }
        else
            System.out.println("Produto nao localizado.");
    }

    public Produto buscarProduto(int codigo) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getIdProduto() == codigo) {
                return produto;
            }
        }
        return null;
    }
    
    public int getTotalProdutos(){
        return this.listaDeProdutos.size();
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Produto produto : listaDeProdutos) {
            saida.append(produto.toString()).append("\n");
        }
        return saida.toString();
    }   
    
     public String toStringPedido() {
        StringBuilder saida = new StringBuilder();
        for (Produto produto : listaDeProdutos) {
            saida.append(produto.toStringPedido()).append("\n");
        }
        return saida.toString();
    }  
   

    public boolean remProduto(int codProduto) {
        for (Produto produto : listaDeProdutos) {
            if (produto.getIdProduto() == codProduto) {
                listaDeProdutos.remove(produto);
                System.out.println("Produto removido!");
                return true;
            }
        }
        System.out.println("Produto não encontrado!");
        return false;
    }
    public void salvarNoArquivo(String pathFile){
         SerializadorJSONProduto  serializadorJSON = new SerializadorJSONProduto();
        String jsonData = serializadorJSON.ToJSON(this.listaDeProdutos);
         FilePersistence filePersistence = new FilePersistence();
         filePersistence.saveToFile(jsonData, pathFile);
         System.out.println("Salvo com sucesso em " + pathFile);
    }
    public void carregarDoArquivo(String pathFile){
        FilePersistence filePersistence = new FilePersistence();
        String jsonData = filePersistence.loadFromFile(pathFile);
        SerializadorJSONProduto desserializadorJson = new SerializadorJSONProduto();
        this.listaDeProdutos = desserializadorJson.fromJSON(jsonData);
        
        System.out.println("Pedidos carregados com sucesso de: " + pathFile);
    }
}