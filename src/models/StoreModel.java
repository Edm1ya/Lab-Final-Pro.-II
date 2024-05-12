package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Store;
import data.DBEntity;

public class StoreModel extends DBEntity {
    private ArrayList<Store> stores;

    public StoreModel() {

    }

    public void Mapping(ResultSet dset) {
        stores = new ArrayList<Store>();

        try {
            while (dset.next()) {
                Store store = new Store();
                store.stor_id = dset.getString("stor_id");
                store.stor_name = dset.getString("stor_name");
                store.stor_address = dset.getString("stor_address");
                store.city = dset.getString("city");
                store.state = dset.getString("state");
                store.zip = dset.getString("zip");

                stores.add(store);
            }
            dset.close();
        } catch (SQLException e) {
            System.out.println("error " + e);
        }
    }

    public ArrayList<Store> getAll() {
        String sql = "Select * from stores";
        Mapping(getData(sql));

        return stores;
    }

    public ArrayList<Store> Get(String shc) {

        String sql = "Select * from stores where ";
        sql += "concat(stor_id, stor_name, stor_address, city) LIKE '%" + shc + "%'";

        Mapping(getData(sql));

        return stores;
    }

    public Store GetFirst(String shc) {
        String sql = "SELECT * FROM stores WHERE ";
        sql += "CONCAT(stor_id, stor_name, stor_address, city) LIKE '%" + shc + "%' LIMIT 1";

        Mapping(getData(sql));

        if (!stores.isEmpty()) {
            return stores.get(0); // Devuelve el primer elemento del ArrayList
        } else {
            return null; // Si no se encuentra ningún resultado, devuelve null
        }
    }

    // public boolean Put(Store odata) {
    // String sql = "update stores set campo = valor *** ....where ";
    // return execSQL(sql);
    // }

    // public boolean Post(Store odata) {
    // String sql = "INSERT INTO stores (au_id, au_lname, au_fname, phone, address,
    // contract ) VALUES ( ";
    // sql += "'" + odata.auid + "', '" + odata.aulname + "', '" + odata.aufname +
    // "', '" + odata.auphone + "', '"
    // + odata.auaddress + "', '" + odata.aucontract + "');";
    // System.out.println(sql); // Para verificar la consulta SQL generada
    // return execSQL(sql);
    // }
}
