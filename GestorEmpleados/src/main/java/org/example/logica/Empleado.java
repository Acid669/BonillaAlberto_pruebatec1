package org.example.logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado {

    //Atributos de clase.
    // La anotación @Id marca el campo "id" como la clave primaria de la entidad, y @GeneratedValue especifica que se genera automáticamente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String cargo;
    private double salario;
    private String fechaInicio;

    //Constructores.

    //Constructor sin atributos.
    public Empleado() {
    }

    //Constructor con atributos.
    public Empleado(String nombre, String apellido, String cargo, double salario, String fechaInicio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }


    //Getters y Setters.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    //Métodos

    @Override
    public String toString() {
        return String.format("ID: %-3d | Nombre: %-12s | Apellido: %-12s | Cargo: %-15s | Salario: %-8.2f | Fecha de Inicio: %-10s",
                id, nombre, apellido, cargo, salario, fechaInicio);
    }

}
