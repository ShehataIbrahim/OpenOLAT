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
package org.olat.modules.fo.export;

import org.olat.core.gui.UserRequest;
import org.olat.core.gui.components.form.flexible.impl.Form;
import org.olat.core.gui.control.WindowControl;
import org.olat.core.gui.control.generic.wizard.BasicStep;
import org.olat.core.gui.control.generic.wizard.PrevNextFinishConfig;
import org.olat.core.gui.control.generic.wizard.StepFormController;
import org.olat.core.gui.control.generic.wizard.StepsRunContext;

/**
 * Initial Date: 15.02.2017
 * @author fkiefer, fabian.kiefer@frentix.com, www.frentix.com
 */
public class Step_2_SelectForum extends BasicStep {

	/**
	 * @param ureq
	 */
	public Step_2_SelectForum(UserRequest ureq) {
		super(ureq);
		setI18nTitleAndDescr("step.select.forum", "step.select.forum");
		setNextStep(new Step_3_SelectThread(ureq));
	}


	@Override
	public PrevNextFinishConfig getInitialPrevNextFinishConfig() {
		return new PrevNextFinishConfig(true, true, false);
	}


	@Override
	public StepFormController getStepController(UserRequest ureq, WindowControl wControl,
			StepsRunContext runContext, Form form) {
		return new SelectForumStepForm(ureq, wControl, form, runContext, null);

	}

}
