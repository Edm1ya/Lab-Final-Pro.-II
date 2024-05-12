package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import data.Sale;
import models.SaleModel;

public class SalesController {
    public void allSales() {
        SaleModel objSale = new SaleModel();
        ShowDateSet(objSale.getAll());

        objSale.CloseDB();
    }

    public void SearchSales(Scanner pin) {
        SaleModel objSale = new SaleModel();
        String criterio = "";
        short opt = 0;

        do {
            System.out.print("\n> ");
            criterio = pin.nextLine().trim(); // Lee la línea y elimina los espacios en blanco al inicio y al final
            if (!criterio.isEmpty()) { // Utiliza isEmpty() para verificar si la cadena está vacía
                ShowDateSet(objSale.Get(criterio));
                System.out.println(objSale.getActionMessage());
            } else {
                System.out.println("Criterio incorrecto");
            }

            System.out.println("\nDesea continuar [Si: 1| No: 0]");
            opt = pin.nextShort();
            pin.nextLine(); // Consumir el carácter de nueva línea en el búfer
        } while (opt == 1);
        objSale.CloseDB();
    }

    public void SearchSales(String pin) {
        ArrayList<Sale> ArrSale = new ArrayList<Sale>();
        SaleModel objSale = new SaleModel();

        ArrSale = objSale.Get(pin);
        ShowDateSet(ArrSale);
        objSale.CloseDB();
    }

    // public void PostAuthor(Scanner pin) {
    // SaleModel objSale = new SaleModel();
    // Author author = new Author();

    // String data = "";

    // if (res) {
    // System.out.println("El autor se ha agregado correctamente");
    // } else {
    // System.out.println("ocurrio un error al agregar un nuevo autor");
    // }
    // }

    public void ShowDateSet(ArrayList<Sale> odt) {
        System.out.println("Id\t\t|No. Orden\t\t\t|Fecha\t\t|qty\t\t|payterms");
        for (Sale sale : odt) {
            System.out.println(sale.stor_id + "\t|" + sale.ord_num + "\t\t\t|" +
                    sale.ord_date + "\t\t|" + sale.qty + "\t\t|"
                    + sale.pay_terms + "\t|");
        }
    }
}
