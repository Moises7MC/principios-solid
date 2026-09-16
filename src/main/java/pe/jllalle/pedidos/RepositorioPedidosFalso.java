package pe.jllalle.pedidos;

public class RepositorioPedidosFalso implements RepositorioPedidos {

    private int vecesGuardado = 0;

    @Override
    public void guardar(Pedido pedido) {
        vecesGuardado++;
        System.out.println("[FALSO] No se guardó nada de verdad. Contador: " + vecesGuardado);
    }

    public int getVecesGuardado() {
        return vecesGuardado;
    }
}