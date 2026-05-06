package edu.itm.SistemaDeInventario.controllers;

import edu.itm.SistemaDeInventario.identidadesSQL.Proveedor;
import edu.itm.SistemaDeInventario.services.ProveedorServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
@Tag(name = "Proveedores", description = "API para la gestión de proveedores usando JPA")
public class ProveedorController {

    @Autowired
    private ProveedorServices proveedorServices;

    @Operation(
            summary = "lista los proveedores",
            description = "permite realizar una lista de los proveedores que se encuentran en la base de datos y los devuelve como json"
    )
    @GetMapping("/listar")
    public List<Proveedor> listar() {
        return proveedorServices.listarTodo();
    }

    @Operation(
            summary = "Introduce un proveedor nuevo",
            description = "permite introducir un nuevo proveedor a la base de datos"
    )
    @PostMapping("/nuevo")
    public Proveedor guardar(@RequestBody Proveedor proveedor) {
        return proveedorServices.guardar(proveedor);
    }

    @Operation(
            summary = "permite buscar un proveedor por su id",
            description = "permite buscar un proveedor por su id y devuelve el proveedor encontrado como json"
    )
    @GetMapping("/buscar{id}")
    public ResponseEntity<Proveedor> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(proveedorServices.buscarPorId(id));
    }

    @Operation(
            summary = "Actualizar un proveedor",
            description = "Busca un proveedor por su ID y actualiza sus datos (nombre, contacto, teléfono y correo)."
    )
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Proveedor> actualizar(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorServices.actualizar(id, proveedor));
    }

    @Operation(
            summary = "Elimina un proveedor",
            description = "Elimina un proveedor de la base de datos utilizando su ID."
    )
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        proveedorServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}