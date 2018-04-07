package org.javades.jqueues.r5.misc.guided_tour;

import org.javades.jqueues.r5.entity.SimEntityEventScheduler;
import org.javades.jqueues.r5.entity.jq.SimJQEventScheduler;
import org.javades.jqueues.r5.entity.jq.job.DefaultSimJob;
import org.javades.jqueues.r5.entity.jq.job.SimJob;
import org.javades.jqueues.r5.entity.jq.queue.nonpreemptive.FCFS_B;
import org.javades.jsimulation.r5.DefaultSimEventList;
import org.javades.jsimulation.r5.SimEventList;

final class GuidedTour_170_SimExample1_Update
{
  
  public static void main (final String[] args)
  {
    final SimEventList el = new DefaultSimEventList ();
    final int bufferSize = 2;
    final FCFS_B queue = new FCFS_B (el, bufferSize);
    queue.registerStdOutSimEntityListener ();
    for (int j = 0; j < 4; j++)
    {
      final double jobServiceTime = (double) 2.2 * j;
      final double jobArrivalTime = (double) j;
      final String jobName = Integer.toString (j);
      final SimJob job = new DefaultSimJob (null, jobName, jobServiceTime);
      SimJQEventScheduler.scheduleJobArrival (job, queue, jobArrivalTime);
    }
    SimEntityEventScheduler.scheduleUpdate (el, queue, 8.5);
    SimEntityEventScheduler.scheduleUpdate (el, queue, 1000.0);
    el.run ();
  }
  
}
