package sample.pojo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.Inet4Address;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataBase {
    ObservableList<Film> films;
    ObservableList<Cinema> cinemas;
    ObservableList<Rental> rentals;


    public ObservableList<Film> generateRandomFilms(){
        //Заполнение тестовыми данными
        films = FXCollections.observableArrayList();
        films.add(new Film("name1", 1, "Зарубежный", 500, 3, 0, 120));
        films.add(new Film("name2", 2, "Отечественный", 400, 2, 1, 160));
        films.add(new Film("name3", 3, "Зарубежный", 1800, 1, 1, 130));
        films.add(new Film("name4", 4, "Отечественный", 1400, 1, 1, 90));
        films.add(new Film("name5", 5, "Отечественный", 800, 1, 0, 160));
        films.add(new Film("name6", 6, "Зарубежный", 1800, 1, 4, 130));
        return films;
    }

    public ObservableList<Cinema> generateRandomCinemas(){
        cinemas = FXCollections.observableArrayList();
        cinemas.add(new Cinema("name1", 1, 60, "Manager1", "10.02.1997", 20, 20, 20));
        cinemas.add(new Cinema("name2", 2, 70, "Manager2", "12.11.2000", 20, 25, 25));
        cinemas.add(new Cinema("name3", 3, 50, "Manager3", "15.02.2003", 10, 10, 30));
        cinemas.add(new Cinema("name4", 4, 90, "Manager4", "20.05.1999", 20, 30, 40));
        cinemas.add(new Cinema("name5", 5, 80, "Manager5", "30.11.2007", 15, 30, 35));
        return cinemas;
    }

    public ObservableList<Rental> generateRandomRental(){
        rentals = FXCollections.observableArrayList();
        rentals.add(new Rental(1, 1, "10.12.2000", "28.15.2000", 18, 50, 40, 20, 1000));
        rentals.add(new Rental(2, 1, "13.12.2015", "25.15.2015", 12, 40, 35, 25, 980));
        rentals.add(new Rental(5, 1, "2.12.2015", "20.15.2015", 18, 45, 35, 30, 1300));
        rentals.add(new Rental(3, 2, "2.01.2016", "15.01.2016", 13, 45, 35, 30, 1400));
        rentals.add(new Rental(4, 2, "4.02.2016", "10.02.2016", 6, 49, 38, 40, 2000));
        rentals.add(new Rental(2, 3, "13.12.2015", "29.12.2015", 16, 40, 35, 25, 1480));
        rentals.add(new Rental(3, 4, "10.02.2016", "25.02.2015", 15, 45, 35, 30, 1300));
        rentals.add(new Rental(5, 5, "1.03.2016", "21.03.2015", 20, 50, 20, 30, 1500));
        rentals.add(new Rental(5, 3, "28.03.2016", "15.04.2015", 17, 45, 23, 37, 1900));
        return rentals;
    }

    public ObservableList<Film> getFilms() {
        return films;
    }

    public ObservableList<Cinema> getCinemas() {
        return cinemas;
    }

    public ObservableList<Rental> getRentals() {
        return rentals;
    }

    public ObservableList<Film> delete(Film film){
        films.remove(film);
        return films;
    }

    public ObservableList<Cinema> delete(Cinema cinema){
        cinemas.remove(cinema);
        return cinemas;
    }

    public ObservableList<Rental> delete(Rental rental){
        rentals.remove(rental);
        Film film = findFilmById(rental.getFilmId());
        film.decrementCountCinema();
        return rentals;
    }



    //добавление записи в базу, для трех видов обьектов
    public ObservableList<Film> add(Film film){
        if(film.getId() == 0){
            film.setId(generateId());
        }
        films.add(film);
        return films;
    }

    public ObservableList<Cinema> add(Cinema cinema){
        if(cinema.getId() == 0){
            cinema.setId(generateId());
        }
        cinemas.add(cinema);
        return cinemas;
    }


    public ObservableList<Rental> add(Rental rental){
        rentals.add(counterOfDay(rental));
        findFilmById(rental.getFilmId()).incrementCountCinema();
        return rentals;
    }

    private Film findFilmById(long filmId) {
        for(Film f : films){
            if(f.getId() == filmId){
                return f;
            }
        }
        return null;
    }


    private Cinema findCinemaById(long cinemaId) {
        for(Cinema c : cinemas){
            if(c.getId() == cinemaId){
                return c;
            }
        }
        return null;
    }


    //Триггер на удаление не валидных записей прката(такого фильма уже нет, например)
    public void deleteWrongRental(long id) {
        int size = rentals.size();
        for(int i = 0; i < size; i++){
            if(rentals.get(i).getFilmId() == id){
                rentals.remove(i);
                i--;
                size--;
            }
        }
    }

    private long generateId(){
        return new Random(System.nanoTime()).nextInt(2000);
    }

    //Подсчет количества дней в прокате на основе введенных дат начала и конца проката
    private Rental counterOfDay(Rental r){
        String start = r.getStartRentale();
        String end = r.getEndRentale();
        String[] bufSt = start.split("\\.");
        String[] bufEnd = end.split("\\.");
        int[] s = new int[3];
        int[] e = new int[3];
        for(int i = 0; i < 3; i++){
            s[i] = Integer.decode(bufSt[i]);
            e[i] = Integer.decode(bufEnd[i]);
        }
        int d = (365 * e[2] + 30 *  e[1] + e[0]) - (365 * s[2] + 30 *  s[1] + s[0]);
        r.setDurationRental(d);
        return r;
    }

    //Для заданного кинотеатра выдать список фильмов отечественного производства, которые когда-либо шли в этом кинотеатре
    public ObservableList<Result> findFilm(int cinemaId) {
        ObservableList<Result> results = FXCollections.observableArrayList();
        for(Rental r : rentals){
            if((int)r.getCinemaId() == cinemaId){
                Film f = findFilmById(r.getFilmId());
                if(f.getSign().equals("Отечественный")){
                    results.add(new Result((int) f.getId(), 0));
                }
            }
        }
        return results;
    }

    // Выдать список кинотеатров, в которых в 2000 году шли только зарубежные фильмы.
    public ObservableList<Result> findCinemas() {
        ObservableList<Result> results = FXCollections.observableArrayList();
        List<Cinema> cins = new LinkedList<>(cinemas);
        //обход прокатов с постепенным вычеркивание кинотеатров не удовлетворяющих условию поиска
        for(Rental r : rentals) {
            if (is2000(r.getStartRentale())) {
                Film f = findFilmById(r.getFilmId());
                if (f.getSign().equals("Отечественный")) {
                    for (int i = 0; i < cins.size(); i++) {
                        Cinema c = cins.get(i);
                        if (c.getId() == r.getCinemaId()) {
                            cins.remove(c);
                            i--;
                        }
                    }
                }
            } else {
                for (int i = 0; i < cins.size(); i++) {
                    Cinema c = cins.get(i);
                    if (c.getId() == r.getCinemaId()) {
                        cins.remove(c);
                        i--;
                    }
                }
            }
        }

        for(Cinema c : cins){
            results.add(new Result((int)c.getId(), 0));
        }
        return results;
    }

    //Для каждого кинотеатра подсчитать сумму реального сбора с проката фильмов за апрель 2000 года.
    public ObservableList<Result> findSbor() {
        ObservableList<Result> results = FXCollections.observableArrayList();
        for(Cinema c : cinemas){
            int sbor = 0;
            Result result = new Result();
            for(Rental r : rentals){
                if(c.getId() == r.getCinemaId() && isAprilAnd2000(r.getStartRentale())){
                    sbor += r.getProceeds();
                }
            }
            results.add(new Result((int)c.getId(), sbor));
        }
        return results;
    }

    private boolean is2000(String date){
        date = date.trim();
        String[] buf = date.split("\\.");
        String age = buf[2];
        return age.equals("2000");
    }

    private boolean isAprilAnd2000(String date){
        date = date.trim();
        String[] buf = date.split("\\.");
        String age = buf[1];
        return age.equals("04") && is2000(date);
    }

    private boolean conteins(int[] arr, int a){
        for(int i = 0; i < arr.length; i++){
            if(a == arr[i]){
                return true;
            }
        }
        return false;
    }

    public Film getNext(Film film) {
        int ind = films.indexOf(film);
        ind++;
        if(ind < films.size()) {
            return films.get(ind);
        } else {
            return film;
        }
    }

    public Cinema getNext(Cinema cinema) {
        int ind = cinemas.indexOf(cinema);
        ind++;
        if(ind < cinemas.size()) {
            return cinemas.get(ind);
        } else {
            return cinema;
        }
    }

    public Rental getNext(Rental rental) {
        int ind = rentals.indexOf(rental);
        ind++;
        if(ind < rentals.size()) {
            return rentals.get(ind);
        } else {
            return rental;
        }
    }

    public Film getBack(Film film) {
        int ind = films.indexOf(film);
        ind--;
        if(ind > films.size()) {
            return films.get(ind);
        } else {
            return film;
        }
    }

    public Cinema getBack(Cinema cinema) {
        int ind = cinemas.indexOf(cinema);
        ind--;
        if(ind >cinemas.size()) {
            return cinemas.get(ind);
        } else {
            return cinema;
        }
    }

    public Rental getBack(Rental rental) {
        int ind = rentals.indexOf(rental);
        ind--;
                if(ind > rentals.size()) {
            return rentals.get(ind);
        } else {
            return rental;
        }
    }
}
