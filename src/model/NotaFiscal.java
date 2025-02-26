package model;

import java.text.NumberFormat;
import java.util.List;

public class NotaFiscal {
    private double totalPrice;
    private double totalWithTax;
    private double serviceTax = 0.10;

    public double getTotalWithTax() {
        return totalWithTax;
    }

    public void setTotalWithTax(double totalWithTax) {
        this.totalWithTax = totalWithTax;
    }



    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getServiceTax() {
        return serviceTax;
    }


    public void setServiceTax(double serviceTax) {
        this.serviceTax = serviceTax;
    }


    public void sum(List<Item> pedido) {
        for (Item item : pedido) {
            this.totalPrice += item.getPrice();
        }
    }


    public void exibirNotaFiscal(List<Item> pedido) {
        sum(pedido);
        totalWithTax = totalPrice + (totalPrice * serviceTax);

        System.out.println("---------------------------");
        System.out.println("NOTA FISCAL");
        System.out.println("---------------------------");

        for (Item item : pedido) {
            System.out.println(item.getName() + " - " + item.getPrice());
        }

        NumberFormat percentage = NumberFormat.getPercentInstance();
        percentage.setMinimumFractionDigits(0);
        String serviceTaxFormatted = percentage.format(getServiceTax());

        System.out.println("Taxa de serviço: " + serviceTaxFormatted);
        System.out.println("Total: R$" + totalPrice);
        System.out.println("Total com taxa: R$" + totalWithTax);
        System.out.println("---------------------------");
    }


}
