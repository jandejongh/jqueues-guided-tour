package org.javades.jqueues.r5.misc.guided_tour;

import org.javades.jsimulation.r5.DefaultSimEvent;
import org.javades.jsimulation.r5.DefaultSimEventList;
import org.javades.jsimulation.r5.SimEvent;
import org.javades.jsimulation.r5.SimEventList;

/** Example from the "Events, Actions and the Event List" chapter;
 *  "Creating and using SimEventActions".
 * 
 * <p>
 * <b>Last javadoc Review:</b> Jan de Jongh, TNO, 20180408, r5.3.0-SNAPSHOT.
 * 
 * @author Jan de Jongh, TNO
 * 
 */
public final class GuidedTour_118_Action1
{
  
  /** Prevents instantiation.
   * 
   */
  private GuidedTour_118_Action1 ()
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
    final SimEvent e
      = new DefaultSimEvent ("My First Real Event", 5.0, null, ((event) ->
      {
        System.out.println ("Event=" + event + ", time=" + event.getTime () + ".");
      }));
    el.add (e);
    el.print ();
    el.run ();
    el.print ();
  }
  
}
