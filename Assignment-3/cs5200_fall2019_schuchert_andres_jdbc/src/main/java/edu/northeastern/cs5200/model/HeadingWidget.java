package edu.northeastern.cs5200.model;

public class HeadingWidget extends Widget{
	private Integer size;
	
	public HeadingWidget(int id, String name, Integer width, Integer height, String cssStyle, String cssClass,
			String text, Integer order, Integer size) {
		super(id, name, width, height, cssStyle, cssClass, text, order);
		this.size = size;
		super.setType(WidgetType.HEADING);
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getSize() {
		return size;
	}
}
