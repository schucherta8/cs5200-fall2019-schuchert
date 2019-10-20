package edu.northeastern.cs5200.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.model.Page;
import edu.northeastern.cs5200.model.Widget;
import edu.northeastern.cs5200.model.WidgetType;

public class WidgetImpl implements WidgetDao {
	
	private static final String CREATE_HEADING_WIDGET = "INSERT INTO widget_generalization "
			+ "(widget_id, name, d_type, text, order, width, height, css_class, css_style, page_id, size) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String CREATE_HTML_WIDGET = "INSERT INTO widget_generalization "
			+ "(widget_id, name, d_type, text, order, width, height, css_class, css_style, page_id, html) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String CREATE_IMAGE_WIDGET = "INSERT INTO widget_generalization "
			+ "(widget_id, name, d_type, text, order, width, height, css_class, css_style, page_id, image_src) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String CREATE_YOUTUBE_WIDGET = "INSERT INTO widget_generalization "
			+ "(widget_id, name, d_type, text, order, width, height, css_class, css_style, page_id, "
			+ "youtube_url, youtube_shareable, youtube_expandable) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String FIND_ALL_WIDGETS = "SELECT * FROM widget_generalization";
	private static final String FIND_WIDGET_BY_ID = "SELECT * FROM widget_generalization "
			+ "WHERE widget_generalization.widget_id = ?";
	private static final String FIND_WIDGETS_FOR_PAGE = "SELECT * FROM widget_generalization "
			+ "WHERE widget_generalization.page_id = ?";
	private static final String UPDATE_WIDGET = "";
	private static final String DELETE_WIDGET = "DELETE FROM widget_generalization "
			+ "WHERE widget_generalization.widget_id = ?";
	private static WidgetImpl instance = null;
	
	private WidgetImpl() {}
	
	public static WidgetImpl getInstance() {
		if(instance == null) {
			instance = new WidgetImpl();
		}
		return instance;
	}
	
	@Override
	public void createWidgetForPage(int pageId, Widget widget) {
		// TODO Auto-generated method stub
		//What happens if they pass a widget object that doesnt take an enum value?
		//How do we handle it? DEFAULT ENUM
		//In the assignment the widget doesnt have an id, can we assign some random id value or use last assignemnts id?
		//YES
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = null;
			PageImpl pagedao = PageImpl.getInstance();
			Page page = pagedao.findPageById(pageId);
			page.insertWidget(widget);
			switch(widget.getType()) {
			case HEADING:
				statement = conn.prepareStatement(CREATE_HEADING_WIDGET);
				statement.setInt(1, widget.getId());
				statement.setString(2, widget.getName());
				statement.setString(3, widget.getType().name());
				statement.setString(4,widget.getText());
				statement.setInt(5, widget.getOrder());
				statement.setInt(6, widget.getWidth());
				statement.setInt(7, widget.getHeight());
				statement.setString(8, widget.getCssClass());
				statement.setString(9, widget.getCssStyle());
				statement.setInt(10, pageId);
				statement.setInt(11, widget.getSize());
				break;
			case HTML:
				statement = conn.prepareStatement(CREATE_HTML_WIDGET);
				statement.setInt(1, widget.getId());
				statement.setString(2, widget.getName());
				statement.setString(3, widget.getType().name());
				statement.setString(4,widget.getText());
				statement.setInt(5, widget.getOrder());
				statement.setInt(6, widget.getWidth());
				statement.setInt(7, widget.getHeight());
				statement.setString(8, widget.getCssClass());
				statement.setString(9, widget.getCssStyle());
				statement.setInt(10, pageId);
				statement.setString(11, widget.getHtml());
				break;
			case IMAGE:
				statement = conn.prepareStatement(CREATE_IMAGE_WIDGET);
				statement.setInt(1, widget.getId());
				statement.setString(2, widget.getName());
				statement.setString(3, widget.getType().name());
				statement.setString(4,widget.getText());
				statement.setInt(5, widget.getOrder());
				statement.setInt(6, widget.getWidth());
				statement.setInt(7, widget.getHeight());
				statement.setString(8, widget.getCssClass());
				statement.setString(9, widget.getCssStyle());
				statement.setInt(10, pageId);
				statement.setString(11, widget.getSrc());
				break;
			case YOUTUBE:
				statement = conn.prepareStatement(CREATE_YOUTUBE_WIDGET);
				statement.setInt(1, widget.getId());
				statement.setString(2, widget.getName());
				statement.setString(3, widget.getType().name());
				statement.setString(4,widget.getText());
				statement.setInt(5, widget.getOrder());
				statement.setInt(6, widget.getWidth());
				statement.setInt(7, widget.getHeight());
				statement.setString(8, widget.getCssClass());
				statement.setString(9, widget.getCssStyle());
				statement.setInt(10, pageId);
				statement.setString(11,widget.getUrl());
				statement.setBoolean(13, widget.isShareable());
				statement.setBoolean(12, widget.isExpandable());
				break;
			default:
				break;
			}
			statement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Widget> findAllWidgets() {
		// TODO Auto-generated method stub
		Collection<Widget> widgets = null;
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_ALL_WIDGETS);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				int id = res.getInt("widget_id");
				int pageId = res.getInt("page_id");
				String name = res.getString("name");
				WidgetType type = WidgetType.valueOf(res.getString("d_type"));
				String text = res.getString("text");
				Integer order = res.getInt("order");
				Integer width = res.getInt("width");
				Integer height = res.getInt("height");
				String cssClass = res.getString("css_class");
				String cssStyle = res.getString("css_style");
				Integer size = res.getInt("heading_size");
				String html = res.getString("html");
				String src = res.getString("image_src");
				String url = res.getString("youtube_url");
				boolean sharable = res.getBoolean("youtube_sharable");
				boolean expandable = res.getBoolean("youtube_expandable");
				Widget widget = new Widget(id,name,width,height,cssStyle,cssClass,text,order,
						size,html,src,url,sharable,expandable,type);
				widget.setPageId(pageId);
				widgets.add(widget);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return widgets;
	}

