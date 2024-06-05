package project.orgtech.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import project.orgtech.StartApplication;

import java.io.IOException;

@Component
public class SceneManager {

    public void openScene(Button button, FxmlView fxmlView) throws IOException {
        Stage currentStage = (Stage) button.getScene().getWindow();
        String fxmlPath = fxmlView.getFxmlPath();
        String title = fxmlView.getTitle();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setControllerFactory(StartApplication.getContext()::getBean);
        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setTitle(title);
        newStage.setScene(new Scene(root));
        newStage.show();
        if (currentStage != null) {
            currentStage.close();
        }
    }
    public void showAlert(String title, String content) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
