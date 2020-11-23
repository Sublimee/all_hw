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

    private void validatePoints(List<Point> points) {
        if (points == null || points.size() < 2) {
            throw new IllegalArgumentException("В качестве параметра задан список неверной длины");
        }
        if (points.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Список точек содержит null значения");
        }
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i).equals(points.get(i + 1))) {
                throw new IllegalArgumentException("Список содержит одинаковые подряд идущие значения");
            }
        }
    }

    @Override
    public List<Line> getLines() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            lines.add(new Line(Arrays.asList(points.get(i), points.get(i + 1))));
        }
        return lines;
    }

}
