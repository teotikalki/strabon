/*
 * Copyright Aduna (http://www.aduna-software.com/) (c) 2008.
 * 
 * Licensed under the Aduna BSD-style license.
 */
package org.openrdf.sail.generaldb.algebra;

import org.openrdf.sail.generaldb.algebra.base.GeneralDBQueryModelVisitorBase;
import org.openrdf.sail.generaldb.algebra.base.GeneralDBSqlExpr;

/**
 * 
 * @see {@link org.openrdf.query.algebra.evaluation.function.spatial.stsparql.property.SridFunc}
 */
public class GeneralDBSqlGeoSrid extends GeneralDBSqlAbstractGeoSrid {

  public GeneralDBSqlGeoSrid(GeneralDBSqlExpr expr) {
    super(expr);
  }

  @Override
  public <X extends Exception> void visit(GeneralDBQueryModelVisitorBase<X> visitor) throws X {
    visitor.meet(this);
  }
}
