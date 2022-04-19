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
import pe.com.serviciosrest.entity.Categoria;
import pe.com.serviciosrest.repository.CategoriaRepository;

/**
 *
 * @author Manuel
 */
@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAllCustom();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);    
    }

    @Override
    public List<Categoria> findByName(String name) {
        return categoriaRepository.findByName(name);
    }

    @Override
    public Categoria add(Categoria c) {
        return categoriaRepository.save(c);
    }

    @Override
    public Categoria update(Categoria c) {
        Categoria objCategoria=categoriaRepository.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objCategoria);
        return categoriaRepository.save(objCategoria);
    }

    @Override
    public Categoria delete(Categoria c) {
        Categoria objCategoria=categoriaRepository.getById(c.getCodigo());
        objCategoria.setEstado(false);
        return categoriaRepository.save(objCategoria);
    }   
}
