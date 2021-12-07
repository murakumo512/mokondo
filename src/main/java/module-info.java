module mokondo{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;

    opens id.ac.ukdw.fti.rpl.mokondo to javafx.fxml;
    exports id.ac.ukdw.fti.rpl.mokondo;
    exports id.ac.ukdw.fti.rpl.mokondo.database;
    exports id.ac.ukdw.fti.rpl.mokondo.modal;
}

//disini buat req berbagai macam2 package