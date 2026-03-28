package edu.itm.SistemaDeInventario.identidadesSQL;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    private String nomProducto;

    private String DescripcionProducto;

    @Temporal(TemporalType.DATE)
    private Date ingresoProducto;
}