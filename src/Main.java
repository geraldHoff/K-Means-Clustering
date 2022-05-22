import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Random;

/**
 * Gerald Hoff
 * Git Repo: https://github.com/geraldHoff/K-Means-Clustering
 */
public class Main extends Application {

    public static void main(String args[])
    {
        // launch the application by calling start()
        launch(args);
    }

    public CirclePoint[] circlePointArray = new CirclePoint[100];

    /**
     * Sets up the window
     * @param window
     * @throws Exception
     */
    public void start(Stage window) throws Exception {

        // set title for the stage
        window.setTitle("KMeans");
        Button b = new Button("Cluster");
        Group root = new Group(b);
        Scene scene = new Scene(root, 400, 400);

        Random rand = new Random();

        //set number of dots
        int dots = 100;

        //the number of clusters (colors)
        int clusters = 4;



        //populate
        for(int i = 0; i < dots; i++){
            CirclePoint circlePoint = new CirclePoint(
                    rand.nextInt(130) * 10 + 37, rand.nextInt(60) * 10 + 50, 5,
                    Color.rgb(rand.nextInt(230), rand.nextInt(230),
                            rand.nextInt(230))
            );
            circlePointArray[i] = circlePoint;
            root.getChildren().add(circlePoint);
        }

        b.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                circlePointArray = sortCircles(circlePointArray);
            }
        });

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                CirclePoint circle = new CirclePoint((int) event.getX(), (int) event.getY(), 5,
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

    public CirclePoint[] sortCircles(CirclePoint[] circles) {
        int circlesLength = circles.length;
        for (int i = 0; i < circlesLength; i+=2){
            circles[i].setFill(Color.rgb(100, 100, 100));
        }
        for (int i = 1; i < circlesLength; i+=2){
            circles[i].setFill(Color.rgb(200, 200, 200));
        }
        return circles;
    }
}