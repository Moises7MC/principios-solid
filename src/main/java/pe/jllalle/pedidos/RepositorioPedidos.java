package pe.jllalle.pedidos;

public class RepositorioPedidos {
    public void guardar(Pedido pedido) {
        System.out.println("Guardando pedido de " + pedido.getNombreCliente() + " en la base de datos...");
    }
}
