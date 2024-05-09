/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Random;

/**
 *
 * @author wbo
 */
public class Cliente {

    private int id_cliente;
    private String nome_cliente;
    private String cpf_cliente;
    private String telefone_cliente;
    private Random gerador;

    public Cliente() {
        gerador = new Random();
        this.id_cliente = gerador.nextInt(10000, 20000);
        this.nome_cliente = "";
        this.cpf_cliente = "";
        this.telefone_cliente = "";
    }

    public Cliente(String nome, String cpf, String telefone, int id) {
        this.id_cliente = id;
        this.nome_cliente = nome;
        this.cpf_cliente = cpf;
        this.telefone_cliente = telefone;
    }
    
    public void copiar (Cliente outro){
        this.setCpf_cliente(outro.getCpf_cliente());
        this.setNome_cliente(outro.getNome_cliente());
        this.setTelefone_cliente(outro.getTelefone_cliente());       
        
    }

    @Override
    public String toString() {
        return "Cliente " + id_cliente + "\n{Nome:" + nome_cliente + " || CPF:" +
                cpf_cliente + " || Contato:" + telefone_cliente + "}";
    }
    
    public void imprimir(){
        System.out.println("Cliente:" + id_cliente + "\n{Nome:" + nome_cliente + " || CPF:" + cpf_cliente + " || Contato:" + telefone_cliente + "}");
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }

    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    
    
}
