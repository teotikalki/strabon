/**
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 * Copyright (C) 2010, 2011, 2012, Pyravlos Team
 * 
 * http://www.strabon.di.uoa.gr/
 */
package org.openrdf.query.resultio.text;

import java.io.IOException;
import java.io.OutputStream;

import org.openrdf.model.Value;
import org.openrdf.model.impl.LiteralImpl;
import org.openrdf.model.impl.URIImpl;
import org.openrdf.query.algebra.evaluation.function.spatial.StrabonInstant;
import org.openrdf.query.algebra.evaluation.function.spatial.StrabonPeriod;
import org.openrdf.query.algebra.evaluation.function.spatial.StrabonTemporalElement;
import eu.earthobservatory.constants.TemporalConstants;
import org.openrdf.query.resultio.text.tsv.SPARQLResultsTSVWriter;
import org.openrdf.sail.generaldb.model.GeneralDBPolyhedron;

/**
 * @author Charalampos Nikolaou <charnik@di.uoa.gr>
 * @author Konstantina Bereta <Konstantina.Bereta@di.uoa.gr> (extensions for the temporal case)
 * 
 */
public class stSPARQLResultsTSVWriter extends SPARQLResultsTSVWriter {

	public stSPARQLResultsTSVWriter(OutputStream out) {
		super(out);
	}

	@Override
	protected void writeValue(Value val) throws IOException {
		if (val.stringValue()== null)
			return;
		if (val instanceof GeneralDBPolyhedron) {
			// catch the spatial case and create a new literal
			// constructing a new literal is the only way if we want to reuse the {@link #writeValue(Value)} method
			GeneralDBPolyhedron dbpolyhedron = (GeneralDBPolyhedron) val;
			val = new LiteralImpl(dbpolyhedron.getPolyhedronStringRep()+";http://www.opengis.net/def/crs/EPSG/0/"+dbpolyhedron.getPolyhedron().getGeometry().getSRID(), dbpolyhedron.getDatatype());
		}
		else if(val instanceof StrabonTemporalElement){
			//creating a temporal literal, which is either a period or an instant
			
			val = new LiteralImpl(((StrabonTemporalElement)val).stringValue(), ((StrabonTemporalElement) val).getDatatype());
		}
		
		// write value		
		super.writeValue(val);
		
	}
}
