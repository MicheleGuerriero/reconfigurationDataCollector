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
package it.polimi.seaclouds.config;

import it.polimi.seaclouds.exception.ConfigurationException;


public class EnvironmentReader {
      

            private static EnvironmentReader _instance = null;
            private String mmIP;
            private int mmPort;
            private int dcSyncPeriod = 30;
            private int resourcesKeepAlivePeriod = 60;
            private String cloudProviderId;
            private String cloudProviderType;
            private String paasServiceId;
            private String paasServiceType;
            private String vmId;
            private String vmType;
            private String locationId;
            private String locationtype;
            private String internalComponentId;
            private String internalComponentType;

            public static EnvironmentReader getInstance() throws ConfigurationException {
                  if (_instance == null)
                        _instance = new EnvironmentReader();
                  return _instance;
            }

            private EnvironmentReader() throws ConfigurationException {
                  try {
                        mmIP = getMandatoryEnvVar(Environment.MODACLOUDS_TOWER4CLOUDS_MANAGER_IP);
                        String mmPortString = getMandatoryEnvVar(Environment.MODACLOUDS_TOWER4CLOUDS_MANAGER_PORT);
                        mmPort = Integer.parseInt(mmPortString);

                        String dcSyncPeriodString = getOptionalEnvVar(
                                    Environment.MODACLOUDS_TOWER4CLOUDS_DC_SYNC_PERIOD,
                                    Integer.toString(dcSyncPeriod));
                        dcSyncPeriod = Integer.parseInt(dcSyncPeriodString);
                        
                        String resourcesKeepAlivePeriodString = getOptionalEnvVar(
                                    Environment.MODACLOUDS_TOWER4CLOUDS_RESOURCES_KEEP_ALIVE_PERIOD,
                                    Integer.toString(resourcesKeepAlivePeriod));
                        resourcesKeepAlivePeriod = Integer.parseInt(resourcesKeepAlivePeriodString);
                        
                        cloudProviderId = getOptionalEnvVar(
                                    Environment.MODACLOUDS_TOWER4CLOUDS_CLOUD_PROVIDER_ID);
                        cloudProviderType = getOptionalEnvVar(Environment.MODACLOUDS_TOWER4CLOUDS_CLOUD_PROVIDER_TYPE);
                        paasServiceId = getOptionalEnvVar(Environment.MODACLOUDS_TOWER4CLOUDS_PAAS_SERVICE_ID);
                        paasServiceType = getOptionalEnvVar(Environment.MODACLOUDS_TOWER4CLOUDS_PAAS_SERVICE_TYPE);
                        vmId = getOptionalEnvVar(Environment.MODACLOUDS_TOWER4CLOUDS_VM_ID);
                        vmType = getOptionalEnvVar(Environment.MODACLOUDS_TOWER4CLOUDS_VM_TYPE);
                        locationId = getOptionalEnvVar(Environment.MODACLOUDS_TOWER4CLOUDS_LOCATION_ID);
                        locationtype = getOptionalEnvVar(Environment.MODACLOUDS_TOWER4CLOUDS_LOCATION_TYPE);
                        internalComponentId = getOptionalEnvVar(Environment.MODACLOUDS_TOWER4CLOUDS_INTERNAL_COMPONENT_ID);
                        internalComponentType = getOptionalEnvVar(Environment.MODACLOUDS_TOWER4CLOUDS_INTERNAL_COMPONENT_TYPE);
                        

                  } catch (Exception e) {
                        throw new ConfigurationException(
                                    "Could not configure properly the data collector");
                  }
            }

            private String getMandatoryEnvVar(String varName)
                        throws ConfigurationException {
                  String var = System.getenv(varName);
                  if (var == null)
                        throw new ConfigurationException(varName
                                    + " variable was not defined");
                  return var;
            }

            private String getOptionalEnvVar(String varName, String defaultValue) {
                  String var = getOptionalEnvVar(varName);
                  if (var == null) {
                        var = defaultValue;
                  }
                  return var;
            }

            private String getOptionalEnvVar(String varName) {
                  return System.getenv(varName);
            }
            
            public String getCloudProviderId() {
                  return cloudProviderId;
            }
            
            public String getCloudProviderType() {
                  return cloudProviderType;
            }
            
            public String getInternalComponentId() {
                  return internalComponentId;
            }
            
            public int getDcSyncPeriod() {
                  return dcSyncPeriod;
            }
            
            public String getInternalComponentType() {
                  return internalComponentType;
            }
            
            public String getLocationId() {
                  return locationId;
            }
            
            public String getLocationtype() {
                  return locationtype;
            }
            
            public String getMmIP() {
                  return mmIP;
            }
            
            public int getMmPort() {
                  return mmPort;
            }
            
            public String getPaasServiceId() {
                  return paasServiceId;
            }
            
            public String getPaasServiceType() {
                  return paasServiceType;
            }
            
            public int getResourcesKeepAlivePeriod() {
                  return resourcesKeepAlivePeriod;
            }
            
            public String getVmId() {
                  return vmId;
            }
            
            public String getVmType() {
                  return vmType;
            }

}
