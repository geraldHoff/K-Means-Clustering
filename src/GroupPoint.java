public class GroupPoint {

    public GroupPoint(int circlePointArrayLength){
        circlePointArray = new CirclePoint[circlePointArrayLength];
    }

    public CirclePoint[] circlePointArray;

    double x;
    double y;
    double mean;

    public void setMean(){
        double temp = 0;
        for (int i = 0; i < circlePointArray.length; i++){
            temp = temp + circlePointArray[i].groupDistance;
        }
        //TODO technically this won't work as this doesn't show the number of circlePoints, just the length of array.
        mean = temp / circlePointArray.length;
    }
}
