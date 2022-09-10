package com.example.ProyectoBreadCiclo3.entities;

import javax.persistence.*;
import java.util.List;


enum EnumRol{
    ADMINISTRADOR,
    OPERATIVO
}

@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nombreEmpleado;

    //Preguntar si el unique se pone así
    @Column(unique = true)
    private String correoEmpleado;

    @Column
    //Preguntar funcion del campo

    //@Enumerated(value = EnumType.STRING)
    private EnumRol rolEmpleado;

    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresaEmpleado;

    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY)
    private List<movimientoDinero> movimientoDineros;

    //Preguntar por los atributos del diagrama que dicen update and created, como deben ser y demás

    //Preguntar por las entidades profile


    //GETTER AND SETTERS


    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public Empresa getEmpresaEmpleado() {
        return empresaEmpleado;
    }


    public void setEmpresaEmpleado(Empresa empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public EnumRol getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(EnumRol rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<movimientoDinero> getMovimientoDineros() {
        return movimientoDineros;
    }

    public void setMovimientoDineros(List<movimientoDinero> movimientoDineros) {
        this.movimientoDineros = movimientoDineros;
    }
}
