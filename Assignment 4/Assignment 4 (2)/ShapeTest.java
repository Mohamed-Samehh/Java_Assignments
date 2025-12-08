import java.util.ArrayList;
import java.util.List;

public class ShapeTest {
    
    // Method that accepts only lists of Shape's child classes
    public static void drawAllShapes(List<? extends Shape> shapes) {
        System.out.println("--- Drawing All Shapes ---");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Rectangle());
        shapes.add(new Circle());
        shapes.add(new Rectangle());
        shapes.add(new Circle());
        shapes.add(new Circle());

        drawAllShapes(shapes);
    }
}