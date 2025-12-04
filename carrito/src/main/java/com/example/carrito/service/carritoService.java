package com.example.carrito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carrito.model.dto.carrito;
import com.example.carrito.repository.carritoRepositorio;

@Service
public class carritoService {

    @Autowired //para que se inicie junto con el repo y no se desconecten uno del otro
    private carritoRepositorio carritoRepo;

    // no se por que alguien querria listar carritos, pero bueno, lo pongo por si acaso
    public List<carrito> listarCarritos() {
        return carritoRepo.findAll();
    }

    public carrito guardarCarrito(carrito carrito) {
        return carritoRepo.save(carrito);
    }

    public void eliminarCarrito(Long id) {
        carritoRepo.deleteById(id);
    }

    public carrito buscarCarrito(Long id) {
        return carritoRepo.findById(id).orElse(null);
    }

    //recordar añadir para actualizar carrito


}
