package ir.shariaty.hesabche;

public class Outgo {

    private String amount;
    private String outgoId;
    private String cat;
    private String title;
    private String date;
    private String desc;

    public Outgo() {
    }

    public Outgo(String outgoId, String amount, String cat, String title, String date, String desc) {
        this.outgoId = outgoId;
        this.amount = amount;
        this.cat = cat;
        this.title = title;
        this.date = date;
        this.desc = desc;
    }

    public String getOutgoId() { return outgoId; }

    public void setOutgoId(String outgoId) { this.outgoId = outgoId; }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
