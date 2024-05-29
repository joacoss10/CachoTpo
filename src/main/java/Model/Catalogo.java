package Model;

public class Catalogo {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private double descuento;
    private String video;
    private String foto;

    public Catalogo(int id, String nombre, String descripcion, double precio, int stock, String video, String foto,double descuento){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.video = video;
        this.foto = foto;
        this.descuento=descuento;
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
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
