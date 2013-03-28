/**
 * AllDisplayInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package au.gov.ansto.bragg.web.model.webService.server.webservice.types;

public class AllDisplayInfo  implements java.io.Serializable {
    private java.lang.String screenMessage;

    private java.util.Calendar timeStamp;

    private java.lang.String timeStr;

    private au.gov.ansto.bragg.web.model.webService.server.webservice.types.SeminarInfo[] seminarInfo;

    private au.gov.ansto.bragg.web.model.webService.server.webservice.types.ReactorDisplayInfo reactorInfo;

    private java.lang.String errorMsg;

    private au.gov.ansto.bragg.web.model.webService.server.webservice.types.ExperimentDisplay[] experimentInfo;

    private java.lang.String dateStr;

    private java.lang.String newsBar;

    public AllDisplayInfo() {
    }

    public AllDisplayInfo(
           java.lang.String screenMessage,
           java.util.Calendar timeStamp,
           java.lang.String timeStr,
           au.gov.ansto.bragg.web.model.webService.server.webservice.types.SeminarInfo[] seminarInfo,
           au.gov.ansto.bragg.web.model.webService.server.webservice.types.ReactorDisplayInfo reactorInfo,
           java.lang.String errorMsg,
           au.gov.ansto.bragg.web.model.webService.server.webservice.types.ExperimentDisplay[] experimentInfo,
           java.lang.String dateStr,
           java.lang.String newsBar) {
           this.screenMessage = screenMessage;
           this.timeStamp = timeStamp;
           this.timeStr = timeStr;
           this.seminarInfo = seminarInfo;
           this.reactorInfo = reactorInfo;
           this.errorMsg = errorMsg;
           this.experimentInfo = experimentInfo;
           this.dateStr = dateStr;
           this.newsBar = newsBar;
    }


    /**
     * Gets the screenMessage value for this AllDisplayInfo.
     * 
     * @return screenMessage
     */
    public java.lang.String getScreenMessage() {
        return screenMessage;
    }


    /**
     * Sets the screenMessage value for this AllDisplayInfo.
     * 
     * @param screenMessage
     */
    public void setScreenMessage(java.lang.String screenMessage) {
        this.screenMessage = screenMessage;
    }


    /**
     * Gets the timeStamp value for this AllDisplayInfo.
     * 
     * @return timeStamp
     */
    public java.util.Calendar getTimeStamp() {
        return timeStamp;
    }


    /**
     * Sets the timeStamp value for this AllDisplayInfo.
     * 
     * @param timeStamp
     */
    public void setTimeStamp(java.util.Calendar timeStamp) {
        this.timeStamp = timeStamp;
    }


    /**
     * Gets the timeStr value for this AllDisplayInfo.
     * 
     * @return timeStr
     */
    public java.lang.String getTimeStr() {
        return timeStr;
    }


    /**
     * Sets the timeStr value for this AllDisplayInfo.
     * 
     * @param timeStr
     */
    public void setTimeStr(java.lang.String timeStr) {
        this.timeStr = timeStr;
    }


    /**
     * Gets the seminarInfo value for this AllDisplayInfo.
     * 
     * @return seminarInfo
     */
    public au.gov.ansto.bragg.web.model.webService.server.webservice.types.SeminarInfo[] getSeminarInfo() {
        return seminarInfo;
    }


    /**
     * Sets the seminarInfo value for this AllDisplayInfo.
     * 
     * @param seminarInfo
     */
    public void setSeminarInfo(au.gov.ansto.bragg.web.model.webService.server.webservice.types.SeminarInfo[] seminarInfo) {
        this.seminarInfo = seminarInfo;
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.types.SeminarInfo getSeminarInfo(int i) {
        return this.seminarInfo[i];
    }

    public void setSeminarInfo(int i, au.gov.ansto.bragg.web.model.webService.server.webservice.types.SeminarInfo _value) {
        this.seminarInfo[i] = _value;
    }


    /**
     * Gets the reactorInfo value for this AllDisplayInfo.
     * 
     * @return reactorInfo
     */
    public au.gov.ansto.bragg.web.model.webService.server.webservice.types.ReactorDisplayInfo getReactorInfo() {
        return reactorInfo;
    }


    /**
     * Sets the reactorInfo value for this AllDisplayInfo.
     * 
     * @param reactorInfo
     */
    public void setReactorInfo(au.gov.ansto.bragg.web.model.webService.server.webservice.types.ReactorDisplayInfo reactorInfo) {
        this.reactorInfo = reactorInfo;
    }


    /**
     * Gets the errorMsg value for this AllDisplayInfo.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this AllDisplayInfo.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }


    /**
     * Gets the experimentInfo value for this AllDisplayInfo.
     * 
     * @return experimentInfo
     */
    public au.gov.ansto.bragg.web.model.webService.server.webservice.types.ExperimentDisplay[] getExperimentInfo() {
        return experimentInfo;
    }


    /**
     * Sets the experimentInfo value for this AllDisplayInfo.
     * 
     * @param experimentInfo
     */
    public void setExperimentInfo(au.gov.ansto.bragg.web.model.webService.server.webservice.types.ExperimentDisplay[] experimentInfo) {
        this.experimentInfo = experimentInfo;
    }

    public au.gov.ansto.bragg.web.model.webService.server.webservice.types.ExperimentDisplay getExperimentInfo(int i) {
        return this.experimentInfo[i];
    }

    public void setExperimentInfo(int i, au.gov.ansto.bragg.web.model.webService.server.webservice.types.ExperimentDisplay _value) {
        this.experimentInfo[i] = _value;
    }


    /**
     * Gets the dateStr value for this AllDisplayInfo.
     * 
     * @return dateStr
     */
    public java.lang.String getDateStr() {
        return dateStr;
    }


    /**
     * Sets the dateStr value for this AllDisplayInfo.
     * 
     * @param dateStr
     */
    public void setDateStr(java.lang.String dateStr) {
        this.dateStr = dateStr;
    }


    /**
     * Gets the newsBar value for this AllDisplayInfo.
     * 
     * @return newsBar
     */
    public java.lang.String getNewsBar() {
        return newsBar;
    }


    /**
     * Sets the newsBar value for this AllDisplayInfo.
     * 
     * @param newsBar
     */
    public void setNewsBar(java.lang.String newsBar) {
        this.newsBar = newsBar;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AllDisplayInfo)) return false;
        AllDisplayInfo other = (AllDisplayInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.screenMessage==null && other.getScreenMessage()==null) || 
             (this.screenMessage!=null &&
              this.screenMessage.equals(other.getScreenMessage()))) &&
            ((this.timeStamp==null && other.getTimeStamp()==null) || 
             (this.timeStamp!=null &&
              this.timeStamp.equals(other.getTimeStamp()))) &&
            ((this.timeStr==null && other.getTimeStr()==null) || 
             (this.timeStr!=null &&
              this.timeStr.equals(other.getTimeStr()))) &&
            ((this.seminarInfo==null && other.getSeminarInfo()==null) || 
             (this.seminarInfo!=null &&
              java.util.Arrays.equals(this.seminarInfo, other.getSeminarInfo()))) &&
            ((this.reactorInfo==null && other.getReactorInfo()==null) || 
             (this.reactorInfo!=null &&
              this.reactorInfo.equals(other.getReactorInfo()))) &&
            ((this.errorMsg==null && other.getErrorMsg()==null) || 
             (this.errorMsg!=null &&
              this.errorMsg.equals(other.getErrorMsg()))) &&
            ((this.experimentInfo==null && other.getExperimentInfo()==null) || 
             (this.experimentInfo!=null &&
              java.util.Arrays.equals(this.experimentInfo, other.getExperimentInfo()))) &&
            ((this.dateStr==null && other.getDateStr()==null) || 
             (this.dateStr!=null &&
              this.dateStr.equals(other.getDateStr()))) &&
            ((this.newsBar==null && other.getNewsBar()==null) || 
             (this.newsBar!=null &&
              this.newsBar.equals(other.getNewsBar())));
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
        if (getScreenMessage() != null) {
            _hashCode += getScreenMessage().hashCode();
        }
        if (getTimeStamp() != null) {
            _hashCode += getTimeStamp().hashCode();
        }
        if (getTimeStr() != null) {
            _hashCode += getTimeStr().hashCode();
        }
        if (getSeminarInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSeminarInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSeminarInfo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getReactorInfo() != null) {
            _hashCode += getReactorInfo().hashCode();
        }
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        if (getExperimentInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExperimentInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExperimentInfo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDateStr() != null) {
            _hashCode += getDateStr().hashCode();
        }
        if (getNewsBar() != null) {
            _hashCode += getNewsBar().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AllDisplayInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "AllDisplayInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("screenMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "screenMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeStamp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "timeStamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "timeStr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seminarInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "seminarInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "SeminarInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reactorInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "reactorInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "ReactorDisplayInfo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "errorMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("experimentInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "experimentInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "ExperimentDisplay"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateStr");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "dateStr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newsBar");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "newsBar"));
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
