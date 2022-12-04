module br.gov.sp.procon {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    exports br.gov.sp.procon;
    opens br.gov.sp.procon to javafx.fxml;
    exports br.gov.sp.procon.controller;
    opens br.gov.sp.procon.controller to javafx.fxml;
    exports br.gov.sp.procon.model;
    opens br.gov.sp.procon.model to javafx.fxml;
}