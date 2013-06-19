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
package org.opoo.press;

import freemarker.cache.TemplateLoader;
import freemarker.template.TemplateModel;


/**
 * @author Alex Lin
 *
 */
public interface Registry {
	
	Site getSite();
	
	void registerConverter(Converter c);
	
	void registerGenerator(Generator g);
	
	void registerSiteFilter(SiteFilter filter);
	
	void registerTemplateModel(String name, TemplateModel model);

//	void registerRenderFilter(RenderFilter filter);
	
	void registerTemplateLoader(TemplateLoader loader);
}
