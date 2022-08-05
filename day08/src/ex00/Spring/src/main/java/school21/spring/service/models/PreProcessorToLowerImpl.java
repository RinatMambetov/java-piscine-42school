package school21.spring.service.models;

import school21.spring.service.interfaces.PreProcessor;

public class PreProcessorToLowerImpl implements PreProcessor {

    @Override
    public String process(String text) {
        return (text.toLowerCase());
    }
}
