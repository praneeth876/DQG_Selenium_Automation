package com.baseClass;

import com.Config.NewConnectionsDataConfig;
import com.pages.ConnectionsPage;
import com.pages.ConnectionsPage;
import org.openqa.selenium.WebDriver;

public class BasePage {
public static WebDriver driver;
public ConnectionsPage connectionspage;
//    NewConnectionsDataConfig dataConfig=new NewConnectionsDataConfig();
//
////    public BasePage(WebDriver driver) {
////        this.driver=driver;
////    }
//
    public ConnectionsPage getConnectionspage()
    {

        return (connectionspage==null) ? (connectionspage=new ConnectionsPage(driver)) : connectionspage;
    }


}
