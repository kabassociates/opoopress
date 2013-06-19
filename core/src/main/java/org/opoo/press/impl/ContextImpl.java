/*
 * Copyright 2013 Alex Lin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opoo.press.impl;

import org.opoo.press.Application;
import org.opoo.press.Context;
import org.opoo.press.SiteManager;
import org.opoo.press.source.SourceEntryLoader;
import org.opoo.press.source.SourceParser;
import org.opoo.press.source.impl.SourceEntryLoaderImpl;
import org.opoo.press.source.impl.SourceParserImpl;
import org.yaml.snakeyaml.Yaml;

/**
 * @author Alex Lin
 *
 */
public class ContextImpl implements Context{
	private Yaml yaml;
	private SiteManagerImpl siteManager;
	private SourceEntryLoaderImpl sourceEntryLoader;
	private SourceParserImpl sourceParser;
	
	public void initialize() {
		if(!Application.isInitialized()){
			yaml = new Yaml();
		
			sourceEntryLoader = new SourceEntryLoaderImpl();
			
			sourceParser = new SourceParserImpl();
			sourceParser.setYaml(yaml);
			
			siteManager = new SiteManagerImpl();
			Application.setContext(this);
		}
	}

	/* (non-Javadoc)
	 * @see org.opoo.joctopress.Context#getSiteManager()
	 */
	@Override
	public SiteManager getSiteManager() {
		return siteManager;
	}

	/* (non-Javadoc)
	 * @see org.opoo.joctopress.Context#getSourceEntryLoader()
	 */
	@Override
	public SourceEntryLoader getSourceEntryLoader() {
		return sourceEntryLoader;
	}

	/* (non-Javadoc)
	 * @see org.opoo.joctopress.Context#getSourceParser()
	 */
	@Override
	public SourceParser getSourceParser() {
		return sourceParser;
	}

	@Override
	public Yaml getYaml() {
		return yaml;
	}
}
