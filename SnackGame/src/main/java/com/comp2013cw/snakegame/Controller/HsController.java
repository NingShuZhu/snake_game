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

/**
 * Controller of High Score screen, which can be accessed from the start screen.
 * @author Shuli WANG
 */

public class HsController implements Initializable {
    public TableView<RankedRecord> tableView;
    public TableColumn<RankedRecord, Integer> colRank;
    public TableColumn<RankedRecord, String> colUserName;
    public TableColumn<RankedRecord, Integer> colScore;
    private ObservableList<RankedRecord> dataList = FXCollections.observableArrayList();

    /**
     * initialize the high score table
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colRank.setCellValueFactory(new PropertyValueFactory<>("idx"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colScore.setCellValueFactory(new PropertyValueFactory<>("score"));
        for (int i = 0; i < MainController.dataList.size(); i++) {
            dataList.add(new RankedRecord(i+1, MainController.dataList.get(i).getUserName(), MainController.dataList.get(i).getScore()));
        }
        tableView.setItems(dataList);
    }
}
