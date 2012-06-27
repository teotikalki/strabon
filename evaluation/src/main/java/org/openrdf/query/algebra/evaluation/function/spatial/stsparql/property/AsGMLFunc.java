/**
 * 
 */
package org.openrdf.query.algebra.evaluation.function.spatial.stsparql.property;

import org.openrdf.query.algebra.evaluation.function.spatial.SpatialPropertyFunc;
import org.openrdf.query.algebra.evaluation.function.spatial.StrabonPolyhedron;

/**
 * A spatial function returning a geometry in GML encoding.
 * 
 * @author Charalampos Nikolaou <charnik@di.uoa.gr>
 */
public class AsGMLFunc extends SpatialPropertyFunc {

	@Override
	public String getURI() {
		return StrabonPolyhedron.asGML;
	}
}