package project.orgtech.frontController.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.models.Application;
import project.orgtech.service.application.ApplicationService;
import project.orgtech.service.client.ClientService;
import project.orgtech.service.repair.RepairService;
import project.orgtech.service.status.StatusService;
import project.orgtech.service.type.TypeService;
import project.orgtech.utils.AuthManager;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

@Controller
public class AddApplication {

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
    private TextField descriptionField;

    @FXML
    private Button SaveButton;

    @FXML
    private Button BackButton;

    @FXML
    private void handleSave(ActionEvent event) throws IOException {

        Application application = new Application();
        application.setName(nameField.getText());
        application.setPrice(BigDecimal.valueOf(Long.parseLong(descriptionField.getText())));
        application.setClient(clientService.getClientById(1L));
        application.setRepair(repairService.getRepairById(1L));
        application.setType(typeService.getTypeById(1L));
        application.setStatus(statusService.getStatusById(1L));
        Date date = new Date();
        application.setDate(date);
        application.setMaster(AuthManager.getMaser());

        // Вызываем сервис для сохранения изменений
        applicationService.addApplication(application);

        // Показываем сообщение об успешном сохранении
        sceneManager.showAlert("Успешно", "Тип создан");
        application = null;
        sceneManager.openScene(SaveButton, FxmlView.MAIN);

    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(BackButton, FxmlView.MAIN);
    }

}
