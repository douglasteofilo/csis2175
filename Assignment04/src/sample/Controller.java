package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private RadioButton airlineRB;

    @FXML
    private RadioButton airlineNoRB;

    @FXML
    private RadioButton departureRB;

    @FXML
    private RadioButton arrivalRB;

    @FXML
    private ChoiceBox<String> airlineCB;

    @FXML
    private ChoiceBox<String> airlineNoCB;

    @FXML
    private ChoiceBox<String> departureCB;

    @FXML
    private ChoiceBox<String> arrivalCB;

    @FXML
    private ListView<String> listViewBox;

    private List<String> input;
    private List<String> colum1 = new ArrayList<>();
    private List<String> colum2 = new ArrayList<>();;
    private List<String> colum3 = new ArrayList<>();;
    private List<String> colum4 = new ArrayList<>();;
    private String col;

    @FXML
    void handleAirlineCB(MouseEvent event) {
        airlineCB.setOnAction((evt) -> {
            col = airlineCB.getValue();
            //System.out.println(str);
        });
    }

    @FXML
    void handleAirlineNoCB(MouseEvent event) {
        airlineNoCB.setOnAction((evt) -> {
            col = airlineNoCB.getValue();
            //System.out.println(str);
        });
    }

    @FXML
    void handleDepartureCB(MouseEvent event) {
        departureCB.setOnAction((evt) -> {
            col = departureCB.getValue();
            //System.out.println(str);
        });
    }

    @FXML
    void handleArrivalCB(MouseEvent event) {
        arrivalCB.setOnAction((evt) -> {
            col = arrivalCB.getValue();
            //System.out.println(str);
        });
    }

    @FXML
    void handleAirlineNoRB(ActionEvent event) {
        airlineRB.setSelected(false);
        airlineNoRB.setSelected(true);
        departureRB.setSelected(false);
        arrivalRB.setSelected(false);

        airlineCB.setDisable(true);
        departureCB.setDisable(true);
        arrivalCB.setDisable(true);
        airlineNoCB.setDisable(false);

        ObservableList<String> obList = FXCollections.observableList(colum2);
        airlineNoCB.getItems().addAll(obList);
    }

    @FXML
    void handleAirlineRB(ActionEvent event) {
        airlineRB.setSelected(true);
        airlineNoRB.setSelected(false);
        departureRB.setSelected(false);
        arrivalRB.setSelected(false);

        departureCB.setDisable(true);
        airlineNoCB.setDisable(true);
        arrivalCB.setDisable(true);
        airlineCB.setDisable(false);


        ObservableList<String> obList = FXCollections.observableList(colum1);
        airlineCB.getItems().addAll(obList);
    }

    @FXML
    void handleArrivalRB(ActionEvent event) {
        airlineRB.setSelected(false);
        airlineNoRB.setSelected(false);
        departureRB.setSelected(false);
        arrivalRB.setSelected(true);

        airlineCB.setDisable(true);
        airlineNoCB.setDisable(true);
        departureCB.setDisable(true);
        arrivalCB.setDisable(false);

        ObservableList<String> obList = FXCollections.observableList(colum4);
        arrivalCB.getItems().addAll(obList);
    }

    @FXML
    void handleCloseBtn(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void handleDepartureRB(ActionEvent event) {
        airlineRB.setSelected(false);
        airlineNoRB.setSelected(false);
        arrivalRB.setSelected(false);
        departureRB.setSelected(true);

        airlineCB.setDisable(true);
        airlineNoCB.setDisable(true);
        arrivalCB.setDisable(true);
        departureCB.setDisable(false);

        ObservableList<String> obList = FXCollections.observableList(colum3);
        departureCB.getItems().addAll(obList);
    }

    @FXML
    void handleSearchBtn() {
        BufferedReader in = null;
        listViewBox.getItems().clear();
        try {
            in = new BufferedReader(new FileReader("C:\\Users\\douglas\\Desktop\\Assignment04\\Flight.txt"));
            String str;
            input = new ArrayList<String>();
            while((str = in.readLine()) != null){
                String[] s = str.split(",");
                if(col.equals(s[0])) {
                    listViewBox.getItems().add(s[0] + " \t\t" + s[1] + " \t\t" + s[2] + " \t\t" + s[3]);
                }
                if(col.equals(s[1])) {
                    listViewBox.getItems().add(s[0] + " \t\t" + s[1] + " \t\t" + s[2] + " \t\t" + s[3]);
                }
                if(col.equals(s[2])) {
                    listViewBox.getItems().add(s[0] + " \t\t" + s[1] + " \t\t" + s[2] + " \t\t" + s[3]);
                }
                if(col.equals(s[3])) {
                    listViewBox.getItems().add(s[0] + " \t\t" + s[1] + " \t\t" + s[2] + " \t\t" + s[3]);
                }
                //listViewBox.getItems().add(colum1.get(0) + " \t\t" + colum2.get(0) + " \t\t" + colum3.get(0) + " \t\t" + colum4.get(0));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // choice box with select value displayed:
        airlineCB.setValue("Select Airline");
        airlineNoCB.setValue("Select Airline Number");
        departureCB.setValue("Select Departure Airport");
        arrivalCB.setValue("Select Arrival Airport");

        // header:
        listViewBox.getItems().add("Airline \t\tAirlineNo \t\tDeparture \t\tArrival");

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("C:\\Users\\douglas\\Desktop\\Assignment04\\Flight.txt"));
            String str;

            input = new ArrayList<String>();
            while((str = in.readLine()) != null){
                input.add(str);
                String[] tmp = str.split(",");
                colum1.add(tmp[0]);
                colum2.add(tmp[1]);
                colum3.add(tmp[2]);
                colum4.add(tmp[3]);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

