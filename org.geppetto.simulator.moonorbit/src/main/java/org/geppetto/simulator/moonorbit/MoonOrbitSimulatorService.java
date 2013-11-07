package main.java.org.geppetto.simulator.moonorbit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.geppetto.core.common.GeppettoExecutionException;
import org.geppetto.core.common.GeppettoInitializationException;
import org.geppetto.core.data.model.VariableList;
import org.geppetto.core.model.IModel;
import org.geppetto.core.simulation.IRunConfiguration;
import org.geppetto.core.simulation.ISimulatorCallbackListener;
import org.geppetto.core.simulator.ASimulator;
import org.springframework.stereotype.Service;

@Service
public class MoonOrbitSimulatorService extends ASimulator {

	
	private static Log logger = LogFactory.getLog(MoonOrbitSimulatorService.class);


	@Override
	public void simulate(IRunConfiguration runConfiguration) throws GeppettoExecutionException
	{
	}

	@Override
	public void initialize(IModel model, ISimulatorCallbackListener listener) throws GeppettoInitializationException, GeppettoExecutionException
	{
		super.initialize(model, listener);
	}

	@Override
	public VariableList getForceableVariables()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VariableList getWatchableVariables()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
