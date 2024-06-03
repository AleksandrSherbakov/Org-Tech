package project.orgtech;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.orgtech.config.dbConfig;

public class StartApplication extends Application {

    @Getter
    private static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {
        // Initialize Spring context
        context = new AnnotationConfigApplicationContext(dbConfig.class);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/orgtech/auth/login-view.fxml"));
        loader.setControllerFactory(context::getBean);  // Use Spring context to load controllers
        Parent root = loader.load();
        primaryStage.setTitle("Вход");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        context.close();  // Close Spring context when application stops
    }
}