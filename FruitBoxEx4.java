import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Fruit4 {
    String name;
    int weight;

    Fruit4(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return name + "(" + weight + ")";
    }
}

class Apple4 extends Fruit4 {
    Apple4(String name, int weight) {
        super(name, weight);
    }
}

class Grape4 extends Fruit4 {
    Grape4(String name, int weight) {
        super(name, weight);
    }
}

class AppleComp implements Comparator<Apple4> {
    public int compare(Apple4 t1, Apple4 t2) {
        return t2.weight - t1.weight;
    }
}

class GrapeComp implements Comparator<Grape4> {
    public int compare(Grape4 t1, Grape4 t2) {
        return t2.weight - t1.weight;
    }
}

class FruitComp implements Comparator<Fruit4> {
    public int compare(Fruit4 t1, Fruit4 t2) {
        return t1.weight - t2.weight;
    }
}

// List<Apple>을 정렬하기 위해서는 Comparator<Apple>이 필요함.
// 하지만 Apple 대신에 Grape를 대입하게 되면 Comparator<Apple>로는 List<Grape>를
// 정렬할 수 없기 때문에 Comparator<Grape>가 필요함.
// 자손이 생길때마다 똑같은 코드를 반복해서 만들어야 함.
// -> 타입매개변수에 하한 제한의 와일드카드를 적용.
// static <T> void sort(List<T> list, Comparator<? super T> c)
// static void sort(List<Apple> list, Comparator<? super Apple> c)
// : 매개변수가 ? super Apple이라는 것은 Comparator의 매개변수로 Apple과 그 조상이 가능하다는 것.

public class FruitBoxEx4 {
    public static void main(String[] args) {
        FruitBox4<Apple4> appleBox = new FruitBox4<Apple4>();
        FruitBox4<Grape4> grapeBox = new FruitBox4<Grape4>();

        appleBox.add(new Apple4("GreenApple", 300));
        appleBox.add(new Apple4("GreenApple", 100));
        appleBox.add(new Apple4("GreenApple", 200));

        grapeBox.add(new Grape4("GreenGrape", 400));
        grapeBox.add(new Grape4("GreenGrape", 200));
        grapeBox.add(new Grape4("GreenGrape", 300));

        Collections.sort(appleBox.getList(), new AppleComp());
        Collections.sort(grapeBox.getList(), new GrapeComp());
        System.out.println(appleBox);
        System.out.println(grapeBox);
        System.out.println();
        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(), new FruitComp());
        System.out.println(appleBox);
        System.out.println(grapeBox);
    }
}

class FruitBox4<T extends Fruit4> extends Box4<T> {
}

class Box4<T> {
    ArrayList<T> list = new ArrayList<T>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    ArrayList<T> getList() {
        return list;
    }

    int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }
}