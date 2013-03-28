/**
 * WebServiceAppService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl;

public class WebServiceAppService_ServiceLocator extends org.apache.axis.client.Service implements au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppService_Service {

    public WebServiceAppService_ServiceLocator() {
    }


    public WebServiceAppService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebServiceAppService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebServiceAppServiceSoapHttpPort
    private java.lang.String WebServiceAppServiceSoapHttpPort_address = "http://neutron.ansto.gov.au/WebServices/WebServiceAppServiceSoapHttpPort";

    public java.lang.String getWebServiceAppServiceSoapHttpPortAddress() {
        return WebServiceAppServiceSoapHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebServiceAppServiceSoapHttpPortWSDDServiceName = "WebServiceAppServiceSoapHttpPort";

    public java.lang.String getWebServiceAppServiceSoapHttpPortWSDDServiceName() {
        return WebServiceAppServiceSoapHttpPortWSDDServiceName;
    }

    public void setWebServiceAppServiceSoapHttpPortWSDDServiceName(java.lang.String name) {
        WebServiceAppServiceSoapHttpPortWSDDServiceName = name;
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppService_PortType getWebServiceAppServiceSoapHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebServiceAppServiceSoapHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebServiceAppServiceSoapHttpPort(endpoint);
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppService_PortType getWebServiceAppServiceSoapHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppServiceSoapHttpStub _stub = new au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppServiceSoapHttpStub(portAddress, this);
            _stub.setPortName(getWebServiceAppServiceSoapHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebServiceAppServiceSoapHttpPortEndpointAddress(java.lang.String address) {
        WebServiceAppServiceSoapHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppServiceSoapHttpStub _stub = new au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppServiceSoapHttpStub(new java.net.URL(WebServiceAppServiceSoapHttpPort_address), this);
                _stub.setPortName(getWebServiceAppServiceSoapHttpPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WebServiceAppServiceSoapHttpPort".equals(inputPortName)) {
            return getWebServiceAppServiceSoapHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "WebServiceAppService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "WebServiceAppServiceSoapHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebServiceAppServiceSoapHttpPort".equals(portName)) {
            setWebServiceAppServiceSoapHttpPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
