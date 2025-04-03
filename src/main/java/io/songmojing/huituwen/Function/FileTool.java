package io.songmojing.huituwen.Function;

import javafx.stage.FileChooser;

import java.io.File;

public class FileTool {
	/**
	 * 选择文件
	 * @param title 窗口标题
	 * @param name 显示的文件提示
	 * @param regex 文件后缀
	 * @return 文件
	 */
	public static File selectFile(String title, String name, String regex) {
		// 创建文件选择器
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(title);
		
		// 设置文件过滤器
		FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter(name, regex);
		fileChooser.getExtensionFilters().add(filter);
		// 设置初始目录（可选）
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		// 打开文件选择器（模态窗口）
		return fileChooser.showOpenDialog(null);
	}
	
	/**
	 * 保存文件
	 * @param title 标题
	 * @param name 显示的文件提示
	 * @param regex 文件过滤
	 * @param suffix 文件后缀，带(.)
	 * @param def_name 默认文件名
	 * @return 最终选择保存的文件
	 */
	public static File createFile(String title, String name, String regex, String suffix, String def_name) {
		// 1. 创建文件选择器
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(title);
		
		// 2. 设置文件过滤器
		FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter(name, regex);
		fileChooser.getExtensionFilters().add(filter);
		// 3. 设置初始目录（可选）
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		// 4. 设置默认文件名（可选）
		fileChooser.setInitialFileName(def_name);
		// 5. 打开保存对话框
		File selectedFile = fileChooser.showSaveDialog(null);
		// 6. 处理用户选择
		if (selectedFile != null) {
			// 确保文件名的结尾（某些系统可能需要手动添加）
			String path = selectedFile.getAbsolutePath();
			if (!path.endsWith(suffix)) {
				path += suffix;
				selectedFile = new File(path);
			}
			// 获取最终路径
			String finalPath = selectedFile.getAbsolutePath();
			return new File(finalPath);
		} else {
			return null;
		}
	}
}
