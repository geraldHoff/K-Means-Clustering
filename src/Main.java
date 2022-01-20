import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Random;

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

        Random rand = new Random();

        //set number of dots
        int d = 1000;

        Circle[] circleArray = new Circle[d];

        //populate
        for(int i = 0; i < d; i++){
            Circle circle = new Circle(
                    rand.nextInt(130) * 10 + 37, rand.nextInt(60) * 10 + 50, 5,
                    Color.rgb(rand.nextInt(230), rand.nextInt(230),
                            rand.nextInt(230))
            );
            circleArray[i] = circle;
            root.getChildren().add(circle);
        }

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Circle circle = new Circle(event.getX(), event.getY(), 5,
                        Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))
                );
                root.getChildren().add(circle);
            }
        });

        // set the scene
        window.setMaximized(true);
        window.setScene(scene);
        window.show();
    }

    public static void main(String args[])
    {
        // launch the application by calling start()
        launch(args);
    }
}