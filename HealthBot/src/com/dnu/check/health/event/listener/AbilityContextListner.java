package com.dnu.check.health.event.listener;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.dnu.check.health.annotations.Ability;
import com.dnu.check.health.constants.Constants;
import com.dnu.check.health.exceptions.GenericException;
import com.dnu.check.health.exceptions.NoAblilityConfigException;
import com.dnu.check.health.utils.ClassScanner;

@WebListener
public class AbilityContextListner implements ServletContextListener {

	
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 4198953301865193126L;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + AbilityContextListner.contextInitialized() + + + + + + + + + + + + + + + + + + + + + +");
		ServletContext context = event.getServletContext();
		String configFile = context.getInitParameter(Constants.CONTEXTCONFIG.toString());
		
		if(configFile == null || configFile.isEmpty()) {
			throw new NoAblilityConfigException("Failed to load ability configuration. Please check your application classpath");
		}
		
		ArrayList<String> packages = new ArrayList<String>();
		HashMap<String,String> connectionParameter = new HashMap<String,String>();
		//XML Parsing starts ----- put this in separate class
		DocumentBuilderFactory xmlFactory = null;
		DocumentBuilder xmlParseBuilder = null;
		Document xmlStructure = null;
		NodeList packageNodes = null;
		NodeList connectionNodes = null;
		ArrayList<Object> classes = null;
		HashMap<String,Object> strategies = new HashMap<String,Object>();
		try {
			//xmlConfig = new FileInputStream();
			xmlFactory = DocumentBuilderFactory.newInstance();
			xmlParseBuilder = xmlFactory.newDocumentBuilder();
			xmlStructure = xmlParseBuilder.parse(new File(configFile));
			packageNodes = xmlStructure.getElementsByTagName(Constants.PACKAGE.toString());
			connectionNodes = xmlStructure.getElementsByTagName(Constants.PROPERTY.toString());
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			if(packageNodes.getLength() <= 0 ||  connectionNodes.getLength() <= 0) {
				throw new GenericException("Not able to detect");
			}
			for(int walker=0; walker<packageNodes.getLength(); walker++) {
				packages.add(packageNodes.item(walker).getFirstChild().getNodeValue());
			}
			System.out.println("Packages: " + packages);
			for(int walker=0; walker<connectionNodes.getLength(); walker++) {
				connectionParameter.put(connectionNodes.item(walker).getAttributes().item(0).getNodeName(), connectionNodes.item(walker).getFirstChild().getNodeValue());
			}

			for(String pkg : packages) {
				try {
					classes = ClassScanner.getClasses(pkg);
					Class<?> objClass = loader.loadClass(classes.toString());
					Annotation annotation = objClass.getAnnotation(Ability.class);
					if(annotation != null) {
						Ability ability = (Ability) annotation;
						strategies.put(ability.name(),objClass.newInstance());
					}
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException e) {
					throw new GenericException("Not able instantiate classes inside the package " + pkg + " . " + e.getMessage(), e);
				}
			}
			System.out.println("Strategies: " + strategies);
			System.out.println("Connection Parameter: " + connectionParameter);
			context.setAttribute(Constants.STRATEGIES.toString(), strategies);
			context.setAttribute(Constants.CONNECTION.toString(), connectionParameter);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new NoAblilityConfigException("Not able to parse Ability configuration. " + e.getMessage(),e);
		} 
	}
}
