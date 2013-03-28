/**
 * WebServiceAppService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl;

public interface WebServiceAppService_PortType extends java.rmi.Remote {
    public au.gov.ansto.bragg.web.model.webService.server.webservice.types.BookingInfo[] getBookingDetails(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBookingDetailsElement parameters) throws java.rmi.RemoteException;
    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoResponseElement getBraggInfo(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoElement parameters) throws java.rmi.RemoteException;
    public int[] getCoInvestigators(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetCoInvestigatorsElement parameters) throws java.rmi.RemoteException;
    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDResponseElement getPrincipalInvestigatorID(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDElement parameters) throws java.rmi.RemoteException;
    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdResponseElement getProposalId(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdElement parameters) throws java.rmi.RemoteException;
    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesResponseElement getProposalReferences(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesElement parameters) throws java.rmi.RemoteException;
    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundResponseElement getProposalRound(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundElement parameters) throws java.rmi.RemoteException;
    public java.lang.String[] getProposalTags(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTagsElement parameters) throws java.rmi.RemoteException;
    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextResponseElement getProposalText(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextElement parameters) throws java.rmi.RemoteException;
    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleResponseElement getProposalTitle(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleElement parameters) throws java.rmi.RemoteException;
    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayResponseElement getReactorDisplay(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayElement parameters) throws java.rmi.RemoteException;
    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerResponseElement getReactorPower(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerElement parameters) throws java.rmi.RemoteException;
    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayResponseElement getReactorSimpleDisplay(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayElement parameters) throws java.rmi.RemoteException;
    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaResponseElement getScientificArea(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaElement parameters) throws java.rmi.RemoteException;
    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalResponseElement validateProposal(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalElement parameters) throws java.rmi.RemoteException;
}
