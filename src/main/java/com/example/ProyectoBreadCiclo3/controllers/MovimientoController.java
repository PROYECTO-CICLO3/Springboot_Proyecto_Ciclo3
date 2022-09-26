package com.example.ProyectoBreadCiclo3.controllers;

import com.example.ProyectoBreadCiclo3.entities.movimientoDinero;
import com.example.ProyectoBreadCiclo3.services.EmpresaService;
import com.example.ProyectoBreadCiclo3.services.MovimientoService;
import org.springframework.web.bind.annotation.*;
import com.example.ProyectoBreadCiclo3.services.Response;

import java.util.ArrayList;


@RestController
@RequestMapping("movimiento")
public class MovimientoController {

    private MovimientoService movimientoService;


    public MovimientoController(MovimientoService mov){
        this.movimientoService = mov;
    }

    @PostMapping("createmovimiento")
    public boolean createMovimiento(@RequestBody movimientoDinero movimiento){
        return this.movimientoService.saveOrUpdateMovimiento(movimiento);
    }

    @GetMapping("movimientos")
    public ArrayList<movimientoDinero> getAllMovimientos(){
        return this.movimientoService.getAllMovimiento();
    }

    @GetMapping("movimientoid/{id}")
    public ArrayList<movimientoDinero> getMovimientosEmpleados(@PathVariable long id){
        return this.movimientoService.getMovimientoIdEmpleado(id);
    }
}
