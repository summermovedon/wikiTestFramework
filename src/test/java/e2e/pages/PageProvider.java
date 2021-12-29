package e2e.pages;

import static com.codeborne.selenide.WebDriverRunner.url;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

public class PageProvider {

    public ConcurrentHashMap<String, BasePage> pages = new ConcurrentHashMap<>();

    {
        pages.put("^https://ru.wikipedia.org/wiki/[A-Za-zА-Яа-я0-9-+?_,%()]*$", new ArticlePage());
        pages.put("https://ru.wikipedia.org/wiki/Заглавная_страница", new WikiMainPage());
    }

    public BasePage find() {
        for (String key : pages.keySet()) {
            String url = URLDecoder.decode(url(), StandardCharsets.UTF_8);
            if (url.matches(key)) {
                return pages.get(key);
            }
        }
        return new BasePage();
    }


}
