# Informe de la Aplicación de Gestión de Empleados

Esta aplicación de gestión de empleados le permite realizar varias operaciones relacionadas con la gestión de registros de empleados: 

*  Agregar nuevos empleados.
* Listar empleados existentes.
* Actualizar información de empleados. 
* Eliminar empleados
* Buscar empleados por cargo.


A continuación, se describen los pasos para probar la aplicación, junto con algunos supuestos considerados.


### Uso de la Aplicación
Una vez que el programa esté en funcionamiento, seguirás el flujo de menú interactivo proporcionado en la aplicación. Aquí está cómo usar cada una de las opciones:

1. **Agregar un Registro Nuevo de Empleado**
   - Elige la opción `1` en el menú principal.
   - Sigue las instrucciones para ingresar los datos del nuevo empleado, como nombre, apellido, cargo, salario y fecha de inicio.
   - La información ingresada se almacenará en la base de datos.

   Ejemplo:
   ```
   ********************************
   --Menu de Gestión de Empleados--
   ********************************
   [1]-Agregar un registro nuevo de empleado-
   [2]-Generar lista de empleados-
   [3]-Actualizar información de un empleado registrado-
   [4]-Eliminar un registro de empleado-
   [5]-Buscar empleados por cargo-
   [6]-Salir del sistema-
   ***********************************
   --Introduzca el numero de opción:--
   ***********************************

   Opción seleccionada: 1

   -Agregar un registro nuevo de empleado-
   -Introduzca el nombre: Juan
   -Introduzca el apellido: Pérez
   -Introduzca el cargo: Gerente
   -Introduzca el salario: 75000.0
   -Introduzca la fecha de inicio (dd-mm-yyyy): 15-03-2020

   -Empleado agregado con éxito.-

   ¿Quiere crear otro registro? (1: Sí, 0: No): 1
   ```

2. **Generar Lista de Empleados**
   - Selecciona la opción `2` en el menú.
   - La aplicación mostrará una lista de todos los empleados registrados en la base de datos.

   Ejemplo:
   ```
   Opción seleccionada: 2

   [2]-Generar lista de empleados-
   -Listado de empleados registrados-
    ID: 1   | Nombre: Juan         | Apellido: Pérez        | Cargo: Gerente         | Salario: 75000,00 | Fecha de Inicio: 15-03-2020
    ID: 2   | Nombre: María        | Apellido: Lopez        | Cargo: Asistente       | Salario: 30500,00 | Fecha de Inicio: 02-07-2021
    ID: 11  | Nombre: Juan         | Apellido: del          | Cargo: Val             | Salario: 35000,00 | Fecha de Inicio: 16-05-2020
   ```

3. **Actualizar Información de un Empleado Registrado**
   - Elije la opción `3` en el menú.
   - Ingresa el ID del empleado que deseas actualizar.
   - Proporciona los nuevos detalles del empleado, como nombre, apellido, cargo, salario y fecha de inicio.

   Ejemplo:
   ```
   Opción seleccionada: 3

   -Actualizar información de un empleado registrado-
   -Introduzca el ID del empleado que quiere actualizar: 1

   -Datos actuales del empleado:-
    ID: 1   | Nombre: Juan         | Apellido: Pérez        | Cargo: Gerente         | Salario: 75000,00 | Fecha de Inicio: 15-03-2020
   -Introduzca el nombre: Antonio
   -Introduzca el apellido: Lopez
   -Introduzca el cargo: Gerente
   -Introduzca el salario: 74000.0
   -Introduzca la fecha de inicio (dd-mm-yyyy): 15-02-2023

   -Datos antiguos del empleado:-
    ID: 1   | Nombre: Juan         | Apellido: Pérez        | Cargo: Gerente         | Salario: 75000,00 | Fecha de Inicio: 15-03-2020
   ********************************
   -Datos actuales del empleado:-
    ID: 1   | Nombre: Antonio         | Apellido: Lopez        | Cargo: Gerente         | Salario: 74000,00 | Fecha de Inicio: 15-02-2023
   ********************************

   -Empleado actualizado con éxito.-

   ¿Quiere actualizar otro registro? (1: Sí, 0: No): 0
   ```

4. **Eliminar un Registro de Empleado**
   - Elige la opción `4` en el menú.
   - Ingresa el ID del empleado que deseas eliminar.
   - La aplicación eliminará el empleado correspondiente de la base de datos.

   Ejemplo:
   ```
   Opción seleccionada: 4

   [4]-Eliminar un registro de empleado-
   -Introduzca el ID del empleado que quiere eliminar: 1

   -Empleado a eliminar:
   ID: 1   | Nombre: Juan         | Apellido: Pérez        | Cargo: Gerente         | Salario: 75000,00 | Fecha de Inicio: 15-03-2020

   -Empleado eliminado con éxito.-

   -Listado actualizado de empleados registrados-
    ID: 2   | Nombre: María        | Apellido: Lopez        | Cargo: Asistente       | Salario: 30500,00 | Fecha de Inicio: 02-07-2021
    ID: 11  | Nombre: Juan         | Apellido: del          | Cargo: Val             | Salario: 35000,00 | Fecha de Inicio: 16-05-2020
   ```

5. **Buscar Empleados por Cargo**
   - Selecciona la opción `5` en el menú.
   - Ingresa el cargo que deseas buscar.
   - La aplicación mostrará una lista de empleados que tienen ese cargo.

   Ejemplo:
   ```
   Opción seleccionada: 5

   [5]-Buscar empleados por cargo-
   -Introduzca el cargo para generar listado: Programador
    ID: 7   | Nombre: Carlos       | Apellido: Vargas       | Cargo: Programador     | Salario: 46000,00 | Fecha de Inicio: 12-12-2019
    ID: 8   | Nombre: Alberto      | Apellido: Bonilla      | Cargo: Programador     | Salario: 46500,00 | Fecha de Inicio: 08-09-2022
   ```

6. **Salir del Sistema**
   - Si deseas salir de la aplicación, selecciona la opción `6`.

   Ejemplo:
   ```
   Opción seleccionada: 6
   -Saliendo del sistema-
   ```

## Supuestos Considerados

Al desarrollar esta aplicación, se consideraron los siguientes supuestos:

1.   **Funcionalidad de Búsqueda Avanzada:** 
      *  Agregar funcionalidades de búsqueda avanzada, como buscar empleados por nombre, apellido, salario dentro de un rango, etc.


2. **Interfaz de Usuario Gráfica (GUI):** 
   *  La aplicación actualmente se ejecuta en la línea de comandos: 
      *  Deberia tener una interfaz de usuario gráfica (GUI) para que sea más amigable y visualmente atractiva. Esto permitiría a los usuarios interactuar con la aplicación de una manera más intuitiva.

