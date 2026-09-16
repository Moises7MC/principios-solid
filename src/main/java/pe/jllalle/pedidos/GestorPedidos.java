package pe.jllalle.pedidos;

public class GestorPedidos {

    private RepositorioPedidos repositorio = new RepositorioPedidos();
    private NotificadorPedidos notificador = new NotificadorPedidos();

    public void procesarPedido(Pedido pedido, EstrategiaDescuento estrategiaDescuento) {
        double subtotal = pedido.calcularTotal();
        double descuento = estrategiaDescuento.calcularDescuento(subtotal);
        double total = subtotal - descuento;

        System.out.println("Subtotal: S/ " + subtotal);
        System.out.println("Descuento: S/ " + descuento);
        System.out.println("Total a pagar: S/ " + total);

        repositorio.guardar(pedido);
        notificador.notificar(pedido, total);
    }

}

