enum Direction2 {
    EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");

    private static final Direction2[] DIR_ARR = Direction2.values();
    private final int value;
    private final String symbol;

    // 열거형의 생성자는 항상 private으로..
    Direction2(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Direction2 of(int dir) {
        // dir의 범위가 0~3을 벗어나면 예외발생 시키기
        if (dir < 1 || dir > 4) {
            throw new IllegalArgumentException("Invalid value : " + dir);
        }
        return DIR_ARR[dir - 1];
    }

    // 90씩 시계방향으로 회전시키기
    public Direction2 rotate(int num) {
        num = num % 4;
        if (num < 0) // 음수라면 반시계방향으로 돌려
            num += 4;
        return DIR_ARR[(value - 1 + num) % 4];
    }

    public String toString() {
        return name() + " " + getSymbol();
    }
} // end class Direction2

public class EnumEx2 {
    public static void main(String[] args) {
        for (Direction2 d : Direction2.values())
            System.out.printf("%s = %d%n", d.name(), d.getValue());
        System.out.println();
        Direction2 d1 = Direction2.EAST;
        Direction2 d2 = Direction2.of(1);
        System.out.printf("d1 = %s, %d%n", d1.name(), d1.getValue());
        System.out.printf("d2 = %s, %d%n", d2.name(), d2.getValue());
        System.out.println();
        System.out.println(Direction2.EAST.rotate(1));
        System.out.println(Direction2.EAST.rotate(2));
        System.out.println(Direction2.EAST.rotate(-1));
        System.out.println(Direction2.EAST.rotate(-2));
    }

}
