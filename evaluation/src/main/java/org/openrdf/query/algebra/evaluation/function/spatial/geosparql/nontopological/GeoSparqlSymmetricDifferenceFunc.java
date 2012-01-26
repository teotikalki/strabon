package org.openrdf.query.algebra.evaluation.function.spatial.geosparql.nontopological;

import org.openrdf.query.algebra.evaluation.function.spatial.StrabonPolyhedron;
import org.openrdf.query.algebra.evaluation.function.spatial.geosparql.GeoSparqlNonTopologicalConstruct;

public class GeoSparqlSymmetricDifferenceFunc extends GeoSparqlNonTopologicalConstruct {

	@Override
	public String getURI() {
		return StrabonPolyhedron.geoSparqlSymmetricDifference;
		}
}
