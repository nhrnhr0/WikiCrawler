package sample;

import javafx.geometry.Orientation;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Iterator;

public class WikiNode extends FlowPane {
    WikiNode(WikiPage page) {
        this.page = page;
        url = new Text(page.url);
        linkIterator = page.links.iterator();
        link = new Text(linkIterator.next());
        counter = new Text(Integer.toString(currentLink) + "/" + Integer.toString(page.links.size()));

        this.setOrientation(Orientation.VERTICAL);
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.shri

        this.getChildren().add(url);
        this.getChildren().add(link);
        this.getChildren().add(counter);
    }

    public boolean Next() {
        if(linkIterator.hasNext()) {
            link.setText(linkIterator.next());
            ++currentLink;
            counter.setText(Integer.toString(currentLink) + "/" + Integer.toString(page.links.size()));
            return true;
        }
        return false;
    }

    Text url;
    Text link;
    Text counter;

    WikiPage page;
    Iterator<String> linkIterator;
    int currentLink = 0;
}
