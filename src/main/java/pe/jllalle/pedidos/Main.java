package pe.jllalle.pedidos;

public class Main {

    public static void main(String[] args){

        Pedido pedido = new Pedido("Juan Pérez");
        pedido.agregarItem(new ItemPedido("Teclado", 45.0, 2));
        pedido.agregarItem(new ItemPedido("Mouse", 25.0, 1));

        GestorPedidos gestor = new GestorPedidos();
        gestor.procesarPedido(pedido);
    }
}
