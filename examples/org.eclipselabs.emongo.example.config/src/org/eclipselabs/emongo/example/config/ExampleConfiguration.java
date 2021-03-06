/*******************************************************************************
 * Copyright (c) 2013 Bryan Hunt.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bryan Hunt - initial API and implementation
 *******************************************************************************/

package org.eclipselabs.emongo.example.config;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipselabs.emongo.MongoClientProvider;
import org.eclipselabs.emongo.MongoDatabaseProvider;
import org.eclipselabs.emongo.config.ConfigurationProperties;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

/**
 * @author bhunt
 * 
 */
public class ExampleConfiguration
{
	public void bindConfigurationAdmin(ConfigurationAdmin configurationAdmin)
	{
		try
		{
			Configuration config = configurationAdmin.getConfiguration(ConfigurationProperties.CLIENT_PID, null);

			Dictionary<String, Object> properties = config.getProperties();

			if (properties == null)
				properties = new Hashtable<String, Object>();

			properties.put(MongoClientProvider.PROP_CLIENT_ID, "example");
			properties.put(MongoClientProvider.PROP_URI, "mongodb://localhost");
			config.update(properties);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			Configuration config = configurationAdmin.getConfiguration(ConfigurationProperties.DATABASE_PID, null);

			Dictionary<String, Object> properties = config.getProperties();

			if (properties == null)
				properties = new Hashtable<String, Object>();

			properties.put(MongoDatabaseProvider.PROP_DATABASE, "example");
			properties.put(MongoDatabaseProvider.PROP_ALIAS, "example");
			config.update(properties);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
