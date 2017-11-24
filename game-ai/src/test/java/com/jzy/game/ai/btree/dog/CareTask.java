/*******************************************************************************
 * Copyright 2014 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.jzy.game.ai.btree.dog;

import com.jzy.game.ai.btree.LeafTask;
import com.jzy.game.ai.btree.annotation.TaskAttribute;

/**小心,醒
 * @author implicit-invocation
 * @author davebaol
 */
public class CareTask extends LeafTask<Dog> {

	@TaskAttribute(required = true)
	public float urgentProb = 0.8f;		//休息概率

	@Override
	public Status execute() {
		if (Math.random() < urgentProb) {
			return Status.SUCCEEDED;
		}
		Dog dog = getObject();
		dog.brainLog("GASP - Something urgent :/");
		return Status.FAILED;
	}

//	@Override
//	protected Task<Dog> copyTo(Task<Dog> task) {
//		CareTask care = (CareTask) task;
//		care.urgentProb = urgentProb;
//
//		return task;
//	}

	@Override
	public void release() {
		urgentProb = 0.8f;
		super.release();
	}

}
