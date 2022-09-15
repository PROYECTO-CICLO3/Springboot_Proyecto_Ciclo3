package com.example.ProyectoBreadCiclo3.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String nombreEmpresa;
    @Column(unique = true)
    private String direccionEmpresa;
    @Column
    private int telefonoEmpresa;
    @Column
    private int NITEmpresa;

    //Preguintar porque no puedo usar Arraylist en estos casos
    //Preguntar si son necesarios, cuando creo una conexion de empleado con empresa me sale error

    //No logro que haga la conexión de empresa con empleado
    //@OneToMany(mappedBy = "empresaEmpleado")
    //private List<Empleado> empleadosList;


    @OneToMany(mappedBy = "empresaMovimiento")
    private List<movimientoDinero> movimientoDinerosList;


    //GETTER AND SETTERS

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public int getTelefono() {
        return telefonoEmpresa;
    }

    public void setTelefono(int telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public int getNITEmpresa() {
        return NITEmpresa;
    }

    public void setNITEmpresa(int NITEmpresa) {
        this.NITEmpresa = NITEmpresa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<movimientoDinero> getMovimientoDinerosList() {
        return movimientoDinerosList;
    }

    public void setMovimientoDinerosList(List<movimientoDinero> movimientoDinerosList) {
        this.movimientoDinerosList = movimientoDinerosList;
    }

    /*
    public List<Empleado> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleado> empleadosList) {
        this.empleadosList = empleadosList;
    }*/


}
