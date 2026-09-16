package pe.jllalle.pedidos;

public class NotificadorPedidosGrandes implements Notificador {
    @Override
    public void notificar(Pedido pedido, double total) {
        System.out.println("Notificación PRIORITARIA a " + pedido.getNombreCliente() + ": tu pedido por S/ " + total + " fue procesado.");
    }
}
