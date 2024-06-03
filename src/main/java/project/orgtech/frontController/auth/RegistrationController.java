package project.orgtech.frontController.auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.dao.MasterDao;
import project.orgtech.models.Master;

import java.io.IOException;

@Controller
public class RegistrationController {

    @Autowired
    private MasterDao masterDao; // Injected by Spring

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
            showAlert("Ошибка", "Все поля должны быть заполнены");
            return;
        }

        Master newMaster = new Master();
        newMaster.setLogin(login);
        newMaster.setPassword(password);
        newMaster.setFirstName(firstName);
        newMaster.setLastName(lastName);
        newMaster.setMiddleName(middleName);

        masterDao.addMaster(newMaster);
        showAlert("Успех", "Регистрация прошла успешно");

        navigateToLogin();
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        navigateToLogin();
    }

    private void navigateToLogin() throws IOException {
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/orgtech/auth/login-view.fxml"));
        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setTitle("Вход");
        newStage.setScene(new Scene(root));
        newStage.show();
        currentStage.close();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        // Initialization logic if necessary
    }
}
