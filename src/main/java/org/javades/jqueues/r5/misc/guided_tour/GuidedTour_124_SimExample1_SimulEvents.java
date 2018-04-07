package org.javades.jqueues.r5.misc.guided_tour;

import org.javades.jqueues.r5.entity.jq.SimJQEventScheduler;
import org.javades.jqueues.r5.entity.jq.job.DefaultSimJob;
import org.javades.jqueues.r5.entity.jq.job.SimJob;
import org.javades.jqueues.r5.entity.jq.queue.SimQueueListener;
import org.javades.jqueues.r5.entity.jq.queue.nonpreemptive.FCFS_B;
import org.javades.jqueues.r5.listener.StdOutSimQueueListener;
import org.javades.jsimulation.r5.DefaultSimEventList;
import org.javades.jsimulation.r5.SimEventList;

final class GuidedTour_124_SimExample1_SimulEvents
{
  
  public static void main (final String[] args)
  {
    final SimEventList el = new DefaultSimEventList ();
    final int bufferSize = 2;
    final FCFS_B queue = new FCFS_B (el, bufferSize);
    final SimQueueListener listener = new StdOutSimQueueListener ();
    queue.registerSimEntityListener (listener);
    for (int j = 1; j <= 3; j++)
    {
      final double jobServiceTime = 1.0;
      final double jobArrivalTime = (double) j;
      final String jobName = Integer.toString (j);
      final SimJob job = new DefaultSimJob (null, jobName, jobServiceTime);
      SimJQEventScheduler.scheduleJobArrival (job, queue, jobArrivalTime);
    }
    el.run ();
  }
  
}
