/*
 * Copyright Aduna (http://www.aduna-software.com/) (c) 2008.
 * 
 * Licensed under the Aduna BSD-style license.
 */
package org.openrdf.sail.generaldb.iteration;

import org.openrdf.sail.SailException;

import java.sql.SQLException;

/**
 * Empty iteration that extends {@link GeneralDBStatementIteration}.
 */
public class EmptyGeneralDBStatementIteration extends GeneralDBStatementIteration {

  public EmptyGeneralDBStatementIteration() throws SQLException {
    super(null, null, null);
  }

  @Override
  public void close() throws SailException {}

  @Override
  public boolean hasNext() throws SailException {
    return false;
  }

}
