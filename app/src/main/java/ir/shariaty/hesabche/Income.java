package ir.shariaty.hesabche;

import java.util.Map;

public class Income {

    private String incomeId;
    private String amount;
    private String cat;
    private String title;
    private String date;
    private String desc;

    public Income(String id, Map<String, Object> data) {
    }


    public Income(String incomeId, String amount, String cat, String title, String date, String desc) {
        this.incomeId = incomeId;
        this.amount = amount;
        this.cat = cat;
        this.title = title;
        this.date = date;
        this.desc = desc;
    }

    public String getIncomeId() { return incomeId; }

    public void setIncomeId(String incomeId) { this.incomeId = incomeId; }

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
