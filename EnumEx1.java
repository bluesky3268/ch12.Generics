enum Direction {
    EAST, SOUTH, WEST, NORTH
}

public class EnumEx1 {
    // 열거형 : 서로 관련된 상수를 편리하게 선언하기 위한 것.
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("SOUTH");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");
        // 열거형 상수의 이름으로 문자열 상수에 대한 참조를 얻을 수 있게 해줌.

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        System.out.println("d1 == d2 ?" + (d1 == d2));
        System.out.println("d1 == d3 ? " + (d1 == d3));
        // 그래서 d1 == d3로 같은 값을 참조하고 있음.
        System.out.println("d1.equals(d3) ? " + (d1.equals(d3)));
        // System.out.println("d2 > d3 ?" + (d1 > d3)); 에러
        System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
        System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));

        switch (d1) {
            case EAST:
                System.out.println("The direiction is EAST");
                break;
            case SOUTH:
                System.out.println("The direction is SOUTH");
                break;
            case WEST:
                System.out.println("The direction is WEST");
                break;
            case NORTH:
                System.out.println("The direction is NORTH");
                break;
            default:
                System.out.println("Invalid direction");
                break;
        }
        Direction[] dArr = Direction.values();
        for (Direction d : dArr)
            System.out.printf("%s = %d%n", d.name(), d.ordinal());
    }

}
