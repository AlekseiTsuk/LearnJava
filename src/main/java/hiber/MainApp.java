package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Igor", "Dubov", "IDubov@mail.ru",
                new Car("Mazda", 3)));
        userService.add(new User("Irina", "Pronina", "Prosha@mail.ru",
                new Car("Toyota", 8)));
        userService.add(new User("Tatiana", "Lobova", "Lombok@mail.ru",
                new Car("Lada", 99)));
        userService.add(new User("Oleg", "Klimov", "OKlim@mail.ru",
                new Car("Volga", 17)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().toString());
            System.out.println();
        }

        System.out.println(userService.getUserByCar("Mazda", 3));
        context.close();
    }
}
