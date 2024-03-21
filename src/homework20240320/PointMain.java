package homework20240320;

import java.util.*;

public class PointMain {
    public static void main(String[] args) {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1,3));
        pointList.add(new Point(5,5));
        pointList.add(new Point(2,2));
        pointList.add(new Point(3,1));
        pointList.add(new Point(4, 4));
        pointList.add(new Point(5,5));
        pointList.add(new Point(2,5));


        Collections.sort(pointList, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.getY() - p2.getY();
            }
        });
        System.out.println(pointList);

        Set<Point> treeSet = new TreeSet<>();
        treeSet.addAll(pointList);
        System.out.println(treeSet);

        Set<Point> treeSetY = new TreeSet<>();
        treeSetY.addAll(pointList);


    }

}
