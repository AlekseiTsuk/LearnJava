package app.model;

import org.springframework.stereotype.Component;


@Component(Dog.TARGET_BEAN)
public class Dog extends Animal {
    protected static final String TARGET_BEAN = "MyDog";

    @Override
    public String toString() {
        return "I'm a Dog";
    }
}
