package com.example.ProyectoBreadCiclo3.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @OneToMany(mappedBy = "empresaEmpleado", fetch = FetchType.LAZY)
    private List<Empleado> empleados;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    private List<movimientoDinero> movimientoDineros;


    //CONSTRUCTOR

    public Empresa(String nombreEmpresa, String direccionEmpresa, int telefonoEmpresa, int NITEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.NITEmpresa = NITEmpresa;
    }


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

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<movimientoDinero> getMovimientoDineros() {
        return movimientoDineros;
    }

    public void setMovimientoDineros(ArrayList<movimientoDinero> movimientoDineros) {
        this.movimientoDineros = movimientoDineros;
    }
}
