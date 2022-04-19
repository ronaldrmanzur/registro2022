/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.serviciosrest.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.serviciosrest.entity.Categoria;
import pe.com.serviciosrest.service.CategoriaService;
import pe.com.serviciosrest.rest.request.CategoriaRequest;

/**
 *
 * @author Manuel
 */
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @PostMapping
    public Categoria add(@RequestBody Categoria c) {
        return categoriaService.add(c);
    }

    @GetMapping("/{id}")
    public Optional<Categoria> findById(@PathVariable long id){
        return categoriaService.findById(id);
    }
    
    @PostMapping("by-name")
    public List<Categoria> findByName(@RequestBody CategoriaRequest categoriaRequest){
        return categoriaService.findByName(categoriaRequest.getNombre());
    }
    
    @PutMapping("/{id}")
    public Categoria update(@PathVariable long id, @RequestBody Categoria c) {
        c.setCodigo(id);
        return categoriaService.update(c);
    }
    
    @DeleteMapping("/{id}")
    public Categoria delete(@PathVariable long id) {
        Categoria objcategoria= new Categoria();
        objcategoria.setCodigo(id);
        return categoriaService.delete(Categoria.builder().codigo(id).build());
    }
}
