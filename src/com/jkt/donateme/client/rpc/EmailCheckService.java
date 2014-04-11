package com.jkt.donateme.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("email")
public interface EmailCheckService extends RemoteService {
	Boolean validateDuplicateEmail(String email) throws IllegalArgumentException;
}
