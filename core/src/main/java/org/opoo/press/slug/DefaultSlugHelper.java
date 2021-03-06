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
package org.opoo.press.slug;

import org.opoo.press.SlugHelper;

/**
 * @author Alex Lin
 *
 */
public class DefaultSlugHelper implements SlugHelper {

	/* (non-Javadoc)
	 * @see org.opoo.press.SlugHelper#transform(java.lang.String)
	 */
	@Override
	public String toSlug(String text) {
		if(text == null || text.length() == 0){
			return null;
		}
		text = text.toLowerCase();
		text = text.replace(' ', '-');
		char[] chars = text.toLowerCase().toCharArray();
		StringBuffer sb = new StringBuffer();
		for(char c: chars){
			toSlug(sb, c);
		}
		if(sb.length() == 0){
			throw new UnsupportedOperationException("Cannot process text '"
					+ text + "' to slug, try configure another SlugHelper instead.");
		}
		trimDot(sb);
		return sb.toString();
	}

	protected void toSlug(StringBuffer result, char c) {
		if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '/' || c == '.'){
			result.append(c);
		}
	}
	
	public static void trimDot(StringBuffer sb){
		while(sb.charAt(0) == '.'){
			sb.deleteCharAt(0);
		}
		while(sb.charAt(sb.length() - 1) == '.'){
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
