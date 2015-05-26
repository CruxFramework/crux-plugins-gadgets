/*
 * Copyright 2013 cruxframework.org.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.cruxframework.crux.plugin.gadget.rebind.rest;

import org.cruxframework.crux.core.rebind.rest.CruxRestProxyCreatorFromServerMetadata;
import org.cruxframework.crux.core.rebind.rest.RestMethodInfo;

import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.gadgets.client.gwtrpc.GadgetsRequestBuilder;

/**
 * This class creates a client proxy for calling rest services
 * 
 * @author Samuel Almeida Cardoso (samuel@cruxframework.org) 
 * 
 */
public class CruxGadgetRestProxyCreator extends CruxRestProxyCreatorFromServerMetadata
{
	public CruxGadgetRestProxyCreator(TreeLogger logger, GeneratorContext context, JClassType baseIntf)
	{
		super(logger, context, baseIntf);
	}

	protected String getRequestBuilderInitialization(RestMethodInfo methodInfo, String restURIParam)
	{
		return "new "+GadgetsRequestBuilder.class.getCanonicalName()+"(RequestBuilder."+methodInfo.httpMethod+", "+restURIParam+")";
	}
}