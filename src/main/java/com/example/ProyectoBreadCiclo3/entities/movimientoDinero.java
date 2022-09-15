package com.example.ProyectoBreadCiclo3.entities;


import javax.persistence.*;

@Entity
@Table(name = "movimientoDineros")
public class movimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int montoMovimiento;

    @Column
    private String conceptoMovimiento;


    //@ManyToOne
    //@JoinColumn(name="empleado_id")
    //private Empleado empleadoMovimiento;

    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresaMovimiento;



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

    /*
    public Empleado getEmpleado() {
        return empleadoMovimiento;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleadoMovimiento = empleado;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresaMovimiento;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresaMovimiento = empresa;
    }
}
