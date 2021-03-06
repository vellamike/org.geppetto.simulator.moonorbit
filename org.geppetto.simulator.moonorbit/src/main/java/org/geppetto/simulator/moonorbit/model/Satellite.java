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
package org.geppetto.simulator.moonorbit.model;


/**
 * @author matteocantarelli
 *
 */
public class Satellite
{
	
	Vector3D _position;
	Vector3D _velocity;
	double _mass;
	
	public Satellite(Vector3D position, Vector3D velocity, float mass)
	{
		super();
		this._position = position;
		this._velocity = velocity;
		this._mass = mass;
	}

	public Satellite()
	{
		// TODO Auto-generated constructor stub
	}

	public double getMass()
	{
		return _mass;
	}

	public Vector3D getPosition()
	{
		return _position;
	}
	
	public Vector3D getVelocity()
	{
		return _velocity;
	}

	public void setPosition(Vector3D position)
	{
		_position=position;
	}

	public void setVelocity(Vector3D velocity)
	{
		_velocity=velocity;
	}

	public void setMass(double mass)
	{
		_mass=mass;
	}
}
