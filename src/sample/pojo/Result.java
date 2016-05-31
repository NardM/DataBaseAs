package sample.pojo;


public class Result {
    private int id;
    private int proceeds;

    public Result(int id, int proceeds) {
        this.id = id;
        this.proceeds = proceeds;
    }

    public Result() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProceeds() {
        return proceeds;
    }

    public void setProceeds(int proceeds) {
        this.proceeds = proceeds;
    }
}
