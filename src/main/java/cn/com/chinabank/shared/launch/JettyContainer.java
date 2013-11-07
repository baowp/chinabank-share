package cn.com.chinabank.shared.launch;

import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.servlet.FilterHolder;
import org.mortbay.jetty.servlet.ServletHandler;
import org.mortbay.jetty.servlet.ServletHolder;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 11/7/13
 * Time: 9:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class JettyContainer implements Container {

    // private static final Logger logger = LoggerFactory.getLogger(JettyContainer.class);

    public static final String JETTY_PORT = "jetty.port";

    public static final int DEFAULT_JETTY_PORT = 8080;

    SelectChannelConnector connector;

    public void start() {
        String serverPort ="12080";// ConfigUtils.getProperty(JETTY_PORT);
        int port;
        if (serverPort == null || serverPort.length() == 0) {
            port = DEFAULT_JETTY_PORT;
        } else {
            port = Integer.parseInt(serverPort);
        }
        connector = new SelectChannelConnector();
        connector.setPort(port);
        ServletHandler handler = new ServletHandler();

        /*String resources = ConfigUtils.getProperty(JETTY_DIRECTORY);
        if (resources != null && resources.length() > 0) {
            FilterHolder resourceHolder = handler.addFilterWithMapping(ResourceFilter.class, "*//*", Handler.DEFAULT);
            resourceHolder.setInitParameter("resources", resources);
        }*/

        ServletHolder pageHolder = handler.addServletWithMapping(DispatcherServlet.class, "/*");
        pageHolder.setInitParameter("contextConfigLocation","classpath*:spring-servlet.xml");
        pageHolder.setInitOrder(2);

        Server server = new Server();
        server.addConnector(connector);
        server.addHandler(handler);
        try {
            server.start();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to start jetty server on " + "NetUtils.getLocalHost()" + ":" + port + ", cause: " + e.getMessage(), e);
        }
    }

    public void stop() {
        try {
            if (connector != null) {
                connector.close();
                connector = null;
            }
        } catch (Throwable e) {
            //TODO logger.error(e.getMessage(), e);
        }
    }

}
