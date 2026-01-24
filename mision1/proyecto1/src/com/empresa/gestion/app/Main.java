package com.empresa.gestion.app;
import com.empresa.gestion.model.*;
import com.empresa.gestion.service.NominaService;
public class Main {
  public static void main(String[] args) {
    //crear empleado
    Empleado eduardo = new Empleado("Eduardo", 25, true, 'r', 500, 10);
    Gerente manuel = new Gerente("Manuel", 88, true, 'M', 2000, 25, "Antioquia", 800);

    // eduardo.presentarse();
    // manuel.presentarse();

    NominaService nomina = new NominaService();
    // System.out.println(nomina.calcularSalarioAnual(manuel));

    System.out.println("==============");
    System.out.println(manuel.obtenerTipoEmpleado());
    System.out.println(eduardo.obtenerTipoEmpleado());
  }
}
