package edu.northeastern.cs5200.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import edu.northeastern.cs5200.Connection;

import edu.northeastern.cs5200.model.*;

public class WidgetImpl implements WidgetDao {

	private static final String CREATE_HEADING_WIDGET = "INSERT INTO widget_generalization "
			+ "(widget_id, `name`, d_type, `text`, `order`, width, height, css_class, css_style, page_id, heading_size) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String CREATE_HTML_WIDGET = "INSERT INTO widget_generalization "
			+ "(widget_id, `name`, d_type, `text`, `order`, width, height, css_class, css_style, page_id, html) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String CREATE_IMAGE_WIDGET = "INSERT INTO widget_generalization "
			+ "(widget_id, `name`, d_type, `text`, `order`, width, height, css_class, css_style, page_id, image_src) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String CREATE_YOUTUBE_WIDGET = "INSERT INTO widget_generalization "
			+ "(widget_id, `name`, d_type, `text`, `order`, width, height, css_class, css_style, page_id, "
			+ "youtube_url, youtube_shareable, youtube_expandable) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	private static final String FIND_ALL_WIDGETS = "SELECT * FROM widget_generalization";
	private static final String FIND_WIDGET_BY_ID = "SELECT * FROM widget_generalization "
			+ "WHERE widget_generalization.widget_id = ?";
	private static final String FIND_WIDGETS_FOR_PAGE = "SELECT * FROM widget_generalization "
			+ "WHERE widget_generalization.page_id = ?";
	private static final String UPDATE_HEADING_WIDGET = "UPDATE widget_generalization " +
			"SET d_type = ?, `name` = ?, `text` = ?,`order` = ?, width = ?, height = ?," +
			" css_class = ?, css_style = ?,  heading_size = ? " +
			"WHERE widget_generalization.widget_id = ?";
	private static final String UPDATE_HTML_WIDGET = "UPDATE widget_generalization " +
			"SET d_type = ?, `name` = ?, `text` = ?, `order` = ?, width = ?, height = ?," +
			" css_class = ?, css_style = ?,  html = ? " +
			"WHERE widget_generalization.widget_id = ?";
	private static final String UPDATE_IMAGE_WIDGET = "UPDATE widget_generalization " +
			"SET d_type = ?, `name` = ?, `text` = ?, `order` = ?, width = ?, height = ?," +
			" css_class = ?, css_style = ?, image_src = ? " +
			"WHERE widget_generalization.widget_id = ?";
	private static final String UPDATE_YOUTUBE_WIDGET = "UPDATE widget_generalization " +
			"SET d_type = ?, `name` = ?, `text` = ?, `order` = ?, width = ?, height = ?," +
			" css_class = ?, css_style = ?, " +
			" youtube_url = ?, youtube_sharable = ?, youtube_expandable = ? " +
			"WHERE widget_generalization.widget_id = ?";

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
		try {

			PageImpl pagedao = PageImpl.getInstance();
			Page page = pagedao.findPageById(pageId);
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = null;
			switch(widget.getType()) {
			case HEADING:
				if(widget instanceof HeadingWidget){
					statement = conn.prepareStatement(CREATE_HEADING_WIDGET);
					statement.setInt(1, widget.getId());
					statement.setString(2, widget.getName());
					statement.setString(3, widget.getType().name());
					statement.setString(4,widget.getText());
					statement.setObject(5, widget.getOrder(),Types.INTEGER);
					statement.setObject(6, widget.getWidth(),Types.INTEGER);
					statement.setObject(7, widget.getHeight(), Types.INTEGER);
					statement.setString(8, widget.getCssClass());
					statement.setString(9, widget.getCssStyle());
					statement.setInt(10	, pageId);
					statement.setObject(11, ((HeadingWidget)widget).getSize(),Types.INTEGER);
					page.insertWidget(widget);
					statement.executeUpdate();
				}
				break;
			case HTML:
				if(widget instanceof HtmlWidget){
					statement = conn.prepareStatement(CREATE_HTML_WIDGET);
					statement.setInt(1, widget.getId());
					statement.setString(2, widget.getName());
					statement.setString(3, widget.getType().name());
					statement.setString(4,widget.getText());
					statement.setObject(5, widget.getOrder(),Types.INTEGER);
					statement.setObject(6, widget.getWidth(),Types.INTEGER);
					statement.setObject(7, widget.getHeight(),Types.INTEGER);
					statement.setString(8, widget.getCssClass());
					statement.setString(9, widget.getCssStyle());
					statement.setInt(10	, pageId);
					statement.setString(11, ((HtmlWidget)widget).getHtml());
					page.insertWidget(widget);
					statement.executeUpdate();
				}
				break;
			case IMAGE:
				if(widget instanceof ImageWidget){
					statement = conn.prepareStatement(CREATE_IMAGE_WIDGET);
					statement.setInt(1, widget.getId());
					statement.setString(2, widget.getName());
					statement.setString(3, widget.getType().name());
					statement.setString(4,widget.getText());
					statement.setObject(5, widget.getOrder(),Types.INTEGER);
					statement.setObject(6, widget.getWidth(),Types.INTEGER);
					statement.setObject(7, widget.getHeight(),Types.INTEGER);
					statement.setString(8, widget.getCssClass());
					statement.setString(9, widget.getCssStyle());
					statement.setInt(10	, pageId);
					statement.setString(11, ((ImageWidget)widget).getSrc());
					page.insertWidget(widget);
					statement.executeUpdate();
				}
				break;
			case YOUTUBE:
				if(widget instanceof YouTubeWidget){
					statement = conn.prepareStatement(CREATE_YOUTUBE_WIDGET);
					statement.setInt(1, widget.getId());
					statement.setString(2, widget.getName());
					statement.setString(3, widget.getType().name());
					statement.setString(4,widget.getText());
					statement.setObject(5, widget.getOrder(),Types.INTEGER);
					statement.setObject(6, widget.getWidth(),Types.INTEGER);
					statement.setObject(7, widget.getHeight(),Types.INTEGER);
					statement.setString(8, widget.getCssClass());
					statement.setString(9, widget.getCssStyle());
					statement.setInt(10	, pageId);
					statement.setString(11, ((YouTubeWidget)widget).getUrl());
					statement.setBoolean(11, ((YouTubeWidget)widget).isSharable());
					statement.setBoolean(11, ((YouTubeWidget)widget).isExpandable());
					page.insertWidget(widget);
					statement.executeUpdate();
				}
				break;
			default:
				break;
			}
			Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Widget> findAllWidgets() {
		// TODO Auto-generated method stub
		Collection<Widget> widgets = new LinkedList<>();
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
				Widget widget = null;
				switch (type){
					case HEADING:
						Integer size = res.getInt("heading_size");
						widget = new HeadingWidget(id,name,width,height,
								cssStyle,cssClass,text,order,size);
						break;
					case HTML:
						String html = res.getString("html");
						widget = new HtmlWidget(id,name,width,height,
								cssStyle,cssClass,text,order,html);
						break;
					case IMAGE:
						String src = res.getString("image_src");
						widget = new ImageWidget(id,name,width,height,
								cssStyle,cssClass,text,order,src);
						break;
					case YOUTUBE:
						String url = res.getString("youtube_url");
						boolean sharable = res.getBoolean("youtube_sharable");
						boolean expandable = res.getBoolean("youtube_expandable");
						widget = new YouTubeWidget(id,name,width,height,
								cssStyle,cssClass,text,order,url,sharable,expandable);
						break;
				}
				widget.setPageId(pageId);
				widgets.add(widget);
			}
			Connection.closeConnection();
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
			statement.setInt(1,widgetId);
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
				switch (type){
					case HEADING:
						Integer size = res.getInt("heading_size");
						widget = new HeadingWidget(id,name,width,height,cssStyle,cssClass,text,order,size);
						break;
					case HTML:
						String html = res.getString("html");
						widget = new HtmlWidget(id,name,width,height,cssStyle,cssClass,text,order,html);
						break;
					case IMAGE:
						String src = res.getString("image_src");
						widget = new ImageWidget(id,name,width,height,cssStyle,cssClass,text,order,src);
						break;
					case YOUTUBE:
						String url = res.getString("youtube_url");
						boolean sharable = res.getBoolean("youtube_sharable");
						boolean expandable = res.getBoolean("youtube_expandable");
						widget = new YouTubeWidget(id,name,width,height,cssStyle,cssClass,
								text,order,url,sharable,expandable);
						break;
				}
				widget.setPageId(pageId);
			}
			Connection.closeConnection();
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
		Collection<Widget> widgets = new LinkedList<>();
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
				Widget widget = null;
				switch (type){
					case HEADING:
						Integer size = res.getInt("heading_size");
						widget = new HeadingWidget(id,name,width,height,
								cssStyle,cssClass,text,order,size);
						break;
					case HTML:
						String html = res.getString("html");
						widget = new HtmlWidget(id,name,width,height,
								cssStyle,cssClass,text,order,html);
						break;
					case IMAGE:
						String src = res.getString("image_src");
						widget = new ImageWidget(id,name,width,height,
								cssStyle,cssClass,text,order,src);
						break;
					case YOUTUBE:
						String url = res.getString("youtube_url");
						boolean sharable = res.getBoolean("youtube_sharable");
						boolean expandable = res.getBoolean("youtube_expandable");
						widget = new YouTubeWidget(id,name,width,height,
								cssStyle,cssClass,text,order,url,sharable,expandable);
						break;
				}
				widget.setPageId(pageId);
				widgets.add(widget);
			}
			Connection.closeConnection();
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
		int res = -1;
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = null;
			switch(widget.getType()) {
				case HEADING:
					if(widget instanceof HeadingWidget){
						statement = conn.prepareStatement(UPDATE_HEADING_WIDGET);
						statement.setString(1, widget.getType().name());
						statement.setString(2, widget.getName());
						statement.setString(3,widget.getText());
						statement.setObject(4, widget.getOrder(),Types.INTEGER);
						statement.setObject(5, widget.getWidth(),Types.INTEGER);
						statement.setObject(6, widget.getHeight(),Types.INTEGER);
						statement.setString(7, widget.getCssClass());
						statement.setString(8, widget.getCssStyle());
						statement.setObject(9, ((HeadingWidget)widget).getSize(),Types.INTEGER);
						statement.setInt(10,widgetId);
						statement.executeUpdate();
						res = 0;
					}
					break;
				case HTML:
					if(widget instanceof HtmlWidget){
						statement = conn.prepareStatement(UPDATE_HTML_WIDGET);
						statement.setString(1, widget.getType().name());
						statement.setString(2, widget.getName());
						statement.setString(3,widget.getText());
						statement.setObject(4, widget.getOrder(),Types.INTEGER);
						statement.setObject(5, widget.getWidth(),Types.INTEGER);
						statement.setObject(6, widget.getHeight(),Types.INTEGER);
						statement.setString(7, widget.getCssClass());
						statement.setString(8, widget.getCssStyle());
						statement.setString(9, ((HtmlWidget)widget).getHtml());
						statement.setInt(10,widgetId);
						statement.executeUpdate();
						res = 0;
					}
					break;
				case IMAGE:
					if(widget instanceof ImageWidget){
						statement = conn.prepareStatement(UPDATE_IMAGE_WIDGET);
						statement.setString(1, widget.getType().name());
						statement.setString(2, widget.getName());
						statement.setString(3,widget.getText());
						statement.setObject(4, widget.getOrder(),Types.INTEGER);
						statement.setObject(5, widget.getWidth(),Types.INTEGER);
						statement.setObject(6, widget.getHeight(),Types.INTEGER);
						statement.setString(7, widget.getCssClass());
						statement.setString(8, widget.getCssStyle());
						statement.setString(9, ((ImageWidget)widget).getSrc());
						statement.setInt(10,widgetId);
						statement.executeUpdate();
						res = 0;
					}
					break;
				case YOUTUBE:
					if(widget instanceof YouTubeWidget){
						statement = conn.prepareStatement(UPDATE_YOUTUBE_WIDGET);
						statement.setString(1, widget.getType().name());
						statement.setString(2, widget.getName());
						statement.setString(3,widget.getText());
						statement.setObject(4, widget.getOrder(),Types.INTEGER);
						statement.setObject(5, widget.getWidth(),Types.INTEGER);
						statement.setObject(6, widget.getHeight(),Types.INTEGER);
						statement.setString(7, widget.getCssClass());
						statement.setString(8, widget.getCssStyle());
						statement.setString(9, ((YouTubeWidget)widget).getUrl());
						statement.setBoolean(10, ((YouTubeWidget)widget).isSharable());
						statement.setBoolean(11, ((YouTubeWidget)widget).isExpandable());
						statement.setInt(12,widgetId);
						statement.executeUpdate();
						res = 0;
					}
					break;
				default:
					break;
			}
			Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteWidget(int widgetId) {
		// TODO Auto-generated method stub
		try {
			java.sql.Connection conn = Connection.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_WIDGET);
			statement.setInt(1,widgetId);
			statement.executeUpdate();
			Connection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
