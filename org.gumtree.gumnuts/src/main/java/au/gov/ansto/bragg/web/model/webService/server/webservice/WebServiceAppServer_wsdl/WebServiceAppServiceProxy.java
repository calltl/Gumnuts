package au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl;

public class WebServiceAppServiceProxy implements au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppService_PortType {
  private String _endpoint = null;
  private au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppService_PortType webServiceAppService_PortType = null;
  
  public WebServiceAppServiceProxy() {
    _initWebServiceAppServiceProxy();
  }
  
  public WebServiceAppServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebServiceAppServiceProxy();
  }
  
  private void _initWebServiceAppServiceProxy() {
    try {
      webServiceAppService_PortType = (new au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppService_ServiceLocator()).getWebServiceAppServiceSoapHttpPort();
      if (webServiceAppService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webServiceAppService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webServiceAppService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webServiceAppService_PortType != null)
      ((javax.xml.rpc.Stub)webServiceAppService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppService_PortType getWebServiceAppService_PortType() {
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType;
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.types.BookingInfo[] getBookingDetails(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBookingDetailsElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getBookingDetails(parameters);
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoResponseElement getBraggInfo(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getBraggInfo(parameters);
  }
  
  public int[] getCoInvestigators(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetCoInvestigatorsElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getCoInvestigators(parameters);
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDResponseElement getPrincipalInvestigatorID(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getPrincipalInvestigatorID(parameters);
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdResponseElement getProposalId(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getProposalId(parameters);
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesResponseElement getProposalReferences(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getProposalReferences(parameters);
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundResponseElement getProposalRound(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getProposalRound(parameters);
  }
  
  public java.lang.String[] getProposalTags(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTagsElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getProposalTags(parameters);
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextResponseElement getProposalText(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getProposalText(parameters);
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleResponseElement getProposalTitle(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getProposalTitle(parameters);
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayResponseElement getReactorDisplay(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getReactorDisplay(parameters);
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerResponseElement getReactorPower(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getReactorPower(parameters);
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayResponseElement getReactorSimpleDisplay(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getReactorSimpleDisplay(parameters);
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaResponseElement getScientificArea(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.getScientificArea(parameters);
  }
  
  public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalResponseElement validateProposal(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalElement parameters) throws java.rmi.RemoteException{
    if (webServiceAppService_PortType == null)
      _initWebServiceAppServiceProxy();
    return webServiceAppService_PortType.validateProposal(parameters);
  }
  
  
}