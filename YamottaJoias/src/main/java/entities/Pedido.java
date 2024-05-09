/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import gerenciadores.GerenciadorProdutos;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author wbo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pedido {

    private int id_pedido;
    private Cliente cliente;
    private double valor_total;
    private GerenciadorProdutos gerenciadorProdutos;
    private Random gerador;
    

    public Pedido() {
        gerador = new Random();
        this.id_pedido = gerador.nextInt(10000, 20000);
        this.cliente = new Cliente();
        this.gerenciadorProdutos = new GerenciadorProdutos();
        this.valor_total = 0.0;
    }

    public void addCliente(Cliente clienteAdd) {
        this.cliente = new Cliente();
        this.cliente.copiar(cliente);
    }

    public void addProduto(Produto produto) {
        this.gerenciadorProdutos.addProduto(produto);
        this.valor_total += produto.getPrecoProdutoVenda();
    }

    public void removeProduto(int idProduto) {        
        Produto produto_deduzir = this.gerenciadorProdutos.buscarProduto(idProduto);
        this.gerenciadorProdutos.remProduto(idProduto);
        this.valor_total -= produto_deduzir.getPrecoProdutoVenda();
    }

    public Produto pesquisarProduto(int idProduto) {
        return this.gerenciadorProdutos.buscarProduto(idProduto);
    }
    public boolean possuiProdutos(){
        if(this.gerenciadorProdutos.getTotalProdutos() > 0)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        String texto = "--------------- Pedido" + id_pedido + "--------------- \n";
        String textoListaProdutos = this.gerenciadorProdutos.toStringPedido();
        texto += this.getCliente().toString() + "\n";
        texto += textoListaProdutos +"\n";
        return texto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public GerenciadorProdutos getGerenciadorProdutos() {
        return gerenciadorProdutos;
    }

    public void setGerenciadorProdutos(GerenciadorProdutos gerenciadorProdutos) {
        this.gerenciadorProdutos = gerenciadorProdutos;
    }

    public int getId() {
        return id_pedido;
    }

    public double getValor_total() {
        return valor_total;
    }
    
    
}
