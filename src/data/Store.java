package data;

public class Store {
    public String stor_id;
    public String stor_name;
    public String stor_address;
    public String city;
    public String state;
    public String zip;

    public Store() {
    }

    public Store(String stor_id, String stor_name, String stor_address, String city, String state, String zip) {
        this.stor_id = stor_id;
        this.stor_name = stor_name;
        this.stor_address = stor_address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
