import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Прототип, який підтримує клонування
class Prototype implements Cloneable {
    private String property;

    public Prototype(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}

// Інтерфейс для компоненти
interface Component {
    void operation();
}

// Конкретна реалізація компоненти
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("Basic operation");
    }
}

// Абстрактний декоратор
abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

// Конкретний декоратор
class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        additionalOperation();
    }

    private void additionalOperation() {
        System.out.println("Additional operation");
    }
}

// Колекція, яку потрібно ітерувати
class MyCollection implements Iterable<String> {
    private List<String> elements;

    public MyCollection() {
        elements = new ArrayList<>();
    }

    public void add(String element) {
        elements.add(element);
    }

    @Override
    public Iterator<String> iterator() {
        return elements.iterator();
    }
}

// Приклад використання усіх трьох шаблонів
public class DesignPatternsExample {
    public static void main(String[] args) {
        // Приклад використання шаблону Prototype
        try {
            Prototype prototype = new Prototype("Initial property value");
            Prototype cloned = prototype.clone();
            System.out.println("Prototype Example:");
            System.out.println("Original property: " + prototype.getProperty());
            System.out.println("Cloned property: " + cloned.getProperty());
            System.out.println();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Приклад використання шаблону Decorator
        System.out.println("Decorator Example:");
        Component component = new ConcreteComponent();
        Component decorated = new ConcreteDecorator(component);
        decorated.operation();
        System.out.println();

        // Приклад використання шаблону Iterator
        System.out.println("Iterator Example:");
        MyCollection collection = new MyCollection();
        collection.add("Element 1");
        collection.add("Element 2");
        collection.add("Element 3");

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
