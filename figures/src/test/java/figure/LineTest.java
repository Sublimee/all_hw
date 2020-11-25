package figure;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LineTest {

    @Test
    public void lineConstructorTest() {
        List<Point> points = Arrays.asList(new Point(0, 0), new Point(1, 1));
        new Line(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lineConstructorNullPointsListTest() {
        List<Point> points = null;
        new Line(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lineConstructorLackOfPointsTest() {
        List<Point> points = Collections.singletonList(new Point(0, 0));
        new Line(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lineConstructorNullPointsTest() {
        Point point1 = null;
        Point point2 = null;
        List<Point> points = Arrays.asList(point1, point2);
        new Line(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lineConstructorEqualsPointsGoesConsequentTest() {
        List<Point> points = Arrays.asList(new Point(0, 0), new Point(0, 0));
        new Line(points);
    }

}
