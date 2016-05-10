package module3.events;

/**
 * 
 * @author pbose
 * Interface that the event consumers should implement
 */
public interface RandEventListener
{
	/**
	 * This method is called by event source notifier.
	 * @param evObj
	 */
	public void eventHandler(RandEvent evObj);
}
