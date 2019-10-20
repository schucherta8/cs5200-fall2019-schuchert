package edu.northeastern.cs5200.model;

public class YouTubeWidget extends Widget {
    private String url;
    private boolean sharable;
    private boolean expandable;

    public YouTubeWidget(int id, String name, Integer width, Integer height,
                         String cssStyle, String cssClass, String text, Integer order,
                         String url, boolean sharable, boolean expandable) {
        super(id, name, width, height, cssStyle, cssClass, text, order);
        this.url = url;
        this.sharable = sharable;
        this.expandable = expandable;
        super.setType(WidgetType.YOUTUBE);
    }
}
