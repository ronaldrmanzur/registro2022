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
import pe.com.serviciosrest.entity.Distrito;
import pe.com.serviciosrest.service.DistritoService;

/**
 *
 * @author Manuel
 */
@RestController
@RequestMapping("/distrito")
public class DistritoController {
    
    @Autowired
    private DistritoService distritoService;
    
    @GetMapping
    public List<Distrito> findAll() {
        return distritoService.findAll();
    }

    @PostMapping
    public Distrito add(@RequestBody Distrito d) {
        return distritoService.add(d);
    }

    @GetMapping("/{id}")
    public Optional<Distrito> findById(@PathVariable long id){
        return distritoService.findById(id);
    }
    
    @PutMapping("/{id}")
    public Distrito update(@PathVariable long id, @RequestBody Distrito d) {
        d.setCodigo(id);
        return distritoService.update(d);
    }
    
    @DeleteMapping("/{id}")
    public Distrito delete(@PathVariable long id) {
        Distrito objdistrito= new Distrito();
        objdistrito.setCodigo(id);
        return distritoService.delete(Distrito.builder().codigo(id).build());
    }
}
