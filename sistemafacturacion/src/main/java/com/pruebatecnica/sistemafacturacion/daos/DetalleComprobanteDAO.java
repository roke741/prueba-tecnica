package com.pruebatecnica.sistemafacturacion.daos;

import com.pruebatecnica.sistemafacturacion.entidades.DetalleComprobante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleComprobanteDAO extends JpaRepository<DetalleComprobante, Integer> {
}
