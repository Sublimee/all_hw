import figure.Line;
import figure.Point;
import figure.Rectangle;
import figure.Square;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CanvasTest {

    private Canvas canvas;

    private final String expected = " ▰  ▰  ▰  ▰  ▰  ▰  ▰  ▰  ▰  ▰ \n" +
            " ▰  ▱  ▱  ▱  ▱  ▱  ▱  ▱  ▱  ▰ \n" +
            " ▰  ▱  ▰  ▰  ▰  ▱  ▱  ▱  ▱  ▰ \n" +
            " ▰  ▱  ▰  ▱  ▰  ▱  ▱  ▱  ▱  ▰ \n" +
            " ▰  ▱  ▰  ▰  ▰  ▱  ▱  ▱  ▱  ▰ \n" +
            " ▰  ▱  ▱  ▱  ▱  ▱  ▱  ▱  ▱  ▰ \n" +
            " ▰  ▱  ▱  ▱  ▱  ▱  ▱  ▱  ▱  ▰ \n" +
            " ▰  ▱  ▰  ▰  ▰  ▰  ▰  ▰  ▱  ▰ \n" +
            " ▰  ▱  ▱  ▱  ▱  ▱  ▱  ▱  ▱  ▰ \n" +
            " ▰  ▰  ▰  ▰  ▰  ▰  ▰  ▰  ▰  ▰ \n";

    @Before
    public void init() {
        canvas = new Canvas(10, 10);
    }

    @Test
    public void drawTest() {
        canvas.draw(new Line(Arrays.asList(new Point(2, 7), new Point(7, 7))));
        canvas.draw(new Rectangle(Arrays.asList(new Point(0, 0), new Point(9, 0), new Point(9, 9), new Point(0, 9))));
        canvas.draw(new Square(Arrays.asList(new Point(2, 2), new Point(4, 2), new Point(4, 4), new Point(2, 4))));
        String actual = canvas.render();
        assertEquals(expected, actual);
        System.out.println(actual);
    }

}
