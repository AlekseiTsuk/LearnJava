package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

@Slf4j
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
            log.info("Id = {}", user.getId());
            log.info("First Name = {}", user.getFirstName());
            log.info("Last Name = {}", user.getLastName());
            log.info("Email = {}", user.getEmail());
            log.info("Car = {}", user.getCar());
            log.info("");
        }


        System.out.println(userService.getUserByCar("Mazda", 3));
        context.close();
    }
}