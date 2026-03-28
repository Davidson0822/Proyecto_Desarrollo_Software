package edu.itm.SistemaDeInventario.repositorios;

import edu.itm.SistemaDeInventario.identidadesSQL.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Aquí no necesitas escribir nada más por ahora
}