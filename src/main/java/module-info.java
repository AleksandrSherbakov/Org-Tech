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
    opens project.orgtech.dao.auth to spring.core, spring.beans, spring.context;
    opens project.orgtech.dao.client to spring.core, spring.beans, spring.context;
    opens project.orgtech.dao.repair to spring.core, spring.beans, spring.context;
    opens project.orgtech.models to java.persistence, org.hibernate.orm.core; // Add org.hibernate.orm.core
    opens project.orgtech.auth to spring.core, spring.beans, spring.context;
    opens project.orgtech.frontController.auth to javafx.fxml, spring.beans, spring.context, spring.core;
    opens project.orgtech.frontController.client to javafx.fxml, spring.beans, spring.context, spring.core;
    opens project.orgtech.frontController.posibleRepair to javafx.fxml, spring.beans, spring.context, spring.core;
    opens project.orgtech.service.auth to javafx.fxml, spring.beans, spring.context, spring.core, java.persistence, org.hibernate.orm.core;
    opens project.orgtech.utils to javafx.fxml, spring.beans, spring.context, spring.core, java.persistence, org.hibernate.orm.core;

    exports project.orgtech;
    exports project.orgtech.frontController;
    exports project.orgtech.dao.auth;
    /*
    exports project.orgtech.dao;
    exports project.orgtech.dao.client;
    exports project.orgtech.dao.possibleRepair;*/
    exports project.orgtech.models;
    exports project.orgtech.frontController.auth;
    exports project.orgtech.service.auth;
    exports project.orgtech.utils;

}
