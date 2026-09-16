package pe.jllalle.pedidos;

public class DescuentoRegular implements EstrategiaDescuento{
    @Override
    public double calcularDescuento(double total) {
        return 0;
    }
}
