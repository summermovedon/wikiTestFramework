package e2e.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$;

import java.util.concurrent.ConcurrentHashMap;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class BasePage {

    public ConcurrentHashMap<String, String> one = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, String> many = new ConcurrentHashMap<>();

    public SelenideElement find(String name) {
        SelenideElement element = $(one.get(name));
        if (element.exists()) {
            return element;
        }
        if (name.startsWith("//")) {
            return $x(name);
        }
        return $(name);
    }

    public ElementsCollection all(String name) {
        return $$(one.get(name));
    }
}
