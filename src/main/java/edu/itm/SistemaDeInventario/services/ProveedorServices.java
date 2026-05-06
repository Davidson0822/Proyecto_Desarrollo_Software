package edu.itm.SistemaDeInventario.services;

import edu.itm.SistemaDeInventario.identidadesSQL.Proveedor;
import edu.itm.SistemaDeInventario.repositorios.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorServices {

    @Autowired
    private IProveedorRepository proveedorRepository;

    public List<Proveedor> listarTodo() {
        return proveedorRepository.findAll();
    }

    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void eliminar(int id) {
        proveedorRepository.deleteById(id);
    }

    public Proveedor buscarPorId(int id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor actualizar(int id, Proveedor proveedorActualizado) {
        return proveedorRepository.findById(id).map(proveedorExistente -> {


            proveedorExistente.setNombreProveedor(proveedorActualizado.getNombreProveedor());
            proveedorExistente.setContacto(proveedorActualizado.getContacto());
            proveedorExistente.setTelefono(proveedorActualizado.getTelefono());
            proveedorExistente.setCorreo(proveedorActualizado.getCorreo());

            return proveedorRepository.save(proveedorExistente);

        }).orElseThrow(() -> new RuntimeException("No se encontró el proveedor con ID: " + id));
    }

}