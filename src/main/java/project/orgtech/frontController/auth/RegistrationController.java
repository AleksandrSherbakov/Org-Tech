package project.orgtech.frontController.auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.service.gender.GenderService;
import project.orgtech.utils.AuthManager;
import project.orgtech.models.Master;
import project.orgtech.models.Gender;
import project.orgtech.service.auth.MasterService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class RegistrationController {

    @Autowired
    private MasterService masterService;

    @Autowired
    private GenderService genderService;

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
    private ComboBox<String> genderComboBox;

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
        String genderName = genderComboBox.getId();
        long genderId = 0;
        if (genderName != null && genderName.matches("\\d+")) {
            genderId = Long.parseLong(genderName);
        }
        if (login.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || genderName == null) {
            sceneManager.showAlert("Ошибка", "Все поля должны быть заполнены");
            return;
        }

        Master newMaster = new Master();
        newMaster.setLogin(login);
        newMaster.setPassword(password);
        newMaster.setFirstName(firstName);
        newMaster.setLastName(lastName);
        newMaster.setMiddleName(middleName);

        Gender gender = genderService.getById(genderId + 1);
        //gender.setName(genderName);
        newMaster.setGender(gender);

        masterService.add(newMaster);
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
        //genderComboBox.getItems().addAll("Мужской", "Женский");
    }
}
