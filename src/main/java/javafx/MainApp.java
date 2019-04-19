package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mysql.ExeQuery;

public class MainApp extends Application{

	static ExeQuery query;
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		
		Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        
        stage.setTitle("Compile");
        stage.setScene(scene);
        stage.setResizable(false);	//��ֹ�ı䴰�ڴ�С
        stage.show();
        
        query = new ExeQuery();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
