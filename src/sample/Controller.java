package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.pojo.*;

import java.awt.*;
import java.util.Random;

public class Controller {

    private DataBase dataBase = new DataBase();

    @FXML
    private TabPane tabPane;

    @FXML
    private TableView<Film> films;

    @FXML
    private TableColumn<Film, String> name;
    @FXML
    private TableColumn<Film, Long> id;
    @FXML
    private TableColumn<Film, String> sign;
    @FXML
    private TableColumn<Film, Integer> priceOneDay;
    @FXML
    private TableColumn<Film, Integer> countCinema;
    @FXML
    private TableColumn<Film, Integer> prizes;
    @FXML
    private TableColumn<Film, Integer> duration;

    //Таблица кинотеатров
    @FXML
    private TableView<Cinema> cinemas;

    @FXML
    private TableColumn<Cinema, String> nameCinema;
    @FXML
    private TableColumn<Cinema, Long> idCinema;
    @FXML
    private TableColumn<Cinema, Integer> roominess;
    @FXML
    private TableColumn<Cinema, String> manager;
    @FXML
    private TableColumn<Cinema, String> dateStart;
    @FXML
    private TableColumn<Cinema, Integer> place1;
    @FXML
    private TableColumn<Cinema, Integer> place2;
    @FXML
    private TableColumn<Cinema, Integer> place3;


    //Таблица проката
    @FXML
    private TableView<Rental> rentalsTab;
    @FXML
    private TableColumn<Rental, Long> cinemaId;
    @FXML
    private TableColumn<Rental, Long> filmId;
    @FXML
    private TableColumn<Rental, String> startRentale;
    @FXML
    private TableColumn<Rental, String> endRentale;
    @FXML
    private TableColumn<Rental, Integer> durationRental;
    @FXML
    private TableColumn<Rental, Integer> pricePlace1;
    @FXML
    private TableColumn<Rental, Integer> pricePlace2;
    @FXML
    private TableColumn<Rental, Integer> pricePlace3;
    @FXML
    private TableColumn<Rental, Integer> proceeds;


    @FXML
    private TextField nameFilmT;
    @FXML
    private TextField idFilmT;
    @FXML
    private TextField signT;
    @FXML
    private TextField priceOneDayT;
    @FXML
    private TextField countOfCinemaT;
    @FXML
    private TextField prizesT;
    @FXML
    private TextField lengthT;

    @FXML
    private TextField nameCinemaT;
    @FXML
    private TextField idCinemaT;
    @FXML
    private TextField capacityT;
    @FXML
    private TextField FIOT;
    @FXML
    private TextField puskDateT;
    @FXML
    private TextField countPlace1T;
    @FXML
    private TextField countPlace2T;
    @FXML
    private TextField countPlace3T;

    @FXML
    private TextField filmIdRenT;
    @FXML
    private TextField cinemaIdRenT;
    @FXML
    private TextField startDateT;
    @FXML
    private TextField endDateT;
    @FXML
    private TextField longProkT;
    @FXML
    private TextField pricePlace1T;
    @FXML
    private TextField pricePlace2T;
    @FXML
    private TextField pricePlace3T;
    @FXML
    private TextField sborT;

    @FXML
    private TableView<Result> results;
    @FXML
    private TextField idResultCinema;
    @FXML
    private TableColumn<Result, Integer> idRes;
    @FXML
    private TableColumn<Result, Integer> proceedsRes;



    @FXML
    public void initialize(){
        //Связывание столбцов таблицы и полей классов
        name.setCellValueFactory(new PropertyValueFactory<Film, String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Film, Long>("id"));
        sign.setCellValueFactory(new PropertyValueFactory<Film, String>("sign"));
        priceOneDay.setCellValueFactory(new PropertyValueFactory<Film, Integer>("priceOneDay"));
        countCinema.setCellValueFactory(new PropertyValueFactory<Film, Integer>("countCinema"));
        prizes.setCellValueFactory(new PropertyValueFactory<Film, Integer>("countCinema"));
        duration.setCellValueFactory(new PropertyValueFactory<Film, Integer>("duration"));

        nameCinema.setCellValueFactory(new PropertyValueFactory<Cinema, String>("name"));
        idCinema.setCellValueFactory(new PropertyValueFactory<Cinema, Long>("id"));
        roominess.setCellValueFactory(new PropertyValueFactory<Cinema, Integer>("roominess"));
        manager.setCellValueFactory(new PropertyValueFactory<Cinema, String>("manager"));
        dateStart.setCellValueFactory(new PropertyValueFactory<Cinema, String>("dateStart"));
        place1.setCellValueFactory(new PropertyValueFactory<Cinema, Integer>("countPlace1"));
        place2.setCellValueFactory(new PropertyValueFactory<Cinema, Integer>("countPlace2"));
        place3.setCellValueFactory(new PropertyValueFactory<Cinema, Integer>("countPlace3"));

        cinemaId.setCellValueFactory(new PropertyValueFactory<Rental, Long>("cinemaId"));
        filmId.setCellValueFactory(new PropertyValueFactory<Rental, Long>("filmId"));
        startRentale.setCellValueFactory(new PropertyValueFactory<Rental, String>("startRentale"));
        endRentale.setCellValueFactory(new PropertyValueFactory<Rental, String>("endRentale"));
        durationRental.setCellValueFactory(new PropertyValueFactory<Rental, Integer>("durationRental"));
        pricePlace1.setCellValueFactory(new PropertyValueFactory<Rental, Integer>("pricePlace1"));
        pricePlace2.setCellValueFactory(new PropertyValueFactory<Rental, Integer>("pricePlace2"));
        pricePlace3.setCellValueFactory(new PropertyValueFactory<Rental, Integer>("pricePlace3"));
        proceeds.setCellValueFactory(new PropertyValueFactory<Rental, Integer>("proceeds"));

        idRes.setCellValueFactory(new PropertyValueFactory<Result, Integer>("id"));
        proceedsRes.setCellValueFactory(new PropertyValueFactory<Result, Integer>("proceeds"));


        films.setItems(dataBase.generateRandomFilms());
        cinemas.setItems(dataBase.generateRandomCinemas());
        rentalsTab.setItems(dataBase.generateRandomRental());
    }


