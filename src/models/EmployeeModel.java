package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import data.DBEntity;
import data.Employee;

public class EmployeeModel extends DBEntity {
    private ArrayList<Employee> aumodel;

    public EmployeeModel() {

    }

    public void Mapping(ResultSet dset) {
        aumodel = new ArrayList<Employee>();

        try {
            while (dset.next()) {
                Employee objau = new Employee();
                objau.emp_id = dset.getString("emp_id");
                objau.fname = dset.getString("fname");
                objau.minit = dset.getString("minit");
                objau.lname = dset.getString("lname");
                objau.job_id = dset.getInt("job_id");
                objau.job_lvl = dset.getInt("job_lvl");
                objau.pub_id = dset.getString("pub_id");
                objau.hire_date = dset.getDate("hire_date");

                aumodel.add(objau);
            }
            dset.close();
        } catch (SQLException e) {
            System.out.println("error " + e);
        }
    }

    public ArrayList<Employee> getAll() {
        String sql = "Select * from employee";
        Mapping(getData(sql));

        return aumodel;
    }

    public ArrayList<Employee> Get(String shc) {

        String sql = "Select * from employee where ";
        sql += "concat(emp_id, fname, lname) LIKE '%" + shc + "%'";

        Mapping(getData(sql));

        return aumodel;
    }

    // public boolean Put(Employee odata) {
    // String sql = "update employee set campo = valor *** ....where ";
    // return execSQL(sql);
    // }

    // public boolean Post(Employee odata) {
    // String sql = "INSERT INTO employee (au_id, au_lname, au_fname, phone,
    // address, contract ) VALUES ( ";
    // sql += "'" + odata.auid + "', '" + odata.aulname + "', '" + odata.aufname +
    // "', '" + odata.auphone + "', '"
    // + odata.auaddress + "', '" + odata.aucontract + "');";
    // System.out.println(sql); // Para verificar la consulta SQL generada
    // return execSQL(sql);
    // }
}
