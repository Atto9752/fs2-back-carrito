package com.example.carrito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carrito.model.dto.carrito;
import com.example.carrito.service.carritoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/carritos")
public class carritoControlador {

    @Autowired //para que cuando se levante el controlador se inicie el servicio 
    private carritoService servicio;

    @GetMapping("/all")
    public List<carrito> listarCarritos() {
        return servicio.listarCarritos();
    }
    
    @PostMapping("/add")
    public carrito guardarCarrito(@RequestBody carrito carrito){
        return servicio.guardarCarrito(carrito);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarCarrito(@RequestParam Long id){
        servicio.eliminarCarrito(id);
    }

    @GetMapping("/search/{id}")
    public carrito buscarCarrito(@RequestParam Long id){
        return servicio.buscarCarrito(id);
    }

    @PutMapping("/update/{id}")
    public carrito actualizarCarrito(@RequestParam Long id, @RequestBody carrito carrito){
        return servicio.actualizarCarrito(id, carrito);
    }

}
