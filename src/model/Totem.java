package model;

import java.util.Scanner;

public class Totem {
    private Cliente cliente;
    private Pedido pedido;

    Scanner scanner = new Scanner(System.in);

    public enum options {
        fazerPedido,
        sair
    }


    public void start() {
        System.out.println("Bem vindo ao Totem");
        System.out.println("Escolha uma opção para continuar:");
        System.out.println("1 - Fazer pedido");
        System.out.println("2 - Sair");

        System.out.print("> ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        options selected = null;

        switch (choice) {
            case 1:
                selected = options.fazerPedido;
                System.out.println("Você está pronto para escolher o pedido");
                fazerPedido();
                break;
            case 2:
                selected = options.sair;
                System.out.println("Tudo bem. Até mais tarde!");
                break;
            default:
                System.out.println("Não entendi. Escolha novamente!");
                break;
        }
    }

    private void fazerPedido(){
        System.out.println("Primeiro, nos diga seu nome ou apelido :)");
        System.out.print("> ");
        String name = scanner.nextLine();

        criarCliente(name);
        System.out.println("Perfeito, "+cliente.getNome()+ ", aqui está o cardápio:");
        exibirCardapio();


    }

    private void exibirCardapio() {
        Cardapio cardapio = Cardapio.createCardapio();
        System.out.println("---------------------------");
        System.out.println("CARDÁPIO");
        System.out.println("---------------------------");
        for (Item item : cardapio.getItens()) {
            System.out.println(item.getId() + " - " + item.getName() + " - R$" + item.getPrice());
            System.out.println(item.getDescription());
            System.out.println("---------------------------");
        }

        System.out.println(" ");

        int i = 0;

        criarPedido();
        while (i <= 0) {
            System.out.println(" Escolha os itens do cardápio ");
            System.out.println(" Para finalizar, selecione 0: ");
            System.out.print("> ");

            String numInput = scanner.nextLine();
            int num = Integer.parseInt(numInput);

            if (num != 0) {
                pedido.addItem(buscarItemPorId(cardapio, num));
            } else {
                i+=1;
            }

            }
        System.out.println(" ");
        System.out.println(" Ok ");
        System.out.println("Preparando seu pedido...");
        pedido.finalizarPedido();
        pagar();
        }

    private void criarCliente(String name){
        cliente = new Cliente();
        cliente.setNome(name);
    }

    private void criarPedido(){
        pedido = new Pedido();
    }

    private Item buscarItemPorId(Cardapio cardapio, int id) {
        for (Item item : cardapio.getItens()) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void pagar() {
        System.out.println("Insira o valor a pagar:");
        System.out.print("> ");

        String valueInput = scanner.nextLine();
        double value = Double.parseDouble(valueInput);
        pedido.setPayment(value);
        pedido.sumReturn();
        System.out.println(" ");

        System.out.println("Seu troco é de R$"+pedido.getReturnValue());
        System.out.print("Obrigada pela preferência. Volte sempre :)");
    }



}
