package org.geppetto.simulator.moonorbit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.geppetto.core.model.IModel;
import org.geppetto.core.model.IModelInterpreter;
import org.geppetto.core.model.ModelInterpreterException;
import org.geppetto.core.model.state.StateTreeRoot;
import org.geppetto.core.visualisation.model.Entity;
import org.geppetto.core.visualisation.model.Point;
import org.geppetto.core.visualisation.model.Scene;
import org.geppetto.core.visualisation.model.Sphere;
import org.geppetto.simulator.moonorbit.model.MoonOrbitModel;
import org.geppetto.simulator.moonorbit.model.Satellite;
import org.geppetto.simulator.moonorbit.model.Vector3D;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

/**
 * @author matteocantarelli
 * 
 */
@Service
public class MoonOrbitModelInterpreter implements IModelInterpreter
{

	private static String readUrl(String urlString) throws Exception
	{
		BufferedReader reader = null;
		try
		{
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		}
		finally
		{
			if(reader != null) reader.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.geppetto.core.model.IModelInterpreter#readModel(java.net.URL)
	 */
	@Override
	public IModel readModel(URL url) throws ModelInterpreterException
	{
		try
		{
			Gson gson = new Gson();
			String jsonString = readUrl(url.toString());
			Map<String,String> json=new HashMap<String,String>();
			json=(Map<String,String>) gson.fromJson(jsonString, json.getClass());
			MoonOrbitModel mom = new MoonOrbitModel(readSatellite(json, "moon"), readSatellite(json, "earth"), readSatellite(json, "luna3")

			);
			return mom;
		}
		catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Satellite readSatellite(Map obj, String satellite)
	{
		Satellite s = new Satellite();
		Map js = (Map) obj.get(satellite);
		Vector3D position = readVector3D((Map) js.get("position"));
		Vector3D velocity = readVector3D((Map) js.get("velocity"));
		s.setPosition(position);
		s.setVelocity(velocity);
		s.setMass((double)js.get("mass"));
		return s;
	}

	private Vector3D readVector3D(Map obj)
	{
		return new Vector3D((double)obj.get("x"),(double)obj.get("y"),(double)obj.get("z"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.geppetto.core.model.IModelInterpreter#getSceneFromModel(org.geppetto.core.model.IModel, org.geppetto.core.model.state.StateTreeRoot)
	 */
	@Override
	public Scene getSceneFromModel(IModel model, StateTreeRoot stateTree) throws ModelInterpreterException
	{
		MoonOrbitModel mo = (MoonOrbitModel) model;
		Scene s = new Scene();
		Entity space = new Entity();
		Sphere moon = getSphereFromSatellite(mo.getMoon());
		moon.setRadius(5d);
		Sphere earth = getSphereFromSatellite(mo.getEarth());
		earth.setRadius(10d);
		Sphere luna3 = getSphereFromSatellite(mo.getLuna3());
		luna3.setRadius(2d);
		space.getGeometries().add(moon);
		space.getGeometries().add(earth);
		space.getGeometries().add(luna3);
		s.getEntities().add(space);
		return s;
	}

	/**
	 * @param moon
	 * @return
	 */
	private Sphere getSphereFromSatellite(Satellite moon)
	{
		Sphere s = new Sphere();
		Point p = new Point();
		p.setX(moon.getPosition().getX());
		p.setY(moon.getPosition().getY());
		p.setZ(moon.getPosition().getZ());
		s.setPosition(p);
		return s;
	}

}
