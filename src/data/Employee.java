package data;

import java.util.Date;

public class Employee {
    public String emp_id;
    public String fname;
    public String minit;
    public String lname;
    public int job_id;
    public int job_lvl;
    public String pub_id;
    public Date hire_date;

    public Employee() {
    }

    public Employee(String emp_id, String fname, String minit, String lname, int job_id, int job_lvl, String pub_id,
            Date hire_date) {

        this.emp_id = emp_id;
        this.fname = fname;
        this.minit = minit;
        this.lname = lname;
        this.job_id = job_id;
        this.job_lvl = job_lvl;
        this.pub_id = pub_id;
        this.hire_date = hire_date;
    }
}
