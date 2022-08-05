package school21.spring.service.models;

import school21.spring.service.interfaces.PreProcessor;
import school21.spring.service.interfaces.Renderer;

public class RendererErrImpl implements Renderer {

    PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String textToPrint) {
        textToPrint = preProcessor.process(textToPrint);
        System.err.println(textToPrint);
    }
}
