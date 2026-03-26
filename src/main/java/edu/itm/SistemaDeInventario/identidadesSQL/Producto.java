package edu.itm.SistemaDeInventario.identidadesSQL;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Producto {
    private Integer idProducto;
    private String nomProducto;
    private String DescripcionProducto;
    private Date ingresoProducto;
}
