package com.pruebatecnica.sistemafacturacion.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_comprobante")
public class DetalleComprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalle;
    @ManyToOne
    @JoinColumn(name = "id_cabecera")
    private CabeceraComprobante cabeceraComprobante;
    private String producto;
    private int cantidad;
    private double precio;

    public DetalleComprobante() {
    }

    public DetalleComprobante(int idDetalle, CabeceraComprobante cabeceraComprobante, String producto, int cantidad, double precio) {
        this.idDetalle = idDetalle;
        this.cabeceraComprobante = cabeceraComprobante;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public CabeceraComprobante getCabeceraComprobante() {
        return cabeceraComprobante;
    }

    public void setCabeceraComprobante(CabeceraComprobante cabeceraComprobante) {
        this.cabeceraComprobante = cabeceraComprobante;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
