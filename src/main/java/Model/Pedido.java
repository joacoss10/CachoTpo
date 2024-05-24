package Model;

public class Pedido {
    private int idPedido;
    private int datosCliente;
    private String cadaArticulo;
    private String cadaArticuloCantidad;
    private String cadaArticuloPrecio;
    private String cadaArticuloDescuento;
    private float valorFinal;
   private Factura factura;

    public Pedido( int datosCliente, String cadaArticulo, String cadaArticuloCantidad, String cadaArticuloPrecio, String cadaArticuloDescuento, float valorFinal){
        //this.idPedido=idPedido;
        this.datosCliente=datosCliente;
        this.cadaArticulo=cadaArticulo;
        this.cadaArticuloCantidad=cadaArticuloCantidad;
        this.cadaArticuloPrecio=cadaArticuloPrecio;
        this.cadaArticuloDescuento=cadaArticuloDescuento;
        this.valorFinal=valorFinal;
        this.factura=factura;
    }


    public void finalizarPedido(){

    }
}
