module project.orgtech {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires static lombok;
    requires spring.core;
    requires java.sql;
    requires spring.beans;
    requires spring.context;
    requires spring.jdbc;
    requires spring.orm;
    requires spring.tx;
    requires java.transaction;
    requires org.hibernate.orm.core;

    opens project.orgtech to javafx.fxml, spring.core, spring.beans, spring.context;
    opens project.orgtech.config to spring.core, spring.beans, spring.context;
    opens project.orgtech.frontController to javafx.fxml, spring.core, spring.beans, spring.context;
    opens project.orgtech.dao to spring.core, spring.beans, spring.context;
    opens project.orgtech.models to java.persistence, org.hibernate.orm.core; // Add org.hibernate.orm.core
    opens project.orgtech.auth to spring.core, spring.beans, spring.context;

    exports project.orgtech;
    exports project.orgtech.frontController;
    exports project.orgtech.dao;
    exports project.orgtech.models;
    exports project.orgtech.auth;
    exports project.orgtech.frontController.auth;
    opens project.orgtech.frontController.auth to javafx.fxml, spring.beans, spring.context, spring.core;
}
