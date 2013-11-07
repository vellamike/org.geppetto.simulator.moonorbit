package org.geppetto.simulator.moonorbit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.geppetto.core.common.GeppettoExecutionException;
import org.geppetto.core.common.GeppettoInitializationException;
import org.geppetto.core.data.model.VariableList;
import org.geppetto.core.model.IModel;
import org.geppetto.core.model.state.StateTreeRoot;
import org.geppetto.core.simulation.IRunConfiguration;
import org.geppetto.core.simulation.ISimulatorCallbackListener;
import org.geppetto.core.simulator.ASimulator;
import org.geppetto.simulator.moonorbit.model.MoonOrbitModel;
import org.springframework.stereotype.Service;

@Service
public class MoonOrbitSimulatorService extends ASimulator {

	
	private static Log logger = LogFactory.getLog(MoonOrbitSimulatorService.class);

	private MoonOrbitModel _moonOrbit;

	private ISimulatorCallbackListener _listener;
	
	private StateTreeRoot _stateTree=new StateTreeRoot("MO");
	
	@Override
	public void simulate(IRunConfiguration runConfiguration) throws GeppettoExecutionException
	{
		_listener.stateTreeUpdated(_stateTree);
	}

	@Override
	public void initialize(IModel model, ISimulatorCallbackListener listener) throws GeppettoInitializationException, GeppettoExecutionException
	{
		super.initialize(model, listener);
		_moonOrbit=(MoonOrbitModel) model;
		_listener=listener;
	}

	@Override
	public VariableList getForceableVariables()
	{
		return new VariableList();
	}

	@Override
	public VariableList getWatchableVariables()
	{
		return new VariableList();
	}

}
