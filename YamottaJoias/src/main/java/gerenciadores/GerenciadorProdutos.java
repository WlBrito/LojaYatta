/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gerenciadores;

/**
 *
 * @author wbo
 */
import entities.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wbo
 */
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

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (Produto produto : listaDeProdutos) {
            saida.append(produto.ToString()).append("\n");
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
}