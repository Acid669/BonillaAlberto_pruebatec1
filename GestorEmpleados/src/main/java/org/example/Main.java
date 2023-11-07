package org.example;

import org.example.logica.Empleado;
import org.example.persistencia.ControladoraPersistencia;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Habilitar la entrada de datos por teclado
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        //Crear una instancia de la controladora de persistencia para gestionar los datos de empleados
        ControladoraPersistencia controlPers = new ControladoraPersistencia();
        int opcionSwitch;

        System.out.println("********************************");
        System.out.println("--Menu de Gestión de Empleados--");
        System.out.println("********************************");

        do {

            //Mostrar el menu principal
            menu();

            //Opcion seleccionada por el usuario


            try {
                opcionSwitch = sc.nextInt();
            } catch (Exception e) {
                // Manejar la excepción cuando se ingresa un valor no numérico
                System.out.println("-Por favor, ingrese un número válido.-");
                // Limpiar el búfer de entrada
                sc.next();
                // Establecer un valor no válido para que se repita el bucle
                opcionSwitch = 7;
            }

            switch (opcionSwitch) {
                //Agregar usuario
                case 1:
                    do {
                        boolean datosValidosCrear = false;
                        while (!datosValidosCrear) {
                            try {
                                System.out.println("-Agregar un registro nuevo de empleado-");
                                System.out.println("-Introduzca el nombre:-");
                                String nombre = sc.next();
                                System.out.println("-Introduzca el apellido:-");
                                String apellido = sc.next();
                                System.out.println("-Introduzca el cargo:-");
                                String cargo = sc.next();
                                System.out.println("-Introduzca el salario:-");
                                double salario = sc.nextDouble();
                                System.out.println("-Introduzca la fecha de inicio (dd-mm-yyyy):-");
                                String fechaInicio = sc.next();

                                //Crear un objeto empleado con los datos introducidos por teclado
                                Empleado empleado = new Empleado(nombre, apellido, cargo, salario, fechaInicio);

                                //Guardar el empleado en la base de datos
                                controlPers.crearRegistro(empleado);
                                datosValidosCrear = true;
                                System.out.println("-Empleado agregado con éxito.-");

                            } catch (Exception ex) {
                                //Controlar los errores de entrada de datos
                                System.out.println("-Error: Datos introducidos no válidos.-");
                                System.out.println("-Por favor, inténtelo de nuevo.-");
                                //Se limpia la variable almacenada y se vuelve a pedir dato
                                sc.nextLine();
                            }
                        }

                        //Preguntar al usuario si quiere agregar otro empleado
                        System.out.println("-¿Quiere crear otro registro? (1: Sí, 0: No)-");
                        opcionSwitch = sc.nextInt();
                    } while (opcionSwitch == 1);
                    break;


                case 2:
                    //Listar empleados registrados
                    System.out.println("[2]-Generar lista de empleados-");
                    System.out.println("-Listado de empleados registrados-");
                    List<Empleado> listaEmpleados = controlPers.listarEmpleados();
                    for (Empleado listado : listaEmpleados) {
                        System.out.println(listado.toString());
                    }
                    break;

                case 3:
                    //Actualizar información de un empleado registrado
                    do {
                        boolean datosValidosActualizar = false;
                        while (!datosValidosActualizar) {
                            try {
                                System.out.println("-Actualizar información de un empleado registrado-");
                                System.out.println("-Introduzca el ID del empleado que quiere actualizar-");
                                int idEmpleado = sc.nextInt();
                                Empleado empleado = controlPers.buscarEmpleado(idEmpleado);

                                if (empleado != null) {
                                    System.out.println("-Datos actuales del empleado:-");
                                    System.out.println(empleado);
                                    System.out.println("-Introduzca el nombre:-");
                                    String nombreNuevo = sc.next();
                                    System.out.println("-Introduzca el apellido:-");
                                    String apellidoNuevo = sc.next();
                                    System.out.println("-Introduzca el cargo:-");
                                    String cargoNuevo = sc.next();
                                    System.out.println("-Introduzca el salario:-");
                                    double salarioNuevo = sc.nextDouble();
                                    System.out.println("-Introduzca la fecha de inicio (dd-mm-yyyy):-");
                                    String fechaInicioNuevo = sc.next();

                                    //Mostrar datos antes de la actualización
                                    System.out.println("-Datos antiguos del empleado:-");
                                    System.out.println(empleado);
                                    System.out.println("********************************");


                                    //Actualizar los datos del empleado
                                    empleado.setNombre(nombreNuevo);
                                    empleado.setApellido(apellidoNuevo);
                                    empleado.setCargo(cargoNuevo);
                                    empleado.setSalario(salarioNuevo);
                                    empleado.setFechaInicio(fechaInicioNuevo);

                                    //Guardar los cambios en la base de datos
                                    controlPers.actualizarRegistro(empleado);

                                    //Mostrar datos después de la actualización
                                    System.out.println("-Datos actuales del empleado:-");
                                    System.out.println(empleado);
                                    System.out.println("********************************");


                                    System.out.println("-Empleado actualizado con éxito.-");
                                    datosValidosActualizar = true;
                                } else {
                                    System.out.println("-No hay datos asociados a ese ID-");
                                }
                            } catch (Exception ex) {
                                //Controlar los errores de entrada de datos
                                System.out.println("-Error: Datos introducidos no validos.-");
                                System.out.println("-Por favor, inténtelo de nuevo.-");
                                sc.nextLine();
                            }
                        }

                        //Preguntar al usuario si quiere agregar otro empleado
                        System.out.println("-¿Quiere actualizar otro registro? (1: Sí, 0: No)-");
                        opcionSwitch = sc.nextInt();
                    } while (opcionSwitch == 1);
                    break;

                case 4:
                    //Eliminar un registro de empleado
                    do {
                        boolean datosValidosEliminar = false;
                        while (!datosValidosEliminar) {
                            try {
                                System.out.println("[4]-Eliminar un registro de empleado-");
                                System.out.println("-Introduzca el ID del empleado que quiere eliminar-");

                                int idEmpleado = sc.nextInt();
                                Empleado empleado = controlPers.buscarEmpleado(idEmpleado);
                                //Mostrar registro que se va a eliminar
                                System.out.println(empleado);

                                if (empleado != null) {
                                    //Eliminar el empleado de la base de datos
                                    controlPers.eliminarRegistro(idEmpleado);
                                    System.out.println("-Empleado eliminado con éxito.-");
                                    datosValidosEliminar = true;
                                    //Mostrar listado actualizado
                                    System.out.println("-Listado actualizado de empleados registrados-");
                                    listaEmpleados = controlPers.listarEmpleados();
                                    for (Empleado listado : listaEmpleados) {
                                        System.out.println(listado.toString());
                                    }
                                } else {
                                    System.out.println("-No hay datos asociados a ese ID-");
                                }
                            } catch (Exception ex) {
                                System.out.println("-Error: Datos introducidos no validos.-");
                                System.out.println("-Por favor, inténtelo de nuevo.-");
                                sc.nextLine();
                            }
                        }

                        //Preguntar al usuario si quiere eliminar otro empleado
                        System.out.println("-¿Quiere eliminar otro registro? (1: Sí, 0: No)-");
                        opcionSwitch = sc.nextInt();
                    } while (opcionSwitch == 1);
                    break;

                case 5:
                    do {
                        boolean datosValidosBusqueda = false;
                        while (!datosValidosBusqueda) {
                            try {
                                System.out.println("[5]-Buscar empleados por cargo-");
                                System.out.println("-Introduzca el cargo para genererar listado-");
                                String cargoEmpleado = sc.next();

                                //LLama a un metodo para buscar empleados por el cargo que se ha introducido
                                List<Empleado> listaEmpleadosCargo = controlPers.buscarEmpleadoCargo(cargoEmpleado);

                                if (listaEmpleadosCargo != null && !listaEmpleadosCargo.isEmpty()) {
                                    for (Empleado listado : listaEmpleadosCargo) {
                                        System.out.println(listado.toString());
                                    }
                                    datosValidosBusqueda = true;
                                } else {
                                    System.out.println("-No hay datos asociados a ese cargo-");
                                }
                            } catch (Exception ex) {
                                System.out.println("-Error: Datos introducidos no validos.-");
                                System.out.println("-Por favor, inténtelo de nuevo.-");
                                sc.nextLine();
                            }
                        }

                        //Preguntar al usuario si quiere buscar por otro cargo
                        System.out.println("-¿Quiere buscar por otro cargo? (1: Sí, 0: No)-");
                        opcionSwitch = sc.nextInt();
                    } while (opcionSwitch == 1);
                    break;


                case 6:
                    System.out.println("-Saliendo del sistema-");
                    break;


                default:
                    System.out.println("-No se encuentra la opción marcada-");
                    System.out.println("-Por favor, inténtelo de nuevo.-");
            }
            try {
                System.out.println("-¿Quiere hacer otra operación? (1: Sí, 0: No)-");
                opcionSwitch = sc.nextInt();

            } catch (Exception exception) {
                System.out.println("-No se encuentra la opción marcada-");
                System.out.println("-Por favor, inténtelo de nuevo.-");
            }
        } while (opcionSwitch == 1);
    }


    public static void menu() {

        System.out.println("**********************************************");
        System.out.println("--Seleccione una de las opciones disponibles--");
        System.out.println("**********************************************");
        System.out.println("[1]-Agregar un registro nuevo de empleado-");
        System.out.println("[2]-Generar lista de empleados-");
        System.out.println("[3]-Actualizar información de un empleado registrado-");
        System.out.println("[4]-Eliminar un registro de empleado-");
        System.out.println("[5]-Buscar empleados por cargo-");
        System.out.println("[6]-Salir del sistema-");
        System.out.println("***********************************");
        System.out.println("--Introduzca el numero de opción:--");
        System.out.println("***********************************");
    }


}



