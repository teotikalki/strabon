/**
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of
 * the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 * Copyright (C) 2010, 2011, 2012, 2013 Pyravlos Team
 * 
 * http://www.strabon.di.uoa.gr/
 */
package org.openrdf.sail.monetdb;

import org.openrdf.sail.generaldb.GeneralDBProvider;

/**
 * Checks the database product name and version to be compatible with this Sesame store.
 */
public class MonetDBProvider extends GeneralDBProvider {

  public MonetDBConnectionFactory createRdbmsConnectionFactory(String dbName, String dbVersion) {
    if ("MonetDB".equalsIgnoreCase(dbName))
      return new MonetDBConnectionFactory();
    return null;
  }

}
