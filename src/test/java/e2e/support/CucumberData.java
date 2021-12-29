package e2e.support;

import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;

import e2e.pages.BasePage;
import e2e.pages.PageProvider;

public class CucumberData {

    public static ConcurrentHashMap<Long, WebDriver> drivers = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Long, BasePage> pages = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Long, PageProvider> providers = new ConcurrentHashMap<>();

    public static Long id() {
        return Thread.currentThread().getId();
    }

    public static void setDriver(WebDriver driver) {
        drivers.put(id(), driver);
    }

    public static WebDriver getDriver() {
        return drivers.get(id());
    }

    public static void setPage(BasePage page) {
        pages.put(id(), page);
    }

    public static BasePage getPage() {
        return pages.get(id());
    }

    public static void setProvider(PageProvider provider) {
        providers.put(id(), provider);
    }

    public static PageProvider getProvider() {
        return providers.get(id());
    }

}
