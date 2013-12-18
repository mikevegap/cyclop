package org.cyclop.service.completion.parser.dropkeyspace;

import org.cyclop.model.CqlKeyword;
import org.cyclop.model.CqlPart;
import org.cyclop.service.completion.parser.NotSupportedCompletion;

import javax.inject.Named;

/**
 * @author Maciej Miklas
 */
@Named("dropkeyspace.DropCompletion")
public class DropCompletion extends NotSupportedCompletion {

    private final static CqlPart SM = new CqlKeyword("drop");

    @Override
    public CqlPart startMarker() {
        return SM;
    }

    @Override
    protected String getNotSupportedText() {
        return "drop keyspace";
    }
}