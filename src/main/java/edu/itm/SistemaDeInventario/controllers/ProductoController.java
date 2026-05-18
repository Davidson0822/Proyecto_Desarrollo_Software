package edu.itm.SistemaDeInventario.controllers;

import edu.itm.SistemaDeInventario.identidadesSQL.Producto;
import edu.itm.SistemaDeInventario.services.ProductoServicesInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Tag(name = "Productos", description = "Esta es la API que controla los productos que se manejan en el inventario")
public class ProductoController implements ProductoControllerApi{

    @Autowired

    private ProductoServicesInterface services;


    @Operation(summary = "Obtener lista de productos")
    public ResponseEntity<List<Producto>> getProductos(){
        return new ResponseEntity<>(services.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Buscar producto por ID")
    public ResponseEntity<Producto> findById(int id){
        Producto producto = services.findById(id);
        return ResponseEntity.ok(producto);
    }

    @Operation(summary = "Agregar un nuevo producto")
    public ResponseEntity<Integer> insertarProducto(@RequestBody Producto producto){
        return new ResponseEntity<>( services.save(producto), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Actualizar un producto")
    public ResponseEntity<Integer> actualizarProducto(@PathVariable int id, @RequestBody Producto producto){
        producto.setIdProducto(id); // Asumiendo que el ID viene del path
        return new ResponseEntity<>(services.update(producto), HttpStatus.OK);
    }

    @Operation(summary = "Eliminar un producto")
    public ResponseEntity<Integer> eliminarProducto(@PathVariable int id){
        return new ResponseEntity<>(services.delete(id), HttpStatus.OK);
    }
}