    //Метод для перемещения по строкам
    @FXML
    public void next(){
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        String tabName = selectedTab.getText();
        if(tabName.equals("Films")){
            Film film = films.getSelectionModel().getSelectedItem();
            films.getSelectionModel().select(dataBase.getNext(film));
            edit();
        }
        if(tabName.equals("Cinema")){
            Cinema cinema = cinemas.getSelectionModel().getSelectedItem();
            cinemas.getSelectionModel().select(dataBase.getNext(cinema));
            edit();
        }
        if(tabName.equals("Rental")){
            Rental rental = rentalsTab.getSelectionModel().getSelectedItem();
            rentalsTab.getSelectionModel().select(dataBase.getNext(rental));
            edit();
        }
    }

    @FXML
    public void back(){
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        String tabName = selectedTab.getText();
        if(tabName.equals("Films")){
            Film film = films.getSelectionModel().getSelectedItem();
            films.getSelectionModel().select(dataBase.getBack(film));
            edit();
        }
        if(tabName.equals("Cinema")){
            Cinema cinema = cinemas.getSelectionModel().getSelectedItem();
            cinemas.getSelectionModel().select(dataBase.getBack(cinema));
            edit();
        }
        if(tabName.equals("Rental")){
            Rental rental = rentalsTab.getSelectionModel().getSelectedItem();
            rentalsTab.getSelectionModel().select(dataBase.getBack(rental));
            edit();
        }
    }

    @FXML
    public void add(){
        //Вытаскиваем выбранную пользователем панель
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        //Извлекаем название таблицы, которую вытащили
        String tabName = selectedTab.getText();
        Random r = new Random(System.nanoTime());
        //Ифами определяем выбранную пользователем таблицу
        if(tabName.equals("Films")){
            int id = 0;
            try {
                //Пытаемся распарсить айдишник, если не получается, значит это создание поля с нуля
                id = Integer.decode(idFilmT.getText());
                delete();
            } catch (Exception e){}

            //инициализируем новый объект фильм
            Film film = new Film(nameFilmT.getText(),
                    id,
                    signT.getText(),
                    Integer.decode(priceOneDayT.getText()),
                    Integer.decode(countOfCinemaT.getText()),
                    Integer.decode(prizesT.getText()),
                    Integer.decode(lengthT.getText()));
            films.setItems(dataBase.add(film));
            films.setVisible(false);
            films.setVisible(true);
            //Обнуляем поле id
            idFilmT.setText("Не заполняемое поле");
        }
        //По аналогии то же с другими таблицами
        if(tabName.equals("Cinema")){
            int id = 0;
            try {
                id = Integer.decode(idCinemaT.getText());
                delete();
            } catch (Exception e){}

            Cinema cinema = new Cinema(nameCinemaT.getText(),
                    id,
                    Integer.decode(capacityT.getText()),
                    FIOT.getText(), puskDateT.getText(),
                    Integer.decode(countPlace1T.getText()),
                    Integer.decode(countPlace2T.getText()),
                    Integer.decode(countPlace3T.getText()));
            cinemas.setItems(dataBase.add(cinema));
            cinemas.setVisible(false);
            cinemas.setVisible(true);
            idCinemaT.setText("Не заполняемое поле");
        }
        if(tabName.equals("Rental")){
            delete();
            Rental rental = new Rental(Long.decode(cinemaIdRenT.getText()),
                    Long.decode(filmIdRenT.getText()),
                    startDateT.getText(), endDateT.getText(),
                    0,
                    Integer.decode(pricePlace1T.getText()),
                    Integer.decode(pricePlace2T.getText()),
                    Integer.decode(pricePlace3T.getText()),
                    Integer.decode(sborT.getText()));
            dataBase.add(rental);
            refresh();
            filmIdRenT.setText("Не заполняемое поле");
            cinemaIdRenT.setText("Не заполняемое поле");
        }
    }

