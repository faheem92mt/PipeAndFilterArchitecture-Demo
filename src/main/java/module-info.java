module com.example.pipeandfilter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pipeandfilter to javafx.fxml;
    exports com.example.pipeandfilter;
}