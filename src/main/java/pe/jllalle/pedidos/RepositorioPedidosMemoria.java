package pe.jllalle.pedidos;

public class RepositorioPedidosMemoria implements RepositorioPedidos{
    @Override
    public void guardar(Pedido pedido) {
        System.out.println("Guardando pedido de " + pedido.getNombreCliente() + " en la base de datos...");
    }
}