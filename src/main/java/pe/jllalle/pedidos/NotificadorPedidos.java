package pe.jllalle.pedidos;

public class NotificadorPedidos implements Notificador,GeneradorFactura {

    @Override
    public void notificar(Pedido pedido, double total) {
        System.out.println("Enviando email a " + pedido.getNombreCliente() + ": tu pedido por S/ " + total + " fue procesado.");
    }

    @Override
    public void generarFacturaPDF(Pedido pedido) {
        System.out.println("Generando factura PDF para " + pedido.getNombreCliente() + "...");
    }
}
