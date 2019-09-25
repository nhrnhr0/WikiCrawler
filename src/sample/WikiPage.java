package sample;

import java.util.HashSet;
import java.util.Set;

public class WikiPage {

    public String url = "";
    public Set<String> links;

    public WikiPage() {
        links = new HashSet<>();
    }
}
