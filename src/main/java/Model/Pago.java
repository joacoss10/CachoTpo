package Model;

public class Pago {
    private MetodoDePago formaPago;
    private  String fecha;
    private float monto;
    private String hora;

    public Pago(MetodoDePago formaPago, float monto, String fecha, String hora) {
        this.formaPago = formaPago;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
    }

}
