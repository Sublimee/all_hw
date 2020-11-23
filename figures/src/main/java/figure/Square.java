package figure;

import java.util.List;

public class Square extends Rectangle {

    public Square(List<Point> points) {
        super(points);
        if (!isSquare(points)) {
            throw new IllegalArgumentException("Указанные точки не составляют квадрат");
        }
    }

    private boolean isSquare(List<Point> points) {
        return Math.abs((points.get(0).getX() - points.get(1).getX()) + (points.get(0).getY() - points.get(1).getY()))
                - Math.abs((points.get(0).getX() - points.get(3).getX()) + (points.get(0).getY() - points.get(3).getY())) == 0;
    }

}
