package controllers;

import java.util.ArrayList;
import java.util.Scanner;
import data.Employee;
import models.EmployeeModel;

public class EmployeeController {
    public void allEmployee() {
        EmployeeModel objEmployee = new EmployeeModel();
        ShowDateSet(objEmployee.getAll());

        objEmployee.CloseDB();
    }

    public void SearchEmployee(Scanner pin) {
        EmployeeModel objEmployee = new EmployeeModel();
        String criterio = "";
        short opt = 0;

        do {
            System.out.print("\n> ");
            criterio = pin.nextLine().trim(); // Lee la línea y elimina los espacios en blanco al inicio y al final
            if (!criterio.isEmpty()) { // Utiliza isEmpty() para verificar si la cadena está vacía
                ShowDateSet(objEmployee.Get(criterio));
                System.out.println(objEmployee.getActionMessage());
            } else {
                System.out.println("Criterio incorrecto");
            }

            System.out.println("\nDesea continuar [Si: 1| No: 0]");
            opt = pin.nextShort();
            pin.nextLine(); // Consumir el carácter de nueva línea en el búfer
        } while (opt == 1);
        objEmployee.CloseDB();
    }

    // public void PostAuthor(Scanner pin) {
    // EmployeeModel objEmployee = new EmployeeModel();
    // Author author = new Author();

    // String data = "";

    // if (res) {
    // System.out.println("El autor se ha agregado correctamente");
    // } else {
    // System.out.println("ocurrio un error al agregar un nuevo autor");
    // }
    // }

    public void ShowDateSet(ArrayList<Employee> odt) {
        System.out.println("Id\t\t|Nombre\t\t\t|Minit\t\t|Apellido\t\t|Job Id\t\t|Job LvL\t\t|Pub Id\t\t|Hire date");
        for (Employee employee : odt) {
            System.out.println(employee.emp_id + "\t|" + employee.fname + "\t\t\t|" +
                    employee.minit + "\t\t|" + employee.lname + "\t\t|"
                    + employee.job_id + "\t|" + employee.job_lvl + "\t|"
                    + employee.pub_id + "\t|" + employee.hire_date + "\t|");
        }
    }
}
