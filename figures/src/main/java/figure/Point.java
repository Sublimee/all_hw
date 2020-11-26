package figure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Point implements DrawableFigure {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public List<Line> getSegments() {
        Point point = new Point(x, y);
        return Collections.singletonList(new Line(Arrays.asList(point, point)));
    }

}
