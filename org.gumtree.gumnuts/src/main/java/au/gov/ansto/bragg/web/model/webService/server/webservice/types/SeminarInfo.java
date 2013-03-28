/**
 * SeminarInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package au.gov.ansto.bragg.web.model.webService.server.webservice.types;

public class SeminarInfo  implements java.io.Serializable {
    private java.lang.String presenterInfo;

    private java.lang.String type;

    private java.lang.String title;

    private java.lang.String timeStr;

    private java.util.Calendar talkDate;

    private java.lang.String host;

    private java.lang.String presenter;

    private java.lang.String location;

    private java.lang.String dateStr;

    private boolean imminent;

    private java.lang.String lengthStr;

    public SeminarInfo() {
    }

    public SeminarInfo(
           java.lang.String presenterInfo,
           java.lang.String type,
           java.lang.String title,
           java.lang.String timeStr,
           java.util.Calendar talkDate,
           java.lang.String host,
           java.lang.String presenter,
           java.lang.String location,
           java.lang.String dateStr,
           boolean imminent,
           java.lang.String lengthStr) {
           this.presenterInfo = presenterInfo;
           this.type = type;
           this.title = title;
           this.timeStr = timeStr;
           this.talkDate = talkDate;
           this.host = host;
           this.presenter = presenter;
           this.location = location;
           this.dateStr = dateStr;
           this.imminent = imminent;
           this.lengthStr = lengthStr;
    }


    /**
     * Gets the presenterInfo value for this SeminarInfo.
     * 
     * @return presenterInfo
     */
    public java.lang.String getPresenterInfo() {
        return presenterInfo;
    }


    /**
     * Sets the presenterInfo value for this SeminarInfo.
     * 
     * @param presenterInfo
     */
    public void setPresenterInfo(java.lang.String presenterInfo) {
        this.presenterInfo = presenterInfo;
    }


    /**
     * Gets the type value for this SeminarInfo.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this SeminarInfo.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the title value for this SeminarInfo.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this SeminarInfo.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the timeStr value for this SeminarInfo.
     * 
     * @return timeStr
     */
    public java.lang.String getTimeStr() {
        return timeStr;
    }


    /**
     * Sets the timeStr value for this SeminarInfo.
     * 
     * @param timeStr
     */
    public void setTimeStr(java.lang.String timeStr) {
        this.timeStr = timeStr;
    }


    /**
     * Gets the talkDate value for this SeminarInfo.
     * 
     * @return talkDate
     */
    public java.util.Calendar getTalkDate() {
        return talkDate;
    }


    /**
     * Sets the talkDate value for this SeminarInfo.
     * 
     * @param talkDate
     */
    public void setTalkDate(java.util.Calendar talkDate) {
        this.talkDate = talkDate;
    }


    /**
     * Gets the host value for this SeminarInfo.
     * 
     * @return host
     */
    public java.lang.String getHost() {
        return host;
    }


    /**
     * Sets the host value for this SeminarInfo.
     * 
     * @param host
     */
    public void setHost(java.lang.String host) {
        this.host = host;
    }


    /**
     * Gets the presenter value for this SeminarInfo.
     * 
     * @return presenter
     */
    public java.lang.String getPresenter() {
        return presenter;
    }


    /**
     * Sets the presenter value for this SeminarInfo.
     * 
     * @param presenter
     */
    public void setPresenter(java.lang.String presenter) {
        this.presenter = presenter;
    }


    /**
     * Gets the location value for this SeminarInfo.
     * 
     * @return location
     */
    public java.lang.String getLocation() {
        return location;
    }


    /**
     * Sets the location value for this SeminarInfo.
     * 
     * @param location
     */
    public void setLocation(java.lang.String location) {
        this.location = location;
    }


    /**
     * Gets the dateStr value for this SeminarInfo.
     * 
     * @return dateStr
     */
    public java.lang.String getDateStr() {
        return dateStr;
    }


    /**
     * Sets the dateStr value for this SeminarInfo.
     * 
     * @param dateStr
     */
    public void setDateStr(java.lang.String dateStr) {
        this.dateStr = dateStr;
    }


    /**
     * Gets the imminent value for this SeminarInfo.
     * 
     * @return imminent
     */
    public boolean isImminent() {
        return imminent;
    }


    /**
     * Sets the imminent value for this SeminarInfo.
     * 
     * @param imminent
     */
    public void setImminent(boolean imminent) {
        this.imminent = imminent;
    }


    /**
     * Gets the lengthStr value for this SeminarInfo.
     * 
     * @return lengthStr
     */
    public java.lang.String getLengthStr() {
        return lengthStr;
    }


    /**
     * Sets the lengthStr value for this SeminarInfo.
     * 
     * @param lengthStr
     */
    public void setLengthStr(java.lang.String lengthStr) {
        this.lengthStr = lengthStr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SeminarInfo)) return false;
        SeminarInfo other = (SeminarInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.presenterInfo==null && other.getPresenterInfo()==null) || 
             (this.presenterInfo!=null &&
              this.presenterInfo.equals(other.getPresenterInfo()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.timeStr==null && other.getTimeStr()==null) || 
             (this.timeStr!=null &&
              this.timeStr.equals(other.getTimeStr()))) &&
            ((this.talkDate==null && other.getTalkDate()==null) || 
             (this.talkDate!=null &&
              this.talkDate.equals(other.getTalkDate()))) &&
            ((this.host==null && other.getHost()==null) || 
             (this.host!=null &&
              this.host.equals(other.getHost()))) &&
            ((this.presenter==null && other.getPresenter()==null) || 
             (this.presenter!=null &&
              this.presenter.equals(other.getPresenter()))) &&
            ((this.location==null && other.getLocation()==null) || 
             (this.location!=null &&
              this.location.equals(other.getLocation()))) &&
            ((this.dateStr==null && other.getDateStr()==null) || 
             (this.dateStr!=null &&
              this.dateStr.equals(other.getDateStr()))) &&
            this.imminent == other.isImminent() &&
            ((this.lengthStr==null && other.getLengthStr()==null) || 
             (this.lengthStr!=null &&
              this.lengthStr.equals(other.getLengthStr())));
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
        if (getPresenterInfo() != null) {
            _hashCode += getPresenterInfo().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getTimeStr() != null) {
            _hashCode += getTimeStr().hashCode();
        }
        if (getTalkDate() != null) {
            _hashCode += getTalkDate().hashCode();
        }
        if (getHost() != null) {
            _hashCode += getHost().hashCode();
        }
        if (getPresenter() != null) {
            _hashCode += getPresenter().hashCode();
        }
        if (getLocation() != null) {
            _hashCode += getLocation().hashCode();
        }
        if (getDateStr() != null) {
            _hashCode += getDateStr().hashCode();
        }
        _hashCode += (isImminent() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getLengthStr() != null) {
            _hashCode += getLengthStr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SeminarInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "SeminarInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("presenterInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "presenterInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "timeStr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("talkDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "talkDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("host");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "host"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("presenter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "presenter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("location");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "location"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "dateStr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imminent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "imminent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lengthStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "lengthStr"));
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
