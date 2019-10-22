package edu.northeastern.cs5200.model;

public class YouTubeWidget extends Widget {
    private String url;
    private Boolean sharable;
    private Boolean expandable;

    public YouTubeWidget(int id, String name, Integer width, Integer height,
                         String cssStyle, String cssClass, String text, Integer order,
                         String url, Boolean sharable, Boolean expandable) {
        super(id, name, width, height, cssStyle, cssClass, text, order);
        this.url = url;
        this.sharable = sharable;
        this.expandable = expandable;
        super.setType(WidgetType.YOUTUBE);
    }

    public String getUrl() {
        return url;
    }

    public Boolean isSharable() {
        return sharable;
    }

    public Boolean isExpandable() {
        return expandable;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSharable(Boolean sharable) {
        this.sharable = sharable;
    }

    public void setExpandable(Boolean expandable) {
        this.expandable = expandable;
    }
}
