package com.example.ProyectoBreadCiclo3.controllers;

import com.example.ProyectoBreadCiclo3.entities.Empleado;
import com.example.ProyectoBreadCiclo3.services.EmpleadoService;
import com.example.ProyectoBreadCiclo3.services.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("empleado")
public class EmpleadoController {

    public EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService emp){
        this.empleadoService = emp;
    }

    @PostMapping("createempleado")
    public Response createUser(@RequestBody Empleado emp){

        return this.empleadoService.createEmpleado(emp);
    }

    @GetMapping("getempleados")
    public ArrayList<Empleado> getEmpleados(){
        return this.empleadoService.selectAll();
    }

    @GetMapping("getempleado/{id}")
    public Empleado getEmpleadoById(@PathVariable long id){
        return this.empleadoService.empleadoById(id);
    }

    @DeleteMapping("deleteempleado/{id}")
    public Response deleteEmpleadoById(long id){
        return this.empleadoService.deleteEmpleadoById(id);
    }

    @PatchMapping("updateempleado")
    public Response updateEmpleado(@RequestBody Empleado emp){
        return this.empleadoService.updateEmpleado(emp);
    }
}
