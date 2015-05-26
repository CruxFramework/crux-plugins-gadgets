/*
 * Copyright 2011 cruxframework.org.
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
package org.cruxframework.crux.plugin.gadget.client.features.impl;

import org.cruxframework.crux.plugin.gadget.client.features.Pubsub2Feature;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Samuel Almeida Cardoso
 *
 */
public class Pubsub2FeatureImpl implements Pubsub2Feature
{
	@Override
	public native void connect(final ConnectCallback callback)/*-{
	 	if($wnd.gadgets.Hub && $wnd.gadgets.Hub.isConnected())
	 	{
	 		callback.@org.cruxframework.crux.plugin.gadget.client.features.Pubsub2Feature.ConnectCallback::onConnected()();
	 	} else
	 	{
		 	$wnd.gadgets.HubSettings.onConnected = function( hub, suc, err ) {
				if(suc)
				{
					callback.@org.cruxframework.crux.plugin.gadget.client.features.Pubsub2Feature.ConnectCallback::onConnected()();
				} else
				{
					console.log(err);
					alert('ERROR! pubsub2 resource not loaded: ' + err)
				}
		 	};
	 	
			try {
				$wnd.gadgets.Hub.connect( $wnd.gadgets.HubSettings.onConnected );
			} catch(e) {
				console.log(e);
				alert('ERROR! pubsub2 resource not loaded: ' + e)
			}
		}
	}-*/;
	
	@Override
	public native <T extends JavaScriptObject> void publish(String channelName, T message)/*-{
	    $wnd.gadgets.Hub.publish(channelName, message);
    }-*/;
	
	@Override
	public native void subscribe(String channelName, Callback<?, ?> callback)/*-{
		$wnd.gadgets.Hub.subscribe(channelName, 
			function(topic, data, subscriberData) { 
				callback.@org.cruxframework.crux.plugin.gadget.client.features.Pubsub2Feature.Callback::onMessage(Ljava/lang/String; Lcom/google/gwt/core/client/JavaScriptObject; Ljava/lang/Object;)(topic, data, subscriberData); 
			} );
    }-*/;

	@Override
	public native void unsubscribe(String channelName)/*-{
	    $wnd.gadgets.Hub.unsubscribe(channelName);
    }-*/;
	
	@Override
	public native boolean isConnected()/*-{
		return $wnd.gadgets.Hub.isConnected();
	}-*/;
}
