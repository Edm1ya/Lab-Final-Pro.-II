package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import data.Job;
import models.JobModel;

public class JobController {

    public void allJob() {
        JobModel objJob = new JobModel();
        ShowDateSet(objJob.getAll());

        objJob.CloseDB();
    }

    public void SearchJob(Scanner pin) {
        JobModel objJob = new JobModel();
        String criterio = "";
        short opt = 0;

        do {
            System.out.print("\n> ");
            criterio = pin.nextLine().trim(); // Lee la línea y elimina los espacios en blanco al inicio y al final
            if (!criterio.isEmpty()) { // Utiliza isEmpty() para verificar si la cadena está vacía
                ShowDateSet(objJob.Get(criterio));
                System.out.println(objJob.getActionMessage());
            } else {
                System.out.println("Criterio incorrecto");
            }

            System.out.println("\nDesea continuar [Si: 1| No: 0]");
            opt = pin.nextShort();
            pin.nextLine(); // Consumir el carácter de nueva línea en el búfer
        } while (opt == 1);
        objJob.CloseDB();
    }

    // public void PostAuthor(Scanner pin) {
    // JobModel objAuthor = new JobModel();
    // Author author = new Author();

    // String data = "";

    // if (res) {
    // System.out.println("El autor se ha agregado correctamente");
    // } else {
    // System.out.println("ocurrio un error al agregar un nuevo autor");
    // }
    // }

    public void ShowDateSet(ArrayList<Job> odt) {
        System.out.println("Id\t|Desc\t\t\t|Min_Lvl\t\t\t|Max_lvl");
        for (Job job : odt) {
            System.out.println(job.job_id + "\t|" + job.job_desc + "\t\t\t|" +
                    job.min_lvl + "\t\t|" + job.max_lvl + "\t\t|");
        }
    }
}
