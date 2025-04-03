module io.songmojing.huituwen {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    exports io.songmojing.huituwen;
    opens io.songmojing.huituwen to javafx.fxml;
    
    exports io.songmojing.huituwen.Controller;
    opens io.songmojing.huituwen.Controller to javafx.fxml;
}