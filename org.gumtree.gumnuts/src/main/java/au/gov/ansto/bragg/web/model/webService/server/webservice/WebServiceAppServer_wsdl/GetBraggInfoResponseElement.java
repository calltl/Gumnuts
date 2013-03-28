/**
 * GetBraggInfoResponseElement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package au.gov.ansto.bragg.web.model.webService.server.webservice.WebServiceAppServer_wsdl;

public class GetBraggInfoResponseElement  implements java.io.Serializable {
    private au.gov.ansto.bragg.web.model.webService.server.webservice.types.AllDisplayInfo result;

    public GetBraggInfoResponseElement() {
    }

    public GetBraggInfoResponseElement(
           au.gov.ansto.bragg.web.model.webService.server.webservice.types.AllDisplayInfo result) {
           this.result = result;
    }


    /**
     * Gets the result value for this GetBraggInfoResponseElement.
     * 
     * @return result
     */
    public au.gov.ansto.bragg.web.model.webService.server.webservice.types.AllDisplayInfo getResult() {
        return result;
    }


    /**
     * Sets the result value for this GetBraggInfoResponseElement.
     * 
     * @param result
     */
    public void setResult(au.gov.ansto.bragg.web.model.webService.server.webservice.types.AllDisplayInfo result) {
        this.result = result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetBraggInfoResponseElement)) return false;
        GetBraggInfoResponseElement other = (GetBraggInfoResponseElement) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.result==null && other.getResult()==null) || 
             (this.result!=null &&
              this.result.equals(other.getResult())));
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
        if (getResult() != null) {
            _hashCode += getResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetBraggInfoResponseElement.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", ">getBraggInfoResponseElement"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://au/gov/ansto/bragg/web/model/webService/server/webservice/WebServiceAppServer.wsdl", "result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "AllDisplayInfo"));
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
