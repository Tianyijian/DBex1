package javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import mysql.Constant;
import javafx.fxml.Initializable;

public class IndexController implements Initializable{

    @FXML
    private TextArea ta_index_sql;

    @FXML
    private ChoiceBox<String> cb_index_text;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cb_index_text.setItems(FXCollections.observableList(Constant.index_text));
		cb_index_text.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				ta_index_sql.setText(Constant.index_sql.get(newValue.intValue()));
				
			}
		});
		
	}

}
