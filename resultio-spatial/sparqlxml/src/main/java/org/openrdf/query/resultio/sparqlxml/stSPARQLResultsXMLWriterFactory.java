/**
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of
 * the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 * Copyright (C) 2010, 2011, 2012, Pyravlos Team
 * 
 * http://www.strabon.di.uoa.gr/
 */
package org.openrdf.query.resultio.sparqlxml;

import org.openrdf.query.resultio.TupleQueryResultFormat;
import org.openrdf.query.resultio.TupleQueryResultWriter;
import org.openrdf.query.resultio.TupleQueryResultWriterFactory;
import org.openrdf.query.resultio.stSPARQLQueryResultFormat;

import java.io.OutputStream;

public class stSPARQLResultsXMLWriterFactory implements TupleQueryResultWriterFactory {

  @Override
  public TupleQueryResultFormat getTupleQueryResultFormat() {
    return stSPARQLQueryResultFormat.XML;
  }

  @Override
  public TupleQueryResultWriter getWriter(OutputStream out) {
    return new stSPARQLResultsXMLWriter(out);
  }

}
