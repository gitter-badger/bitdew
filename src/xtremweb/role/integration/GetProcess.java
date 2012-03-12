package xtremweb.role.integration;

import java.io.File;

import xtremweb.api.bitdew.BitDew;
import xtremweb.api.bitdew.BitDewException;
import xtremweb.api.transman.TransferManager;
import xtremweb.api.transman.TransferManagerException;
import xtremweb.core.com.idl.ComWorld;
import xtremweb.core.com.idl.ModuleLoaderException;
import xtremweb.core.iface.InterfaceRMIdc;
import xtremweb.core.iface.InterfaceRMIdr;
import xtremweb.core.iface.InterfaceRMIds;
import xtremweb.core.iface.InterfaceRMIdt;
import xtremweb.core.obj.dc.Data;
import xtremweb.serv.dt.OOBTransfer;

/**
 * This class perform a bitdew GET in a different java process,
 * multiple instances should run in order to put stress on 
 * a distant transfer manager.
 * @author josefrancisco
 *
 */
public class GetProcess {
    
    /**
     * Bitdew API
     */
    private BitDew bd;
    
    private String getfilename;
    
    /**
     * Transfer Manager API
     */
    private TransferManager tm;
    
    /**
     * Data uid you want to get
     */
    private String duid;
    
    /**
     * Process number , it will be added on the filename get by this process
     * 
     */
    private int prnum;
    
    /**
     * GetProcess constructor
     * @param stable stable node where bitdew services run
     * @param uid data uid to get
     * @param filenumber
     */
    public GetProcess(String stable, String uid,int filenumber,String getfname) {
	try {
	    prnum = filenumber;
	    this.getfilename= getfname;
	    InterfaceRMIdr idr = (InterfaceRMIdr) ComWorld.getComm(stable,
		    "rmi", 4325, "dr");

	    InterfaceRMIdc idc = (InterfaceRMIdc) ComWorld.getComm(stable,
		    "rmi", 4325, "dc");
	    InterfaceRMIds ids = (InterfaceRMIds) ComWorld.getComm(stable,
		    "rmi", 4325, "ds");
	    InterfaceRMIdt idt = (InterfaceRMIdt) ComWorld.getComm(stable,
		    "rmi", 4325, "dt");
	    duid = uid;
	  
	    bd = new BitDew(idc, idr, idt, ids);
	    tm = new TransferManager(idt);
	    tm.start();
	} catch (ModuleLoaderException e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * Perform a GET
     */
    public void execute() {
	Data d;
	try {
	    System.out.println(" Process #   " + prnum);
	    d = bd.searchDataByUid(duid);
	    File fofis = new File(getfilename + prnum);
	    OOBTransfer oobt = bd.get(d, fofis);
	    tm.registerTransfer(oobt);
	    tm.waitFor(d);
	    tm.stop();
	    System.out.println("Finish process !!!!!!!!! " + prnum);
	} catch (BitDewException e) {
	    e.printStackTrace();
	} catch (TransferManagerException e) {
	    e.printStackTrace();
	}

    }
}
