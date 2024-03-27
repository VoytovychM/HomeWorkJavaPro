package geometricFigures;

public class Figures {
    // 1. Создать набор классов для хранения геометрических фигур:
    //прямоугольник, квадрат, круг, треугольник (пусть для простоты будет только прямоугольный)
    //2. Добавить метод вычисления площади фигур
    //3. Составить список из разных геометрических фигур и отсортировать его по площади
    //4. Составить TreeSet из геометрических фигур - тех, для которых это имеет смысл

    double calculateArea() {
        return 0;
    }
}

    // Класс прямоугольника
    class Rectangle extends Figures {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        double calculateArea() {
            return width * height;
        }
    }


    class Square extends Rectangle {
        public Square(double side) {
            super(side, side);
        }
    }


    class Circle extends Figures {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        double calculateArea() {

            return Math.PI * radius * radius;
        }
    }

    class Triangle extends Figures {
        private double base;
        private double height;

        public Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        double calculateArea() {
            return 0.5 * base * height;
        }
    }



