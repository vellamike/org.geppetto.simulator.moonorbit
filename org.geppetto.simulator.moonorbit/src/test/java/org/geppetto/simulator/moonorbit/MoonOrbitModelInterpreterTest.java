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
package org.geppetto.simulator.moonorbit;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.geppetto.core.model.IModel;
import org.geppetto.core.model.ModelInterpreterException;
import org.geppetto.simulator.moonorbit.MoonOrbitModelInterpreter;
import org.geppetto.simulator.moonorbit.model.MoonOrbitModel;
import org.junit.Test;

/**
 * @author mikevella
 *
 */
public class MoonOrbitModelInterpreterTest
{

	@Test
	public void test() throws MalformedURLException, ModelInterpreterException
	{
		MoonOrbitModelInterpreter momi=new MoonOrbitModelInterpreter();
		IModel model=momi.readModel(new URL("https://raw.github.com/vellamike/org.geppetto.simulator.moonorbit/master/org.geppetto.simulator.moonorbit/src/main/java/resources/samplescenario.mo"));
		Assert.assertTrue(model instanceof MoonOrbitModel);
		MoonOrbitModel mo=(MoonOrbitModel)model;
		Assert.assertNotNull(mo.getEarth());
		Assert.assertNotNull(mo.getLuna3());
		Assert.assertNotNull(mo.getMoon());
		Assert.assertEquals(100.0,mo.getLuna3().getMass());
		Assert.assertEquals(100.0,mo.getMoon().getMass());
		Assert.assertEquals(100.0,mo.getEarth().getMass());
		
		Assert.assertEquals(100.0,mo.getLuna3().getPosition().getX());
		Assert.assertEquals(0d,mo.getLuna3().getPosition().getY());
		Assert.assertEquals(0d,mo.getLuna3().getPosition().getZ());
		
		Assert.assertEquals(0d,mo.getEarth().getPosition().getX());
		Assert.assertEquals(0d,mo.getEarth().getPosition().getY());
		Assert.assertEquals(0d,mo.getEarth().getPosition().getZ());
		
		Assert.assertEquals(200.0,mo.getMoon().getPosition().getX());
		Assert.assertEquals(0d,mo.getMoon().getPosition().getY());
		Assert.assertEquals(0d,mo.getMoon().getPosition().getZ());
		
		Assert.assertEquals(0d,mo.getEarth().getVelocity().getX());
		Assert.assertEquals(0d,mo.getEarth().getVelocity().getY());
		Assert.assertEquals(0d,mo.getEarth().getVelocity().getZ());
		
		Assert.assertEquals(0d,mo.getMoon().getVelocity().getX());
		Assert.assertEquals(0d,mo.getMoon().getVelocity().getY());
		Assert.assertEquals(0d,mo.getMoon().getVelocity().getZ());
		
		Assert.assertEquals(0d,mo.getLuna3().getVelocity().getX());
		Assert.assertEquals(0d,mo.getLuna3().getVelocity().getY());
		Assert.assertEquals(0d,mo.getLuna3().getVelocity().getZ());
		
	}


}
