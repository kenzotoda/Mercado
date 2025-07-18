package Main;

import Model.Produto;
import Utilitarios.Utils;

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
        mercado.menu();
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

            if (produtoSelecionado == null) {
                System.out.println("Não existe um produto com esse código!");
                menu();
            }

            System.out.println("Produto selecionado: " + produtoSelecionado.getNome());
            System.out.println("Quantidade: ");
            int quantidade = input.nextInt();

            adicionarProdutoCarrinho(produtoSelecionado, quantidade);

            System.out.println("Produto adicionado ao carrinho!");

            System.out.println("Digite 1 --- Continuar comprando");
            System.out.println("Digite 2 --- Voltar ao menu");
            System.out.println("Digite 3 --- Remover produtos do carrinho");
            System.out.println("Digite 4 --- Finalizar compra");
            int acao = input.nextInt();

            while (acao != 1 && acao != 2 && acao != 3 && acao != 4) {
                System.out.println("Opção inválida!");
                System.out.println("Digite 1 --- Continuar comprando");
                System.out.println("Digite 2 --- Voltar ao menu");
                System.out.println("Digite 3 --- Remover produtos do carrinho");
                System.out.println("Digite 4 --- Finalizar compra");
                acao = input.nextInt();
            }

            if (acao == 1) {
                comprarProdutos();
            } else if (acao == 2) {
                menu();
            } else if (acao == 3) {
                removerProdutos();
            } else {
                finalizarCompra();
            }
        } else {
            System.out.println("Não há produtos cadastrados");
        }

        menu();
    }

    private void verCarrinho() {
        System.out.println("-------Carrinho de compras-------");
        if (carrinho.size() > 0) {
            for (Produto p : carrinho.keySet()) {
                System.out.println("Produto: " + p);
                System.out.println("Quantidade: " + carrinho.get(p) + "\n");
            }
        } else {
            System.out.println("Carrinho vazio!");
        }
        menu();
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

    private void adicionarProdutoCarrinho(Produto produto, int quantidade) {
        if (carrinho.containsKey(produto)) {
            int quantidadeAtual = carrinho.get(produto);
            carrinho.put(produto, quantidadeAtual + quantidade);
        } else {
            carrinho.put(produto, quantidade);
        }
    }

    private void finalizarCompra() {
        double valorTotal = 0.0;
        System.out.println("*************** RECIBO ***************");
        for (Produto p : carrinho.keySet()) {
            System.out.println(p.getNome() + " - " + Utils.doubleToString(p.getPreco()) + " (x " + carrinho.get(p) +
                    ") = " + Utils.doubleToString(p.getPreco() * carrinho.get(p)));

            valorTotal += (p.getPreco() * carrinho.get(p));
        }

        System.out.println("TOTAL: " + Utils.doubleToString(valorTotal));

        carrinho.clear();

        System.out.println("Compra finalizada com sucesso, volte sempre!");

        menu();
    }

    private void removerProdutos() {
        System.out.println("-------Carrinho de compras-------");
        for (Produto p : carrinho.keySet()) {
            System.out.println("Produto: " + p);
            System.out.println("Quantidade: " + carrinho.get(p) + "\n");
        }

        System.out.println("Informe o código do produto que será removido: ");
        int codigoProduto = input.nextInt();

        Produto produtoSelecionado = encontrarProduto(codigoProduto);

        if (produtoSelecionado == null) {
            System.out.println("Não existe um produto com esse código!");
            removerProdutos();
        }

        System.out.println("Produto selecionado: " + produtoSelecionado.getNome());
        System.out.println("Quantidade: ");
        int quantidade = input.nextInt();

        if (carrinho.containsKey(produtoSelecionado)) {

            int quantidadeAtual = carrinho.get(produtoSelecionado);

            if (quantidade < 0 || quantidade > quantidadeAtual) {
                System.out.println("Não é possível remover essa quantidade!");
                removerProdutos();
            } else if (quantidade == quantidadeAtual) {
                carrinho.remove(produtoSelecionado);
            } else {
                carrinho.put(produtoSelecionado, quantidadeAtual - quantidade);
            }

            System.out.println("Produto removido com sucesso!");
        }
    }


}
