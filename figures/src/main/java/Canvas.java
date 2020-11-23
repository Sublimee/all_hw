import figure.DrawableFigure;
import figure.Line;
import figure.Point;

import java.util.Arrays;


public class Canvas {

    private static final char LINE_CHAR = '▰';

    private final char[][] cachedCanvasArray;
    private final int width;
    private final int height;

    public Canvas(int w, int h) {
        width = w;
        height = h;
        cachedCanvasArray = new char[this.height][this.width];
        Arrays.stream(cachedCanvasArray).forEach(chars -> Arrays.fill(chars, '▱'));
    }

    public void draw(DrawableFigure figure) {
        for (Line line : figure.getLines()) {
            Point point = line.getPoints().get(0);
            Point anotherPoint = line.getPoints().get(1);
            if (isPointOutsideCanvas(point.getX(), point.getY()) || isPointOutsideCanvas(anotherPoint.getX(), anotherPoint.getY())) {
                throw new IllegalArgumentException("figure.Line is outside of canvas");
            }
            int maxY = Math.max(point.getY(), anotherPoint.getY());
            int minY = Math.min(point.getY(), anotherPoint.getY());
            int maxX = Math.max(point.getX(), anotherPoint.getX());
            int minX = Math.min(point.getX(), anotherPoint.getX());
            for (int row = minY; row <= maxY; row++) {
                for (int col = minX; col <= maxX; col++) {
                    cachedCanvasArray[row][col] = Canvas.LINE_CHAR;
                }
            }
        }
    }

    public String render() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                builder.append(cachedCanvasArray[i][j]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private boolean isPointOutsideCanvas(int x, int y) {
        return x < 0 || x >= width || y < 0 || y >= height;
    }
}