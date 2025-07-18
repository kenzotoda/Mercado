package Model;

import Utilitarios.Utils;

public class Produto {

    private static int contadorDeContas = 1;

    private int id;
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.id = contadorDeContas;
        this.nome = nome;
        this.preco = preco;
        contadorDeContas += 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String toString() {
        return
        "\nId: " + this.getId() +
        "\nNome: " + this.getNome() +
        "\nPreço: " + Utils.doubleToString(this.getPreco());
    }
}
