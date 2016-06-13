/**
 * <a href="http://www.openolat.org">
 * OpenOLAT - Online Learning and Training</a><br>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); <br>
 * you may not use this file except in compliance with the License.<br>
 * You may obtain a copy of the License at the
 * <a href="http://www.apache.org/licenses/LICENSE-2.0">Apache homepage</a>
 * <p>
 * Unless required by applicable law or agreed to in writing,<br>
 * software distributed under the License is distributed on an "AS IS" BASIS, <br>
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. <br>
 * See the License for the specific language governing permissions and <br>
 * limitations under the License.
 * <p>
 * Initial code contributed and copyrighted by<br>
 * frentix GmbH, http://www.frentix.com
 * <p>
 */
package org.olat.core.gui.components.stack;

import java.util.ArrayList;
import java.util.List;

import org.olat.core.gui.UserRequest;
import org.olat.core.gui.components.AbstractComponent;
import org.olat.core.gui.components.Component;
import org.olat.core.gui.components.ComponentCollection;
import org.olat.core.gui.components.ComponentEventListener;
import org.olat.core.gui.components.ComponentRenderer;
import org.olat.core.gui.components.link.Link;
import org.olat.core.gui.control.Event;

/**
 * 
 * Initial date: 07.06.2016<br>
 * @author srosse, stephane.rosse@frentix.com, http://www.frentix.com
 *
 */
public class ButtonGroupComponent extends AbstractComponent implements ComponentCollection, ComponentEventListener {
	
	private static final ComponentRenderer RENDER = new ButtonGroupComponentRenderer();
	
	private Link selectedButton;
	private final List<Link> buttons = new ArrayList<>(5);
	
	public ButtonGroupComponent(String name) {
		super(name);
		setDomReplacementWrapperRequired(false);
	}
	
	@Override
	public boolean isDomReplacementWrapperRequired() {
		return false;
	}

	public List<Link> getButtons() {
		return buttons;
	}
	
	public void addButton(Link button, boolean selected) {
		buttons.add(button);
		button.addListener(this);
		if(selected) {
			selectedButton = button;
		}
	}
	
	public Link getSelectedButton() {
		return selectedButton;
	}

	@Override
	public Component getComponent(String name) {
		for(Link button:buttons) {
			if(name.equals(button.getComponentName())) {
				return button;
			}
		}
		return null;
	}

	@Override
	public Iterable<Component> getComponents() {
		return new ArrayList<>(buttons);
	}

	@Override
	public void dispatchEvent(UserRequest ureq, Component source, Event event) {
		if(buttons.contains(source)) {
			selectedButton = (Link)source;
		}
	}

	@Override
	protected void doDispatchRequest(UserRequest ureq) {
		// 
	}

	@Override
	public ComponentRenderer getHTMLRendererSingleton() {
		return RENDER;
	}
}
