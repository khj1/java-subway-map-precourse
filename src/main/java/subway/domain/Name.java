package subway.domain;

import java.util.Objects;

public class Name {

    private static final String INVALID_NAME_LENGTH = "이름은 2글자 이상이어야 합니다";
    private static final int NAME_LENGTH_LOWER_BOUND = 2;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (hasInvalidLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    private boolean hasInvalidLength(String name) {
        return name.length() < NAME_LENGTH_LOWER_BOUND;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
