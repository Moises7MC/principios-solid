package pe.jllalle.pedidos;

import java.util.ArrayList;
import java.util.List;


public class Pedido {
    private String nombreCliente;
    private List<ItemPedido> items;

    public Pedido(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemPedido item) {
        items.add(item);
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public List<ItemPedido> getItems() {
        return new ArrayList<>(items);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : items) {
            total += item.getSubtotal();
        }
        return total;
    }



}
