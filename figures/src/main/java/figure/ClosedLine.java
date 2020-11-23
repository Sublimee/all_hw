package figure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosedLine extends Line implements DrawableFigure {

    public ClosedLine(List<Point> points) {
        super(points);
        if (points.size() < 3) {
            throw new IllegalArgumentException("Замкнутая линия не может состоять менее, чем из 3 точек");
        }
        boolean isStraightLine = points.stream().map(Point::getX).distinct().limit(2).count() <= 1 ||
                points.stream().map(Point::getY).distinct().limit(2).count() <= 1;
        if (isStraightLine) {
            throw new IllegalArgumentException("Точки находятся на прямой и не образуют замкнутую линию");
        }
    }

    @Override
    public List<Line> getLines() {
        List<Line> lines = new ArrayList<>(super.getLines());
        lines.add(new Line(Arrays.asList(points.get(points.size() - 1), points.get(0))));
        return lines;
    }

}
