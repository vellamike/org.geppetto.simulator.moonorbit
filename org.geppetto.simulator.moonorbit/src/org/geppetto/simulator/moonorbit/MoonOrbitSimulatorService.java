package org.geppetto.simulator.moonorbit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.geppetto.core.common.GeppettoExecutionException;
import org.geppetto.core.common.GeppettoInitializationException;
import org.geppetto.core.model.IModel;
import org.geppetto.core.model.state.StateTreeRoot;
import org.geppetto.core.simulation.IRunConfiguration;
import org.geppetto.core.simulation.ISimulatorCallbackListener;
import org.geppetto.core.simulator.ASimulator;
import org.geppetto.core.solver.ISolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoonOrbitSimulatorService extends ASimulator {

	
	private static Log logger = LogFactory.getLog(MoonOrbitSimulatorService.class);
	
	@Autowired
	private ISolver sphSolver;


	@Override
	public void simulate(IRunConfiguration runConfiguration) throws GeppettoExecutionException
	{
		logger.info("SPH Simulate method invoked");
		StateTreeRoot results=sphSolver.solve(runConfiguration);
		getListener().stateTreeUpdated(results);
	}

	@Override
	public void initialize(IModel model, ISimulatorCallbackListener listener) throws GeppettoInitializationException, GeppettoExecutionException
	{
		super.initialize(model, listener);
		StateTreeRoot stateTree = sphSolver.initialize(model);	
		getListener().stateTreeUpdated(stateTree);
	}

}
