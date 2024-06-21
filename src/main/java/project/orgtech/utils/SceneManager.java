package project.orgtech.utils;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.orgtech.StartApplication;
import project.orgtech.frontController.utils.DataReceiver;
import project.orgtech.service.exel.ExcelExportService;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

@Component
public class SceneManager {

    @Autowired
    ExcelExportService excelExportService;

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
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        // Устанавливаем размеры окна на размеры экрана
        newStage.setX(primaryScreenBounds.getMinX());
        newStage.setY(primaryScreenBounds.getMinY());
        newStage.setWidth(primaryScreenBounds.getWidth());
        newStage.setHeight(primaryScreenBounds.getHeight());
        newStage.setMaximized(true);

        newStage.show();

        if (currentStage != null) {
            currentStage.close();
        }
    }

    public <D> void openScene(Button button, FxmlView fxmlView, D data) throws IOException {
        Stage currentStage = (Stage) button.getScene().getWindow();
        String fxmlPath = fxmlView.getFxmlPath();
        String title = fxmlView.getTitle();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setControllerFactory(StartApplication.getContext()::getBean);
        Parent root = loader.load();

        DataReceiver<D> controller = loader.getController();
        controller.setData(data);

        Stage newStage = new Stage();
        newStage.setTitle(title);
        newStage.setScene(new Scene(root));
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        // Устанавливаем размеры окна на размеры экрана
        newStage.setX(primaryScreenBounds.getMinX());
        newStage.setY(primaryScreenBounds.getMinY());
        newStage.setWidth(primaryScreenBounds.getWidth());
        newStage.setHeight(primaryScreenBounds.getHeight());
        newStage.setMaximized(true);
        newStage.show();
        if (currentStage != null) {
            currentStage.close();
        }
    }

    public void openScene(FxmlView fxmlView) throws IOException {
        String fxmlPath = fxmlView.getFxmlPath();
        String title = fxmlView.getTitle();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setControllerFactory(StartApplication.getContext()::getBean);
        Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setTitle(title);
        newStage.setScene(new Scene(root));
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        // Устанавливаем размеры окна на размеры экрана
        newStage.setX(primaryScreenBounds.getMinX());
        newStage.setY(primaryScreenBounds.getMinY());
        newStage.setWidth(primaryScreenBounds.getWidth());
        newStage.setHeight(primaryScreenBounds.getHeight());
        newStage.setMaximized(true);
        newStage.show();
    }
    public void closeScene(Button button) throws IOException {
        Stage currentStage = (Stage) button.getScene().getWindow();
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
    public void getReports(Button button) throws IOException {
        Stage currentStage = (Stage) button.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();

        // Установка заголовка диалога
        fileChooser.setTitle("Save Excel File");

        // Установка базового имени файла
        fileChooser.setInitialFileName("example.xlsx");

        // Установка фильтра на типы файлов
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
        fileChooser.getExtensionFilters().add(extFilter);

        // Показать диалог для сохранения файла
        File file = fileChooser.showSaveDialog(currentStage);
        if (file != null) {
            // Ваш код для сохранения файла по выбранному пути
            System.out.println("File saved to: " + file.getAbsolutePath());
        }
        excelExportService.exportApplicationsToExcel(file.getAbsolutePath());
    }
}
