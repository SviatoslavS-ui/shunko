package libs;

public class DealTimeAndDate {

    /* ввожу класс для хранения даты и времени сделок, так как там 5 переменных */
    /* разных типов (решил сделать все переменные типа String) для этих полей */

    private String dealDate;
    private String dealMonth;
    private String dealYear;
    private String dealHour;
    private String dealMinute;

    public DealTimeAndDate(String dealDate, String dealMonth, String dealYear, String dealHour, String dealMinute) {
        this.dealDate = dealDate;
        this.dealMonth = dealMonth;
        this.dealYear = dealYear;
        this.dealHour = dealHour;
        this.dealMinute = dealMinute;
    }
    public String getDealDate(){
        return dealDate;
    }
    public String getDealMonth(){
        return dealMonth;
    }
    public String getDealYear(){
        return dealYear;
    }
    public String getDealHour(){
        return dealHour;
    }
    public String getDealMinute(){
        return dealMinute;
    }
}
