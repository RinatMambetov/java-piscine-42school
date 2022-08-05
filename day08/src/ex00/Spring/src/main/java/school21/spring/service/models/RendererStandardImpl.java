package school21.spring.service.models;

import school21.spring.service.interfaces.Renderer;
import school21.spring.service.interfaces.PreProcessor;

public class RendererStandardImpl implements Renderer {
    PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String textToPrint) {
        textToPrint = preProcessor.process(textToPrint);
        System.out.println(textToPrint);
    }
}
