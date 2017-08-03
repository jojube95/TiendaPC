package Modelo;

import es.upv.inf.Product;

public class Componente {
    private Product producto;
    private int cantidad;
    
    public Componente(Product producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }
    public Product getProducto() {
        return producto;
    }
    public void setProducto(Product producto) {
        this.producto = producto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
