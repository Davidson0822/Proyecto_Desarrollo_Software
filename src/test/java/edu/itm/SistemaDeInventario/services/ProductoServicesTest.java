package edu.itm.SistemaDeInventario.services;

import edu.itm.SistemaDeInventario.identidadesSQL.Producto;
import edu.itm.SistemaDeInventario.repositorios.IProductoDAO;
import edu.itm.SistemaDeInventario.repositorios.ProductoDAOImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProductoServicesTest {

    @Mock
    ProductoDAOImpl productoDAO;

    @InjectMocks
    private ProductoServices productoServices;

    private List<Producto> productoList;


    @BeforeEach
    void SetUp() {
        productoList = List.of(
                Producto.builder()
                        .idProducto(1)
                        .nomProducto("Monitor")
                        .build(),
                Producto.builder()
                        .idProducto(2)
                        .nomProducto("Mouse")
                        .build(),
                Producto.builder()
                        .idProducto(3)
                        .nomProducto("Teclado")
                        .build(),
                Producto.builder()
                        .idProducto(4)
                        .nomProducto("Speakers")
                        .build());
    }

    @Test
    void EncontrarTodosLosProductosCon_FindAll() {

        when(productoDAO.findAll()).thenReturn(productoList);

        List<Producto> result = productoServices.findAll();

        assertEquals("Monitor", result.get(0).getNomProducto());
        assertEquals(2, result.get(1).getIdProducto());

        verify(productoDAO).findAll();
    }

    @Test
    void EncontrarProductoEnEspecificoPorId() {

        Producto producto = Producto.builder()
                .idProducto(1)
                .nomProducto("Monitor")
                .build();

        when(productoDAO.findById(1)).thenReturn(producto);

        Producto result = productoServices.findById(1);

        assertNotNull(result);
        assertEquals(1, result.getIdProducto());
        assertEquals("Monitor", result.getNomProducto());

        verify(productoDAO).findById(1);
    }

    @Test
    void GuardarUnNuevoProductoPor_save() {
        Producto producto = Producto.builder()
                .idProducto(5)
                .nomProducto("Gabinete")
                .descripcionProducto("Gabinete que contiene componentes de la pc")
                .build();

        when(productoDAO.save(any(Producto.class))).thenReturn(1);
        //el 1 se retorna cuando el que se inserta es verdadero

        int result = productoServices.save(producto);

        assertEquals(1, result);

        verify(productoDAO).save(producto);
    }

    @Test
    void CuandoEncuentraProductoYHace_update() {
        Producto pExistente = Producto.builder()
                .idProducto(2)
                .nomProducto("Mouse")
                .build();

        Producto pActualizado = Producto.builder()
                .idProducto(2)
                .nomProducto("Mouse gamer")
                .build();

        when(productoDAO.findById(2)).thenReturn(pExistente);
        when(productoDAO.update(any(Producto.class))).thenReturn(1);
        //el 1 se retorna cuando actualizar es verdadero


        int result = productoServices.update(pExistente);

        assertEquals(1, result);

        verify(productoDAO).update(pExistente);
    }

//    @Test
//    void CuandoNOEncuentraProductoYHace_update() {
//
//        when(productoDAO.findById(1)).thenReturn(null);
//
//        Producto nuevo = new Producto();
//
//        assertThrows(RuntimeException.class, () -> {
//            productoServices.update(nuevo);
//        });
//
//        verify(productoDAO).findById(1);
//        verify(productoDAO, never()).update(any());
//    }

    @Test
    void CuandoEncuentraProductoYHace_delete() {
        Producto pExistente = Producto.builder()
                .idProducto(3)
                .nomProducto("Teclado")
                .build();

        when(productoDAO.findById(3)).thenReturn(pExistente);
        when(productoDAO.delete(3)).thenReturn(1);
        //el 1 se retorna cuando el que el borrado fue exitoso

        int result = productoServices.delete(3);

        assertEquals(1, result);

        verify(productoDAO).findById(3);
        verify(productoDAO).delete(3);
    }

//    @Test
//    void CuandoNOEncuentraProductoYHacedelete() {
//
//        when(productoDAO.findById(1)).thenReturn(null);
//        //el 1 se retorna cuando el que el borrado fue exitoso
//
//        assertThrows(RuntimeException.class, () -> {
//            productoServices.delete(1);
//        });
//
//        verify(productoDAO).findById(1);
//        verify(productoDAO, never()).delete(anyInt());
//    }

}