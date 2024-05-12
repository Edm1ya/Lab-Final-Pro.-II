package data;

import java.util.Date;

public class Title {
    public String id;
    public String name;
    public String type;
    public String pub_id;
    public float price;
    public float advance;
    public int royalty;
    public int ytd_sales;
    public String notes;
    public Date pub_date;

    public Title() {
    }

    public Title(String id, String name, String type, String pub_id, float price, float advance, int royalty,
            int ytd_sales, String notes, Date pub_date) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.pub_id = pub_id;
        this.price = price;
        this.advance = advance;
        this.royalty = royalty;
        this.ytd_sales = ytd_sales;
        this.notes = notes;
        this.pub_date = pub_date;
    }

}
