package data;

public class Author {

    public String auid;
    public String aulname;
    public String aufname;
    public String auphone;
    public String auaddress;
    public String aucity;
    public String austate;
    public String auzip;
    public Boolean aucontract;

    public Author() {

        this.auid = "";
        this.aulname = "";
        this.aufname = "";
        this.auphone = "";
        this.auaddress = "";
        this.aucity = "";
        this.austate = "";
        this.auzip = "";
        this.aucontract = false;
    }

    public Author(String auid, String aulname, String aufname, String auphone, String auaddress, Boolean aucontract) {

        this.auid = auid;
        this.aulname = aulname;
        this.aufname = aufname;
        this.auphone = auphone;
        this.auaddress = auaddress;
        this.aucontract = aucontract;
    }
}
