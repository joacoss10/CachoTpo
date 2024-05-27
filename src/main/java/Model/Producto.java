package Model;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private double descuento;
    private String video;
    private String foto;


    public Producto(int id, String nombre, String descripcion, double precio, int stock, double descuento, String video, String foto){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.descuento = descuento;
        this.video = video;
        this.foto = foto;
    }
    public int getStock(){
        return stock;
    }
    public double getPrecio(){
        return precio;
    }
    public double getDescuento(){
        return descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public String getVideo() {
        return video;
    }
}
