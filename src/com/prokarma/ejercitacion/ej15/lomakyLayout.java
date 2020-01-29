package com.prokarma.ejercitacion.ej15;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

public class lomakyLayout implements LayoutManager{

	public lomakyLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 275 + insets.left + insets.right;
        dim.height = 323 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+88,200,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+120,32,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+120,32,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+120,32,32);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+120,32,32);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+120,32,32);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+160,56,48);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+160,56,48);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+216,200,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+56,200,24);}
    }
	
}
