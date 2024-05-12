package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.DBEntity;
import data.Sale;

public class SaleModel extends DBEntity {
    private ArrayList<Sale> saleModel;

    public SaleModel() {

    }

    public void Mapping(ResultSet dset) {
        saleModel = new ArrayList<Sale>();

        try {
            while (dset.next()) {
                Sale objau = new Sale();
                objau.stor_id = dset.getString("stor_id");
                objau.ord_num = dset.getString("ord_num");
                objau.ord_date = dset.getDate("ord_date");
                objau.qty = dset.getInt("qty");
                objau.pay_terms = dset.getString("payterms");
                objau.title_id = dset.getString("title_id");

                saleModel.add(objau);
            }
            dset.close();
        } catch (SQLException e) {
            System.out.println("error " + e);
        }
    }

    public ArrayList<Sale> getAll() {
        String sql = "Select * from sales";
        Mapping(getData(sql));

        return saleModel;
    }

    public ArrayList<Sale> Get(String shc) {

        String sql = "Select * from sales where ";
        sql += "concat(stor_id) LIKE '%" + shc + "%'";

        Mapping(getData(sql));

        return saleModel;
    }

    // public boolean Put(Sale odata) {
    // String sql = "update sales set campo = valor *** ....where ";
    // return execSQL(sql);
    // }

    // public boolean Post(Sale odata) {
    // String sql = "INSERT INTO sales (au_id, au_lname, au_fname, phone, address,
    // contract ) VALUES ( ";
    // sql += "'" + odata.auid + "', '" + odata.aulname + "', '" + odata.aufname +
    // "', '" + odata.auphone + "', '"
    // + odata.auaddress + "', '" + odata.aucontract + "');";
    // System.out.println(sql); // Para verificar la consulta SQL generada
    // return execSQL(sql);
    // }
}
