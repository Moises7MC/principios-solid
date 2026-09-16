package pe.jllalle.pedidos;

public class NotificadorPedidosGrandes implements Notificador {
    @Override
    public void notificar(Pedido pedido, double total) {
        if (total < 100) {
            throw new IllegalStateException("Este notificador no procesa pedidos menores a S/ 100");
        }
        System.out.println("Enviando notificación prioritaria a " + pedido.getNombreCliente() + ": tu pedido por S/ " + total + " fue procesado.");
    }

//    @Override
//    public void notificar(Pedido pedido, double total) {
//        System.out.println("Notificación PRIORITARIA a " + pedido.getNombreCliente() + ": tu pedido por S/ " + total + " fue procesado.");
//    }
}
