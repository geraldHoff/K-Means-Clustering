import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CirclePoint extends Circle {
    public CirclePoint(int int1, int int2, int int3, Color color){
        super(int1, int2, int3, color);
    }

    public GroupPoint group;

    public void setGroupPoint(GroupPoint group){
        this.group = group;
    }
}