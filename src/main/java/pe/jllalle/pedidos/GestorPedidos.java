package pe.jllalle.pedidos;

public class GestorPedidos {

    private final RepositorioPedidos repositorio;

    public GestorPedidos(RepositorioPedidos repositorio) {
        this.repositorio = repositorio;
    }

    public void procesarPedido(Pedido pedido, EstrategiaDescuento estrategiaDescuento) {
        double subtotal = pedido.calcularTotal();
        double descuento = estrategiaDescuento.calcularDescuento(subtotal);
        double total = subtotal - descuento;

        System.out.println("Subtotal: S/ " + subtotal);
        System.out.println("Descuento: S/ " + descuento);
        System.out.println("Total a pagar: S/ " + total);

        repositorio.guardar(pedido);

        Notificador notificador = elegirNotificador(total);
        notificador.notificar(pedido, total);

        if (notificador instanceof GeneradorFactura generador) {
            generador.generarFacturaPDF(pedido);
        }
    }

    private Notificador elegirNotificador(double total) {
        if (total >= 100) {
            return new NotificadorPedidosGrandes();
        }
        return new NotificadorPedidos();
    }
}