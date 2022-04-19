/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.serviciosrest.service;

import java.util.List;
import java.util.Optional;
import pe.com.serviciosrest.entity.Distrito;

/**
 *
 * @author Manuel
 */
public interface DistritoService {
    
    List<Distrito> findAll();

    Optional<Distrito> findById(Long id);

    Distrito add(Distrito d);

    Distrito update(Distrito d);

    Distrito delete(Distrito d);
}
