package pe.jllalle.pedidos;

public class GestorPedidos {

    private RepositorioPedidos repositorio = new RepositorioPedidos();
    private NotificadorPedidos notificador = new NotificadorPedidos();

    public void procesarPedido(Pedido pedido) {
        double total = pedido.calcularTotal();
        System.out.println("Total del pedido: S/ " + total);

        repositorio.guardar(pedido);
        notificador.notificar(pedido, total);
    }
}

