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
 * Git Repo: <a href="https://github.com/geraldHoff/K-Means-Clustering">...</a>
 */
public class Main extends Application {

    public static void main(String[] args)
    {
        // launch the application by calling start()
        launch(args);
    }

    public CirclePoint[] circlePointArray = new CirclePoint[100];
    public Random rand = new Random();

    /**
     * Sets up the window
     * @param window The window that shows the data
     */
    public void start(Stage window) throws Exception {

        // set title for the stage
        window.setTitle("KMeans");
        Button b = new Button("Cluster");
        Group root = new Group(b);
        Scene scene = new Scene(root, 400, 400);

        //set number of dots
        int dots = 100;

        //the number of clusters to sort the points into
        int clusters = 3;

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

        //Button that calls the cluster method when pressed
        b.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                circlePointArray = clusterCircles(circlePointArray, clusters);
            }
        });

        //adds dot to the screen when the mouse is clicked, just for fun
        scene.setOnMousePressed(new EventHandler<>() {
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

    /**
     * Groups the data into a specified number of clusters.
     * @param circlePoints The array of circles
     * @param groupPointsLength The number of groups, i.e. the number of GroupPoints
     * @return returns the new array of CirclePoints
     */
    public CirclePoint[] clusterCircles(CirclePoint[] circlePoints, int groupPointsLength) {

        int circlesLength = circlePoints.length;
        GroupPoint[] groupPointArray = new GroupPoint[groupPointsLength];

        //Create GroupPoints randomly
        for (int i = 0; i < groupPointsLength; i++){
            GroupPoint groupPoint = new GroupPoint();
            groupPoint.x = circlePoints[(i + 1) * (circlesLength / groupPointsLength)].getCenterX();
            groupPoint.y = circlePoints[(i + 1) * (circlesLength / groupPointsLength)].getCenterY();
            groupPointArray[i] = groupPoint;
            System.out.println("GroupPoint x = " + groupPoint.x + " GroupPoint y = " + groupPoint.y + "\n");
        }

        return circlePoints;
    }
}