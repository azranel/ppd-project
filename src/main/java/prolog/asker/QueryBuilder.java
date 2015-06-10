package prolog.asker;

import jpl.*;
import jpl.Integer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by azranel on 09.06.15.
 * <p>
 * QueryBuilder class suppose to be used to build JPL queries.
 * <p>
 * Important note: order of adding another term to query have influence
 * on how query will be build.
 */
public class QueryBuilder {
    private List<Term> queryTerms;
    private String queryName;

    public QueryBuilder(String queryName) {
        this.queryName = queryName;
        queryTerms = new LinkedList<>();
    }

    public QueryBuilder addNewVariable(String variableName) {
        queryTerms.add(new Variable(variableName.toString()));
        return this;
    }

    public QueryBuilder addNewVariables(String... variableNames) {
        for (String variableName : variableNames) {
            addNewVariable(variableName);
        }
        return this;
    }

    public QueryBuilder addNewAtom(String atomName) {
        queryTerms.add(new Atom(atomName));
        return this;
    }

    public QueryBuilder addNewInteger(int integerValue) {
        queryTerms.add(new Integer(integerValue));
        return this;
    }

    public Query buildQuery() {
        Term[] terms = getTermsArray();
        Query query = new Query(queryName, terms);
        return query;
    }

    private Term[] getTermsArray() {
        Term[] terms = new Term[queryTerms.size()];
        for (int index = 0; index < queryTerms.size(); index++) {
            terms[index] = queryTerms.get(index);
        }
        return terms;
    }
}
