package com.jkt.donateme.client.model;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SignUpFields_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getConfirmPassword(com.jkt.donateme.client.model.SignUpFields instance) /*-{
    return instance.@com.jkt.donateme.client.model.SignUpFields::confirmPassword;
  }-*/;
  
  private static native void setConfirmPassword(com.jkt.donateme.client.model.SignUpFields instance, java.lang.String value) 
  /*-{
    instance.@com.jkt.donateme.client.model.SignUpFields::confirmPassword = value;
  }-*/;
  
  private static native java.lang.String getDob(com.jkt.donateme.client.model.SignUpFields instance) /*-{
    return instance.@com.jkt.donateme.client.model.SignUpFields::dob;
  }-*/;
  
  private static native void setDob(com.jkt.donateme.client.model.SignUpFields instance, java.lang.String value) 
  /*-{
    instance.@com.jkt.donateme.client.model.SignUpFields::dob = value;
  }-*/;
  
  private static native java.lang.String getEmail(com.jkt.donateme.client.model.SignUpFields instance) /*-{
    return instance.@com.jkt.donateme.client.model.SignUpFields::email;
  }-*/;
  
  private static native void setEmail(com.jkt.donateme.client.model.SignUpFields instance, java.lang.String value) 
  /*-{
    instance.@com.jkt.donateme.client.model.SignUpFields::email = value;
  }-*/;
  
  private static native java.lang.String getFirstName(com.jkt.donateme.client.model.SignUpFields instance) /*-{
    return instance.@com.jkt.donateme.client.model.SignUpFields::firstName;
  }-*/;
  
  private static native void setFirstName(com.jkt.donateme.client.model.SignUpFields instance, java.lang.String value) 
  /*-{
    instance.@com.jkt.donateme.client.model.SignUpFields::firstName = value;
  }-*/;
  
  private static native java.lang.String getGender(com.jkt.donateme.client.model.SignUpFields instance) /*-{
    return instance.@com.jkt.donateme.client.model.SignUpFields::gender;
  }-*/;
  
  private static native void setGender(com.jkt.donateme.client.model.SignUpFields instance, java.lang.String value) 
  /*-{
    instance.@com.jkt.donateme.client.model.SignUpFields::gender = value;
  }-*/;
  
  private static native java.lang.String getLastName(com.jkt.donateme.client.model.SignUpFields instance) /*-{
    return instance.@com.jkt.donateme.client.model.SignUpFields::lastName;
  }-*/;
  
  private static native void setLastName(com.jkt.donateme.client.model.SignUpFields instance, java.lang.String value) 
  /*-{
    instance.@com.jkt.donateme.client.model.SignUpFields::lastName = value;
  }-*/;
  
  private static native java.lang.String getPassword(com.jkt.donateme.client.model.SignUpFields instance) /*-{
    return instance.@com.jkt.donateme.client.model.SignUpFields::password;
  }-*/;
  
  private static native void setPassword(com.jkt.donateme.client.model.SignUpFields instance, java.lang.String value) 
  /*-{
    instance.@com.jkt.donateme.client.model.SignUpFields::password = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.jkt.donateme.client.model.SignUpFields instance) throws SerializationException {
    setConfirmPassword(instance, streamReader.readString());
    setDob(instance, streamReader.readString());
    setEmail(instance, streamReader.readString());
    setFirstName(instance, streamReader.readString());
    setGender(instance, streamReader.readString());
    setLastName(instance, streamReader.readString());
    setPassword(instance, streamReader.readString());
    
  }
  
  public static com.jkt.donateme.client.model.SignUpFields instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.jkt.donateme.client.model.SignUpFields();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.jkt.donateme.client.model.SignUpFields instance) throws SerializationException {
    streamWriter.writeString(getConfirmPassword(instance));
    streamWriter.writeString(getDob(instance));
    streamWriter.writeString(getEmail(instance));
    streamWriter.writeString(getFirstName(instance));
    streamWriter.writeString(getGender(instance));
    streamWriter.writeString(getLastName(instance));
    streamWriter.writeString(getPassword(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.jkt.donateme.client.model.SignUpFields_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.jkt.donateme.client.model.SignUpFields_FieldSerializer.deserialize(reader, (com.jkt.donateme.client.model.SignUpFields)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.jkt.donateme.client.model.SignUpFields_FieldSerializer.serialize(writer, (com.jkt.donateme.client.model.SignUpFields)object);
  }
  
}
