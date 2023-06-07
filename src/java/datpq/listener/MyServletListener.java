/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datpq.listener;

import datpq.util.PropertiesFileHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author ASUS
 */
public class MyServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application is deploying.......................");

//        ServletContext context = sce.getServletContext();
//        String siteMapsPath = context.getInitParameter("SITE_MAPS_FILE_PATH");
//        Properties properties = new Properties();
//        InputStream is = null;
//        try {
//            is = context.getResourceAsStream(siteMapsPath);
//            properties.load(is);
//            context.setAttribute("SITEMAPS", properties);
//            
//        } catch (IOException ex) {
//            context.log("MyServletListener _ IO " + ex.getMessage());
//            
//        }finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException ex) {
//                    context.log("MyServletListener _ IO " + ex.getMessage());
//                }
//            }
//        }
        ServletContext context = sce.getServletContext();
        String siteMapLocation
                = context.getInitParameter(
                        "SITE_MAPS_FILE_PATH");
        Properties siteMapProperty
                = PropertiesFileHelper.getProperties(context,
                        siteMapLocation);
        context.setAttribute("SITEMAPS", siteMapProperty);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application is destoying.......................");
    }
}
