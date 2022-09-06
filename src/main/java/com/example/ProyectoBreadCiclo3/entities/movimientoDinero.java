package com.example.ProyectoBreadCiclo3.entities;

import com.example.ProyectoBreadCiclo3.entities.Empleado;

public class movimientoDinero {

    private int montoMovimiento;

    private String conceptoMovimiento;

    private Empleado empleado;

    //CONSTRUCTOR

    public movimientoDinero(int montoMovimiento, String conceptoMovimiento, Empleado empleado) {
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
        this.empleado = empleado;
    }

    //GETTER
    public int getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(int montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
