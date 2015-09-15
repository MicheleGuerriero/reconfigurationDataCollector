/**
 * Copyright 2015 SeaCloudsEU
 * Contact: Michele Guerriero <michele.guerriero@mail.polimi.it>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package it.polimi.seaclouds.dataCollector;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import brooklyn.entity.Application;
import brooklyn.rest.api.EntityApi;
import brooklyn.rest.api.LocationApi;
import brooklyn.rest.api.ScriptApi;
import brooklyn.rest.client.BrooklynApi;
import brooklyn.rest.domain.ApplicationSpec;
import brooklyn.rest.domain.ApplicationSummary;
import brooklyn.rest.domain.EntitySpec;
import brooklyn.rest.domain.EntitySummary;
import brooklyn.rest.domain.LocationSummary;
import it.polimi.seaclouds.config.EnvironmentReader;
import it.polimi.seaclouds.exception.ConfigurationException;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	
          DeployerDC dc=new DeployerDC();

          try {
                EnvironmentReader config = EnvironmentReader.getInstance();

                  dc.startMonitor(config);
            } catch (ConfigurationException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }

    }

  
            
    
}
