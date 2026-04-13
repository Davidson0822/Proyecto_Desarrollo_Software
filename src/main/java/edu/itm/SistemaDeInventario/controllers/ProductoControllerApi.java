package edu.itm.SistemaDeInventario.controllers;

import edu.itm.SistemaDeInventario.identidadesSQL.Producto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @PostMapping("/nuevo")
    ResponseEntity<Integer> insertarProducto(@RequestBody Producto estudiante);
}