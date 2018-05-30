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
package org.olat.modules.forms.handler;

import java.util.List;

import org.olat.core.gui.UserRequest;
import org.olat.core.gui.components.Component;
import org.olat.core.gui.control.Controller;
import org.olat.core.gui.control.WindowControl;
import org.olat.modules.forms.EvaluationFormSessionRef;
import org.olat.modules.forms.model.xml.MultipleChoice;
import org.olat.modules.forms.ui.CountTableController;
import org.olat.modules.forms.ui.ReportHelper;
import org.olat.modules.forms.ui.model.CountDataSource;
import org.olat.modules.forms.ui.model.MultipleChoiceDataSource;
import org.olat.modules.portfolio.ui.editor.PageElement;

/**
 * 
 * Initial date: 21.05.2018<br>
 * @author uhensler, urs.hensler@frentix.com, http://www.frentix.com
 *
 */
public class MultipleChoiceTableHandler implements EvaluationFormReportHandler {

	@Override
	public String getType() {
		return "mctablehandler";
	}

	@Override
	public Component getReportComponent(UserRequest ureq, WindowControl windowControl, PageElement element,
			List<? extends EvaluationFormSessionRef> sessions, ReportHelper reportHelper) {
		if (element instanceof MultipleChoice) {
			MultipleChoice multipleChoice = (MultipleChoice) element;
			CountDataSource dataSource = new MultipleChoiceDataSource(multipleChoice, sessions);
			Controller ctrl = new CountTableController(ureq, windowControl, dataSource);
			return ctrl.getInitialComponent();
		}
		return null;
	}

}