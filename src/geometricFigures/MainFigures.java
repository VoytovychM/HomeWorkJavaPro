package geometricFigures;

import java.util.*;

    public class MainFigures {
        public static void main(String[] args) {
            // Создание списка различных геометрических фигур
            List<Figures> figures = new ArrayList<>();
            figures.add(new Rectangle(5, 4));
            figures.add(new Square(3));
            figures.add(new Circle(6));
            figures.add(new Triangle(4, 3));

            // Сортировка списка по площади
            Collections.sort(figures, Comparator.comparingDouble(Figures::calculateArea));

            System.out.println("Sorted list by area:");
            for (Figures figure : figures) {
                System.out.println(figure.getClass().getSimpleName() + " - area: " + figure.calculateArea());
            }

            // Создание TreeSet из геометрических фигур
            TreeSet<Figures> shapeSet = new TreeSet<>(Comparator.comparingDouble(Figures::calculateArea));
            shapeSet.addAll(figures);

            System.out.println("\nTreeSet из геометрических фигур (отсортированный по площади):");
            for (Figures figure : figures) {
                System.out.println(figures.getClass().getSimpleName() + " - area: " + figure.calculateArea());
            }
        }
    }

