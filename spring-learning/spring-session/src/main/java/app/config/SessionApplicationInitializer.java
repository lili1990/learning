package app.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import javax.servlet.ServletContext;

/**
 * Created by sdlili on 17-3-19.
 */
public class SessionApplicationInitializer extends AbstractHttpSessionApplicationInitializer {

    protected void afterSessionRepositoryFilter(ServletContext servletContext) {
//        servletContext.addListener(new HttpSessionEventPublisher());
    }

}
