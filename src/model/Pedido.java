package model;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Item> pedido;
    private NotaFiscal notaFiscal;
    private double payment;
    private double returnValue;

    public double getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(double returnValue) {
        this.returnValue = returnValue;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Pedido() {
        this.pedido = new ArrayList<>();
    }

    public List<Item> getPedido() {
        return pedido;
    }

    public void setPedido(List<Item> pedido) {
        this.pedido = pedido;
    }

    public void addItem(Item item) {
        this.pedido.add(item);
    }

    public void createNotaFiscal() {
        this.notaFiscal = new NotaFiscal();
    }

    public double sumReturn() {
        System.out.println("Pagamento inserido: " + getPayment());
        System.out.println("Total com taxa: " + this.notaFiscal.getTotalWithTax());

        double troco = getPayment() - this.notaFiscal.getTotalWithTax();
        System.out.println("Troco antes da atribuição: " + troco);

        setReturnValue(troco);
        System.out.println("Troco armazenado: " + getReturnValue());

        return getReturnValue();
    }


    public void finalizarPedido(){
        createNotaFiscal();
        this.notaFiscal.exibirNotaFiscal(pedido);
    }

}
