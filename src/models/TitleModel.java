package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.Title;
import data.DBEntity;

public class TitleModel extends DBEntity {
    private ArrayList<Title> timodel;

    public TitleModel() {

    }

    public void Mapping(ResultSet dset) {
        timodel = new ArrayList<Title>();

        try {
            while (dset.next()) {
                Title objau = new Title();
                objau.id = dset.getString("title_id");
                objau.name = dset.getString("title");
                objau.type = dset.getString("type");
                objau.pub_id = dset.getString("pub_id");
                objau.price = dset.getFloat("price");
                objau.advance = dset.getFloat("advance");
                objau.royalty = dset.getInt("royalty");
                objau.ytd_sales = dset.getInt("ytd_sales");
                objau.notes = dset.getString("notes");
                objau.pub_date = dset.getDate("pubdate");

                timodel.add(objau);
            }
            dset.close();
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("error " + e);
        }
    }

    public ArrayList<Title> getAll() {
        String sql = "Select * from titles";
        Mapping(getData(sql));

        return timodel;
    }

    public ArrayList<Title> Get(String shc) {

        String sql = "Select * from titles where ";
        sql += "concat(title, type, title_id, pub_id, price) LIKE '%" + shc + "%'";

        Mapping(getData(sql));

        return timodel;
    }

    public boolean Put(Title odata) {
        String sql = "update authors set campo = valor *** ....where ";
        return execSQL(sql);
    }

    public boolean Post(Title odata) {
        String sql = "insert into authors (col1, col2, ... *** .... ) values ( ";
        sql += "'" + odata.id + "','...);";

        return execSQL(sql);
    }
}
