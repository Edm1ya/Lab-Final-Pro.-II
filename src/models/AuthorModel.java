package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import data.Author;
import data.DBEntity;

public class AuthorModel extends DBEntity {
    private ArrayList<Author> aumodel;

    public AuthorModel() {

    }

    public void Mapping(ResultSet dset) {
        aumodel = new ArrayList<Author>();

        try {
            while (dset.next()) {
                Author objau = new Author();
                objau.auid = dset.getString("au_id");
                objau.aufname = dset.getString("au_lname");
                objau.aulname = dset.getString("au_fname");
                objau.auphone = dset.getString("phone");
                objau.auaddress = dset.getString("address");

                aumodel.add(objau);
            }
            dset.close();
        } catch (SQLException e) {
            System.out.println("error " + e);
        }
    }

    public ArrayList<Author> getAll() {
        String sql = "Select * from authors";
        Mapping(getData(sql));

        return aumodel;
    }

    public ArrayList<Author> Get(String shc) {

        String sql = "Select * from authors where ";
        sql += "concat(au_lname, au_fname) LIKE '%" + shc + "%'";

        Mapping(getData(sql));

        return aumodel;
    }

    public boolean Put(Author odata) {
        String sql = "update authors set campo = valor *** ....where ";
        return execSQL(sql);
    }

    public boolean Post(Author odata) {
        String sql = "INSERT INTO authors (au_id, au_lname, au_fname, phone, address, contract ) VALUES ( ";
        sql += "'" + odata.auid + "', '" + odata.aulname + "', '" + odata.aufname + "', '" + odata.auphone + "', '"
                + odata.auaddress + "', '" + odata.aucontract + "');";
        System.out.println(sql); // Para verificar la consulta SQL generada
        return execSQL(sql);
    }
}
