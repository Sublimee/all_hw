package figure;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SquareTest {

    @Test
    public void squareTest() {
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(10, 0),
                new Point(10, 10),
                new Point(0, 10)
        );
        new Square(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rectangleTest() {
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(10, 0),
                new Point(10, 20),
                new Point(0, 20)
        );
        new Square(points);
    }

}
