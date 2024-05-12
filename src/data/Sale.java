package data;

import java.util.Date;

public class Sale {
    public String stor_id;
    public String ord_num;
    public Date ord_date;
    public int qty;
    public String pay_terms;
    public String title_id;

    public Sale() {
    }

    public Sale(String stor_id, String ord_num, int qty, String pay_terms, String title_id) {
        this.stor_id = stor_id;
        this.ord_num = ord_num;
        this.qty = qty;
        this.pay_terms = pay_terms;
        this.title_id = title_id;
    }
}
