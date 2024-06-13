package project.orgtech.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import project.orgtech.StartApplication;
import project.orgtech.frontController.utils.DataReceiver;

import java.io.IOException;
import java.util.function.Consumer;

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
    public <T> void openScene(Button button, FxmlView fxmlView, Consumer<T> consumer) throws IOException {
        Stage currentStage = (Stage) button.getScene().getWindow();
        String fxmlPath = fxmlView.getFxmlPath();
        String title = fxmlView.getTitle();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setControllerFactory(StartApplication.getContext()::getBean);
        Parent root = loader.load();

        // Получаем контроллер и передаем данные через consumer
        T controller = loader.getController();
        //consumer.accept(controller);

        Stage newStage = new Stage();
        newStage.setTitle(title);
        newStage.setScene(new Scene(root));
        newStage.show();
        if (currentStage != null) {
            currentStage.close();
        }
    }
    public <T, D> void openScene(Button button, FxmlView fxmlView, D data, Class<T> controllerClass) throws IOException {
        Stage currentStage = (Stage) button.getScene().getWindow();
        String fxmlPath = fxmlView.getFxmlPath();
        String title = fxmlView.getTitle();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setControllerFactory(StartApplication.getContext()::getBean);
        Parent root = loader.load();

        // Получаем контроллер и передаем данные
        T controller = loader.getController();
        if (controllerClass.isInstance(controller)) {
            if (controller instanceof DataReceiver) {
                ((DataReceiver<D>) controller).setData(data);
            }
            // Добавьте сюда дополнительные проверки для других типов контроллеров, если необходимо
        }

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
