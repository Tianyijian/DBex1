package javafx;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import mysql.Constant;
import mysql.ExeQuery;

public class SearchController implements Initializable {

	@FXML
	private TextArea ta_search_res;

	@FXML
	private ChoiceBox<String> cb_text;

	@FXML
	private TextArea ta_sql;

	ExeQuery query;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		query = new ExeQuery();
		cb_text.setItems(FXCollections.observableList(Constant.text));
		cb_text.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				String sql = Constant.sql.get(newValue.intValue());
				ta_sql.setText(sql);
				ResultSet res = query.exeQuery(sql);
				StringBuilder sb = new StringBuilder();
				try {
					ResultSetMetaData rsmd = res.getMetaData();
					int colCount = rsmd.getColumnCount();
					for (int i = 1; i <= colCount; i++) {
						// 得到当前列的列名
						String name = rsmd.getColumnName(i);
						sb.append("\t\t" + name);
					}
					sb.append("\n");
					int line = 1;
					while (res.next()) { // while控制行数
						sb.append(line+"\t\t");
						for (int i = 1; i <= colCount; i++) {// for循环控制列数
							// 得到当前列的值
							String value = res.getString(i);
							sb.append(String.format("%.20s", value) + "\t\t");
						}
						sb.append("\n");
						line++;
					}
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ta_search_res.setText(sb.toString());
			}
		});
	}

}
