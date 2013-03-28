/**
 * BookingInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package au.gov.ansto.bragg.web.model.webService.server.webservice.types;

public class BookingInfo  implements java.io.Serializable {
    private int groupId;

    private java.util.Calendar bookingEnd;

    private int equipmentId;

    private int startTime;

    private int visitNumber;

    private java.util.Calendar bookingStart;

    private int endTime;

    public BookingInfo() {
    }

    public BookingInfo(
           int groupId,
           java.util.Calendar bookingEnd,
           int equipmentId,
           int startTime,
           int visitNumber,
           java.util.Calendar bookingStart,
           int endTime) {
           this.groupId = groupId;
           this.bookingEnd = bookingEnd;
           this.equipmentId = equipmentId;
           this.startTime = startTime;
           this.visitNumber = visitNumber;
           this.bookingStart = bookingStart;
           this.endTime = endTime;
    }


    /**
     * Gets the groupId value for this BookingInfo.
     * 
     * @return groupId
     */
    public int getGroupId() {
        return groupId;
    }


    /**
     * Sets the groupId value for this BookingInfo.
     * 
     * @param groupId
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }


    /**
     * Gets the bookingEnd value for this BookingInfo.
     * 
     * @return bookingEnd
     */
    public java.util.Calendar getBookingEnd() {
        return bookingEnd;
    }


    /**
     * Sets the bookingEnd value for this BookingInfo.
     * 
     * @param bookingEnd
     */
    public void setBookingEnd(java.util.Calendar bookingEnd) {
        this.bookingEnd = bookingEnd;
    }


    /**
     * Gets the equipmentId value for this BookingInfo.
     * 
     * @return equipmentId
     */
    public int getEquipmentId() {
        return equipmentId;
    }


    /**
     * Sets the equipmentId value for this BookingInfo.
     * 
     * @param equipmentId
     */
    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }


    /**
     * Gets the startTime value for this BookingInfo.
     * 
     * @return startTime
     */
    public int getStartTime() {
        return startTime;
    }


    /**
     * Sets the startTime value for this BookingInfo.
     * 
     * @param startTime
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }


    /**
     * Gets the visitNumber value for this BookingInfo.
     * 
     * @return visitNumber
     */
    public int getVisitNumber() {
        return visitNumber;
    }


    /**
     * Sets the visitNumber value for this BookingInfo.
     * 
     * @param visitNumber
     */
    public void setVisitNumber(int visitNumber) {
        this.visitNumber = visitNumber;
    }


    /**
     * Gets the bookingStart value for this BookingInfo.
     * 
     * @return bookingStart
     */
    public java.util.Calendar getBookingStart() {
        return bookingStart;
    }


    /**
     * Sets the bookingStart value for this BookingInfo.
     * 
     * @param bookingStart
     */
    public void setBookingStart(java.util.Calendar bookingStart) {
        this.bookingStart = bookingStart;
    }


    /**
     * Gets the endTime value for this BookingInfo.
     * 
     * @return endTime
     */
    public int getEndTime() {
        return endTime;
    }


    /**
     * Sets the endTime value for this BookingInfo.
     * 
     * @param endTime
     */
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BookingInfo)) return false;
        BookingInfo other = (BookingInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.groupId == other.getGroupId() &&
            ((this.bookingEnd==null && other.getBookingEnd()==null) || 
             (this.bookingEnd!=null &&
              this.bookingEnd.equals(other.getBookingEnd()))) &&
            this.equipmentId == other.getEquipmentId() &&
            this.startTime == other.getStartTime() &&
            this.visitNumber == other.getVisitNumber() &&
            ((this.bookingStart==null && other.getBookingStart()==null) || 
             (this.bookingStart!=null &&
              this.bookingStart.equals(other.getBookingStart()))) &&
            this.endTime == other.getEndTime();
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
        _hashCode += getGroupId();
        if (getBookingEnd() != null) {
            _hashCode += getBookingEnd().hashCode();
        }
        _hashCode += getEquipmentId();
        _hashCode += getStartTime();
        _hashCode += getVisitNumber();
        if (getBookingStart() != null) {
            _hashCode += getBookingStart().hashCode();
        }
        _hashCode += getEndTime();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BookingInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "BookingInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "groupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookingEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "bookingEnd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("equipmentId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "equipmentId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "startTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("visitNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "visitNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bookingStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "bookingStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://webservice.server.webService.model.web.bragg.ansto.gov.au/types/", "endTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
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
