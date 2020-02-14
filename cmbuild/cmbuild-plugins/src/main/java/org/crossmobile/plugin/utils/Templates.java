/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.plugin.utils;

public class Templates {
    public final static String LIB_DEF = " \txmlvm_init\n" +
            "\n" +
            "\tJAVA_NULL DATA\n" +
            "\n" +
            "\t_OBJC_CLASS_XMLVMArray DATA\n" +
            "\t__objc_class_name_XMLVMArray CONSTANT\n" +
            "\t__objc_ivar_offset_XMLVMArray.array\n" +
            "\t__objc_ivar_offset_XMLVMArray.type\n" +
            "\t__objc_ivar_offset_XMLVMArray.length\n" +
            "\n" +
            "\t_OBJC_CLASS_crossmobile_rt_StrongReference DATA\n" +
            "\t__objc_class_name_crossmobile_rt_StrongReference CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_BufferedInputStream DATA\n" +
            "\t__objc_class_name_java_io_BufferedInputStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_BufferedOutputStream DATA\n" +
            "\t__objc_class_name_java_io_BufferedOutputStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_BufferedReader DATA\n" +
            "\t__objc_class_name_java_io_BufferedReader CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_BufferedWriter DATA\n" +
            "\t__objc_class_name_java_io_BufferedWriter CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_ByteArrayInputStream DATA\n" +
            "\t__objc_class_name_java_io_ByteArrayInputStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_ByteArrayOutputStream DATA\n" +
            "\t__objc_class_name_java_io_ByteArrayOutputStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_DataInputStream DATA\n" +
            "\t__objc_class_name_java_io_DataInputStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_DataOutputStream DATA\n" +
            "\t__objc_class_name_java_io_DataOutputStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_EOFException DATA\n" +
            "\t__objc_class_name_java_io_EOFException CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_FileDescriptor DATA\n" +
            "\t__objc_class_name_java_io_FileDescriptor CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_FileInputStream DATA\n" +
            "\t__objc_class_name_java_io_FileInputStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_File DATA\n" +
            "\t__objc_class_name_java_io_File CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_FilenameFilter DATA\n" +
            "\t__objc_class_name_java_io_FilenameFilter CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_FileNotFoundException DATA\n" +
            "\t__objc_class_name_java_io_FileNotFoundException CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_FileOutputStream DATA\n" +
            "\t__objc_class_name_java_io_FileOutputStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_FileReader DATA\n" +
            "\t__objc_class_name_java_io_FileReader CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_FileWriter DATA\n" +
            "\t__objc_class_name_java_io_FileWriter CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_InputStream DATA\n" +
            "\t__objc_class_name_java_io_InputStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_InputStreamReader DATA\n" +
            "\t__objc_class_name_java_io_InputStreamReader CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_IOException DATA\n" +
            "\t__objc_class_name_java_io_IOException CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_ObjectInputStream DATA\n" +
            "\t__objc_class_name_java_io_ObjectInputStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_ObjectOutputStream DATA\n" +
            "\t__objc_class_name_java_io_ObjectOutputStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_OutputStream DATA\n" +
            "\t__objc_class_name_java_io_OutputStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_OutputStreamWriter DATA\n" +
            "\t__objc_class_name_java_io_OutputStreamWriter CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_PrintStream DATA\n" +
            "\t__objc_class_name_java_io_PrintStream CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_PrintWriter DATA\n" +
            "\t__objc_class_name_java_io_PrintWriter CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_Reader DATA\n" +
            "\t__objc_class_name_java_io_Reader CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_StringReader DATA\n" +
            "\t__objc_class_name_java_io_StringReader CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_UnsupportedEncodingException DATA\n" +
            "\t__objc_class_name_java_io_UnsupportedEncodingException CONSTANT\n" +
            "\t_OBJC_CLASS_java_io_Writer DATA\n" +
            "\t__objc_class_name_java_io_Writer CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_ArrayIndexOutOfBoundsException DATA\n" +
            "\t__objc_class_name_java_lang_ArrayIndexOutOfBoundsException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_AssertionError DATA\n" +
            "\t__objc_class_name_java_lang_AssertionError CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Boolean DATA\n" +
            "\t__objc_class_name_java_lang_Boolean CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Byte DATA\n" +
            "\t__objc_class_name_java_lang_Byte CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Character DATA\n" +
            "\t__objc_class_name_java_lang_Character CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Class DATA\n" +
            "\t__objc_class_name_java_lang_Class CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_ClassNotFoundException DATA\n" +
            "\t__objc_class_name_java_lang_ClassNotFoundException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Double DATA\n" +
            "\t__objc_class_name_java_lang_Double CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Enum DATA\n" +
            "\t__objc_class_name_java_lang_Enum CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Float DATA\n" +
            "\t__objc_class_name_java_lang_Float CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_IllegalAccessException DATA\n" +
            "\t__objc_class_name_java_lang_IllegalAccessException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_IllegalArgumentException DATA\n" +
            "\t__objc_class_name_java_lang_IllegalArgumentException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_IllegalMonitorStateException DATA\n" +
            "\t__objc_class_name_java_lang_IllegalMonitorStateException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_IllegalStateException DATA\n" +
            "\t__objc_class_name_java_lang_IllegalStateException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_IndexOutOfBoundsException DATA\n" +
            "\t__objc_class_name_java_lang_IndexOutOfBoundsException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_InstantiationException DATA\n" +
            "\t__objc_class_name_java_lang_InstantiationException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Integer DATA\n" +
            "\t__objc_class_name_java_lang_Integer CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_InterruptedException DATA\n" +
            "\t__objc_class_name_java_lang_InterruptedException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Long DATA\n" +
            "\t__objc_class_name_java_lang_Long CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Math DATA\n" +
            "\t__objc_class_name_java_lang_Math CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_NegativeArraySizeException DATA\n" +
            "\t__objc_class_name_java_lang_NegativeArraySizeException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_NoSuchFieldError DATA\n" +
            "\t__objc_class_name_java_lang_NoSuchFieldError CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_NoSuchFieldException DATA\n" +
            "\t__objc_class_name_java_lang_NoSuchFieldException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_NoSuchMethodException DATA\n" +
            "\t__objc_class_name_java_lang_NoSuchMethodException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_NullPointerException DATA\n" +
            "\t__objc_class_name_java_lang_NullPointerException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_NumberFormatException DATA\n" +
            "\t__objc_class_name_java_lang_NumberFormatException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Number DATA\n" +
            "\t__objc_class_name_java_lang_Number CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Object_members DATA\n" +
            "\t__objc_class_name_java_lang_Object_members CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_reflect_Array DATA\n" +
            "\t__objc_class_name_java_lang_reflect_Array CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_reflect_Constructor DATA\n" +
            "\t__objc_class_name_java_lang_reflect_Constructor CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_reflect_Field DATA\n" +
            "\t__objc_class_name_java_lang_reflect_Field CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_reflect_InvocationTargetException DATA\n" +
            "\t__objc_class_name_java_lang_reflect_InvocationTargetException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_reflect_Method DATA\n" +
            "\t__objc_class_name_java_lang_reflect_Method CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_ref_WeakReference DATA\n" +
            "\t__objc_class_name_java_lang_ref_WeakReference CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_RuntimeException DATA\n" +
            "\t__objc_class_name_java_lang_RuntimeException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Runtime DATA\n" +
            "\t__objc_class_name_java_lang_Runtime CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_SecurityException DATA\n" +
            "\t__objc_class_name_java_lang_SecurityException CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Short DATA\n" +
            "\t__objc_class_name_java_lang_Short CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_System DATA\n" +
            "\t__objc_class_name_java_lang_System CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_Thread DATA\n" +
            "\t__objc_class_name_java_lang_Thread CONSTANT\n" +
            "\t_OBJC_CLASS_java_lang_UnsupportedOperationException DATA\n" +
            "\t__objc_class_name_java_lang_UnsupportedOperationException CONSTANT\n" +
            "\t_OBJC_CLASS_java_net_HttpURLConnection DATA\n" +
            "\t__objc_class_name_java_net_HttpURLConnection CONSTANT\n" +
            "\t_OBJC_CLASS_java_net_InetAddress DATA\n" +
            "\t__objc_class_name_java_net_InetAddress CONSTANT\n" +
            "\t_OBJC_CLASS_java_net_InterfaceAddress DATA\n" +
            "\t__objc_class_name_java_net_InterfaceAddress CONSTANT\n" +
            "\t_OBJC_CLASS_java_net_NetworkInterface DATA\n" +
            "\t__objc_class_name_java_net_NetworkInterface CONSTANT\n" +
            "\t_OBJC_CLASS_java_net_ServerSocket DATA\n" +
            "\t__objc_class_name_java_net_ServerSocket CONSTANT\n" +
            "\t_OBJC_CLASS_java_net_SocketException DATA\n" +
            "\t__objc_class_name_java_net_SocketException CONSTANT\n" +
            "\t_OBJC_CLASS_java_net_Socket DATA\n" +
            "\t__objc_class_name_java_net_Socket CONSTANT\n" +
            "\t_OBJC_CLASS_java_net_SocketInputStreamImpl DATA\n" +
            "\t__objc_class_name_java_net_SocketInputStreamImpl CONSTANT\n" +
            "\t_OBJC_CLASS_java_net_SocketOutputStreamImpl DATA\n" +
            "\t__objc_class_name_java_net_SocketOutputStreamImpl CONSTANT\n" +
            "\t_OBJC_CLASS_java_net_SocketTimeoutException DATA\n" +
            "\t__objc_class_name_java_net_SocketTimeoutException CONSTANT\n" +
            "\t_OBJC_CLASS_java_net_URLConnection DATA\n" +
            "\t__objc_class_name_java_net_URLConnection CONSTANT\n" +
            "\t_OBJC_CLASS_java_net_URL DATA\n" +
            "\t__objc_class_name_java_net_URL CONSTANT\n" +
            "\t_OBJC_CLASS_java_nio_ByteBuffer DATA\n" +
            "\t__objc_class_name_java_nio_ByteBuffer CONSTANT\n" +
            "\t_OBJC_CLASS_java_nio_FloatBuffer DATA\n" +
            "\t__objc_class_name_java_nio_FloatBuffer CONSTANT\n" +
            "\t_OBJC_CLASS_java_nio_IntBuffer DATA\n" +
            "\t__objc_class_name_java_nio_IntBuffer CONSTANT\n" +
            "\t_OBJC_CLASS_java_security_Key DATA\n" +
            "\t__objc_class_name_java_security_Key CONSTANT\n" +
            "\t_OBJC_CLASS_java_security_MessageDigest DATA\n" +
            "\t__objc_class_name_java_security_MessageDigest CONSTANT\n" +
            "\t_OBJC_CLASS_java_security_SecureRandom DATA\n" +
            "\t__objc_class_name_java_security_SecureRandom CONSTANT\n" +
            "\t_OBJC_CLASS_java_sql_Connection DATA\n" +
            "\t__objc_class_name_java_sql_Connection CONSTANT\n" +
            "\t_OBJC_CLASS_java_sql_DriverManager DATA\n" +
            "\t__objc_class_name_java_sql_DriverManager CONSTANT\n" +
            "\t_OBJC_CLASS_java_sql_ResultSet DATA\n" +
            "\t__objc_class_name_java_sql_ResultSet CONSTANT\n" +
            "\t_OBJC_CLASS_java_sql_ResultSetMetaData DATA\n" +
            "\t__objc_class_name_java_sql_ResultSetMetaData CONSTANT\n" +
            "\t_OBJC_CLASS_java_sql_SQLException DATA\n" +
            "\t__objc_class_name_java_sql_SQLException CONSTANT\n" +
            "\t_OBJC_CLASS_java_sql_Statement DATA\n" +
            "\t__objc_class_name_java_sql_Statement CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_Arrays DATA\n" +
            "\t__objc_class_name_java_util_Arrays CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_Collections DATA\n" +
            "\t__objc_class_name_java_util_Collections CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_HashMap_EntrySet DATA\n" +
            "\t__objc_class_name_java_util_HashMap_EntrySet CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_IteratorImpl DATA\n" +
            "\t__objc_class_name_java_util_IteratorImpl CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_LinkedHashMap DATA\n" +
            "\t__objc_class_name_java_util_LinkedHashMap CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_Locale DATA\n" +
            "\t__objc_class_name_java_util_Locale CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_Map_Entry_Impl DATA\n" +
            "\t__objc_class_name_java_util_Map_Entry_Impl CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_Objects DATA\n" +
            "\t__objc_class_name_java_util_Objects CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_Observable DATA\n" +
            "\t__objc_class_name_java_util_Observable CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_Random DATA\n" +
            "\t__objc_class_name_java_util_Random CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_Stack DATA\n" +
            "\t__objc_class_name_java_util_Stack CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_StringTokenizer DATA\n" +
            "\t__objc_class_name_java_util_StringTokenizer CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_TreeMap DATA\n" +
            "\t__objc_class_name_java_util_TreeMap CONSTANT\n" +
            "\t_OBJC_CLASS_java_util_TreeSet DATA\n" +
            "\t__objc_class_name_java_util_TreeSet CONSTANT\n" +
            "\t_OBJC_CLASS_javax_crypto_Cipher DATA\n" +
            "\t__objc_class_name_javax_crypto_Cipher CONSTANT\n" +
            "\t_OBJC_CLASS_javax_crypto_KeyGenerator DATA\n" +
            "\t__objc_class_name_javax_crypto_KeyGenerator CONSTANT\n" +
            "\t_OBJC_CLASS_javax_crypto_SecretKey DATA\n" +
            "\t__objc_class_name_javax_crypto_SecretKey CONSTANT\n" +
            "\t_OBJC_CLASS_javax_crypto_spec_SecretKeySpec DATA\n" +
            "\t__objc_class_name_javax_crypto_spec_SecretKeySpec CONSTANT\n" +
            "\t_OBJC_CLASS_javax_xml_parsers_ParserConfigurationException DATA\n" +
            "\t__objc_class_name_javax_xml_parsers_ParserConfigurationException CONSTANT\n" +
            "\t_OBJC_CLASS_javax_xml_xpath_XPathExpressionException DATA\n" +
            "\t__objc_class_name_javax_xml_xpath_XPathExpressionException CONSTANT\n" +
            "\t_OBJC_CLASS_org_apache_http_client_entity_UrlEncodedFormEntity DATA\n" +
            "\t__objc_class_name_org_apache_http_client_entity_UrlEncodedFormEntity CONSTANT\n" +
            "\t_OBJC_CLASS_org_apache_http_client_methods_HttpPost DATA\n" +
            "\t__objc_class_name_org_apache_http_client_methods_HttpPost CONSTANT\n" +
            "\t_OBJC_CLASS_org_apache_http_message_BasicNameValuePair DATA\n" +
            "\t__objc_class_name_org_apache_http_message_BasicNameValuePair CONSTANT\n" +
            "\t_OBJC_CLASS_org_xml_sax_SAXException DATA\n" +
            "\t__objc_class_name_org_xml_sax_SAXException CONSTANT\n";
}
