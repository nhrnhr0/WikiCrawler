package sample;

public class Crawler {


    public Crawler(String targetUrl) {
        this(targetUrl, 5);
    }
    public Crawler(String targetUrl, int maxDepth) {
        this.maxDepth = maxDepth;
        this.targetUrl = targetUrl;
    }

    public void Search(String startUrl) {
        CrawlDFS(startUrl, 0);
    }

    public boolean CrawlDFS(String url, int depth) {
        if(depth >= maxDepth) {
            Log.Debug("got to max depth");
            return false;
        }
        WikiPage page = WikiEngine.Instance().get(url);
        for(String link : page.links) {
            if(link.equals(targetUrl)) {
                Log.Info("found target url");
                System.out.println(link);
                return true;
            }
            boolean targetFound = CrawlDFS(link, depth + 1);
            if(targetFound) {
                System.out.println(link);
                return true;
            }
        }


        Log.Error("this link of code should never be executed");
        return false;
    }

    private String targetUrl = "";
    private int maxDepth;
}
