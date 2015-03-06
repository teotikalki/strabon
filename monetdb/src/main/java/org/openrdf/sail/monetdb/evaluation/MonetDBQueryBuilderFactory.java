/*
 * Copyright Aduna (http://www.aduna-software.com/) (c) 2008.
 * 
 * Licensed under the Aduna BSD-style license.
 */
package org.openrdf.sail.monetdb.evaluation;

import org.openrdf.sail.generaldb.evaluation.*;

/**
 * Creates the SQL query building components.
 */
public class MonetDBQueryBuilderFactory extends GeneralDBQueryBuilderFactory {

  @Override
  public GeneralDBQueryBuilder createQueryBuilder() {
    MonetDBQueryBuilder query = new MonetDBQueryBuilder(createSqlQueryBuilder());
    query.setValueFactory(vf);
    query.setUsingHashTable(usingHashTable);
    return query;
  }

  @Override
  public GeneralDBSqlExprBuilder createSqlExprBuilder() {
    return new MonetDBSqlExprBuilder(this);
  }

  @Override
  public GeneralDBSqlRegexBuilder createSqlRegexBuilder(GeneralDBSqlExprBuilder where) {
    return new MonetDBSqlRegexBuilder((MonetDBSqlExprBuilder) where, this);
  }

  @Override
  public GeneralDBSqlBracketBuilder createSqlBracketBuilder(GeneralDBSqlExprBuilder where) {
    return new MonetDBSqlBracketBuilder(where, this);
  }

  @Override
  public GeneralDBSqlCastBuilder createSqlCastBuilder(GeneralDBSqlExprBuilder where, int type) {
    return new MonetDBSqlCastBuilder(where, this, type);
  }
}
