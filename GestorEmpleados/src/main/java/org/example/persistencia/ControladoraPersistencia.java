package org.example.persistencia;

import org.example.logica.Empleado;

import java.util.List;


public class ControladoraPersistencia {

    //Se crea una instancia de EmpleadoJpaController, que se utilizará para interactuar con la base de datos.
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();


    //Metodo para crear un nuevo registro de empleado en la base de datos
    public void crearRegistro(Empleado empleado){
        empleadoJpa.create(empleado);
    }


    //Metodo para listar todos los empleados almacenados en la base de datos
    public List<Empleado> listarEmpleados(){
        return empleadoJpa.findEmpleadoEntities();
    }

    //Metodo para actualizar un registro existente en la base de datos
    public void actualizarRegistro(Empleado empleado){
        empleadoJpa.edit(empleado);
    }

    //Metodo para eliminar un registro de empleado de la base de datos utilizando su id.
    public void eliminarRegistro(int id){
        empleadoJpa.destroy(id);
    }

    //Metodo para buscar un empleado por su id en la base de datos
    public Empleado buscarEmpleado(int id){
        return empleadoJpa.findEmpleado(id);
    }

    //Metodo para buscar un empleado por su cargo en la base de datos
    public List<Empleado> buscarEmpleadoCargo(String cargo){
        return empleadoJpa.findEmpleadoCargo(cargo);
    }
}
