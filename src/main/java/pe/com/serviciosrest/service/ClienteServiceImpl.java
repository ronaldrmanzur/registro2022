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
import pe.com.serviciosrest.entity.Cliente;
import pe.com.serviciosrest.repository.ClienteRepository;

/**
 *
 * @author Manuel
 */
@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAllCustom();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente add(Cliente c) {
        return clienteRepository.save(c);
    }

    @Override
    public Cliente update(Cliente c) {
        Cliente objCliente=clienteRepository.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objCliente);
        return clienteRepository.save(objCliente);
    }

    @Override
    public Cliente delete(Cliente c) {
        Cliente objCliente=clienteRepository.getById(c.getCodigo());
        objCliente.setEstado(false);
        return clienteRepository.save(objCliente);
    }
}
