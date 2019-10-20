package edu.northeastern.cs5200.model;

public class ImageWidget extends Widget {
    private String src;

    public ImageWidget(int id, String name, Integer width, Integer height,
                       String cssStyle, String cssClass, String text, Integer order, String src) {
        super(id, name, width, height, cssStyle, cssClass, text, order);
        this.src = src;
        super.setType(WidgetType.IMAGE);
    }

    public void setSrc(String src) {
        this.src = src;
    }
    public String getSrc() {
        return src;
    }
}
