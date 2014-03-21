package com.jkt.donateme.client.rpc;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class SignUpService_Proxy extends RemoteServiceProxy implements com.jkt.donateme.client.rpc.SignUpServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "com.jkt.donateme.client.rpc.SignUpService";
  private static final String SERIALIZATION_POLICY ="DF72AAE47B18D53643889EC538E2098B";
  private static final com.jkt.donateme.client.rpc.SignUpService_TypeSerializer SERIALIZER = new com.jkt.donateme.client.rpc.SignUpService_TypeSerializer();
  
  public SignUpService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "greet", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void signUpServer(com.jkt.donateme.client.model.SignUpFields signUpFields, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("SignUpService_Proxy", "signUpServer");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("com.jkt.donateme.client.model.SignUpFields/2922413469");
      streamWriter.writeObject(signUpFields);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
