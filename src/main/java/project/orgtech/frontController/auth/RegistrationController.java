package project.orgtech.frontController.auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.utils.AuthManager;
import project.orgtech.models.Master;
import project.orgtech.service.auth.MasterService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class RegistrationController {

    @Autowired
    private MasterService masterService; // Injected by Spring

    @Autowired
    private SceneManager sceneManager;

    @FXML
    private TextField loginText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField middleNameText;

    @FXML
    private Button registerButton;

    @FXML
    private Button backButton;

    @FXML
    private void handleRegisterButton(ActionEvent event) throws IOException {
        String login = loginText.getText();
        String password = passwordText.getText();
        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        String middleName = middleNameText.getText();

        if (login.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            sceneManager.showAlert("Ошибка", "Все поля должны быть заполнены");
            return;
        }

        Master newMaster = new Master();
        newMaster.setLogin(login);
        newMaster.setPassword(password);
        newMaster.setFirstName(firstName);
        newMaster.setLastName(lastName);
        newMaster.setMiddleName(middleName);

        masterService.addMaster(newMaster);
        sceneManager.showAlert("Успех", "Регистрация прошла успешно");
        AuthManager.setMaster(newMaster);
        sceneManager.openScene(registerButton, FxmlView.MAIN);
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(backButton, FxmlView.LOGIN);
    }

    @FXML
    void initialize() {
        // Initialization logic if necessary
    }
}
