package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import data.DBEntity;
import data.Job;

public class JobModel extends DBEntity {

    private ArrayList<Job> jobmodel;

    public JobModel() {

    }

    public void Mapping(ResultSet dset) {
        jobmodel = new ArrayList<Job>();

        try {
            while (dset.next()) {
                Job objau = new Job();
                objau.job_id = dset.getString("job_id");
                objau.job_desc = dset.getString("job_desc");
                objau.min_lvl = dset.getInt("min_lvl");
                objau.max_lvl = dset.getInt("max_lvl");

                jobmodel.add(objau);
            }
            dset.close();
        } catch (SQLException e) {
            System.out.println("error " + e);
        }
    }

    public ArrayList<Job> getAll() {
        String sql = "Select * from jobs";
        Mapping(getData(sql));

        return jobmodel;
    }

    public ArrayList<Job> Get(String shc) {

        String sql = "Select * from jobs where ";
        sql += "concat(job_id, job_desc) LIKE '%" + shc + "%'";

        Mapping(getData(sql));

        return jobmodel;
    }

    // public boolean Put(Job odata) {
    // String sql = "update authors set campo = valor *** ....where ";
    // return execSQL(sql);
    // }

    // public boolean Post(Job odata) {
    // String sql = "INSERT INTO authors (au_id, au_lname, au_fname, phone, address,
    // contract ) VALUES ( ";
    // sql += "'" + odata.auid + "', '" + odata.aulname + "', '" + odata.aufname +
    // "', '" + odata.auphone + "', '"
    // + odata.auaddress + "', '" + odata.aucontract + "');";
    // System.out.println(sql); // Para verificar la consulta SQL generada
    // return execSQL(sql);
    // }
}
