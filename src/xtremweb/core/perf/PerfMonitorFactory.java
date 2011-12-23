package xtremweb.core.perf;

/**
 * Describe class PerfMonitorFactory here.
 *
 *
 * Created: Fri Jul 20 13:18:48 2007
 *
 * @author <a href="mailto:fedak@lri7-234.lri.fr">Gilles Fedak</a>
 * @version 1.0
 */
import java.util.*;
import xtremweb.core.log.*;

/**
 * 
 * @author josefrancisco
 *
 */
public class PerfMonitorFactory {
    
    /**
     * HashMap 
     */
    private static final HashMap<String,PerfMonitor> monitors = new HashMap<String,PerfMonitor>();
    
    /**
     * Logger
     */
    private static final Logger log  = LoggerFactory.getLogger(PerfMonitorFactory.class);
    
    /**
     * Creates a new <code>PerfMonitorFactory</code> instance.
     *
     */
    public PerfMonitorFactory() {
    }
    
    /**
     * 
     * @param name
     * @param serieTitle
     * @param maxSample
     * @return
     */
    public static PerfMonitor createPerfMonitor(String name, String serieTitle, int maxSample ) {
	PerfMonitor perf = new PerfMonitor(name, serieTitle, maxSample);
	monitors.put(name,perf);
	log.debug("created new Performance Monitor for : " + name);
	return perf;
    }
    
    /**
     * 
     * @param name
     * @return
     */
    public static PerfMonitor createPerfMonitor(String name) {
	PerfMonitor perf = new PerfMonitor(name);
	monitors.put(name,perf);
	log.debug("created new Performance Monitor for : " + name);
	return perf;
    }

    /**
     * 
     * @param name
     * @return
     */
    public static PerfMonitor getPerfMonitor(String name) {
	return monitors.get(name);
    }
    
    /**
     * 
     * @return
     */
    public static Set<String> browse() {
	return monitors.keySet();
    }

}
