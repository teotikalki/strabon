/**
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of
 * the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 * Copyright (C) 2010, 2011, 2012, 2013 Pyravlos Team
 * 
 * http://www.strabon.di.uoa.gr/
 */
package org.openrdf.sail.generaldb.algebra;


import org.openrdf.sail.generaldb.algebra.base.GeneralDBSqlExpr;

public class GeneralDBSqlAbove extends GeneralDBSqlGeoSpatial {

  public GeneralDBSqlAbove(GeneralDBSqlExpr left, GeneralDBSqlExpr right) {
    super(left, right);
  }

}
