package io.songmojing.huituwen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FileExportApplication extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(new FXMLLoader(WelcomeApplication.class.getResource("layout/file_export.fxml")).load(), 1000, 600);
		stage.setScene(scene);
		stage.setTitle("导出为…");
		stage.show();
	}
}
