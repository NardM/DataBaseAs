package sample.pojo;

public class Film {
    private String name;
    private long id;
    private String sign;
    private int priceOneDay;
    private int countCinema;
    private int countPrizes;
    private int duration;

    public Film() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getPriceOneDay() {
        return priceOneDay;
    }

    public void setPriceOneDay(int priceOneDay) {
        this.priceOneDay = priceOneDay;
    }

    public int getCountCinema() {
        return countCinema;
    }

    public void setCountCinema(int countCinema) {
        this.countCinema = countCinema;
    }

    public int getCountPrizes() {
        return countPrizes;
    }

    public void setCountPrizes(int countPrizes) {
        this.countPrizes = countPrizes;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Film(String name, long id, String sign, int priceOneDay, int countCinema, int countPrizes, int duration) {

        this.name = name;
        this.id = id;
        this.sign = sign;
        this.priceOneDay = priceOneDay;
        this.countCinema = countCinema;
        this.countPrizes = countPrizes;
        this.duration = duration;
    }

    public int decrementCountCinema(){
        countCinema--;
        return countCinema;
    }

    public int incrementCountCinema(){
        countCinema++;
        return countCinema;
    }
}
