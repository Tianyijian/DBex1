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

public class DeleteController implements Initializable{

	@FXML
	private TextArea ta_delete_res;

	@FXML
	private ChoiceBox<String> cb_delete_text;

	@FXML
	private TextArea ta_delete_sql;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cb_delete_text.setItems(FXCollections.observableList(Constant.delete_text));
		cb_delete_text.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				String sql = Constant.delete_sql.get(newValue.intValue());
				ta_delete_sql.setText(sql);
				String res = MainApp.query.delete(sql);
				ta_delete_res.setText(res);
			}
		});
		
	}

}
