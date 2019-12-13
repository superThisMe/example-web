package com.exampleWeb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ExampleListener implements ServletContextListener, HttpSessionListener {

    // 웹 애플리케이션이 시작될 때 호출되는 메서드
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("웹 애플리케이션이 시작되었습니다.");
    }

    // 세션이 처음 시작될 때 호출되는 메서드
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("세션이 시작되었습니다.");
    }

    // 세셩이 종료될 때 호출되는 메서드
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("세션이이 종료되었습니다.");
    }

    // 웹 애플리케이션이 종료될 때 호출되는 메서드
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("웹 애플리케이션이 종료되었습니다.");
    }
	
}
