package project.orgtech.frontController.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.models.Application;
import project.orgtech.service.application.ApplicationService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;
import project.orgtech.frontController.utils.DataReceiver;

import java.io.IOException;

@Controller
public class InfoApplicationController implements DataReceiver<Application> {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private SceneManager sceneManager;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField clientField;

    @FXML
    private TextField repairField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField statusField;

    @FXML
    private TextField dateField;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button backButton;

    private Application currentApplication;

    @Override
    public void setData(Application application) {
        this.currentApplication = application;
        populateFields();
    }

    private void populateFields() {
        if (currentApplication != null) {
            nameField.setText(currentApplication.getName());
            priceField.setText(currentApplication.getPrice().toString());
            clientField.setText(currentApplication.getClient().getBio());
            repairField.setText(currentApplication.getRepair().getName());
            typeField.setText(currentApplication.getType().getName());
            statusField.setText(currentApplication.getStatus().getName());
            dateField.setText(currentApplication.getDate().getDay() + "." + currentApplication.getDate().getMonth() + "." + currentApplication.getDate().getYear());
        }
    }

    @FXML
    private void handleEditButton(ActionEvent event) throws IOException {
        sceneManager.openScene(editButton, FxmlView.APPLICATION_EDIT, currentApplication);
    }

    @FXML
    private void handleDeleteButton(ActionEvent event) throws IOException {
        applicationService.delete(currentApplication.getId());
        sceneManager.showAlert("Успешно", "Заявка удалена");
        sceneManager.openScene(deleteButton, FxmlView.MAIN);
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(backButton, FxmlView.MAIN);
    }
}
