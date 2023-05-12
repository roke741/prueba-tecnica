package com.pruebatecnica.sistemafacturacion.daos;

import com.pruebatecnica.sistemafacturacion.entidades.CabeceraComprobante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabeceraComprobanteDAO extends JpaRepository<CabeceraComprobante, Integer> {
}
