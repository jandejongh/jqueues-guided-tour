package org.javades.jqueues.r5.misc.guided_tour;

import org.javades.jsimulation.r5.DefaultSimEvent;
import org.javades.jsimulation.r5.DefaultSimEventList;
import org.javades.jsimulation.r5.SimEvent;
import org.javades.jsimulation.r5.SimEventList;

/** Example from the "Events, Actions and the Event List" chapter.
 * 
 * <p>
 * <b>Last javadoc Review:</b> Jan de Jongh, TNO, 20180408, r5.3.0-SNAPSHOT.
 * 
 * @author Jan de Jongh, TNO
 * 
 */
public final class GuidedTour_115_EventList1
{
  
  /** Prevents instantiation.
   * 
   */
  private GuidedTour_115_EventList1 ()
  {
  }
  
  /** Runs the example.
   * 
   * @param args The command-line arguments (ignored).
   * 
   */
  public static void main (final String[] args)
  {
    final SimEventList el = new DefaultSimEventList (-5);
    final SimEvent e1 = new DefaultSimEvent (5.0);
    final SimEvent e2 = new DefaultSimEvent (10.0);
    el.add (e1);
    el.add (e2);
    el.print ();
    el.run ();
    System.out.println ("Finished!");
  }
  
}
