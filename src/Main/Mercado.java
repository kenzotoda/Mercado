package Main;

import Model.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mercado {

    private Scanner input = new Scanner(System.in);
    private ArrayList<Produto> produtos = new ArrayList<>();
    private Map<Produto, Integer> carrinho = new HashMap<>();

    public static void main(String[] args) {
        Mercado mercado = new Mercado();
        menu();
    }

    public void menu() {

        System.out.println("------------------------------------------------------");
        System.out.println("--------------Welcome to Kenzo's Market--------------");
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
                cadastarProdutos();
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
        
    }

}
