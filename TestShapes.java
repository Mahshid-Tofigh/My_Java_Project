import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.*;


    interface Shape {
       public double getArea();
       public double getPerimeter();

    }

    class Rectangle implements Shape {
        private double width;
        private   double length;

        public Rectangle(double width, double length) {
            this.width = width;
            this.length = length;
        }

        @Override
        public double getArea() {

            return width * length;
        }

        @Override
        public double getPerimeter(){
            return (width + length) * 2;
        }


    }

    class Circle implements Shape {
        private double radius;
        final double pi = Math.PI;

        public Circle(double radius) {

            this.radius = radius;
        }

        @Override
        public double getArea() {

            return Math.pow(radius, 2) * pi;
        }

        @Override
        public double getPerimeter() {

            return (radius * 2) * pi;
        }


    }

    class Triangle implements Shape {
        private double a;
        private double b;
        private double c;

        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double getArea() {
            double s = (a + b + c) / 2;
            double result = (s * (s - a) * (s - b) * (s - c));
            if(result<0) result = result * -1;
            return Math.sqrt(result);

        }

        @Override
        public double getPerimeter() {

            return a + b + c;
        }


    }
public class TestShapes {

    public void testShapes() {
        Shape circle = new Circle(3);
        Shape triangle = new Triangle(2, 4, 8);
        Shape rectangle = new Rectangle(6, 9);
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(triangle);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getName() + " area: " + df.format(shape.getArea()));

        }
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getName() + " perimeter: " + df.format(shape.getPerimeter()));
        }

    }

    public static void main(String[] args) {
        TestShapes ts = new TestShapes();
        ts.testShapes();
    }

}




