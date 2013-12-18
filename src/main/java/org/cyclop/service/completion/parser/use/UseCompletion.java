package org.cyclop.service.completion.parser.use;

import com.google.common.collect.ImmutableSortedSet;
import org.cyclop.model.*;
import org.cyclop.service.cassandra.QueryService;
import org.cyclop.service.completion.parser.CqlPartCompletionStatic;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Maciej Miklas
 */
@Named("use.UsePartCompletion")
public class UseCompletion implements CqlPartCompletionStatic {

    private final static CqlPart SM = new CqlKeyword("use");

    @Inject
    private QueryService queryService;

    @Override
    public CqlCompletion getCompletion(CqlQuery query) {
        ImmutableSortedSet<CqlKeySpace> keySpaces = queryService.findAllKeySpaces();
        CqlCompletion completion = new CqlCompletion(keySpaces, keySpaces);
        return completion;
    }

    @Override
    public CqlPart startMarker() {
        return SM;
    }
}