abstract class Figure { double dimension1;
double dimension2; Figure(double a, double b) {
dimension1 = a;
dimension2 = b; }
    abstract double area();
}


class Rectangle extends Figure { 
	Rectangle(double c, double d) {
	super(c,d); }


    @Override
    double area() {
        return dimension2 * dimension1;
    }
}


class Triangle extends Figure {
Triangle(double a, double b) { super(a,b);
    }
    @Override
    double area() {
        return (dimension2 * dimension1)/2;
    }
}


class Square extends Figure {
Square(double a, double b) { super(a,b);
    }
    @Override
    double area() {
        return dimension1 * dimension2;
    }
}


public class AbstractClass {
    public static void main(String[] args) {

Figure rec = new Rectangle(5, 5); 
Figure tri = new Triangle(2, 5); 
Figure sq = new Square(2, 4);

System.out.println("Area of Rectangle is = " + rec.area()); 

System.out.println("Area of Triangle is = " + tri.area()); 

System.out.println("Area of Square is = " + sq.area());
}
}