/**
 * GetProposalRoundElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl;

public class GetProposalRoundElement  implements java.io.Serializable {
    private java.lang.Integer proposalId;

    public GetProposalRoundElement() {
    }

    public GetProposalRoundElement(
           java.lang.Integer proposalId) {
           this.proposalId = proposalId;
    }


    /**
     * Gets the proposalId value for this GetProposalRoundElement.
     * 
     * @return proposalId
     */
    public java.lang.Integer getProposalId() {
        return proposalId;
    }


    /**
     * Sets the proposalId value for this GetProposalRoundElement.
     * 
     * @param proposalId
     */
    public void setProposalId(java.lang.Integer proposalId) {
        this.proposalId = proposalId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetProposalRoundElement)) return false;
        GetProposalRoundElement other = (GetProposalRoundElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.proposalId==null && other.getProposalId()==null) || 
             (this.proposalId!=null &&
              this.proposalId.equals(other.getProposalId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getProposalId() != null) {
            _hashCode += getProposalId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetProposalRoundElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getProposalRoundElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proposalId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "proposalId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
