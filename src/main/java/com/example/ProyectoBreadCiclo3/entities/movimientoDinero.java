package com.example.ProyectoBreadCiclo3.entities;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "movimientoDineros")
public class movimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long montoMovimiento;

    @Column
    private String conceptoMovimiento;

    //@ManyToOne
    //@JoinColumn(name="empleado_id")
    //private Empleado empleadoMovimiento;
    //(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @JoinColumn(name="empleado_id")
    private Empleado empleadoMovimiento;


    public movimientoDinero(){

    }

    public movimientoDinero(long montoMovimiento, String conceptoMovimiento, Empleado empleadoMovimiento) {
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
        this.empleadoMovimiento = empleadoMovimiento;
    }

    //GETTER
    public long getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(long montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleado getEmpleadoMovimiento() {
        return empleadoMovimiento;
    }

    public void setEmpleadoMovimiento(Empleado empleadoMovimiento) {
        this.empleadoMovimiento = empleadoMovimiento;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
