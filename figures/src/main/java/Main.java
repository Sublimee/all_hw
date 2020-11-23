import figure.Point;
import figure.Rectangle;

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
        canvas.draw(new Rectangle(Arrays.asList(new Point(0, 0), new Point(9, 0), new Point(9, 9), new Point(0, 9))));
        System.out.println(canvas.render());
    }

}
