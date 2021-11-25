module com.example.mmn11q2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.avivn.mmn11.q2 to javafx.fxml;
    exports com.avivn.mmn11.q2;
}