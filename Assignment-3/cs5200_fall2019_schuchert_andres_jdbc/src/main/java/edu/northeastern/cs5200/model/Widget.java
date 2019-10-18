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
	//Adding this:
	private Integer size;
	private String html;
	private String src;
	private String url;
	private boolean shareable;
	private boolean expandable;
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
		size = null;
		html = null;
		src = null;
		url = null;
		shareable = false;
		expandable = false;
	}
	
	public Widget(int id, String name, Integer width, Integer height,
			String cssStyle, String cssClass, String text, Integer order, Integer size,
			String html, String src, String url, Boolean shareable, Boolean expandable, WidgetType TYPE) {
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssStyle = cssStyle;
		this.cssClass = cssClass;
		this.text = text;
		this.order = order;
		this.size = size;
		this.html = html;
		this.src = src;
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
		this.TYPE = TYPE;
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
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isShareable() {
		return shareable;
	}

	public void setShareable(boolean shareable) {
		this.shareable = shareable;
	}

	public boolean isExpandable() {
		return expandable;
	}

	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	public void setType(WidgetType TYPE) {
		this.TYPE = TYPE;
	}
	public WidgetType getType() {
		return TYPE;
	}
}
