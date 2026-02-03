import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());

        Cat tom = (Cat) applicationContext.getBean("Cat");
        System.out.println(tom.getName());

        HelloWorld hellWo =
                applicationContext.getBean(HelloWorld.class);
        System.out.println(hellWo.getMessage());

        Cat pusha =
                applicationContext.getBean(Cat.class);
        System.out.println(pusha.getName());

        System.out.println("HelloWorld same: " + bean.equals(hellWo));
        System.out.println("Cat same: " + tom.equals(pusha));
    }
}