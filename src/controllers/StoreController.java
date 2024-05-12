package controllers;

import java.util.ArrayList;

import data.Store;
import models.StoreModel;

public class StoreController {

    public void allStore() {
        StoreModel objStore = new StoreModel();
        ShowDateSet(objStore.getAll());

        objStore.CloseDB();
    }

    public ArrayList<Store> NameStore() {
        StoreModel objStore = new StoreModel();
        ArrayList<Store> str;
        str = ShowDate(objStore.getAll());
        objStore.CloseDB();

        return str;
    }

    public void getStore(Store store) {
        SalesController salesController = new SalesController();
        StoreModel objStore = new StoreModel();
        salesController.SearchSales(objStore.GetFirst(store.stor_name).stor_id);
        System.out.println(objStore.GetFirst(store.stor_name).stor_name);
    }

    public void ShowDateSet(ArrayList<Store> odt) {
        System.out.println("Id\t\t|Nombre\t\t\t|Dir\t\t|Ciudad\t\t|Estado\t\t|Codigo Postal");
        for (Store store : odt) {
            System.out.println(store.stor_id + "\t|" + store.stor_name + "\t\t\t|" +
                    store.stor_address + "\t\t|" + store.city + "\t\t|"
                    + store.state + "\t|" + store.zip + "\t|");
        }
    }

    public ArrayList<Store> ShowDate(ArrayList<Store> odt) {
        int cont = 0;
        for (Store store : odt) {
            System.out.println(cont + "| " + store.stor_name);
            cont++;
        }
        return odt;
    }
}
