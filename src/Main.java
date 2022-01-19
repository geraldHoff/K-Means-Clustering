import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Sets up the window
     * @param window
     * @throws Exception
     */
    public void start(Stage window) throws Exception {

        // set title for the stage
        window.setTitle("KMeans");

        // create a button
        Button b = new Button("button");

        // create a group
        Group root = new Group(b);

        // create a scene
        Scene scene = new Scene(root, 400, 400);

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Circle circle = new Circle(event.getX(), event.getY(), 5);
                System.out.println(event.getX() + " " + event.getY());
                root.getChildren().add(circle);
            }
        });

        // set the scene
        window.setScene(scene);

        window.setMaximized(true);
        window.show();
    }

    public static void main(String args[])
    {
        // launch the application by calling start()
        launch(args);
    }
}