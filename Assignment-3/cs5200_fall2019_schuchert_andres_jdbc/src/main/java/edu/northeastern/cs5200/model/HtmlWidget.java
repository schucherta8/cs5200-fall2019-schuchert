package edu.northeastern.cs5200.model;

public class HtmlWidget extends Widget {
	private String html;
	
	public HtmlWidget(int id, String name, Integer width, Integer height, String cssStyle, String cssClass, String text,
			Integer order, String html) {
		super(id, name, width, height, cssStyle, cssClass, text, order);
		this.html = html;
		super.setType(WidgetType.HTML);
	}
	
	public void setHtml(String html) {
		this.html = html;
	}
	
	public String getHtml() {
		return html;
	}
}
