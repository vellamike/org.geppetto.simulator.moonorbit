package org.geppetto.simulator.moonorbit;

import java.io.IOException;
import java.net.URL;

import org.geppetto.core.model.IModel;
import org.geppetto.core.model.IModelInterpreter;
import org.geppetto.core.model.ModelInterpreterException;
import org.geppetto.core.model.state.StateTreeRoot;
import org.geppetto.core.visualisation.model.Entity;
import org.geppetto.core.visualisation.model.Point;
import org.geppetto.core.visualisation.model.Scene;
import org.geppetto.core.visualisation.model.Sphere;
import org.geppetto.simulator.moonorbit.JsonReader;
import org.geppetto.simulator.moonorbit.model.MoonOrbitModel;
import org.geppetto.simulator.moonorbit.model.Satellite;
import org.geppetto.simulator.moonorbit.model.Vector3D;
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
			JSONObject json = JsonReader.readJsonFromUrl(url.toString());
			
			MoonOrbitModel mom=new MoonOrbitModel(
					readSatellite(json,"moon"),
					readSatellite(json,"earth"),
					readSatellite(json,"luna3")
			
					);
			return mom;
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

	private Satellite readSatellite(JSONObject obj,String satellite)
	{
		Satellite s=new Satellite();
		JSONObject js=obj.getJSONObject(satellite);
		Vector3D position=readVector3D(js.getJSONObject("position"));
		Vector3D velocity=readVector3D(js.getJSONObject("velocity"));
		s.setPosition(position);
		s.setVelocity(velocity);
		s.setMass(js.getDouble("mass"));
		return s;
	}

	private Vector3D readVector3D(JSONObject obj)
	{
		return new Vector3D(obj.getDouble("x"), obj.getDouble("y"), obj.getDouble("z"));
	}

	/* (non-Javadoc)
	 * @see org.geppetto.core.model.IModelInterpreter#getSceneFromModel(org.geppetto.core.model.IModel, org.geppetto.core.model.state.StateTreeRoot)
	 */
	@Override
	public Scene getSceneFromModel(IModel model, StateTreeRoot stateTree) throws ModelInterpreterException
	{
		MoonOrbitModel mo=(MoonOrbitModel) model;
		Scene s=new Scene();
		Entity space=new Entity();
		Sphere moon = getSphereFromSatellite(mo.getMoon());
		Sphere earth = getSphereFromSatellite(mo.getEarth());
		Sphere luna3 = getSphereFromSatellite(mo.getLuna3());
		space.getGeometries().add(moon);
		space.getGeometries().add(earth);
		space.getGeometries().add(luna3);
		s.getEntities().add(space);
		return null;
	}

	/**
	 * @param moon
	 * @return
	 */
	private Sphere getSphereFromSatellite(Satellite moon)
	{
		Sphere s=new Sphere();
		Point p=new Point();
		p.setX(moon.getPosition().getX());
		p.setY(moon.getPosition().getY());
		p.setZ(moon.getPosition().getZ());
		s.setPosition(p);
		return s;
	}

}
