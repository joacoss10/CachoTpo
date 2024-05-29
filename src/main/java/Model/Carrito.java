package Model;

import java.util.ArrayList;

public class Carrito {
    private float descuento;
    private float total;
    private Pedido pedido;
    private Usuario cliente;
    private ArrayList<Catalogo> productos;

    public Carrito(Usuario cliente){
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


