package edu.itm.SistemaDeInventario.repositorios;

import edu.itm.SistemaDeInventario.identidadesSQL.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {


    List<Proveedor> findByNombreProveedorContainingIgnoreCase(String nombre);
}