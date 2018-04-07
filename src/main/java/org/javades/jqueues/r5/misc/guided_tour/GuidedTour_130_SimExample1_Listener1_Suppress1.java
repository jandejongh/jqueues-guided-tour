package org.javades.jqueues.r5.misc.guided_tour;

import java.util.List;
import org.javades.jqueues.r5.entity.SimEntity;
import org.javades.jqueues.r5.entity.jq.SimJQEventScheduler;
import org.javades.jqueues.r5.entity.jq.job.DefaultSimJob;
import org.javades.jqueues.r5.entity.jq.job.SimJob;
import org.javades.jqueues.r5.entity.jq.queue.SimQueue;
import org.javades.jqueues.r5.entity.jq.queue.SimQueueListener;
import org.javades.jqueues.r5.entity.jq.queue.nonpreemptive.FCFS_B;
import org.javades.jqueues.r5.listener.StdOutSimQueueListener;
import org.javades.jsimulation.r5.DefaultSimEventList;
import org.javades.jsimulation.r5.SimEventList;

final class GuidedTour_130_SimExample1_Listener1_Suppress1
{
  
  public static void main (final String[] args)
  {
    final SimEventList el = new DefaultSimEventList ();
    final int bufferSize = 2;
    final FCFS_B queue = new FCFS_B (el, bufferSize);
    final SimQueueListener listener = new StdOutSimQueueListener ()
    {
      
      @Override
      public void notifyStateChanged (double time, SimEntity entity, List notifications) {}

      @Override
      public void notifyUpdate (double time, SimEntity entity) {}
      
      @Override
      public void notifyStartQueueAccessVacation (double time, SimQueue queue) {}

      @Override
      public void notifyStopQueueAccessVacation (double time, SimQueue queue) {}

      @Override
      public void notifyNewStartArmed (double time, SimQueue queue, boolean startArmed) {}
      
      @Override
      public void notifyOutOfServerAccessCredits (double time, SimQueue queue) {}

      @Override
      public void notifyRegainedServerAccessCredits (double time, SimQueue queue) {}
      
    };
    queue.registerSimEntityListener (listener);
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
