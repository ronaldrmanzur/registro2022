/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.serviciosrest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.serviciosrest.entity.Distrito;
import pe.com.serviciosrest.repository.DistritoRepository;

/**
 *
 * @author Manuel
 */
@Service
public class DistritoServiceImpl implements DistritoService{

    @Autowired
    private DistritoRepository distritoRepository;
    
    @Override
    public List<Distrito> findAll() {
        return distritoRepository.findAllCustom();
    }

    @Override
    public Optional<Distrito> findById(Long id) {
        return distritoRepository.findById(id);
    }

    @Override
    public Distrito add(Distrito d) {
        return distritoRepository.save(d);
    }

    @Override
    public Distrito update(Distrito d) {
        Distrito objDistrito=distritoRepository.getById(d.getCodigo());
        BeanUtils.copyProperties(d, objDistrito);
        return distritoRepository.save(objDistrito);
    }

    @Override
    public Distrito delete(Distrito d) {
        Distrito objDistrito=distritoRepository.getById(d.getCodigo());
        objDistrito.setEstado(false);
        return distritoRepository.save(objDistrito);
    }
    
}
