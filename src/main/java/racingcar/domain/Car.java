package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        checkLimitCharacters(name);
        this.name = name;
        this.position = position;
    }

    private void checkLimitCharacters(String carName) {
        if (carName.length() > LIMIT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(LIMIT_CAR_NAME_LENGTH + "자 이하의 자동차 이름만 허용됩니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }

    public boolean isFartherPosition(int position) {
        return this.position > position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        String output = name + " : ";

        for (int i = 0; i < position; i++) {
            output += "-";
        }
        return output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
