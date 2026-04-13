package edu.itm.SistemaDeInventario.controllers;

import edu.itm.SistemaDeInventario.identidadesSQL.Producto;
import edu.itm.SistemaDeInventario.services.ProductoServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Productos")
public class ProductoController implements ProductoControllerApi{

    @Autowired
    private ProductoServicesInterface services;

    public ResponseEntity<List<Producto>> getProductos(){
        return new ResponseEntity<>(services.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Integer> insertarProducto(@RequestBody Producto producto){
        return new ResponseEntity<>( services.save(producto), HttpStatus.ACCEPTED);
    }
}