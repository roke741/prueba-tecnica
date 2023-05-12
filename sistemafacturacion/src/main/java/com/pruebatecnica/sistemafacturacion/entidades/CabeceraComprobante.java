package com.pruebatecnica.sistemafacturacion.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cabecera_comprobante")
public class CabeceraComprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCabecera;
    private String fecha;
    private String cliente;
    private double total;

    public CabeceraComprobante() {
    }

    public CabeceraComprobante(int idCabecera, String fecha, String cliente, double total) {
        this.idCabecera = idCabecera;
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = total;
    }

    public int getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(int idCabecera) {
        this.idCabecera = idCabecera;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
