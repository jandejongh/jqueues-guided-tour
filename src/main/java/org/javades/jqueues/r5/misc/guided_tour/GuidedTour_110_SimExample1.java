package org.javades.jqueues.r5.misc.guided_tour;

import org.javades.jqueues.r5.entity.jq.SimJQEventScheduler;
import org.javades.jqueues.r5.entity.jq.job.DefaultSimJob;
import org.javades.jqueues.r5.entity.jq.job.SimJob;
import org.javades.jqueues.r5.entity.jq.queue.SimQueue;
import org.javades.jqueues.r5.entity.jq.queue.nonpreemptive.FCFS;
import org.javades.jqueues.r5.listener.StdOutSimEntityListener;
import org.javades.jsimulation.r5.DefaultSimEventList;
import org.javades.jsimulation.r5.SimEventList;

/** Example from the "Hello World" chapter.
 * 
 * <p>
 * <b>Last javadoc Review:</b> Jan de Jongh, TNO, 20180407, r5.2.0.
 * 
 * @author Jan de Jongh, TNO
 * 
 */
public final class GuidedTour_110_SimExample1
{
  
  /** Prevents instantiation.
   * 
   */
  private GuidedTour_110_SimExample1 ()
  {
  }
  
  /** Runs the example.
   * 
   * @param args The command-line arguments (ignored).
   * 
   */
  public static void main (final String[] args)
  {
    final SimEventList el = new DefaultSimEventList (0);
    final SimQueue queue = new FCFS (el);
    queue.registerSimEntityListener (new StdOutSimEntityListener ());
    for (int j = 0; j < 10; j++)
    {
      final double jobServiceTime = (double) 2.2 * j;
      final double jobArrivalTime = (double) j;
      final String jobName = Integer.toString (j);
      final SimJob job = new DefaultSimJob (null, jobName, jobServiceTime);
      SimJQEventScheduler.scheduleJobArrival (job, queue, jobArrivalTime);
    }
    el.run ();
  }
  
}
