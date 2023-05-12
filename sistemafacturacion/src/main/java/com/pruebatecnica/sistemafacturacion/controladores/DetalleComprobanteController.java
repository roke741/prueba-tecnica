package com.pruebatecnica.sistemafacturacion.controladores;

import com.pruebatecnica.sistemafacturacion.daos.DetalleComprobanteDAO;
import com.pruebatecnica.sistemafacturacion.entidades.DetalleComprobante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
public class DetalleComprobanteController {

    @Autowired
    private DetalleComprobanteDAO detalleComprobanteDAO;

    @GetMapping
    public List<DetalleComprobante> obtenerDetallesComprobate(){
        return detalleComprobanteDAO.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetalleComprobante> obtenerDetallesComprobantePorId(@PathVariable Integer id){
        DetalleComprobante detalle = detalleComprobanteDAO.findById(id)
                .orElse(null);
        return ResponseEntity.ok(detalle);
    }

    @PostMapping
    public DetalleComprobante crearDetallesComprobantes(@RequestBody DetalleComprobante detalleComprobante){
        return detalleComprobanteDAO.save(detalleComprobante);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DetalleComprobante> actualizarDetalleComprobante(@PathVariable Integer id, @RequestBody DetalleComprobante detalleComprobanteActualizado) {
        DetalleComprobante detalleComprobante = detalleComprobanteDAO.findById(id)
                .orElse(null);

        if (detalleComprobante != null) {
            detalleComprobante.setCabeceraComprobante(detalleComprobanteActualizado.getCabeceraComprobante());
            detalleComprobante.setProducto(detalleComprobanteActualizado.getProducto());
            detalleComprobante.setCantidad(detalleComprobanteActualizado.getCantidad());
            detalleComprobante.setPrecio(detalleComprobanteActualizado.getPrecio());

            DetalleComprobante detalleComprobanteUpdate = detalleComprobanteDAO.save(detalleComprobante);
            return ResponseEntity.ok(detalleComprobanteUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalleComprobante(@PathVariable Integer id) {
        detalleComprobanteDAO.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
