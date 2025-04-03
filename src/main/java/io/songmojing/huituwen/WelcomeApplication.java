package io.songmojing.huituwen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeApplication extends Application {
	
	private static Stage stage;
	
	@Override
	public void start(Stage stage) throws IOException {
		WelcomeApplication.stage = stage;
		Scene scene = new Scene(new FXMLLoader(WelcomeApplication.class.getResource("layout/welcome.fxml")).load(), 1000, 600);
		stage.setScene(scene);
		stage.setTitle("绘图文");
		stage.show();
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void main(String[] args) {
		launch();
	}
}