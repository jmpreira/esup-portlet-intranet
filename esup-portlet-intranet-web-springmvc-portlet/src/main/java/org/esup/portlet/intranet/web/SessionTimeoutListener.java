package org.esup.portlet.intranet.web;

import javax.servlet.http.HttpSessionEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.session.HttpSessionEventPublisher;

public class SessionTimeoutListener extends HttpSessionEventPublisher{

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		
		ApplicationContext appContext = ApplicationContextProvider.getAppContext();
	    SessionRegistry sessionRegistry = appContext.getBean("sessionRegistry", SessionRegistry.class);	    
	    
	    SessionInformation sessionInfo = (sessionRegistry != null ? 
	    		sessionRegistry.getSessionInformation(event.getSession().getId()) : null);
	    NuxeoResource userSession = null;
	    if (sessionInfo != null) {
	    	userSession = (NuxeoResource) sessionInfo.getPrincipal();
	    }
	    if (userSession != null) {
	    	userSession.expireSession();
	    }
	    super.sessionDestroyed(event);
	}
	
}
