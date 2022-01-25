package com.code;

import java.util.List;
import java.util.Objects;

public class Institute {
    String name;
    List<String> locations;

    public Institute(String name, List<String> locations) {
        this.name = name;
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Institute{" +
                "name='" + name + '\'' +
                ", locations=" + locations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institute institute = (Institute) o;
        return Objects.equals(getName(), institute.getName()) && Objects.equals(getLocations(), institute.getLocations());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLocations());
    }

    public List<String> getLocations() {
        return locations;
    }
}
