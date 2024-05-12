package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import data.Title;
import models.TitleModel;

public class TitleController {
    public void allTitle() {
        TitleModel objTitle = new TitleModel();
        ShowDateSet(objTitle.getAll());

        objTitle.CloseDB();
    }

    public void SearchTitle(Scanner pin) {
        TitleModel objTitle = new TitleModel();
        String criterio = "";
        short opt = 0;

        do {
            System.out.print("\n> ");
            criterio = pin.nextLine().trim(); // Lee la línea y elimina los espacios en blanco al inicio y al final
            if (!criterio.isEmpty()) { // Utiliza isEmpty() para verificar si la cadena está vacía
                ShowDateSet(objTitle.Get(criterio));
                System.out.println(objTitle.getActionMessage());
            } else {
                System.out.println("Criterio incorrecto");
            }

            System.out.println("\nDesea continuar [Si: 1| No: 0]");
            opt = pin.nextShort();
            pin.nextLine(); // Consumir el carácter de nueva línea en el búfer
        } while (opt == 1);
        objTitle.CloseDB();
    }

    public void ShowDateSet(ArrayList<Title> odt) {
        System.out.println("Id\t\t|Nombre\t\t\t|Typo\t\t|pun_id" +
                "\t\t|Precio\t\t|Avance\t\t|Realeza\t\t|ytd_sales" +
                "\t\t|notes\t\t|pub_date");
        for (Title title : odt) {
            System.out.println(title.id + "\t|" + title.name + "\t\t\t|" +
                    title.type + "\t\t|" + title.pub_id + "\t\t|"
                    + title.price + "\t|" + title.advance + "\t|" + title.royalty
                    + "\t|" + title.ytd_sales + "\t|" + title.notes + "\t|"
                    + title.pub_date + "\t|");
        }
    }
}
