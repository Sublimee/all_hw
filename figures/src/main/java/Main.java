import figure.Line;
import figure.Point;
import figure.Rectangle;
import figure.Square;

import java.util.Arrays;

public class Main {

    private static Canvas canvas;

    public static void main(String[] args) throws NumberFormatException {
        createNewCanvas();
        draw();
    }

    private static void createNewCanvas() {
        canvas = new Canvas(10, 10);
        System.out.println(canvas.render());
    }

    private static void draw() {
        if (canvas == null) {
            System.out.println("You have to create canvas first");
            return;
        }

        canvas.draw(new Line(Arrays.asList(new Point(2, 7), new Point(7, 7))));
        canvas.draw(new Rectangle(Arrays.asList(new Point(0, 0), new Point(9, 0), new Point(9, 9), new Point(0, 9))));
        canvas.draw(new Square(Arrays.asList(new Point(2, 2), new Point(4, 2), new Point(4, 4), new Point(2, 4))));
        System.out.println(canvas.render());
    }

}
