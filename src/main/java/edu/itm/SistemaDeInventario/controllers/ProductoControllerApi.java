package edu.itm.SistemaDeInventario.controllers;

import edu.itm.SistemaDeInventario.identidadesSQL.Producto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface ProductoControllerApi{
    @Operation(
            tags = {"Producto"},
            summary = "trae la lista de productos de la base de datos",
            description = "permite consultar los productos y los devuelve como json",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "ejecuta",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = Producto.class))
                            })
            }
    )
    @GetMapping("/listar")
    ResponseEntity<List<Producto>> getProductos();

    @Operation(
        tags = {"Producto"},
        summary = "Busque un producto en especifico",
        description = "Permite Buscar un producto especifico",
        responses = {
                @ApiResponse(responseCode = "200", description = "Busqueda realizada correctamente",
                        content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Producto.class))}),
                @ApiResponse(responseCode = "404", description = "No se encontro el producto")
        }
    )
    @GetMapping("/{id}")
    ResponseEntity<Producto> findById(@PathVariable int id);

    @Operation(
        tags = {"Producto"},
        summary = "Inserta un nuevo producto",
        description = "Permite insertar un nuevo producto en la base de datos",
        responses = {
            @ApiResponse(responseCode = "201", description = "Producto creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
        }
    )
    @PostMapping("/nuevo")
    ResponseEntity<Integer> insertarProducto(@RequestBody Producto estudiante);

    @Operation(
        tags = {"Producto"},
        summary = "Actualizar un producto existente",
        description = "Permite actualizar un producto por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
        }
    )
    @PutMapping("/{id}")
    ResponseEntity<Integer> actualizarProducto(@PathVariable int id, @RequestBody Producto producto);

    @Operation(
        tags = {"Producto"},
        summary = "Eliminar un producto",
        description = "Permite eliminar un producto por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Producto eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
        }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Integer> eliminarProducto(@PathVariable int id);
}