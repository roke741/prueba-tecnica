package com.pruebatecnica.sistemafacturacion.controladores;

import com.pruebatecnica.sistemafacturacion.daos.CabeceraComprobanteDAO;
import com.pruebatecnica.sistemafacturacion.daos.DetalleComprobanteDAO;
import com.pruebatecnica.sistemafacturacion.entidades.CabeceraComprobante;
import com.pruebatecnica.sistemafacturacion.entidades.DetalleComprobante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cabeceras")
public class CabeceraComprobanteController {

    @Autowired
    private CabeceraComprobanteDAO cabeceraComprobanteDAO;

    @GetMapping
    public List<CabeceraComprobante> obtenerCabecerasComprobante() {
        return cabeceraComprobanteDAO.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CabeceraComprobante> obtenerCabeceraComprobantePorId(@PathVariable Integer id){
        CabeceraComprobante cabecera = cabeceraComprobanteDAO.findById(id)
                .orElse(null);
        return ResponseEntity.ok(cabecera);
    }

    @PostMapping
    public CabeceraComprobante crearCabeceraComprobante(@RequestBody CabeceraComprobante cabecera) {
        return cabeceraComprobanteDAO.save(cabecera);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CabeceraComprobante> actualizarCabeceraComprobante(@PathVariable Integer id, @RequestBody CabeceraComprobante cabeceraActualizada) {
        CabeceraComprobante cabecera = cabeceraComprobanteDAO.findById(id)
                .orElse(null);
        if (cabecera != null){
            cabecera.setFecha(cabeceraActualizada.getFecha());
            cabecera.setCliente(cabeceraActualizada.getCliente());
            cabecera.setTotal(cabeceraActualizada.getTotal());
            CabeceraComprobante cabeceraUpdate = cabeceraComprobanteDAO.save(cabecera);
            return ResponseEntity.ok(cabeceraUpdate);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCabeceraComprobante(@PathVariable Integer id) {
        cabeceraComprobanteDAO.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
