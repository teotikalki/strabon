/*
 * Copyright Aduna (http://www.aduna-software.com/) (c) 2008.
 *
 * Licensed under the Aduna BSD-style license.
 */
package org.openrdf.sail.monetdb;

import java.sql.SQLException;

import org.openrdf.sail.generaldb.GeneralDBTripleRepository;
import org.openrdf.sail.rdbms.exceptions.RdbmsException;
import org.openrdf.sail.rdbms.managers.TransTableManager;
import org.openrdf.sail.rdbms.model.RdbmsResource;
import org.openrdf.sail.rdbms.model.RdbmsURI;
import org.openrdf.sail.rdbms.model.RdbmsValue;
import org.openrdf.sail.rdbms.schema.BNodeTable;
import org.openrdf.sail.rdbms.schema.LiteralTable;
import org.openrdf.sail.rdbms.schema.URITable;

/**
 * Facade to {@link GeneralDBTransTableManager}, {@link URITable}, {@link BNodeTable} and
 * {@link LiteralTable} for adding, removing, and retrieving statements from the
 * database.
 * 
 * @author James Leigh
 */
public class MonetDBTripleRepository extends GeneralDBTripleRepository {
	
	@Override
	protected String buildDeleteQuery(String tableName, RdbmsResource subj, RdbmsURI pred, RdbmsValue obj,
			RdbmsResource... ctxs)
		throws RdbmsException, SQLException
	{
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ").append(tableName);
		return buildWhere(sb, subj, pred, obj, ctxs);
	}
	
	@Override
	protected String buildWhere(StringBuilder sb, RdbmsResource subj, RdbmsURI pred, RdbmsValue obj,
			RdbmsResource... ctxs)
	{
		sb.append("\nWHERE ");
		if (ctxs != null && ctxs.length > 0) {
			sb.append(" (");
			for (int i = 0; i < ctxs.length; i++) {
				sb.append("ctx = ?");
				if (i < ctxs.length - 1) {
					sb.append(" OR ");
				}
			}
			sb.append(") AND ");
		}
		if (subj != null) {
			sb.append("subj = ? ");
			sb.append(" AND ");
		}
		if (pred != null) {
			sb.append("pred = ? ");
			sb.append(" AND ");
		}
		if (obj != null) {
			sb.append("obj = ?");
			sb.append(" AND ");
		}
		sb.append(" 1=1 ");
		return sb.toString();
	}
	
//	private String buildWhere(String tableName, StringBuilder sb, RdbmsResource subj, RdbmsURI pred, RdbmsValue obj,
//			RdbmsResource... ctxs)
//	{
//		sb.append("\nWHERE (1=1)");
//		if (ctxs != null && ctxs.length > 0) {
//			sb.append(" AND (");
//			for (int i = 0; i < ctxs.length; i++) {
//				sb.append(tableName);
//				sb.append(".ctx = ?");
//				if (i < ctxs.length - 1) {
//					sb.append(" OR ");
//				}
//			}
//			sb.append(")");
//		}
//		if (subj != null) {
//			sb.append(" AND ");
//			sb.append(tableName);
//			sb.append(".subj = ? ");
//		}
//		if (pred != null) {
//			sb.append(" AND ");
//			sb.append(tableName);
//			sb.append(".pred = ? ");
//		}
//		if (obj != null) {
//			sb.append(" AND ");
//			sb.append(tableName);
//			sb.append(".obj = ?");
//		}
//		return sb.toString();
//	}
}
