package Modelo;

import es.upv.inf.Product;

public class Componente {
    private Product producto;
    private int cantidad;
    
    public Componente(Product producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /**
     * @return the producto
     */
    public Product getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Product producto) {
        this.producto = producto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
