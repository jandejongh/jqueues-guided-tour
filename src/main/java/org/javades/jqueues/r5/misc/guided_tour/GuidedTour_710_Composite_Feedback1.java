package org.javades.jqueues.r5.misc.guided_tour;

import org.javades.jqueues.r5.entity.jq.SimJQEventScheduler;
import org.javades.jqueues.r5.entity.jq.job.DefaultSimJob;
import org.javades.jqueues.r5.entity.jq.job.SimJob;
import org.javades.jqueues.r5.entity.jq.queue.SimQueue;
import org.javades.jqueues.r5.entity.jq.queue.composite.feedback.FB_p;
import org.javades.jqueues.r5.entity.jq.queue.composite.feedback.FB_v;
import org.javades.jqueues.r5.entity.jq.queue.nonpreemptive.FCFS;
import org.javades.jqueues.r5.listener.StdOutSimEntityListener;
import org.javades.jsimulation.r5.DefaultSimEventList;
import org.javades.jsimulation.r5.SimEvent;
import org.javades.jsimulation.r5.SimEventAction;
import org.javades.jsimulation.r5.SimEventList;

final class GuidedTour_710_Composite_Feedback1
{
  
  public static void main (final String[] args)
  {
    // Create the event list.
    final SimEventList el = new DefaultSimEventList ();
    // FB_v example; scheduled at t=0.
    final SimQueue fcfs1 = new FCFS (el);
    final int numVisits = 7;
    final SimQueue fb_v = new FB_v (el, fcfs1, numVisits, null);
    fb_v.registerSimEntityListener (new StdOutSimEntityListener ());
    final SimJob job1 = new DefaultSimJob (null, "1", 1.0);
    SimJQEventScheduler.scheduleJobArrival (job1, fb_v, 0.0);
    // Create some vertical space in the output at t=9.
    el.schedule (9.0, (SimEventAction) (final SimEvent event) ->
    {
      System.out.println ();
    });
    // FB_v example; scheduled at t=10.
    final SimQueue fcfs2 = new FCFS (el);
    final double pFeedback = 0.8;
    final SimQueue fb_p = new FB_p (el, fcfs2, pFeedback, null, null);
    fb_p.registerSimEntityListener (new StdOutSimEntityListener ());
    final SimJob job2 = new DefaultSimJob (null, "2", 1.0);
    SimJQEventScheduler.scheduleJobArrival (job2, fb_p, 10.0);
    // Run the event list.
    el.run ();
  }
  
}
