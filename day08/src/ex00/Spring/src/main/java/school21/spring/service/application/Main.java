package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.interfaces.PreProcessor;
import school21.spring.service.interfaces.Renderer;
import school21.spring.service.models.PreProcessorToUpperImpl;
import school21.spring.service.models.PrinterWithDateTimeImpl;
import school21.spring.service.models.PrinterWithPrefixImpl;
import school21.spring.service.models.RendererErrImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        PreProcessor preProcessor = new PreProcessorToUpperImpl();
        Renderer renderer = new RendererErrImpl(preProcessor);
        PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
        printer.setPrefix("Prefix");
        printer.print("Hello!!!");

        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("EEEE dd-MMMM-yyyy HH:mm");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        PrinterWithPrefixImpl printerWithPrefixErrToUpper = applicationContext.getBean("printerWithPrefixErrToUpper", PrinterWithPrefixImpl.class);
        printerWithPrefixErrToUpper.print("Hello!");

        PrinterWithDateTimeImpl printerWithDateTimeErrToUpper = applicationContext.getBean("printerWithDateTimeErrToUpper", PrinterWithDateTimeImpl.class);
        printerWithDateTimeErrToUpper.print((LocalDateTime.now().format(dateTimeFormat)));

        PrinterWithPrefixImpl printerWithPrefixOutToLower = applicationContext.getBean("printerWithPrefixOutToLower", PrinterWithPrefixImpl.class);
        printerWithPrefixOutToLower.print("HELLO!");

        PrinterWithDateTimeImpl printerWithDateTimeOutToLower = applicationContext.getBean("printerWithDateTimeoutToLower", PrinterWithDateTimeImpl.class);
        printerWithDateTimeOutToLower.print((LocalDateTime.now().format(dateTimeFormat)));
    }
}
