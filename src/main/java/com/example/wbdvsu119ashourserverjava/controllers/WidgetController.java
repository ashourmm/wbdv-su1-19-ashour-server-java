package com.example.wbdvsu119ashourserverjava.controllers;

import com.example.wbdvsu119ashourserverjava.models.Widget;
import java.util.ArrayList;
import java.util.List;


import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class WidgetController {
	static List<Widget> widgets = new ArrayList<Widget>();
	static {
		widgets.add(new Widget(123L, "Widget 1", "HEADING", null, 0, null, null));
        widgets.add(new Widget(234L, "Widget 2", "LIST", null, 0, "Item 1\nitem 2\nitem 3", false));
        widgets.add(new Widget(345L, "Widget 3", "PARAGRAPH", null, 0, null, null));
        widgets.add(new Widget(456L, "Widget 4", "IMAGE", null, 0, null, null));
        widgets.add(new Widget(567L, "Widget 5", "LINK", null, 0, null, null));
	}
	@PostMapping("/api/widgets")		
	public List<Widget> createWidget(@RequestBody Widget widget) {
		widgets.add(widget);
		return widgets;
	}
	@GetMapping("/api/widgets")
	public List<Widget> findAllWidgets(){
		return widgets;
	}
	@GetMapping("/api/widgets/{widgetId}")
	public Widget findWidgetById(@PathVariable("widgetId") Long wid) {
		for (Widget w:widgets) {
			if(w.getId().equals(wid))
				return w;
		}
		return null;
	}
	@PutMapping("/api/widgets/up/{widgetId}")
	public List<Widget> up(
			@PathVariable("widgetId") Long wid) {
		for(Widget w: widgets) {
			if(w.getId().equals(wid)) {
				int fromIndex = widgets.indexOf(w);
				if(fromIndex>0) {
					Widget temp=widgets.get(fromIndex);
					widgets.set(fromIndex,widgets.get(fromIndex-1));
					widgets.set(fromIndex-1,temp);
					break;
				}
			}
		}
		return widgets;
	}
	@PutMapping("/api/widgets/down/{widgetId}")
	public List<Widget> down(
			@PathVariable("widgetId") Long wid) {
		for(Widget w: widgets) {
			if(w.getId().equals(wid)) {
				int fromIndex = widgets.indexOf(w);
				if(fromIndex<widgets.size()-1) {
					Widget temp=widgets.get(fromIndex);
					widgets.set(fromIndex,widgets.get(fromIndex+1));
					widgets.set(fromIndex+1,temp);
					break;
				}
			}
		}
		return widgets;
	}
	
	@PutMapping("/api/widgets/{widgetId}")
	public List<Widget> updateWidget(
			@PathVariable("widgetId") Long wid, 
			@RequestBody Widget widget) {
		for(Widget w: widgets) {
			if(w.getId().equals(wid)) {
				w.setType(widget.getType());
				w.setName(widget.getName());
				w.setText(widget.getText());
				w.setSize(widget.getSize());
				w.setListItems(widget.getListItems());
				w.setOrdered(widget.getOrdered());
			}
		}
		return widgets;
	}
	@DeleteMapping ("/api/widgets/{widgetId}")
	public List<Widget> deleteWidget( @PathVariable ("widgetId") Long wid) {
		widgets = widgets
				.stream()
				.filter(widget -> !widget.getId().equals(wid))
				.collect(Collectors.toList());
		return widgets;
	}
}
