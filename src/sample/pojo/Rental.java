package sample.pojo;

public class Rental {
    private long cinemaId;
    private long filmId;
    private String startRentale;
    private String endRentale;
    private int durationRental;
    private int pricePlace1;
    private int pricePlace2;
    private int pricePlace3;
    private int proceeds;

    public Rental(long cinemaId, long filmId, String startRentale, String endRentale, int durationRental, int pricePlace1, int pricePlace2, int pricePlace3, int proceeds) {
        this.cinemaId = cinemaId;
        this.filmId = filmId;
        this.startRentale = startRentale;
        this.endRentale = endRentale;
        this.durationRental = durationRental;
        this.pricePlace1 = pricePlace1;
        this.pricePlace2 = pricePlace2;
        this.pricePlace3 = pricePlace3;
        this.proceeds = proceeds;
    }

    public Rental() {
    }

    public long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(long cinemaId) {
        this.cinemaId = cinemaId;
    }

    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public String getStartRentale() {
        return startRentale;
    }

    public void setStartRentale(String startRentale) {
        this.startRentale = startRentale;
    }

    public String getEndRentale() {
        return endRentale;
    }

    public void setEndRentale(String endRentale) {
        this.endRentale = endRentale;
    }

    public int getDurationRental() {
        return durationRental;
    }

    public void setDurationRental(int durationRental) {
        this.durationRental = durationRental;
    }

    public int getPricePlace1() {
        return pricePlace1;
    }

    public void setPricePlace1(int pricePlace1) {
        this.pricePlace1 = pricePlace1;
    }

    public int getPricePlace2() {
        return pricePlace2;
    }

    public void setPricePlace2(int pricePlace2) {
        this.pricePlace2 = pricePlace2;
    }

    public int getPricePlace3() {
        return pricePlace3;
    }

    public void setPricePlace3(int pricePlace3) {
        this.pricePlace3 = pricePlace3;
    }

    public int getProceeds() {
        return proceeds;
    }

    public void setProceeds(int proceeds) {
        this.proceeds = proceeds;
    }
}
