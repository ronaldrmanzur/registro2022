/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.serviciosrest.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.serviciosrest.entity.Producto;

/**
 *
 * @author Manuel
 */
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
    @Query("select p from Producto p where p.estado='1'")
    List<Producto> findAllCustom();

    @Query("select p from Producto p where upper(p.nombre) like upper(:nombre) "
            + "and p.estado='1'")
    List<Producto> findByName(@Param("nombre") String nombre);
}
