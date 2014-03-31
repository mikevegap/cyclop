package org.cyclop.service.importer;

import org.cyclop.model.CqlQuery;
import org.cyclop.model.exception.QueryException;

/** @author Maciej Miklas */
public interface ResultWritter {

	void success(CqlQuery query, long runtime);

	void error(CqlQuery query, QueryException error, long runtime);
}
