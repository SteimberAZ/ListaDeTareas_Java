package ToDo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TLDT Java");

        // Cargar el icono desde la ruta de recursos
        primaryStage.getIcons().add(new Image("file:resources/icono.png"));

        Label label1 = new Label("TU LISTA DE TAREAS");
        label1.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333; -fx-padding: 20px 0;");
        VBox layout2 = new VBox();
        layout2.getChildren().add(label1);
        layout2.setAlignment(Pos.TOP_CENTER);

        TextField input1 = new TextField();
        input1.setPromptText("Agregar tarea a la lista");
        input1.setStyle(
                "-fx-background-color: white; -fx-border-color: #ccc; -fx-border-radius: 5px; -fx-padding: 10px;");

        Button button1 = new Button("Aceptar");
        button1.setStyle(
                "-fx-background-color:rgb(126, 208, 252); -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 10px 20px; -fx-background-radius: 5px;");

        HBox layout1 = new HBox(10);
        layout1.getChildren().addAll(input1, button1);
        layout1.setAlignment(Pos.TOP_CENTER);

        VBox container = new VBox(10);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(20, 0, 20, 0));

        ScrollPane desplazamiento = new ScrollPane();
        desplazamiento.setContent(container);
        desplazamiento.setFitToWidth(true);
        desplazamiento.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        desplazamiento.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        VBox root = new VBox(10);
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(20, 0, 0, 0));

        Scene scene1 = new Scene(root, 350, 400);

        button1.setOnAction(event -> {
            System.out.println("¡Botón presionado!");

            Label newlabel = new Label(input1.getText());
            newlabel.setWrapText(true);
            newlabel.setPrefWidth(280);
            newlabel.setAlignment(Pos.CENTER);
            newlabel.setFont(new Font("Arial", 14));
            newlabel.setStyle(
                    "-fx-text-fill: #333;-fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 10px; -fx-border-color: #ddd; -fx-border-radius: 5px; -fx-font-size: 14px;");

            CheckBox borrar = new CheckBox();
            borrar.setStyle("-fx-font-size: 18px; -fx-text-fill: #333;");

            HBox labelconcheck = new HBox(15);
            labelconcheck.setAlignment(Pos.CENTER);
            labelconcheck.getChildren().addAll(newlabel, borrar);

            borrar.setOnAction(e -> {
                if (borrar.isSelected()) {
                    container.getChildren().remove(labelconcheck);
                }
            });
            container.getChildren().add(labelconcheck);
        });

        root.getChildren().addAll(layout2, layout1, container, desplazamiento);
        root.setStyle("-fx-background-color: white;");
        primaryStage.setScene(scene1);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
