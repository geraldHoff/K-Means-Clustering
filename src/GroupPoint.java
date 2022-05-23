import java.util.ArrayList;

public class GroupPoint {

    public GroupPoint(int circlePointArrayLength){
        circlePointArray = new CirclePoint[circlePointArrayLength];
    }

    public CirclePoint[] circlePointArray;
    public ArrayList<CirclePoint> circlePointArrayList;

    double x;
    double y;
    double mean;

    public void setMean(){
        double temp = 0;
        for (int i = 0; i < circlePointArrayList.size(); i++){
            temp = temp + circlePointArrayList.get(i).groupDistance;
        }
        mean = temp / circlePointArrayList.size();
    }
}
