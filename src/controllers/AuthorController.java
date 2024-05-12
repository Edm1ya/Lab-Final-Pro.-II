package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import data.Author;
import models.AuthorModel;

public class AuthorController {

    public void allAuthor() {
        AuthorModel objAuthor = new AuthorModel();
        ShowDateSet(objAuthor.getAll());

        objAuthor.CloseDB();
    }

    public void SearchAuthor(Scanner pin) {
        AuthorModel objAuthor = new AuthorModel();
        String criterio = "";
        short opt = 0;

        do {
            System.out.print("\n> ");
            criterio = pin.nextLine().trim(); // Lee la línea y elimina los espacios en blanco al inicio y al final
            if (!criterio.isEmpty()) { // Utiliza isEmpty() para verificar si la cadena está vacía
                ShowDateSet(objAuthor.Get(criterio));
                System.out.println(objAuthor.getActionMessage());
            } else {
                System.out.println("Criterio incorrecto");
            }

            System.out.println("\nDesea continuar [Si: 1| No: 0]");
            opt = pin.nextShort();
            pin.nextLine(); // Consumir el carácter de nueva línea en el búfer
        } while (opt == 1);
        objAuthor.CloseDB();
    }

    // public void PostAuthor(Scanner pin) {
    // AuthorModel objAuthor = new AuthorModel();
    // Author author = new Author();

    // String data = "";

    // if (res) {
    // System.out.println("El autor se ha agregado correctamente");
    // } else {
    // System.out.println("ocurrio un error al agregar un nuevo autor");
    // }
    // }

    public void ShowDateSet(ArrayList<Author> odt) {
        System.out.println("Id\t\t|Nombre\t\t\t|Apellido\t\t|Dir\t\t|Tel");
        for (Author author : odt) {
            System.out.println(author.auid + "\t|" + author.aufname + "\t\t\t|" +
                    author.aulname + "\t\t|" + author.auaddress + "\t\t|"
                    + author.auphone + "\t|");
        }
    }
}
