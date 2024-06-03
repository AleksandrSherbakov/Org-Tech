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
import project.orgtech.StartApplication;
import project.orgtech.dao.MasterDao;
import project.orgtech.models.Master;

import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private MasterDao masterDao; // Injected by Spring

    @FXML
    private TextField loginText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button loginButton;

    @FXML
    private Button registrationButton;

    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException {
        Master master = masterDao.findMasterByLogin(loginText.getText());
        if (master != null && master.getPassword().equals(passwordText.getText())) {
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/orgtech/request/main-view.fxml"));
            loader.setControllerFactory(StartApplication.getContext()::getBean);
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Главное окно");
            newStage.setScene(new Scene(root));
            newStage.show();
            currentStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Логин или пароль неверный");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleRegistrationButton(ActionEvent event) throws IOException {
        Stage currentStage = (Stage) registrationButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/orgtech/auth/registration-view.fxml"));
        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setTitle("Регистрация");
        newStage.setScene(new Scene(root));
        newStage.show();
        currentStage.close();
    }

    @FXML
    void initialize() {
        // Initialization logic if necessary
    }
}
