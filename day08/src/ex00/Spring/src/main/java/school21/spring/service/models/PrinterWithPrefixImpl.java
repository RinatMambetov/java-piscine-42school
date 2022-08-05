package school21.spring.service.models;

import school21.spring.service.interfaces.Printer;
import school21.spring.service.interfaces.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    private String prefix;
    Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
        prefix = "";
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void print(String text) {
        renderer.print(this.prefix + " " + text);
    }
}
