package com.empresa.gestion.app;
import com.empresa.gestion.model.Empleado;
import com.empresa.gestion.service.EmpleadoService;

import java.util.Scanner;

public class MainLibros {
  public static void main(String[] args) {
    int opcion;
    Scanner scanner = new Scanner(System.in);

    EmpleadoService empleadoService = new EmpleadoService();

    do {
      System.out.println("\n<========= Menú ===========>");
      System.out.println("1. Agregar empleado");
      System.out.println("2. Eliminar empleado");
      System.out.println("3. Mostrar empleados");
      System.out.println("4. Buscar empleado");
      System.out.println("5. Salir \n");

      opcion = scanner.nextInt();
      scanner.nextLine();

      switch (opcion) {
        case 1:
          System.out.println("Ingrese id");
          int id = scanner.nextInt();
          scanner.nextLine();

          System.out.println("Ingrese nombre");
          String nombre = scanner.nextLine();

          System.out.println("Ingrese edad");
          int edad = scanner.nextInt();

          System.out.println("Ingrese estado");
          boolean active = scanner.nextBoolean();

          System.out.println("Ingrese genero");
          char genero = scanner.next().charAt(0);

          System.out.println("Ingrese salario");
          double salario = scanner.nextDouble();

          System.out.println("Ingrese horasTrabajadas");
          int horasTrabajadas = scanner.nextInt();

          Empleado empleado1 = new Empleado(id, nombre, edad, active, genero, salario, horasTrabajadas);

          empleadoService.agregarEmpleados(empleado1);
          break;
        case 2:
          int idBusqueda = scanner.nextInt();
          scanner.nextLine();
          empleadoService.eliminarEmpleado(idBusqueda);
          break;
        case 3:
          empleadoService.listarEmpleados();
          break;
        case 4:
          int idSearch = scanner.nextInt();
          scanner.nextLine();
          empleadoService.buscarEmpleado(idSearch);
          break;
        default:
          System.out.println("Opción inválida");
          break;
      }
    } while (opcion != 5);
  }
}
