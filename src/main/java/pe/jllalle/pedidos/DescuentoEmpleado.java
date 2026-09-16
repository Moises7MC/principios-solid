package pe.jllalle.pedidos;

public class DescuentoEmpleado implements EstrategiaDescuento{

    @Override
    public double calcularDescuento(double total) {
        return total * 0.30;
    }
}
