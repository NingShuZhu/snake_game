package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Model.PlayRecord;
import com.comp2013cw.snakegame.Model.RankedRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HsController implements Initializable {
    public TableView tableView;
    public TableColumn colRank;
    public TableColumn colUserName;
    public TableColumn colScore;
    private ObservableList<RankedRecord> dataList = FXCollections.observableArrayList();

//    public void addInfo(ObservableList<PlayRecord> data) {
//        dataList.addAll(data);
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colRank.setCellValueFactory(new PropertyValueFactory("idx"));
        colUserName.setCellValueFactory(new PropertyValueFactory("userName"));
        colScore.setCellValueFactory(new PropertyValueFactory("score"));
        for (int i = 0; i < MainController.dataList.size(); i++) {
            dataList.add(new RankedRecord(i, MainController.dataList.get(i).userName, MainController.dataList.get(i).score));
        }
        tableView.setItems(dataList);
    }
}
