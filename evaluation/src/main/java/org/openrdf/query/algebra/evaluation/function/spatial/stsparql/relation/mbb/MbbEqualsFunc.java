/*
 * Copyright Aduna (http://www.aduna-software.com/) (c) 2007.
 *
 * Licensed under the Aduna BSD-style license.
 */
package org.openrdf.query.algebra.evaluation.function.spatial.stsparql.relation.mbb;

import org.openrdf.query.algebra.evaluation.function.spatial.GeoConstants;
import org.openrdf.query.algebra.evaluation.function.spatial.SpatialRelationshipFunc;

/**
 * 
 * @author Manos Karpathiotakis <mk@di.uoa.gr>
 */
public class MbbEqualsFunc extends SpatialRelationshipFunc {

	@Override
	public String getURI() {
		return GeoConstants.mbbEquals;
		}

}