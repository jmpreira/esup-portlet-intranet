package org.esup.portlet.intranet.domain.nuxeo;

import org.nuxeo.ecm.automation.client.model.Documents;
import org.nuxeo.ecm.automation.client.model.FileBlob;
import org.nuxeo.ecm.automation.client.model.PaginableDocuments;

/**
 * Nuxeo Service
 * @author jpark
 *
 */
public interface NuxeoService {
	public Documents getList(NuxeoResource nuxeoResource) throws Exception;
	public Documents search(NuxeoResource nuxeoResource, String key) throws Exception;
	public PaginableDocuments news(NuxeoResource nuxeoResource, int pageSize) throws Exception;
	public FileBlob getFile(NuxeoResource nuxeoResource, String uid) throws Exception;
}