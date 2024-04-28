module com.system.chatsystemjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.system.chatsystemjava to javafx.fxml;
    exports com.system.chatsystemjava;
}