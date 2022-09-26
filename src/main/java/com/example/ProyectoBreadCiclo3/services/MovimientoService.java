package com.example.ProyectoBreadCiclo3.services;

import com.example.ProyectoBreadCiclo3.entities.Empresa;
import com.example.ProyectoBreadCiclo3.entities.movimientoDinero;
import com.example.ProyectoBreadCiclo3.repository.IMovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovimientoService {

    @Autowired
    private IMovimientoDineroRepository movimientoDineroRepository;

    public MovimientoService(IMovimientoDineroRepository mov){
        this.movimientoDineroRepository = mov;
    }


    Response response = new Response();


    public boolean saveOrUpdateMovimiento(movimientoDinero movimientoDinero){ //Guardar o actualizar elementos
        movimientoDinero mov=movimientoDineroRepository.save(movimientoDinero);
        if (movimientoDineroRepository.findById(mov.getId())!=null){
            return true;
        }
        return false;
    }


    public ArrayList<movimientoDinero> getAllMovimiento(){
        return (ArrayList<movimientoDinero>) this.movimientoDineroRepository.findAll();
    }


    public ArrayList<movimientoDinero> getMovimientoIdEmpleado(long id){

        return movimientoDineroRepository.findByEmpleado(id);
    }

}
