package javafx;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertController implements Initializable{

    @FXML
    private TextField tf_insert_p;

    @FXML
    private ChoiceBox<Integer> cb_insert_p;

    @FXML
    private ChoiceBox<Integer> cb_insert_pay;

    @FXML
    private TextArea ta_insert_res;

    @FXML
    private TextArea ta_insert_sql;
    
    @FXML
    private Button bt_insert;

    @FXML
    private Button bt_insert1;

    @FXML
    private TextField tf_insert_pay;

    String sql = "INSERT INTO p_p_cor(pay_id, p_id) VALUES(%d, %d);";
    @FXML
    void insert(ActionEvent event) {
    	String sqlString = String.format(sql, cb_insert_p.getValue(), cb_insert_pay.getValue());
    	ta_insert_sql.setText(sqlString);
    	String res = MainApp.query.insert(sqlString);
    	ta_insert_res.setText(res);
    }

    @FXML
    void insert1(ActionEvent event) {
    	if (tf_insert_p.getText().isEmpty() || tf_insert_pay.getText().isEmpty()) {
    		ta_insert_res.setText("≤Â»Îø’÷µ");
    		return;
    	}
    	String sqlString = String.format(sql, Integer.valueOf(tf_insert_p.getText()), Integer.valueOf(tf_insert_pay.getText()));
    	ta_insert_sql.setText(sqlString);
    	String res = MainApp.query.insert(sqlString);
    	ta_insert_res.setText(res);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cb_insert_p.setItems(FXCollections.observableList(Arrays.asList(1,2,3)));
		cb_insert_pay.setItems(FXCollections.observableList(Arrays.asList(1,2,3)));
	}

}

