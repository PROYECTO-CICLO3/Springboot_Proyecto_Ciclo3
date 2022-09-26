package com.example.ProyectoBreadCiclo3.entities;

import javax.persistence.*;


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
    private String password;

    @Column
    //Preguntar funcion del campo

    //@Enumerated(value = EnumType.STRING)
    private EnumRol rolEmpleado;

    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresaEmpleado;

    //@OneToMany(mappedBy = "empleadoMovimiento")
    //private List<movimientoDinero> movimientoDineros;

    //Preguntar por los atributos del diagrama que dicen update and created, como deben ser y demás

    //Preguntar por las entidades profile

    public Empleado(){

    }

    public Empleado(String nombreEmpleado, String correoEmpleado, EnumRol rolEmpleado, Empresa empresaEmpleado) {

        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.empresaEmpleado = empresaEmpleado;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
    public List<movimientoDinero> getMovimientoDineros() {
        return movimientoDineros;
    }

    public void setMovimientoDineros(List<movimientoDinero> movimientoDineros) {
        this.movimientoDineros = movimientoDineros;
    }*/
}
