package entities;
import java.util.Random;


public class Produto {

    protected int idProduto;
    protected String nomeProduto;
    protected int qtdProduto;
    protected double precoProdutoVenda;
    protected double precoProdutoCusto;
    protected Random geradorId;

    public Produto() {
        
        //ID/NOME/ESTOQUE/PVENDA/PCUSTO
        geradorId = new Random();
        this.idProduto = geradorId.nextInt(10000, 30000);
        this.nomeProduto = "";
        this.qtdProduto = 0;
        this.precoProdutoVenda = 0.0;
        this.precoProdutoCusto = 0.0;
    }

    public Produto(String nomeProduto, int qtdProduto, double precoProdutoVenda, double precoProdutoCusto, int idProduto) {        
        this.nomeProduto = nomeProduto;
        this.qtdProduto = qtdProduto;
        this.precoProdutoVenda = precoProdutoVenda;
        this.precoProdutoCusto = precoProdutoCusto;
        this.idProduto = idProduto;
    }

    public void ImprimirProduto() {
        System.out.println("Info Produto " + idProduto);
        System.out.println("Nome:" + nomeProduto);
        System.out.println("Em estoque:" + qtdProduto + "\nPreco de venda:" + precoProdutoVenda);
        System.out.println("\nPreco de custo:" + precoProdutoCusto + "\nLucro por unidade:" + (precoProdutoVenda - precoProdutoCusto));
    }
    @Override
    public String toString() {
        return "Info Produto " + idProduto + "\n{Nome: " + nomeProduto + " || Em estoque:" + qtdProduto
                + " || Preco de venda:" + precoProdutoVenda + " || Preco de custo:" + precoProdutoCusto
                + " || Lucro por unidade:" + (precoProdutoVenda - precoProdutoCusto) + "}\n";
    }
    public String toStringPedido(){
        return "Info Produto" + idProduto + "\nProduto: " + nomeProduto + " || Preço: " + precoProdutoVenda;
    }

    public void setPrecoProdutoCusto(double precoProdutoCusto) {
        this.precoProdutoCusto = precoProdutoCusto;
    }

    public double getPrecoProdutoCusto() {
        return precoProdutoCusto;
    }

    public void setPrecoProdutoVenda(double precoProdutoVenda) {
        this.precoProdutoVenda = precoProdutoVenda;
    }

    public double getPrecoProdutoVenda() {
        return precoProdutoVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

}
