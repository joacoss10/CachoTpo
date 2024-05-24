package Model;

import java.util.ArrayList;

public class Carrito {
    private float descuento;
    private float total;
    private Pedido pedido;
    private Cliente cliente;
    private ArrayList<Producto> productos;

    public Carrito(float descuento, float total,Cliente cliente){
        this.descuento=descuento;
        this.total=total;
        this.cliente=cliente;
    }

    public void AgregarProducto(int idProducto,int cant){

    }

    public void EliminarProducto(int idProducto,int cant){

    }

    public void ActualizarCantidad(int cant){

    }

    public void GenerarPedido(){
        AplicarDescuento(this.descuento);
        CalcularTotal();
        //this.pedido=new Pedido(this.cliente.getDni(),);

    }
    private void AplicarDescuento(float descuento){

    }

    private void CalcularTotal() {
    }

}


