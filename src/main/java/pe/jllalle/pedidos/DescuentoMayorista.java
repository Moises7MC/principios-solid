package pe.jllalle.pedidos;

public class DescuentoMayorista implements EstrategiaDescuento {

    @Override
    public double calcularDescuento(double total) {
        return total * 0.20;
    }
}

