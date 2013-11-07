/*******************************************************************************
 * The MIT License (MIT)
 * 
 * Copyright (c) 2011, 2013 OpenWorm.
 * http://openworm.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution, and is available at
 * http://opensource.org/licenses/MIT
 *
 * Contributors:
 *     	OpenWorm - http://openworm.org/people.html
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights 
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is 
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR 
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE 
 * USE OR OTHER DEALINGS IN THE SOFTWARE.
 *******************************************************************************/
package main.java.org.geppetto.simulator.moonorbit;

import java.io.IOException;
import java.net.URL;

import org.geppetto.core.model.IModel;
import org.geppetto.core.model.IModelInterpreter;
import org.geppetto.core.model.ModelInterpreterException;
import org.geppetto.core.model.state.StateTreeRoot;
import org.geppetto.core.visualisation.model.Scene;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author matteocantarelli
 *
 */
public class MoonOrbitModelInterpreter implements IModelInterpreter
{

	/* (non-Javadoc)
	 * @see org.geppetto.core.model.IModelInterpreter#readModel(java.net.URL)
	 */
	@Override
	public IModel readModel(URL url) throws ModelInterpreterException
	{
		try
		{
			JSONObject json = JsonReader.readJsonFromUrl("https://graph.facebook.com/19292868552");
		}
		catch(JSONException e)
		{
			throw new ModelInterpreterException(e);
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.geppetto.core.model.IModelInterpreter#getSceneFromModel(org.geppetto.core.model.IModel, org.geppetto.core.model.state.StateTreeRoot)
	 */
	@Override
	public Scene getSceneFromModel(IModel model, StateTreeRoot stateTree) throws ModelInterpreterException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
