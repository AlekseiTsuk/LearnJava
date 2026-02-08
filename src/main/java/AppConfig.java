import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    private static final String HELLO_MESSAGE = "Hello World!";
    private static final String CAT_NAME = "Cat created.";

    @Bean(name="helloworld")
    public HelloWorld getHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage(HELLO_MESSAGE);
        return helloWorld;
    }

    @Bean(name="Cat")
    @Scope("prototype")
    public Cat getCat() {
        Cat cat = new Cat();
        cat.setName(CAT_NAME);
        return cat;
    }
}