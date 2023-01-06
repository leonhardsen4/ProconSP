module br.gov.sp.procon {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires java.desktop;
    requires cepcorreios;
    requires static lombok;
    requires jfxtras.labs;

    exports br.gov.sp.procon.view;
    opens br.gov.sp.procon.view to javafx.fxml;
    exports br.gov.sp.procon.controller;
    opens br.gov.sp.procon.controller to javafx.fxml;
    exports br.gov.sp.procon.model;
    opens br.gov.sp.procon.model to javafx.fxml;
}