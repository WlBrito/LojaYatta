/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import entities.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wbo
 */
public class SerializadorCSVProduto {
    public String toCSV(List<Produto> lista_de_produtos){
        String csv = "Id;Nome;Estoque;Pvenda;Pcusto;\n";
        for(Produto produto : lista_de_produtos){
            csv += produto.getIdProduto() + ";"
                    + produto.getNomeProduto() + ";"
                    + produto.getQtdProduto() + ";"
                    + produto.getPrecoProdutoVenda() + ";"
                    + produto.getPrecoProdutoCusto() + ";\n";
        }
        return csv;
    }
    
    public List <Produto> fromCSV(String data){
        List <Produto> lista_de_produtos = new ArrayList<>();
        String[] linhas = data.split("\n");
        for(int i = 1; i < linhas.length; i ++){
            String [] partes = linhas[i].split(";");
            if(partes.length >=5)
            {
                //ID/NOME/ESTOQUE/PVENDA/PCUSTO
                Produto produto = new Produto();
                produto.setIdProduto(Integer.parseInt(partes[0]));
                produto.setNomeProduto(partes[1]);
                produto.setQtdProduto(Integer.parseInt(partes[2]));
                produto.setPrecoProdutoVenda(Double.parseDouble(partes[3]));
                produto.setPrecoProdutoCusto(Double.parseDouble(partes[4]));
                lista_de_produtos.add(produto);
            }
        }
        return lista_de_produtos;
    }
}
