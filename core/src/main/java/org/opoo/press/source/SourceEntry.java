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
package org.opoo.press.source;

import java.io.File;

import org.apache.commons.io.monitor.FileEntry;

/**
 * Source file entry.
 * 
 * @author Alex Lin
 *
 */
public class SourceEntry extends FileEntry {
	private static final long serialVersionUID = -3629623831263979006L;
	private final String path;
	/**
	 * @param file
	 */
	public SourceEntry(File file) {
		super(file);
		path = "";
		refresh(file);
	}

	/**
	 * @param parent
	 * @param file
	 */
	public SourceEntry(FileEntry parent, File file) {
		super(parent, file);
		path = getPath(this);
		refresh(file);
	}
	
	/**
	 * 
	 * @param entry
	 * @return
	 */
	private static String getPath(FileEntry entry){
		FileEntry parent = entry.getParent();
		if(parent != null){
			return getPath(parent) + "/" + parent.getName();
		}
		return "";
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	
	public String toString(){
		return getFile().toString();
	}
}
