package com.empresa.gestion.service;

import com.empresa.gestion.model.Empleado;
import java.util.ArrayList;

public class EmpleadoService {
  ArrayList<Empleado> empleados = new ArrayList<>();

  public void agregarEmpleados(Empleado emp) {
    empleados.add(emp);
    System.out.println("Empleado añadido");
  }

  public void listarEmpleados() {
    if (empleados.isEmpty()) {
      System.out.println("No hay empleados para mostrar");
    } else {
      for (Empleado e: empleados) {
        System.out.println(e.getNombre());
      }
    }
  }

  public void eliminarEmpleado(int id) {

    for (Empleado e: empleados) {
      if (e.getId() == id) {
        empleados.remove(e);
        System.out.println("Se eliminó el empleado con id: " + id);
        return;
      }
    }
    
    System.out.println("No se encontró el empleado con el id: " + id);
  } 

  public void buscarEmpleado(int busqueda) {

    for (Empleado e: empleados) {
      if (e.getId() == busqueda) {
        System.out.println("Empleado encontrado, ID: " + e.getId());
        return;
      }
    }
    System.out.println("No se encontraron empleados " +  busqueda);
  }
}
