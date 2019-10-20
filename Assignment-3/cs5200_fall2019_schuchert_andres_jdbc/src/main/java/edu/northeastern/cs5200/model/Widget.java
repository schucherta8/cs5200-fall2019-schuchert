package edu.northeastern.cs5200.model;

public class Widget {
	private int id;
	private int pageId;
	private String name;
	private Integer width;
	private Integer height;
	private String cssClass;
	private String cssStyle;
	private String text;
	private Integer order;
	private WidgetType TYPE;

	public Widget(int id, String name, Integer width, Integer height,
			String cssStyle, String cssClass, String text, Integer order) {
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssStyle = cssStyle;
		this.cssClass = cssClass;
		this.text = text;
		this.order = order;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public String getCssStyle() {
		return cssStyle;
	}
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public void setType(WidgetType TYPE) {
		this.TYPE = TYPE;
	}
	public WidgetType getType() {
		return TYPE;
	}
}
