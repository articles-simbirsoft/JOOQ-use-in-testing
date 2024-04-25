package org.example.jdbc.db.fields;

/**
 * Class for build db query.
 */
public class QueryBuilder implements AirplaneFields, CompanyFields, ModelFields {
    private final StringBuffer query = new StringBuffer();

    public String build() {
        return query.toString();
    }

    public QueryBuilder select() {
        query.append("SELECT ");
        return this;
    }

    public QueryBuilder all() {
        query.append("*");
        return this;
    }

    public QueryBuilder from() {
        query.append(" FROM ");
        return this;
    }

    public QueryBuilder andField() {
        query.append(", ");
        return this;
    }

    public QueryBuilder leftJoin() {
        query.append(" LEFT JOIN ");
        return this;
    }

    public QueryBuilder join() {
        query.append(" JOIN ");
        return this;
    }

    public QueryBuilder subTableOpen() {
        query.append("(");
        return this;
    }

    public QueryBuilder subTableClose() {
        query.append(")");
        return this;
    }

    public QueryBuilder on() {
        query.append(" ON ");
        return this;
    }

    public QueryBuilder where() {
        query.append(" WHERE ");
        return this;
    }

    public QueryBuilder equals() {
        query.append(" = ");
        return this;
    }

    public QueryBuilder like() {
        query.append(" LIKE ");
        return this;
    }

    public QueryBuilder and() {
        query.append(" AND ");
        return this;
    }

    public QueryBuilder addQuery(String queryString) {
        query.append(queryString);
        return this;
    }

    public QueryBuilder addElement(String string) {
        query.append("'").append(string).append("'");
        return this;
    }

    public QueryBuilder addElement(boolean bool) {
        query.append(bool);
        return this;
    }

    public QueryBuilder addElement(long integer) {
        query.append(integer);
        return this;
    }

    public QueryBuilder as(String newFieldName) {
        query.append(" ").append(newFieldName);
        return this;
    }
    public QueryBuilder modelTable() {
        query.append(MODEL_TABLE);
        return this;
    }
    public QueryBuilder modelId() {
        query.append(MODEL_ID_FIELD);
        return this;
    }
    public QueryBuilder modelName() {
        query.append(MODEL_NAME_FIELD);
        return this;
    }
    public QueryBuilder modelCompany() {
        query.append(COMPANY_FIELD);
        return this;
    }

    public QueryBuilder airplaneTable() {
        query.append(AIRPLANE_TABLE);
        return this;
    }

    public QueryBuilder airplaneId() {
        query.append(AIRPLANE_ID_FIELD);
        return this;
    }

    public QueryBuilder airplaneModel() {
        query.append(MODEL_FIELD);
        return this;
    }

    public QueryBuilder airplaneNumber() {
        query.append(NUMBER_FIELD);
        return this;
    }

    public QueryBuilder release() {
        query.append(RELEASE_FIELD);
        return this;
    }

    public QueryBuilder companyTable() {
        query.append(COMPANY_TABLE);
        return this;
    }

    public QueryBuilder companyId() {
        query.append(COMPANY_ID_FIELD);
        return this;
    }

    public QueryBuilder companyName() {
        query.append(COMPANY_NAME_FIELD);
        return this;
    }
}
