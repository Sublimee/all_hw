package figure;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RectangleTest {

    @Test
    public void rectangleTest() {
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(10, 0),
                new Point(10, 20),
                new Point(0, 20)
        );
        new Rectangle(points);
    }

    @Test
    public void squareTest() {
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(10, 0),
                new Point(10, 10),
                new Point(0, 10)
        );
        new Rectangle(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parallelogramTest() {
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 0),
                new Point(2, 1),
                new Point(1, 1)
        );
        new Rectangle(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void straightVerticalLineTest() {
        List<Point> points = Arrays.asList(
                new Point(0, 1),
                new Point(0, 2),
                new Point(0, 3),
                new Point(0, 4)
        );
        new Rectangle(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void straightHorizontalLineTest() {
        List<Point> points = Arrays.asList(
                new Point(1, 0),
                new Point(2, 0),
                new Point(3, 0),
                new Point(4, 0)
        );
        new Rectangle(points);
    }

}
