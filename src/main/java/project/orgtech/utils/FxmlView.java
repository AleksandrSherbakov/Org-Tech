package project.orgtech.utils;

public enum FxmlView {
    LOGIN("/project/orgtech/auth/login-view.fxml", "Вход"),
    REGISTRATION("/project/orgtech/auth/registration-view.fxml", "Регистрация"),
    CLIENT_ADD("/project/orgtech/client/add-client-view.fxml", "Добавить клиента"),
    CLIENT_EDIT("/project/orgtech/client/edit-client-view.fxml", "Редактировать клиента"),
    CLIENT_INFO("/project/orgtech/client/info-client-view.fxml", "Информация клиента"),
    CLIENT_PANEL("/project/orgtech/client/panel-client-view.fxml", "Панель клиентов"),
    REPAIR_ADD("/project/orgtech/repair/add-repair-view.fxml", "Добавить ремонт"),
    REPAIR_EDIT("/project/orgtech/repair/edit-repair-view.fxml", "Редактировать возможный ремонт"),
    REPAIR_INFO("/project/orgtech/repair/info-repair-view.fxml", "Информация о ремонте"),
    REPAIR_PANEL("/project/orgtech/repair/panel-repair-view.fxml", "Панель ремонта"),
    TYPE_ADD("/project/orgtech/type/add-type-view.fxml", "Добавить тип"),
    TYPE_EDIT("/project/orgtech/type/edit-type-view.fxml", "Редактировать тип"),
    TYPE_INFO("/project/orgtech/type/info-type-view.fxml", "Информация о типе"),
    TYPE_PANEL("/project/orgtech/type/panel-type-view.fxml", "Панель типа"),
    APPLICATION_ADD("/project/orgtech/application/add-application-view.fxml", "Добавить заявку"),
    APPLICATION_EDIT("/project/orgtech/application/edit-application-view.fxml", "Редактировать заявку"),
    APPLICATION_INFO("/project/orgtech/application/info-application-view.fxml", "Информация о заявке"),

    REPAIR_APPLICATION_ADD("/project/orgtech/application/add-repair-view.fxml.fxml", "Добавить ремонт"),
    CLIENT_APPLICATION_ADD("/project/orgtech/application/add-client-view.fxml", "Добавить клиента"),
    TYPE_APPLICATION_ADD("/project/orgtech/application/add-type-view.fxml", "Добавить тип"),

    MAIN("/project/orgtech/application/main-view.fxml", "Главное окно"),
    CATEGORY("/project/orgtech/category-view.fxml", "Категории");

    private final String fxmlPath;
    private final String title;

    FxmlView(String fxmlPath, String title) {
        this.fxmlPath = fxmlPath;
        this.title = title;
    }

    public String getFxmlPath() {
        return fxmlPath;
    }

    public String getTitle() {
        return title;
    }
}
