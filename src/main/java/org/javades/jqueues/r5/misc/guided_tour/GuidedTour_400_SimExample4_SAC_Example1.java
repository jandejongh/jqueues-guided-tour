package org.javades.jqueues.r5.misc.guided_tour;

import org.javades.jqueues.r5.entity.jq.SimJQEventScheduler;
import org.javades.jqueues.r5.entity.jq.job.DefaultSimJob;
import org.javades.jqueues.r5.entity.jq.job.SimJob;
import org.javades.jqueues.r5.entity.jq.queue.SimQueueEventScheduler;
import org.javades.jqueues.r5.entity.jq.queue.nonpreemptive.FCFS_c;
import org.javades.jsimulation.r5.DefaultSimEventList;
import org.javades.jsimulation.r5.SimEventList;

final class GuidedTour_400_SimExample4_SAC_Example1
{
  
  public static void main (final String[] args)
  {
    final SimEventList el = new DefaultSimEventList ();
    final FCFS_c queue = new FCFS_c (el, 2);
    queue.registerStdOutSimEntityListener ();
    el.reset (0.0);
    SimQueueEventScheduler.scheduleServerAccessCredits (queue, 0.0, 0);
    for (int j = 1; j <= 6; j++)
    {
      final double jobServiceTime = 1.05;
      final double jobArrivalTime = (double) j;
      final String jobName = Integer.toString (j);
      final SimJob job = new DefaultSimJob (null, jobName, jobServiceTime);
      SimJQEventScheduler.scheduleJobArrival (job, queue, jobArrivalTime);
    }
    SimQueueEventScheduler.scheduleServerAccessCredits (queue,  8.0, 1);
    SimQueueEventScheduler.scheduleServerAccessCredits (queue, 10.0, 3);
    SimQueueEventScheduler.scheduleServerAccessCredits (queue, 15.0, Integer.MAX_VALUE);
    el.run ();
  }
  
}
