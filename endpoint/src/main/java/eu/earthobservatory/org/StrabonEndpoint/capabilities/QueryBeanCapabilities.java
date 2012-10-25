/**
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 * Copyright (C) 2012, Pyravlos Team
 * 
 * http://www.strabon.di.uoa.gr/
 */
package eu.earthobservatory.org.StrabonEndpoint.capabilities;

import java.util.List;


/**
 * 
 * @author Charalampos Nikolaou <charnik@di.uoa.gr>
 */
public class QueryBeanCapabilities implements RequestCapabilities {

	private static QueryBeanCapabilities caps;
	
	protected QueryBeanCapabilities() {
		
	}
	
	public static synchronized QueryBeanCapabilities getInstance() {
		if (caps == null) {
			caps = new QueryBeanCapabilities();
		}
		
		return caps;
	}
	
	@Override
	public List<String> getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAcceptedValues(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOptional(String param) {
		// TODO Auto-generated method stub
		return false;
	}

}
