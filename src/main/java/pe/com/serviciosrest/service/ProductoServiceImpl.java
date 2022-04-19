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
import pe.com.serviciosrest.entity.Producto;
import pe.com.serviciosrest.repository.ProductoRepository;

/**
 *
 * @author Manuel
 */
@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAllCustom();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Producto add(Producto p) {
        return productoRepository.save(p);
    }

    @Override
    public Producto update(Producto p) {
        Producto objProducto=productoRepository.getById(p.getCodigo());
        BeanUtils.copyProperties(p, objProducto);
        return productoRepository.save(objProducto);
    }

    @Override
    public Producto delete(Producto p) {
        Producto objProducto=productoRepository.getById(p.getCodigo());
        objProducto.setEstado(false);
        return productoRepository.save(objProducto);
    }
}
