/**
 * ReactorDisplayInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package au.gov.ansto.bragg.web.model.webService.server.webservice.types;

public class ReactorDisplayInfo  implements java.io.Serializable {
    private java.util.Calendar timeStamp;

    private float cnsOutTemp;

    private java.lang.String tg123Status;

    private java.lang.String hg2Status;

    private java.lang.String errorMsg;

    private java.lang.String tg4Status;

    private float reactorPower;

    private float cnsInTemp;

    private float cnsTemp;

    private java.lang.String cg4Status;

    private java.lang.String cg123Status;

    public ReactorDisplayInfo() {
    }

    public ReactorDisplayInfo(
           java.util.Calendar timeStamp,
           float cnsOutTemp,
           java.lang.String tg123Status,
           java.lang.String hg2Status,
           java.lang.String errorMsg,
           java.lang.String tg4Status,
           float reactorPower,
           float cnsInTemp,
           float cnsTemp,
           java.lang.String cg4Status,
           java.lang.String cg123Status) {
           this.timeStamp = timeStamp;
           this.cnsOutTemp = cnsOutTemp;
           this.tg123Status = tg123Status;
           this.hg2Status = hg2Status;
           this.errorMsg = errorMsg;
           this.tg4Status = tg4Status;
           this.reactorPower = reactorPower;
           this.cnsInTemp = cnsInTemp;
           this.cnsTemp = cnsTemp;
           this.cg4Status = cg4Status;
           this.cg123Status = cg123Status;
    }


    /**
     * Gets the timeStamp value for this ReactorDisplayInfo.
     * 
     * @return timeStamp
     */
    public java.util.Calendar getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this ReactorDisplayInfo.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(java.util.Calendar timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the cnsOutTemp value for this ReactorDisplayInfo.
     * 
     * @return cnsOutTemp
     */
    public float getCnsOutTemp() {
        return cnsOutTemp;
    }


    /**
     * Sets the cnsOutTemp value for this ReactorDisplayInfo.
     * 
     * @param cnsOutTemp
     */
    public void setCnsOutTemp(float cnsOutTemp) {
        this.cnsOutTemp = cnsOutTemp;
    }


    /**
     * Gets the tg123Status value for this ReactorDisplayInfo.
     * 
     * @return tg123Status
     */
    public java.lang.String getTg123Status() {
        return tg123Status;
    }


    /**
     * Sets the tg123Status value for this ReactorDisplayInfo.
     * 
     * @param tg123Status
     */
    public void setTg123Status(java.lang.String tg123Status) {
        this.tg123Status = tg123Status;
    }


    /**
     * Gets the hg2Status value for this ReactorDisplayInfo.
     * 
     * @return hg2Status
     */
    public java.lang.String getHg2Status() {
        return hg2Status;
    }


    /**
     * Sets the hg2Status value for this ReactorDisplayInfo.
     * 
     * @param hg2Status
     */
    public void setHg2Status(java.lang.String hg2Status) {
        this.hg2Status = hg2Status;
    }


    /**
     * Gets the errorMsg value for this ReactorDisplayInfo.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this ReactorDisplayInfo.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }


    /**
     * Gets the tg4Status value for this ReactorDisplayInfo.
     * 
     * @return tg4Status
     */
    public java.lang.String getTg4Status() {
        return tg4Status;
    }


    /**
     * Sets the tg4Status value for this ReactorDisplayInfo.
     * 
     * @param tg4Status
     */
    public void setTg4Status(java.lang.String tg4Status) {
        this.tg4Status = tg4Status;
    }


    /**
     * Gets the reactorPower value for this ReactorDisplayInfo.
     * 
     * @return reactorPower
     */
    public float getReactorPower() {
        return reactorPower;
    }


    /**
     * Sets the reactorPower value for this ReactorDisplayInfo.
     * 
     * @param reactorPower
     */
    public void setReactorPower(float reactorPower) {
        this.reactorPower = reactorPower;
    }


    /**
     * Gets the cnsInTemp value for this ReactorDisplayInfo.
     * 
     * @return cnsInTemp
     */
    public float getCnsInTemp() {
        return cnsInTemp;
    }


    /**
     * Sets the cnsInTemp value for this ReactorDisplayInfo.
     * 
     * @param cnsInTemp
     */
    public void setCnsInTemp(float cnsInTemp) {
        this.cnsInTemp = cnsInTemp;
    }


    /**
     * Gets the cnsTemp value for this ReactorDisplayInfo.
     * 
     * @return cnsTemp
     */
    public float getCnsTemp() {
        return cnsTemp;
    }


    /**
     * Sets the cnsTemp value for this ReactorDisplayInfo.
     * 
     * @param cnsTemp
     */
    public void setCnsTemp(float cnsTemp) {
        this.cnsTemp = cnsTemp;
    }


    /**
     * Gets the cg4Status value for this ReactorDisplayInfo.
     * 
     * @return cg4Status
     */
    public java.lang.String getCg4Status() {
        return cg4Status;
    }


    /**
     * Sets the cg4Status value for this ReactorDisplayInfo.
     * 
     * @param cg4Status
     */
    public void setCg4Status(java.lang.String cg4Status) {
        this.cg4Status = cg4Status;
    }


    /**
     * Gets the cg123Status value for this ReactorDisplayInfo.
     * 
     * @return cg123Status
     */
    public java.lang.String getCg123Status() {
        return cg123Status;
    }


    /**
     * Sets the cg123Status value for this ReactorDisplayInfo.
     * 
     * @param cg123Status
     */
    public void setCg123Status(java.lang.String cg123Status) {
        this.cg123Status = cg123Status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReactorDisplayInfo)) return false;
        ReactorDisplayInfo other = (ReactorDisplayInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              this.timeStamp.equals(other.getTimeStamp()))) &&
            this.cnsOutTemp == other.getCnsOutTemp() &&
            ((this.tg123Status==null && other.getTg123Status()==null) || 
             (this.tg123Status!=null &&
              this.tg123Status.equals(other.getTg123Status()))) &&
            ((this.hg2Status==null && other.getHg2Status()==null) || 
             (this.hg2Status!=null &&
              this.hg2Status.equals(other.getHg2Status()))) &&
            ((this.errorMsg==null && other.getErrorMsg()==null) || 
             (this.errorMsg!=null &&
              this.errorMsg.equals(other.getErrorMsg()))) &&
            ((this.tg4Status==null && other.getTg4Status()==null) || 
             (this.tg4Status!=null &&
              this.tg4Status.equals(other.getTg4Status()))) &&
            this.reactorPower == other.getReactorPower() &&
            this.cnsInTemp == other.getCnsInTemp() &&
            this.cnsTemp == other.getCnsTemp() &&
            ((this.cg4Status==null && other.getCg4Status()==null) || 
             (this.cg4Status!=null &&
              this.cg4Status.equals(other.getCg4Status()))) &&
            ((this.cg123Status==null && other.getCg123Status()==null) || 
             (this.cg123Status!=null &&
              this.cg123Status.equals(other.getCg123Status())));
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
        if (getTimeStamp() != null) {
            _hashCode += getTimeStamp().hashCode();
        }
        _hashCode += new Float(getCnsOutTemp()).hashCode();
        if (getTg123Status() != null) {
            _hashCode += getTg123Status().hashCode();
        }
        if (getHg2Status() != null) {
            _hashCode += getHg2Status().hashCode();
        }
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        if (getTg4Status() != null) {
            _hashCode += getTg4Status().hashCode();
        }
        _hashCode += new Float(getReactorPower()).hashCode();
        _hashCode += new Float(getCnsInTemp()).hashCode();
        _hashCode += new Float(getCnsTemp()).hashCode();
        if (getCg4Status() != null) {
            _hashCode += getCg4Status().hashCode();
        }
        if (getCg123Status() != null) {
            _hashCode += getCg123Status().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReactorDisplayInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "ReactorDisplayInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeStamp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "timeStamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cnsOutTemp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "cnsOutTemp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tg123Status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "tg123Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hg2Status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "hg2Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "errorMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tg4Status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "tg4Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reactorPower");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "reactorPower"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cnsInTemp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "cnsInTemp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cnsTemp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "cnsTemp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cg4Status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "cg4Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cg123Status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "cg123Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
