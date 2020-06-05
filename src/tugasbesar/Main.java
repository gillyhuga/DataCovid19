package tugasbesar;

import java.util.InputMismatchException;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main extends Application {

    private TableView<Person> table = new TableView<Person>();
    //Isi Tabel

    private final ObservableList<Person> data = FXCollections.observableArrayList();

    //Main
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        //Overriding dan Overloading
        Notification jud = new Notification();
        jud.dev("Aplikasi Covid-19");
        jud.dev("Dibuat :", "Gilly");
        jud.nim();
        jud.tugas();

        stage.setTitle("Covid-19");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Ukuran Layar
        Scene scene = new Scene(grid, 700, 700);

        //Judul Label
        final Label scenetitle = new Label("Data Pasien Positif Covid-19");
        scenetitle.setFont(Font.font("Tamoha", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //Agar Table Bisa di Edit
        table.setEditable(true);

        //Kolom NIK
        TableColumn nikCol = new TableColumn("NIK");
        nikCol.setMinWidth(150);
        nikCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("nik"));
        nikCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nikCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setNik(t.getNewValue());
                    }
                }
        );

        //Kolom Nama
        TableColumn namaCol = new TableColumn("Nama");
        namaCol.setMinWidth(100);
        namaCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("nama"));
        namaCol.setCellFactory(TextFieldTableCell.forTableColumn());
        namaCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setNama(t.getNewValue());
                    }
                }
        );
        //Kolom Kelamin
        TableColumn kelaminCol = new TableColumn("Kelamin");
        kelaminCol.setMinWidth(75);
        kelaminCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("kelamin"));
        kelaminCol.setCellFactory(TextFieldTableCell.forTableColumn());
        kelaminCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setKelamin(t.getNewValue());
                    }
                }
        );
        //Kolom Kota
        TableColumn kotaCol = new TableColumn("Kota");
        kotaCol.setMinWidth(100);
        kotaCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("kota"));
        kotaCol.setCellFactory(TextFieldTableCell.forTableColumn());
        kotaCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setKota(t.getNewValue());
                    }
                }
        );
        //Kolom Alamat
        TableColumn alamatCol = new TableColumn("Alamat");
        alamatCol.setMinWidth(200);
        alamatCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("alamat"));
        alamatCol.setCellFactory(TextFieldTableCell.forTableColumn());
        alamatCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
                    @Override
                    public void handle(CellEditEvent<Person, String> t) {
                        ((Person) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setAlamat(t.getNewValue());
                    }
                }
        );
        //Tabel
        table.setItems(data);
        table.getColumns().addAll(nikCol, namaCol, kelaminCol, kotaCol, alamatCol);
        grid.add(table, 0, 7, 2, 2);

        //Label NIK
        Label labelNik = new Label("NIK");
        grid.add(labelNik, 0, 1);

        //Input NIK
        final TextField addNik = new TextField();
        addNik.setPromptText("Masukkan NIK");
        grid.add(addNik, 1, 1);

        //Label Nama
        Label labelNama = new Label("Nama");
        grid.add(labelNama, 0, 2);

        //Input Nama
        final TextField addNama = new TextField();
        addNama.setPromptText("Masukkan Nama");
        grid.add(addNama, 1, 2);

        //Label Kota
        Label labelKota = new Label("Kota");
        grid.add(labelKota, 0, 4);

        //Input Kota
        final TextField addKota = new TextField();
        addKota.setPromptText("Masukkan Kota");
        grid.add(addKota, 1, 4);

        //Label Alamat
        Label labelAlamat = new Label("Alamat");
        grid.add(labelAlamat, 0, 3);

        //Input Alamat
        final TextField addAlamat = new TextField();
        addAlamat.setPromptText("Masukkan Alamat");
        grid.add(addAlamat, 1, 3);

        //Radio Button Kelamin
        FlowPane flowPaneRadioButton = new FlowPane();
        ObservableList columns = flowPaneRadioButton.getChildren();
        flowPaneRadioButton.setHgap(10);
        grid.add(flowPaneRadioButton, 1, 5);

        //Label Kelamin
        Label labelKelamin = new Label("Jenis Kelamin");
        grid.add(labelKelamin, 0, 5);
        RadioButton radioL = new RadioButton("Laki-Laki");
        RadioButton radioP = new RadioButton("Perempuan");

        ToggleGroup kelamin = new ToggleGroup();
        radioL.setToggleGroup(kelamin);
        radioP.setToggleGroup(kelamin);

        columns.addAll(radioL, radioP);

        //Button Add
        HBox hbBtn = new HBox();
        hbBtn.setSpacing(5);
        grid.add(hbBtn, 1, 6);

        Button addButton = new Button("Add");
        addButton.setPrefSize(70, 25);
        Button delButton = new Button("Delete");
        delButton.setPrefSize(70, 25);
        hbBtn.getChildren().addAll(addButton, delButton);

        delButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //exception
                try {
                    int selectedIndex = table.getSelectionModel().getSelectedIndex();
                    table.getItems().remove(selectedIndex);
                    PushNotif push = new PushNotif();
                    push.suara();;
                } catch (Exception r) {
                    System.err.println("\nPilih baris yang ingin di hapus");
                }
            }
        });

        //Aksi Tombol Add
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                String kelamin = "";
                if (radioL.isSelected()) {
                    kelamin = "Laki-Laki";
                } else if (radioP.isSelected()) {
                    kelamin = "Perempuan";
                }

                data.add(new Person(
                        addNik.getText(),
                        addNama.getText(),
                        kelamin,
                        addKota.getText(),
                        addAlamat.getText()));
                addNik.clear();
                addNama.clear();
                addAlamat.clear();
                addKota.clear();
                radioL.setSelected(false);
                radioP.setSelected(false);

                //Inheritance 
                Notification jud = new Notification();
                jud.suara();
            }
        });

        stage.setScene(scene);
        stage.show();
    }
    // Class Person

    public class Person {

        private final SimpleStringProperty nik;
        private final SimpleStringProperty nama;
        private final SimpleStringProperty kelamin;
        private final SimpleStringProperty kota;
        private final SimpleStringProperty alamat;

        private Person(String nomerNIK, String nama, String kelamin, String kota, String alamat) {
            this.nik = new SimpleStringProperty(nomerNIK);
            this.nama = new SimpleStringProperty(nama);
            this.kelamin = new SimpleStringProperty(kelamin);
            this.kota = new SimpleStringProperty(kota);
            this.alamat = new SimpleStringProperty(alamat);
        }

        // Getter Setter
        public String getNik() {
            return nik.get();
        }

        public void setNik(String nomerNIK) {
            nik.set(nomerNIK);
        }

        public String getNama() {
            return nama.get();
        }

        public void setNama(String nomerNIK) {
            nama.set(nomerNIK);
        }

        public String getKelamin() {
            return kelamin.get();
        }

        public void setKelamin(String nomerNIK) {
            kelamin.set(nomerNIK);
        }

        public String getKota() {
            return kota.get();
        }

        public void setKota(String nomerNIK) {
            kota.set(nomerNIK);
        }

        public String getAlamat() {
            return alamat.get();
        }

        public void setAlamat(String nomerNIK) {
            alamat.set(nomerNIK);
        }

    }

}
