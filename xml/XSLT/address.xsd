<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
   <xs:element name="address">
      <xs:complexType>
         <xs:sequence>
            <xs:element name="person" type="pType" minOccurs="1" macOccurs="unbounded"/>
         </xs:sequence>
      </xs:complexType>
   </xs:element>

      <xs:complexType name="pType">
         <xs:sequence>
            <xs:element name="code" type="xs:positiveInteger"/>
            <xs:element name="name" type="nameType"/>
            <xs:element name="kana" type="kanaType"/>
            <xs:element name="prefCode" type="prefCodeType"/>
         </xs:sequence>
      </xs:complexType>

      <xs:simpleType name="nameType">
         <xs:restriction base="xs:string">
            <xs:minLength value="2"/>
            <xs:maxLength value="10"/>
         </xs:restriction>
      </xs:simpleType>

      <xs:simpleType name="kanaType"/>
         <xs:restriction base="xs:string">
            <xs:minLength value="2"/>
            <xs:maxLength value="50"/>
         </xs:restriction>
      </xs:simpleType>

      <xs:simpleType name="prefCodeType"/>
         <xs:restriction base="xs:positiveInteger">
            <xs:minInclusive value="1"/>
            <xs:maxInclusive value="47"/>
         </xs:restriction>
      </xs:simpleType>
</xs:schema>
