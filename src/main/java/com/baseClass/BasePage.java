package com.baseClass;

import com.Config.NewConnectionsDataConfig;
import com.pages.ConnectionsPage;
import com.pages.ConnectionsPage;
import com.pages.DQ_RulesPage;
import com.pages.Settings;
import org.openqa.selenium.WebDriver;

public class BasePage {
public static WebDriver driver;
public ConnectionsPage connectionspage;
public DQ_RulesPage dqRulepage;
public Settings settings;
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

    public DQ_RulesPage getDQRulepage(){
        return (dqRulepage==null) ? (dqRulepage=new DQ_RulesPage(driver)) : dqRulepage;

    }

    public Settings getSettings(){
        return (settings==null) ? (settings=new Settings(driver)) : settings;

    }

}
