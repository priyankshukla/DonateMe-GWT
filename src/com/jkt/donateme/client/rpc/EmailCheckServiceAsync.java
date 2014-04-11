package com.jkt.donateme.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */

public interface EmailCheckServiceAsync {

	void validateDuplicateEmail(String email, AsyncCallback<Boolean> callback);
}
