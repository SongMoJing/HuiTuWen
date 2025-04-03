package io.songmojing.huituwen.Controller;

import io.songmojing.huituwen.FileExportApplication;
import io.songmojing.huituwen.Function.FileTool;
import io.songmojing.huituwen.Function.HtwDD;
import io.songmojing.huituwen.WelcomeApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class ControllerWelcome {
	
	private static File OpenFile;
	private static HtwDD htwdd;
	
	@FXML
	private void initialize() {
		MenuFileNew.setOnAction(event -> {
		});
		MenuFileOpen.setOnAction(event -> {
			File file = FileTool.selectFile("选择 HtwDD 文件", "绘图文设计草稿 (*.HtwDD)", "*.HtwDD");
			if (file == null) return;
			OpenFile = file;
		});
		MenuFileExport.setOnAction(event -> {
			Stage stageFileExport = new Stage();
			// 绑定到主窗口并设置为模态
			stageFileExport.initOwner(WelcomeApplication.getStage());
			stageFileExport.initModality(Modality.WINDOW_MODAL); // 阻塞父窗口
			try {
				new FileExportApplication().start(stageFileExport);
			} catch (Exception e) {
				// 创建警告对话框（模态）
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("警告");
				alert.setHeaderText("窗口创建失败");
				alert.setContentText(e.toString());
				alert.showAndWait();
			}
		});
		MenuFileSave.setOnAction(event -> {
			File path = FileTool.createFile("保存 HtwDD 文件", "绘图文设计草稿 (*.HtwDD)", "*.HtwDD", ".HtwDD", "default.HtwDD");
		});
		MenuFileSave_as.setOnAction(event -> {
			File file = FileTool.createFile("另存为…", "绘图文设计草稿 (*.HtwDD)", "*.HtwDD", ".HtwDD", "default.HtwDD");
			if (file == null) return;
			OpenFile = file;
		});
		MenuFileClose.setOnAction(event -> System.out.println("Close"));
		MenuEdit.setOnAction(event -> System.out.println("Edit"));
		MenuHelp.setOnAction(event -> System.out.println("Help"));
	}
	
	public static File getOpenFile() {
		return OpenFile;
	}
	
	@FXML
	private MenuItem MenuFileNew;
	@FXML
	private MenuItem MenuFileOpen;
	@FXML
	private MenuItem MenuFileSave;
	@FXML
	private MenuItem MenuFileSave_as;
	@FXML
	private MenuItem MenuFileExport;
	@FXML
	private MenuItem MenuFileClose;
	@FXML
	private MenuItem MenuEdit;
	@FXML
	private MenuItem MenuHelp;
}