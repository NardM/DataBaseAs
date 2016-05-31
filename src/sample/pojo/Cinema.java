package sample.pojo;

public class Cinema {

    private String name;
    private long id;
    private int roominess;
    private String manager;
    private String dateStart;
    private int countPlace1;
    private int countPlace2;
    private int countPlace3;

    public Cinema() {
    }

    public Cinema(String name, long id, int roominess, String manager, String dateStart, int countPlace1, int countPlace2, int countPlace3) {
        this.name = name;
        this.id = id;
        this.roominess = roominess;
        this.manager = manager;
        this.dateStart = dateStart;
        this.countPlace1 = countPlace1;
        this.countPlace2 = countPlace2;
        this.countPlace3 = countPlace3;
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

    public int getRoominess() {
        return roominess;
    }

    public void setRoominess(int roominess) {
        this.roominess = roominess;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public int getCountPlace1() {
        return countPlace1;
    }

    public void setCountPlace1(int countPlace1) {
        this.countPlace1 = countPlace1;
    }

    public int getCountPlace2() {
        return countPlace2;
    }

    public void setCountPlace2(int countPlace2) {
        this.countPlace2 = countPlace2;
    }

    public int getCountPlace3() {
        return countPlace3;
    }

    public void setCountPlace3(int countPlace3) {
        this.countPlace3 = countPlace3;
    }
}
