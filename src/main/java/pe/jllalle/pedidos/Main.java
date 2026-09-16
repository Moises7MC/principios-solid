package pe.jllalle.pedidos;

public class Main {

    public static void main(String[] args){

        Pedido pedido = new Pedido("Juan Pérez");
        pedido.agregarItem(new ItemPedido("Teclado", 50.0, 2));
        pedido.agregarItem(new ItemPedido("Mouse", 25.0, 1));

        GestorPedidos gestor = new GestorPedidos();
        gestor.procesarPedido(pedido,new DescuentoEmpleado());

        //NOTIFICAR AL EMPLEADOS
        Notificador[] notificadores = {
                new NotificadorPedidos(),
                new NotificadorPedidosGrandes()
        };

        for (Notificador n : notificadores) {
            n.notificar(pedido, 50.0);
        }

    }
}
