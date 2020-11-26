package figure;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LineTest {

    @Test
    public void lineConstructorTest() {
        Point point = new Point(0, 0);
        Point anotherPoint = new Point(0, 1);
        List<Point> points = Arrays.asList(point, anotherPoint);
        Line line = new Line(points);
        assertEquals(line.getPoints().get(0), point);
        assertEquals(line.getPoints().get(1), anotherPoint);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lineConstructorDiagonalTest() {
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
