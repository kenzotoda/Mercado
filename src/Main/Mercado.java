package Main;

import Model.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mercado {

    private Scanner input = new Scanner(System.in);
    private ArrayList<Produto> produtos = new ArrayList<>();
    private Map<Produto, Integer> carrinho = new HashMap<>(); // array chave-valor

    public static void main(String[] args) {
        Mercado mercado = new Mercado();
        menu();
    }

    public void menu() {

        System.out.println("------------------------------------------------------");
        System.out.println("---------------Welcome to Kenzo's Market--------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Cadastrar     |");
        System.out.println("|   Opção 2 - Listar        |");
        System.out.println("|   Opção 3 - Comprar       |");
        System.out.println("|   Opção 4 - Carrinho      |");
        System.out.println("|   Opção 5 - Sair          |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                cadastrarProdutos();
                break;
            case 2:
                listarProdutos();
                break;
            case 3:
                comprarProdutos();
                break;
            case 4:
                verCarrinho();
                break;
            case 5:
                System.out.println("Até mais, Obrigado!");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                menu();
                break;
        }
    }

    private void cadastrarProdutos() {
        System.out.println("Nome do produto: ");
        String nome = input.next();

        System.out.println("Preço do produto: ");
        Double preco = input.nextDouble();

        Produto produto = new Produto(nome, preco);
        produtos.add(produto);

        System.out.println("Produto cadastrado com sucesso!");
        menu();
    }

    private void listarProdutos() {
        if (produtos.size() > 0) {
            for (Produto produto : produtos) {
                System.out.println(produto + "\n");
            }
        } else {
            System.out.println("Não há produtos cadastrados");
        }

        menu();
    }

    private void comprarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("---------------Produtos disponíveis--------------");
            for (Produto produto : produtos) {
                System.out.println(produto + "\n");
            }

            System.out.println("Informe o código do produto desejado: ");
            int codigoProduto = input.nextInt();

            Produto produtoSelecionado = encontrarProduto(codigoProduto);
            System.out.println("Produto selecionado: " + produtoSelecionado.getNome());
            System.out.println("Quantidade: ");
            int quantidade = input.nextInt();





        } else {
            System.out.println("Não há produtos cadastrados");
            menu();
        }
    }

    private Produto encontrarProduto(int codigo) {
        Produto produto = null;
        for (Produto p : produtos) {
            if (p.getId() == codigo) {
                 produto = p;
            }
        }
        return produto;
    }




}
