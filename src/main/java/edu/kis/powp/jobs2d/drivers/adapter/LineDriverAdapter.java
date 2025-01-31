package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;

/**
 * Line adapter - Job2dDriver with DrawPanelController object.
 */
public class LineDriverAdapter implements Job2dDriver {
	protected ILine line;
	protected int startX = 0, startY = 0;
	protected String name;

	protected DrawPanelController drawController;

	public LineDriverAdapter(DrawPanelController drawController, ILine line, String name) {
		super();
		this.drawController = drawController;
		this.line = line;
		this.name = name;
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		line.setStartCoordinates(this.startX, this.startY);
		this.setPosition(x, y);
		line.setEndCoordinates(x, y);

		drawController.drawLine(line);
	}

	@Override
	public String toString() {
		return "2d device simulator - " + name;
	}
}
