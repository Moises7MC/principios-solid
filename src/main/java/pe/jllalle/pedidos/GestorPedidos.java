package pe.jllalle.pedidos;

public class GestorPedidos {

    public void procesarPedido(Pedido pedido) {
        double total = pedido.calcularTotal();

        System.out.println("Total del pedido: S/ " + total);

        System.out.println("Guardando pedido de " + pedido.getNombreCliente() + " en la base de datos...");

        System.out.println("Enviando email a " + pedido.getNombreCliente() + ": tu pedido por S/ " + total + " fue procesado.");

    }
}
