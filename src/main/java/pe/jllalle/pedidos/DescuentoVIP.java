package pe.jllalle.pedidos;

public class DescuentoVIP implements EstrategiaDescuento {

    @Override
    public double calcularDescuento(double total) {
        return total * 0.10;
    }
}

