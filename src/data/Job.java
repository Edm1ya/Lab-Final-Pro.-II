package data;

public class Job {
    public String job_id;
    public String job_desc;
    public int min_lvl;
    public int max_lvl;

    public Job() {
    }

    public Job(String job_id, String job_desc, int min_lvl, int max_lvl) {
        this.job_id = job_id;
        this.job_desc = job_desc;
        this.min_lvl = min_lvl;
        this.max_lvl = max_lvl;
    }
}
