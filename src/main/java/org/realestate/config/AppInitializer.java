/**
 * We created the WebConfig configuration class, but for now it's just a separate class, it doesn't affect our
 * application in any way. We need to register this configuration with the Spring context.
 * This requires the AbstractAnnotationConfigDispatcherServletInitializer class.
 * In the config package, create its successor, let's say AppInitializer, and implement its methods.
 */

package org.realestate.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * getRootConfigClasses() -- for "root" application context (non-web infrastructure) configuration.
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HibernateConfig.class};
    }

    /**
     * Web configurations, where ViewResolvers are defined, are placed in getServletConfigClasses().
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * The getServletMappings() method registers addresses.
     * @return address as String.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}