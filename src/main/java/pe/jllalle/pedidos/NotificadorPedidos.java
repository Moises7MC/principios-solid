package pe.jllalle.pedidos;

public class NotificadorPedidos {
    public void notificar(Pedido pedido, double total) {
        System.out.println("Enviando email a " + pedido.getNombreCliente() + ": tu pedido por S/ " + total + " fue procesado.");
    }
}
