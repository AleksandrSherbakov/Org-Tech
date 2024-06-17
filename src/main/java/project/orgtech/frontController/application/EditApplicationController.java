package project.orgtech.frontController.application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.models.*;
import project.orgtech.service.application.ApplicationService;
import project.orgtech.service.client.ClientService;
import project.orgtech.service.repair.RepairService;
import project.orgtech.service.status.StatusService;
import project.orgtech.service.type.TypeService;
import project.orgtech.utils.AuthManager;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;
import project.orgtech.frontController.utils.DataReceiver;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

@Controller
public class EditApplicationController implements DataReceiver<Application> {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private RepairService repairService;
    @Autowired
    private SceneManager sceneManager;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private ComboBox<Client> clientComboBox;

    @FXML
    private ComboBox<Repair> repairComboBox;

    @FXML
    private ComboBox<Type> typeComboBox;

    @FXML
    private ComboBox<Status> statusComboBox;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private Button addClientButton;

    @FXML
    private Button addRepairButton;

    @FXML
    private Button addTypeButton;

    private Application currentApplication;

    @FXML
    public void initialize() {
        loadComboBoxData();
    }

    private void loadComboBoxData() {
        clientComboBox.setItems(FXCollections.observableArrayList(clientService.getAll()));
        repairComboBox.setItems(FXCollections.observableArrayList(repairService.getAll()));
        typeComboBox.setItems(FXCollections.observableArrayList(typeService.getAll()));
        statusComboBox.setItems(FXCollections.observableArrayList(statusService.getAll()));
    }

    @Override
    public void setData(Application application) {
        this.currentApplication = application;
        if (application != null) {
            nameField.setText(application.getName());
            priceField.setText(application.getPrice().toString());
            clientComboBox.setValue(application.getClient());
            repairComboBox.setValue(application.getRepair());
            typeComboBox.setValue(application.getType());
            statusComboBox.setValue(application.getStatus());
        }
    }

    @FXML
    private void handleSave(ActionEvent event) throws IOException {
        if (validateInput()) {
            if (currentApplication == null) {
                currentApplication = new Application();
                currentApplication.setDate(new Date());
                currentApplication.setMaster(AuthManager.getMaser());
            }

            currentApplication.setName(nameField.getText());
            currentApplication.setPrice(new BigDecimal(priceField.getText()));
            currentApplication.setClient(clientComboBox.getValue());
            currentApplication.setRepair(repairComboBox.getValue());
            currentApplication.setType(typeComboBox.getValue());
            currentApplication.setStatus(statusComboBox.getValue());

            if (currentApplication.getId() == null) {
                applicationService.add(currentApplication);
                sceneManager.showAlert("Успешно", "Заявка создана");
            } else {
                applicationService.update(currentApplication);
                sceneManager.showAlert("Успешно", "Заявка обновлена");
            }

            sceneManager.openScene(saveButton, FxmlView.MAIN);
        }
    }

    private boolean validateInput() throws IOException {
        StringBuilder errorMessage = new StringBuilder();

        if (nameField.getText() == null || nameField.getText().isEmpty()) {
            errorMessage.append("Имя не может быть пустым\n");
        }

        if (priceField.getText() == null || priceField.getText().isEmpty()) {
            errorMessage.append("Цена не может быть пустой\n");
        } else {
            try {
                new BigDecimal(priceField.getText());
            } catch (NumberFormatException e) {
                errorMessage.append("Некорректный формат цены\n");
            }
        }

        if (clientComboBox.getValue() == null) {
            errorMessage.append("Выберите клиента\n");
        }

        if (repairComboBox.getValue() == null) {
            errorMessage.append("Выберите ремонт\n");
        }

        if (typeComboBox.getValue() == null) {
            errorMessage.append("Выберите тип\n");
        }

        if (statusComboBox.getValue() == null) {
            errorMessage.append("Выберите статус\n");
        }

        if (!errorMessage.isEmpty()) {
            sceneManager.showAlert("Ошибка", errorMessage.toString());
            return false;
        }

        return true;
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(backButton, FxmlView.MAIN);
    }

    @FXML
    private void handleAddClient(ActionEvent event) throws IOException {
        sceneManager.openScene(FxmlView.CLIENT_APPLICATION_ADD);
        loadComboBoxData();
    }

    @FXML
    private void handleAddRepair(ActionEvent event) throws IOException {
        sceneManager.openScene(FxmlView.REPAIR_APPLICATION_ADD);
        loadComboBoxData();
    }

    @FXML
    private void handleAddType(ActionEvent event) throws IOException {
        sceneManager.openScene(FxmlView.TYPE_APPLICATION_ADD);
        loadComboBoxData();
    }
}
