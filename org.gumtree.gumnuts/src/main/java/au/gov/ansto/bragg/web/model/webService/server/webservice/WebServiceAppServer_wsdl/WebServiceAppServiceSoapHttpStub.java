/**
 * WebServiceAppServiceSoapHttpStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl;

public class WebServiceAppServiceSoapHttpStub extends org.apache.axis.client.Stub implements au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.WebServiceAppService_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[15];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getBookingDetails");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getBookingDetailsElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getBookingDetailsElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBookingDetailsElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getBookingDetailsResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.types.BookingInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getBookingDetailsResponseElement"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "result"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getBraggInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getBraggInfoElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getBraggInfoElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getBraggInfoResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getBraggInfoResponseElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCoInvestigators");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getCoInvestigatorsElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getCoInvestigatorsElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetCoInvestigatorsElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getCoInvestigatorsResponseElement"));
        oper.setReturnClass(int[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getCoInvestigatorsResponseElement"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "result"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPrincipalInvestigatorID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getPrincipalInvestigatorIDElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getPrincipalInvestigatorIDElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getPrincipalInvestigatorIDResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getPrincipalInvestigatorIDResponseElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProposalId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getProposalIdElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalIdElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalIdResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getProposalIdResponseElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProposalReferences");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getProposalReferencesElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalReferencesElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalReferencesResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getProposalReferencesResponseElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProposalRound");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getProposalRoundElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalRoundElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalRoundResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getProposalRoundResponseElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProposalTags");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getProposalTagsElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalTagsElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTagsElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalTagsResponseElement"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getProposalTagsResponseElement"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "result"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProposalText");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getProposalTextElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalTextElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalTextResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getProposalTextResponseElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProposalTitle");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getProposalTitleElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalTitleElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalTitleResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getProposalTitleResponseElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReactorDisplay");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getReactorDisplayElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getReactorDisplayElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getReactorDisplayResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getReactorDisplayResponseElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReactorPower");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getReactorPowerElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getReactorPowerElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getReactorPowerResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getReactorPowerResponseElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReactorSimpleDisplay");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getReactorSimpleDisplayElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getReactorSimpleDisplayElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getReactorSimpleDisplayResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getReactorSimpleDisplayResponseElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getScientificArea");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getScientificAreaElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getScientificAreaElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getScientificAreaResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "getScientificAreaResponseElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("validateProposal");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "validateProposalElement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">validateProposalElement"), au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalElement.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">validateProposalResponseElement"));
        oper.setReturnClass(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalResponseElement.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "validateProposalResponseElement"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

    }

    public WebServiceAppServiceSoapHttpStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public WebServiceAppServiceSoapHttpStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public WebServiceAppServiceSoapHttpStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getBookingDetailsElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBookingDetailsElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getBookingDetailsResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.types.BookingInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "BookingInfo");
            qName2 = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "result");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getBraggInfoElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getBraggInfoResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getCoInvestigatorsElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetCoInvestigatorsElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getCoInvestigatorsResponseElement");
            cachedSerQNames.add(qName);
            cls = int[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int");
            qName2 = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "result");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getPrincipalInvestigatorIDElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getPrincipalInvestigatorIDResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalIdElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalIdResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalReferencesElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalReferencesResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalRoundElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalRoundResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalTagsElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTagsElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalTagsResponseElement");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "result");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalTextElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalTextResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalTitleElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalTitleResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getReactorDisplayElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getReactorDisplayResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getReactorPowerElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getReactorPowerResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getReactorSimpleDisplayElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getReactorSimpleDisplayResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getScientificAreaElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getScientificAreaResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">validateProposalElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">validateProposalResponseElement");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalResponseElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "AllDisplayInfo");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.types.AllDisplayInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "BookingInfo");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.types.BookingInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "ExperimentDisplay");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.types.ExperimentDisplay.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "ReactorDisplayInfo");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.types.ReactorDisplayInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "SeminarInfo");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.types.SeminarInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "ValueAtTime");
            cachedSerQNames.add(qName);
            cls = au.gov.ansto.bragg.web.model.webService.server.webservice.types.ValueAtTime.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.types.BookingInfo[] getBookingDetails(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBookingDetailsElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getBookingDetails");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getBookingDetails"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.types.BookingInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.types.BookingInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.types.BookingInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoResponseElement getBraggInfo(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getBraggInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getBraggInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetBraggInfoResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public int[] getCoInvestigators(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetCoInvestigatorsElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getCoInvestigators");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getCoInvestigators"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (int[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (int[]) org.apache.axis.utils.JavaUtils.convert(_resp, int[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDResponseElement getPrincipalInvestigatorID(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getPrincipalInvestigatorID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getPrincipalInvestigatorID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetPrincipalInvestigatorIDResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdResponseElement getProposalId(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getProposalId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getProposalId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalIdResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesResponseElement getProposalReferences(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getProposalReferences");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getProposalReferences"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalReferencesResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundResponseElement getProposalRound(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getProposalRound");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getProposalRound"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalRoundResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] getProposalTags(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTagsElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getProposalTags");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getProposalTags"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextResponseElement getProposalText(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getProposalText");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getProposalText"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTextResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleResponseElement getProposalTitle(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getProposalTitle");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getProposalTitle"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetProposalTitleResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayResponseElement getReactorDisplay(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getReactorDisplay");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getReactorDisplay"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorDisplayResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerResponseElement getReactorPower(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getReactorPower");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getReactorPower"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorPowerResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayResponseElement getReactorSimpleDisplay(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getReactorSimpleDisplay");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getReactorSimpleDisplay"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetReactorSimpleDisplayResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaResponseElement getScientificArea(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/getScientificArea");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getScientificArea"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.GetScientificAreaResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalResponseElement validateProposal(au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalElement parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl/validateProposal");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "validateProposal"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalResponseElement) _resp;
            } catch (java.lang.Exception _exception) {
                return (au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalResponseElement) org.apache.axis.utils.JavaUtils.convert(_resp, au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl.ValidateProposalResponseElement.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
