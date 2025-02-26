package model;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<Item> itens;

    public Cardapio() {
        this.itens = new ArrayList<>();

    }

    public List<Item> getItens() {
        return itens;
    }

    private void addItem(Item item) {
        getItens().add(item);
    }

    public static Cardapio createCardapio(){
        Cardapio cardapio = new Cardapio();
        cardapio.addItem(new Item(1, "Mojito", "Rum branco, folhas de hortelã, açúcar, suco de limão, água com gás, gelo.", 18.00));
        cardapio.addItem(new Item(2, "X-Burguer", "Pão de hambúrguer, hambúrguer de carne bovina, queijo mussarela, alface, tomate, maionese.", 18.00));
        cardapio.addItem(new Item(3, "X-Bacon", "Pão de hambúrguer, hambúrguer de carne bovina, queijo mussarela, bacon frito, alface, tomate, maionese.", 22.00));
        cardapio.addItem(new Item(4, "Hambúrguer Vegano", "Pão de hambúrguer, hambúrguer vegano (feito com grãos, lentilhas, feijão ou soja), alface, tomate, cebola roxa, molho vegano (ex: maionese vegana ou molho de mostarda e mel vegano).", 20.00));
        cardapio.addItem(new Item(5, "Suco Natural de Laranja (300 ml)", "Laranjas frescas, água (opcional), açúcar (opcional).", 8.00));
        cardapio.addItem(new Item(6, "Suco Natural de Laranja (500 ml)", "Laranjas frescas, água (opcional), açúcar (opcional).", 9.50));
        return cardapio;
    }
}
