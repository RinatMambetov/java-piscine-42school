package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepositoryJdbcImpl;
import school21.spring.service.repositories.UsersRepositoryJdbcTemplateImpl;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        System.out.println("--UseJdbc--");
        UsersRepositoryJdbcImpl JdbcImpl = context.getBean(UsersRepositoryJdbcImpl.class);
        System.out.println(JdbcImpl.findAll());
        System.out.println("findById " + JdbcImpl.findById(1L));
        System.out.println("findByEmail " + JdbcImpl.findByEmail("email2").get());
        JdbcImpl.update(new User(3L, "newEmail"));
        System.out.println("update " + JdbcImpl.findById(3L));
        JdbcImpl.delete(5L);
        System.out.println("after delete " + JdbcImpl.findAll());

        JdbcImpl.update(new User(3L, "email3"));
        JdbcImpl.save(new User(5L, "email5"));

        System.out.println("--UseJdbcTemplate--");
        UsersRepositoryJdbcTemplateImpl springTemplateImpl = context.getBean(UsersRepositoryJdbcTemplateImpl.class);
        System.out.println(springTemplateImpl.findAll());
        System.out.println("findById " + springTemplateImpl.findById(1L));
        System.out.println("findByEmail " + springTemplateImpl.findByEmail("email2").get());
        springTemplateImpl.update(new User(3L, "newEmail"));
        System.out.println("update " + springTemplateImpl.findById(3L));
        springTemplateImpl.delete(5L);
        System.out.println("after delete " + springTemplateImpl.findAll());
     }
}
