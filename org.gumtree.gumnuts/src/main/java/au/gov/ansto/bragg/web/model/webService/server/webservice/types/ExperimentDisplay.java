/**
 * ExperimentDisplay.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package au.gov.ansto.bragg.web.model.webService.server.webservice.types;

public class ExperimentDisplay  implements java.io.Serializable {
    private java.lang.String proposalCode;

    private java.lang.String principalSci;

    private java.lang.String principalOrg;

    private java.lang.String exptTitle;

    private java.lang.String endDisplay;

    private java.lang.String otherSci;

    private java.lang.String errorMsg;

    private java.lang.String startDisplay;

    private java.lang.String instrName;

    private java.lang.String localSci;

    public ExperimentDisplay() {
    }

    public ExperimentDisplay(
           java.lang.String proposalCode,
           java.lang.String principalSci,
           java.lang.String principalOrg,
           java.lang.String exptTitle,
           java.lang.String endDisplay,
           java.lang.String otherSci,
           java.lang.String errorMsg,
           java.lang.String startDisplay,
           java.lang.String instrName,
           java.lang.String localSci) {
           this.proposalCode = proposalCode;
           this.principalSci = principalSci;
           this.principalOrg = principalOrg;
           this.exptTitle = exptTitle;
           this.endDisplay = endDisplay;
           this.otherSci = otherSci;
           this.errorMsg = errorMsg;
           this.startDisplay = startDisplay;
           this.instrName = instrName;
           this.localSci = localSci;
    }


    /**
     * Gets the proposalCode value for this ExperimentDisplay.
     * 
     * @return proposalCode
     */
    public java.lang.String getProposalCode() {
        return proposalCode;
    }


    /**
     * Sets the proposalCode value for this ExperimentDisplay.
     * 
     * @param proposalCode
     */
    public void setProposalCode(java.lang.String proposalCode) {
        this.proposalCode = proposalCode;
    }


    /**
     * Gets the principalSci value for this ExperimentDisplay.
     * 
     * @return principalSci
     */
    public java.lang.String getPrincipalSci() {
        return principalSci;
    }


    /**
     * Sets the principalSci value for this ExperimentDisplay.
     * 
     * @param principalSci
     */
    public void setPrincipalSci(java.lang.String principalSci) {
        this.principalSci = principalSci;
    }


    /**
     * Gets the principalOrg value for this ExperimentDisplay.
     * 
     * @return principalOrg
     */
    public java.lang.String getPrincipalOrg() {
        return principalOrg;
    }


    /**
     * Sets the principalOrg value for this ExperimentDisplay.
     * 
     * @param principalOrg
     */
    public void setPrincipalOrg(java.lang.String principalOrg) {
        this.principalOrg = principalOrg;
    }


    /**
     * Gets the exptTitle value for this ExperimentDisplay.
     * 
     * @return exptTitle
     */
    public java.lang.String getExptTitle() {
        return exptTitle;
    }


    /**
     * Sets the exptTitle value for this ExperimentDisplay.
     * 
     * @param exptTitle
     */
    public void setExptTitle(java.lang.String exptTitle) {
        this.exptTitle = exptTitle;
    }


    /**
     * Gets the endDisplay value for this ExperimentDisplay.
     * 
     * @return endDisplay
     */
    public java.lang.String getEndDisplay() {
        return endDisplay;
    }


    /**
     * Sets the endDisplay value for this ExperimentDisplay.
     * 
     * @param endDisplay
     */
    public void setEndDisplay(java.lang.String endDisplay) {
        this.endDisplay = endDisplay;
    }


    /**
     * Gets the otherSci value for this ExperimentDisplay.
     * 
     * @return otherSci
     */
    public java.lang.String getOtherSci() {
        return otherSci;
    }


    /**
     * Sets the otherSci value for this ExperimentDisplay.
     * 
     * @param otherSci
     */
    public void setOtherSci(java.lang.String otherSci) {
        this.otherSci = otherSci;
    }


    /**
     * Gets the errorMsg value for this ExperimentDisplay.
     * 
     * @return errorMsg
     */
    public java.lang.String getErrorMsg() {
        return errorMsg;
    }


    /**
     * Sets the errorMsg value for this ExperimentDisplay.
     * 
     * @param errorMsg
     */
    public void setErrorMsg(java.lang.String errorMsg) {
        this.errorMsg = errorMsg;
    }


    /**
     * Gets the startDisplay value for this ExperimentDisplay.
     * 
     * @return startDisplay
     */
    public java.lang.String getStartDisplay() {
        return startDisplay;
    }


    /**
     * Sets the startDisplay value for this ExperimentDisplay.
     * 
     * @param startDisplay
     */
    public void setStartDisplay(java.lang.String startDisplay) {
        this.startDisplay = startDisplay;
    }


    /**
     * Gets the instrName value for this ExperimentDisplay.
     * 
     * @return instrName
     */
    public java.lang.String getInstrName() {
        return instrName;
    }


    /**
     * Sets the instrName value for this ExperimentDisplay.
     * 
     * @param instrName
     */
    public void setInstrName(java.lang.String instrName) {
        this.instrName = instrName;
    }


    /**
     * Gets the localSci value for this ExperimentDisplay.
     * 
     * @return localSci
     */
    public java.lang.String getLocalSci() {
        return localSci;
    }


    /**
     * Sets the localSci value for this ExperimentDisplay.
     * 
     * @param localSci
     */
    public void setLocalSci(java.lang.String localSci) {
        this.localSci = localSci;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExperimentDisplay)) return false;
        ExperimentDisplay other = (ExperimentDisplay) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.proposalCode==null && other.getProposalCode()==null) || 
             (this.proposalCode!=null &&
              this.proposalCode.equals(other.getProposalCode()))) &&
            ((this.principalSci==null && other.getPrincipalSci()==null) || 
             (this.principalSci!=null &&
              this.principalSci.equals(other.getPrincipalSci()))) &&
            ((this.principalOrg==null && other.getPrincipalOrg()==null) || 
             (this.principalOrg!=null &&
              this.principalOrg.equals(other.getPrincipalOrg()))) &&
            ((this.exptTitle==null && other.getExptTitle()==null) || 
             (this.exptTitle!=null &&
              this.exptTitle.equals(other.getExptTitle()))) &&
            ((this.endDisplay==null && other.getEndDisplay()==null) || 
             (this.endDisplay!=null &&
              this.endDisplay.equals(other.getEndDisplay()))) &&
            ((this.otherSci==null && other.getOtherSci()==null) || 
             (this.otherSci!=null &&
              this.otherSci.equals(other.getOtherSci()))) &&
            ((this.errorMsg==null && other.getErrorMsg()==null) || 
             (this.errorMsg!=null &&
              this.errorMsg.equals(other.getErrorMsg()))) &&
            ((this.startDisplay==null && other.getStartDisplay()==null) || 
             (this.startDisplay!=null &&
              this.startDisplay.equals(other.getStartDisplay()))) &&
            ((this.instrName==null && other.getInstrName()==null) || 
             (this.instrName!=null &&
              this.instrName.equals(other.getInstrName()))) &&
            ((this.localSci==null && other.getLocalSci()==null) || 
             (this.localSci!=null &&
              this.localSci.equals(other.getLocalSci())));
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
        if (getProposalCode() != null) {
            _hashCode += getProposalCode().hashCode();
        }
        if (getPrincipalSci() != null) {
            _hashCode += getPrincipalSci().hashCode();
        }
        if (getPrincipalOrg() != null) {
            _hashCode += getPrincipalOrg().hashCode();
        }
        if (getExptTitle() != null) {
            _hashCode += getExptTitle().hashCode();
        }
        if (getEndDisplay() != null) {
            _hashCode += getEndDisplay().hashCode();
        }
        if (getOtherSci() != null) {
            _hashCode += getOtherSci().hashCode();
        }
        if (getErrorMsg() != null) {
            _hashCode += getErrorMsg().hashCode();
        }
        if (getStartDisplay() != null) {
            _hashCode += getStartDisplay().hashCode();
        }
        if (getInstrName() != null) {
            _hashCode += getInstrName().hashCode();
        }
        if (getLocalSci() != null) {
            _hashCode += getLocalSci().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExperimentDisplay.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "ExperimentDisplay"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proposalCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "proposalCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("principalSci");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "principalSci"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("principalOrg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "principalOrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exptTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "exptTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDisplay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "endDisplay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("otherSci");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "otherSci"));
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
        elemField.setFieldName("startDisplay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "startDisplay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instrName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "instrName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("localSci");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "localSci"));
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
