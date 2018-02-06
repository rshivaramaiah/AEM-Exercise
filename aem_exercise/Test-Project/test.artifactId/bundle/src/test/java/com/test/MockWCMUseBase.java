package com.test;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingScriptHelper;

import com.adobe.cq.sightly.SightlyWCMMode;
import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

public abstract class MockWCMUseBase {

	@Mocked
	protected ValueMap map;

	@Mocked
	protected Resource resource;

	@Mocked
	protected PageManager pageManager;

	@Mocked
	protected SlingScriptHelper slingScriptHelper;

	@Mocked
	protected Page page;

	@Mocked
	protected ResourceResolver resourceResolver;

	@Mocked
	protected SlingHttpServletRequest request;

	@Mocked
	protected ValueMap pageProperties;

	@Mocked
	protected SlingHttpServletResponse response;

	@Mocked
	protected SightlyWCMMode wcmmode;

	protected void init() {
		new MockUp<WCMUsePojo>() {
			@Mock
			public ValueMap getProperties() {
				return map;
			}

			@Mock
			public Resource getResource() {
				return resource;
			}

			@Mock
			public PageManager getPageManager() {
				return pageManager;
			}

			@Mock
			public SlingScriptHelper getSlingScriptHelper() {
				return slingScriptHelper;
			}

			@Mock
			public Page getCurrentPage() {
				return page;
			}

			@Mock
			ResourceResolver getResourceResolver() {

				return resourceResolver;
			}

			@Mock
			SlingHttpServletRequest getRequest() {

				return request;
			}

			@Mock
			ValueMap getPageProperties() {
				return pageProperties;
			}

			@Mock
			SlingHttpServletResponse getResponse() {
				return response;
			}

			@Mock
			SightlyWCMMode getWcmMode() {
				return wcmmode;
			}

			@SuppressWarnings("unchecked")
			@Mock
			<T> T get(String s, Class<T> c) {
				return (T) "string";
			}

		};
	}
}
