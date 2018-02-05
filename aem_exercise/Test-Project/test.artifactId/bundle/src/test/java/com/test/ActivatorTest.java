package com.test;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import com.adobe.cq.social.commons.bundleactivator.Activator;

import mockit.Cascading;
import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Tested;


public class ActivatorTest {
    
}
  
/*
    @Tested
    Activator activatorToTest;
    @Cascading
    FrameworkUtil frameworkUtil;
    @Cascading
    BundleContext bundleContext;
    @Mocked
    ServiceReference serviceReference;
    @Mocked
    SlingRepository repository;
    @Mocked
    Bundle bundle;
    @Mocked
    ResourceResolverFactory factory;
 
    @Mocked
    ResourceResolver resourceResolver;

    @Test
    public final void testStart() throws Exception {

        new Expectations() {
            {
                bundleContext.getBundle().getSymbolicName();
                returns(anyString);
                
                FrameworkUtil.getBundle(SlingRepository.class).getBundleContext();
                result = bundleContext;
                
                bundleContext.getServiceReference(SlingRepository.class.getName());
                result = serviceReference;

                bundleContext.getService(serviceReference);
                result = repository;

                FrameworkUtil.getBundle(ResourceResolverFactory.class).getBundleContext();
                result = bundleContext;

                bundleContext.getServiceReference(ResourceResolverFactory.class.getName());
                result = serviceReference;

                bundleContext.getService(serviceReference);
                result = factory;


            }
        };

        activatorToTest.start(bundleContext);
    }

    @Test
    public final void testStop() throws Exception {

        new NonStrictExpectations() {
            {
                bundleContext.getBundle().getSymbolicName();
                returns(anyString);
                
                
            }
        };
       
        activatorToTest.stop(bundleContext);
    }

    @Test
    public final void testStartFailure() throws Exception {
        new NonStrictExpectations() {
            {
                bundleContext.getBundle().getSymbolicName();
                returns(anyString);
                
                FrameworkUtil.getBundle(SlingRepository.class).getBundleContext();
                result = bundleContext;
                
                bundleContext.getServiceReference(SlingRepository.class.getName());
                result = serviceReference;

                bundleContext.getService(serviceReference);
                result = repository;

                FrameworkUtil.getBundle(ResourceResolverFactory.class).getBundleContext();
                result = bundleContext;

                bundleContext.getServiceReference(ResourceResolverFactory.class.getName());
                result = serviceReference;

                bundleContext.getService(serviceReference);
                result = factory;

                factory.getAdministrativeResourceResolver(null);


            }
        };
        activatorToTest.start(bundleContext);
    }
}
*/