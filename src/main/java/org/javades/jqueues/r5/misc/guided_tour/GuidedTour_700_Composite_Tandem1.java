package org.javades.jqueues.r5.misc.guided_tour;

import java.util.LinkedHashSet;
import java.util.Set;
import org.javades.jqueues.r5.entity.jq.SimJQEventScheduler;
import org.javades.jqueues.r5.entity.jq.job.DefaultSimJob;
import org.javades.jqueues.r5.entity.jq.job.SimJob;
import org.javades.jqueues.r5.entity.jq.queue.SimQueue;
import org.javades.jqueues.r5.entity.jq.queue.composite.tandem.Tandem;
import org.javades.jqueues.r5.entity.jq.queue.nonpreemptive.FCFS;
import org.javades.jqueues.r5.entity.jq.queue.serverless.DLIMIT;
import org.javades.jqueues.r5.listener.StdOutSimEntityListener;
import org.javades.jsimulation.r5.DefaultSimEventList;
import org.javades.jsimulation.r5.SimEventList;

final class GuidedTour_700_Composite_Tandem1
{
  
  public static void main (final String[] args)
  {
    final SimEventList el = new DefaultSimEventList ();
    final SimQueue fcfs = new FCFS (el);
    // Uncomment to print events at fcfs.
    // fcfs.registerSimEntityListener (new StdOutSimEntityListener ());
    final double rateLimit = 0.25;
    final SimQueue dlimit = new DLIMIT (el, rateLimit);
    // Uncomment to print events at dlimit.
    // dlimit.registerSimEntityListener (new StdOutSimEntityListener ());
    final Set<SimQueue> subQueues = new LinkedHashSet<> ();
    subQueues.add (fcfs);
    subQueues.add (dlimit);
    final SimQueue tandem = new Tandem (el, subQueues, null);
    tandem.registerSimEntityListener (new StdOutSimEntityListener ());
    for (int j = 1; j <= 2; j++)
    {
      final double jobServiceTime = 1.5;
      final double jobArrivalTime = (double) j;
      final String jobName = Integer.toString (j);
      final SimJob job = new DefaultSimJob (null, jobName, jobServiceTime);
      SimJQEventScheduler.scheduleJobArrival (job, tandem, jobArrivalTime);
    }
    el.run ();
  }
  
}
