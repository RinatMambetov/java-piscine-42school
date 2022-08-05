package school21.spring.service.models;

import school21.spring.service.interfaces.Printer;
import school21.spring.service.interfaces.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {

    Renderer renderer;
    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    public void print(String time) {
        renderer.print(time);
    }
}
