package edu.itm.SistemaDeInventario.controllers;

import edu.itm.SistemaDeInventario.identidadesSQL.Producto;
import edu.itm.SistemaDeInventario.services.ProductoServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Controller
public class VistaController{

    @Autowired
    private ProductoServicesInterface services;

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/inventario")
    public String inventario(Model model) {
        model.addAttribute("productos", services.findAll());
        return "inventario";
    }

    // FORM AGREGAR
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("producto", new Producto());
        return "agregar";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(
                          @RequestParam String nomProducto,
                          @RequestParam String descripcionProducto
    ) {

        Instant fecha = Instant.now();

        Producto producto = new Producto();
        int idProducto = 10000;
        producto.setIdProducto(idProducto);
        producto.setNomProducto(nomProducto);
        producto.setDescripcionProducto(descripcionProducto);
        producto.setIngresoProducto(Date.from(fecha));

        services.save(producto);

        return "redirect:/inventario";
        }

    // EDITAR FORM
    @GetMapping("/inventario/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        model.addAttribute("producto", services.findById(id));
        return "editar";
    }

    // ACTUALIZAR
    @PostMapping("/inventario/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute Producto producto){
        producto.setIdProducto(id);
        services.update(producto);
        return "redirect:/inventario";
    }

    // ELIMINAR
    @GetMapping("/inventario/eliminar/{id}")
    public String eliminar(@PathVariable int id){
        services.delete(id);
        return "redirect:/inventario";
    }

    // DETALLE
    @GetMapping("/inventario/detalle/{id}")
    public String detalle(@PathVariable int id, Model model){
        model.addAttribute("producto", services.findById(id));
        return "detalle";
    }
}
