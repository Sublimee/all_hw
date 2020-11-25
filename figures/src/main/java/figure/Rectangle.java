package figure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rectangle extends Line {

    public Rectangle(List<Point> points) {
        super(points);
        if (points.size() != 4 || !isRectangle(points)) {
            throw new IllegalArgumentException("Указанные точки не составляют прямоугольник");
        }
    }

    private boolean isRectangle(List<Point> points) {
        return isOrthogonal(points.get(0), points.get(1), points.get(2)) &&
                isOrthogonal(points.get(1), points.get(2), points.get(3)) &&
                isOrthogonal(points.get(2), points.get(3), points.get(0));
    }

    private boolean isOrthogonal(Point a, Point b, Point c) {
        return (b.getX() - a.getX()) * (b.getX() - c.getX()) + (b.getY() - a.getY()) * (b.getY() - c.getY()) == 0;
    }

    @Override
    public List<Line> getSegments() {
        List<Line> lines = new ArrayList<>(super.getSegments());
        lines.add(new Line(Arrays.asList(points.get(points.size() - 1), points.get(0))));
        return lines;
    }

}
