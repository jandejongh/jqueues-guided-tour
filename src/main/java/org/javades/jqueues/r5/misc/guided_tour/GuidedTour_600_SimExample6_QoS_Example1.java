package org.javades.jqueues.r5.misc.guided_tour;

import org.javades.jqueues.r5.entity.jq.SimJQEventScheduler;
import org.javades.jqueues.r5.entity.jq.job.SimJob;
import org.javades.jqueues.r5.entity.jq.job.qos.DefaultSimJobQoS;
import org.javades.jqueues.r5.entity.jq.queue.preemptive.PreemptionStrategy;
import org.javades.jqueues.r5.entity.jq.queue.qos.PQ;
import org.javades.jsimulation.r5.DefaultSimEventList;
import org.javades.jsimulation.r5.SimEventList;

final class GuidedTour_600_SimExample6_QoS_Example1
{
  
  public static void main (final String[] args)
  {
    final SimEventList el = new DefaultSimEventList ();
    final PQ queue = new PQ (el, PreemptionStrategy.RESUME, Double.class, Double.NEGATIVE_INFINITY);
    queue.registerStdOutSimEntityListener ();
    el.reset (0.0);
    for (int j = 1; j <= 4; j++)
    {
      final double jobServiceTime = 12.0 / j;
      final double jobArrivalTime = (double) j;
      final String jobName = Integer.toString (j);
      final SimJob job = new DefaultSimJobQoS (null, jobName, jobServiceTime, Double.class, (double) (-j));
      SimJQEventScheduler.scheduleJobArrival (job, queue, jobArrivalTime);
    }
    el.run ();
  }
  
}
