package javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import mysql.Constant;

public class ViewController implements Initializable{

    @FXML
    private TextArea ta_view_sql;

    @FXML
    private ChoiceBox<String> cb_view_text;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cb_view_text.setItems(FXCollections.observableList(Constant.view_text));
		cb_view_text.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				ta_view_sql.setText(Constant.view_sql.get(newValue.intValue()));
				
			}
		});
		
	}

}
