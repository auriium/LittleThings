package xyz.auriium.littlethings.conversation.simple.data;

import xyz.auriium.littlethings.conversation.ConversationData;
import xyz.auriium.littlethings.conversation.RemapFunction;

import java.util.List;
import java.util.NoSuchElementException;

public class CdNull implements ConversationData {

    private final ConversationData delegate;

    public CdNull(ConversationData delegate) {
        this.delegate = delegate;
    }

    @Override
    public <T> T getValue(String value, Class<T> type) {

        try {
            return delegate.getValue(value, type);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public ConversationData immutable() {
        return new CdNull(delegate.immutable());
    }

    @Override
    public ConversationData remapped(List<RemapFunction> functions) {
        return new CdNull(delegate.remapped(functions));
    }

}
