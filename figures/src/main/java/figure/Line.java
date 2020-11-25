package figure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line implements DrawableFigure {

    protected List<Point> points;

    public Line(List<Point> points) {
        setPoints(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        validatePoints(points);
        this.points = points;
    }

    @Override
    public List<Line> getSegments() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            lines.add(new Line(Arrays.asList(points.get(i), points.get(i + 1))));
        }
        return lines;
    }

    protected boolean isDiagonal(Point point, Point previousPoint) {
        return point.getX() != previousPoint.getX() && point.getY() != previousPoint.getY();
    }

    private void validatePoints(List<Point> points) {
        if (points == null || points.size() < 2) {
            throw new IllegalArgumentException("В качестве параметра задан список неверной длины");
        }
        int i = 0;
        if (Objects.isNull(points.get(i))) {
            throw new IllegalArgumentException("Список точек содержит null-значения");
        }
        for (i = 1; i < points.size(); i++) {
            Point point = points.get(i);
            Point previousPoint = points.get(i - 1);
            if (Objects.isNull(point)) {
                throw new IllegalArgumentException("Список точек содержит null-значения");
            }
            if (point.equals(previousPoint)) {
                throw new IllegalArgumentException("Список содержит одинаковые подряд идущие значения");
            }
            if (isDiagonal(point, previousPoint)) {
                throw new IllegalArgumentException("Линия не может идти по диагонали");
            }
        }
    }

}
