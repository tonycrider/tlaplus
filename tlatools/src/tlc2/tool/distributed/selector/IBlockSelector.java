package tlc2.tool.distributed.selector;

import tlc2.tool.TLCState;
import tlc2.tool.distributed.TLCWorker;
import tlc2.tool.distributed.TLCWorkerRMI;
import tlc2.tool.queue.StateQueue;

public interface IBlockSelector {
	/**
	 * Calculates the number of states a worker should be assigned. This
	 * calculation is based on the current number of workers registered with the
	 * server assigning each worker 1/N of the {@link StateQueue} with N being the
	 * current amount of {@link TLCWorker}.
	 * 
	 * The block size essentially load balances the workers by deciding how much
	 * work they get assigned.
	 * 
	 * @param stateQueue Current queue of new states
	 * @param worker {@link TLCWorker} requesting work units ({@link TLCState})
	 * @return The states that will be assigned to the given remote {@link TLCWorker}
	 */
	public abstract TLCState[] getBlocks(final StateQueue stateQueue, final TLCWorkerRMI worker);

}