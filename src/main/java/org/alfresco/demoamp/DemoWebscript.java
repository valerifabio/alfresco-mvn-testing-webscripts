/*
    Licensed to the Apache Software Foundation (ASF) under one or more
	contributor license agreements.  See the NOTICE file distributed with
	this work for additional information regarding copyright ownership.
	The ASF licenses this file to You under the Apache License, Version 2.0
	(the "License"); you may not use this file except in compliance with
	the License.  You may obtain a copy of the License at
	
	http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */
package org.alfresco.demoamp;

import org.springframework.extensions.webscripts.DeclarativeWebScript;
import org.springframework.extensions.webscripts.Cache;
import org.springframework.extensions.webscripts.Status;
import org.springframework.extensions.webscripts.WebScriptRequest;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * A basic java backend webscript for demo purposes
 * 
 * @author Fabio Valeri
 */
public class DemoWebscript extends DeclarativeWebScript
{
  
  Log log = LogFactory.getLog(DemoWebscript.class);

  @Override
  protected Map<String, Object> executeImpl(WebScriptRequest req, Status status, Cache cache)
  {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("message", req.getParameter("message"));
    return model;
  }
}