	@Override
	public Widget findWidgetById(int widgetId) {
		// TODO Auto-generated method stub
		Widget widget = null;
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_WIDGET_BY_ID);
			ResultSet res = statement.executeQuery();
			if(res.next()){
				int id = res.getInt("widget_id");
				int pageId = res.getInt("page_id");
				String name = res.getString("name");
				WidgetType type = WidgetType.valueOf(res.getString("d_type"));
				String text = res.getString("text");
				Integer order = res.getInt("order");
				Integer width = res.getInt("width");
				Integer height = res.getInt("height");
				String cssClass = res.getString("css_class");
				String cssStyle = res.getString("css_style");
				Integer size = res.getInt("heading_size");
				String html = res.getString("html");
				String src = res.getString("image_src");
				String url = res.getString("youtube_url");
				boolean sharable = res.getBoolean("youtube_sharable");
				boolean expandable = res.getBoolean("youtube_expandable");
				widget = new Widget(id,name,width,height,cssStyle,cssClass,text,order,
						size,html,src,url,sharable,expandable,type);
				widget.setPageId(pageId);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return widget;
	}

	@Override
	public Collection<Widget> findWidgetsForPage(int pageId) {
		// TODO Auto-generated method stub
		Collection<Widget> widgets = new ArrayList<>();
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_WIDGETS_FOR_PAGE);
			statement.setInt(1,pageId);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				int id = res.getInt("widget_id");
				pageId = res.getInt("page_id");
				String name = res.getString("name");
				WidgetType type = WidgetType.valueOf(res.getString("d_type"));
				String text = res.getString("text");
				Integer order = res.getInt("order");
				Integer width = res.getInt("width");
				Integer height = res.getInt("height");
				String cssClass = res.getString("css_class");
				String cssStyle = res.getString("css_style");
				Integer size = res.getInt("heading_size");
				String html = res.getString("html");
				String src = res.getString("image_src");
				String url = res.getString("youtube_url");
				boolean sharable = res.getBoolean("youtube_sharable");
				boolean expandable = res.getBoolean("youtube_expandable");
				Widget widget = new Widget(id,name,width,height,cssStyle,cssClass,text,order,
						size,html,src,url,sharable,expandable,type);
				widget.setPageId(pageId);
				widgets.add(widget);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return widgets;
	}

	@Override
	public int updateWidget(int widgetId, Widget widget) {
		// TODO Auto-generated method stub
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_WIDGET);

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteWidget(int widgetId) {
		// TODO Auto-generated method stub
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_WIDGET);
			statement.setInt(1,widgetId);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