    //Перерисовка окна, для обновления данных
    private void refresh(){
        rentalsTab.setItems(dataBase.getRentals());
        films.setItems(dataBase.getFilms());
        cinemas.setItems(dataBase.getCinemas());
        rentalsTab.setVisible(false);
        rentalsTab.setVisible(true);
        cinemas.setVisible(false);
        cinemas.setVisible(true);
        films.setVisible(false);
        films.setVisible(true);
    }

    @FXML
    public void delete(){
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        String tabName = selectedTab.getText();
        if(tabName.equals("Films")){
            Film film = films.getSelectionModel().getSelectedItem();
            films.getItems().remove(film);
            dataBase.delete(film);
            dataBase.deleteWrongRental(film.getId());
            rentalsTab.setItems(dataBase.getRentals());
            rentalsTab.setVisible(false);
            rentalsTab.setVisible(true);
        }
        if(tabName.equals("Cinema")){
            Cinema cinema = cinemas.getSelectionModel().getSelectedItem();
            cinemas.getItems().remove(cinema);
            dataBase.delete(cinema);
        }
        if(tabName.equals("Rental")){
            Rental rental = rentalsTab.getSelectionModel().getSelectedItem();
            rentalsTab.getItems().remove(rental);
            dataBase.delete(rental);
            films.setItems(dataBase.getFilms());
            films.getColumns().get(4).setVisible(false);
            films.getColumns().get(4).setVisible(true);
        }
    }

    //Изменить запись в таблице
    @FXML
    public void edit(){
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        String tabName = selectedTab.getText();
        if(tabName.equals("Films")){
            Film film = films.getSelectionModel().getSelectedItem();
            //dataBase.delete(film);

            nameFilmT.setText(film.getName());
            idFilmT.setText(Long.toString(film.getId()));
            signT.setText(film.getSign());
            priceOneDayT.setText(Integer.toString(film.getPriceOneDay()));
            countOfCinemaT.setText(Integer.toString(film.getCountCinema()));
            prizesT.setText(Integer.toString(film.getCountPrizes()));
            lengthT.setText(Integer.toString(film.getDuration()));
        }
        if(tabName.equals("Cinema")){
            Cinema cinema = cinemas.getSelectionModel().getSelectedItem();
            //dataBase.delete(cinema);

            nameCinemaT.setText(cinema.getName());
            idCinemaT.setText(Long.toString(cinema.getId()));
            capacityT.setText(Integer.toString(cinema.getRoominess()));
            FIOT.setText(cinema.getManager());
            puskDateT.setText(cinema.getDateStart());
            countPlace1T.setText(Integer.toString(cinema.getCountPlace1()));
            countPlace2T.setText(Integer.toString(cinema.getCountPlace2()));
            countPlace3T.setText(Integer.toString(cinema.getCountPlace3()));
        }
        if(tabName.equals("Rental")){
            Rental rental = rentalsTab.getSelectionModel().getSelectedItem();
            //dataBase.delete(rental);

            filmIdRenT.setText(Long.toString(rental.getFilmId()));
            cinemaIdRenT.setText(Long.toString(rental.getCinemaId()));
            startDateT.setText(rental.getStartRentale());
            endDateT.setText(rental.getEndRentale());
            longProkT.setText(Integer.toString(rental.getDurationRental()));
            pricePlace1T.setText(Integer.toString(rental.getPricePlace1()));
            pricePlace2T.setText(Integer.toString(rental.getPricePlace2()));
            pricePlace3T.setText(Integer.toString(rental.getPricePlace3()));
            sborT.setText(Integer.toString(rental.getProceeds()));
        }
    }

    //Для заданного кинотеатра выдать список фильмов отечественного производства, которые когда-либо шли в этом кинотеатре
    @FXML
    public void findFilms(){
        int cinemaId =Integer.decode(idResultCinema.getText());
        results.setItems(dataBase.findFilm(cinemaId));
        results.setVisible(false);
        results.setVisible(true);
        proceedsRes.setVisible(false);
        refresh();
    }

    // Выдать список кинотеатров, в которых в 2000 году шли только зарубежные фильмы.
    @FXML
    public void findCinema(){
        results.setItems(dataBase.findCinemas());
        results.setVisible(false);
        results.setVisible(true);
        proceedsRes.setVisible(false);
        refresh();
    }

    //Для каждого кинотеатра подсчитать сумму реального сбора с проката фильмов за апрель 2000 года.
    @FXML
    public void findSbor(){
        results.setItems(dataBase.findSbor());
        results.setVisible(false);
        results.setVisible(true);
        proceedsRes.setVisible(true);
        refresh();
    }
}
