import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.util.HashMap;
import java.util.Map;


public class PadImpl extends UnicastRemoteObject implements Pad {
    
   
    private Map<String, SRecord> records;
    private String name; 

    
    private String otherPadURL; 
    
    private Pad otherPad; 

   
    public PadImpl(String name, String otherPadURL) throws RemoteException {
        super();
        this.name = name;
        this.otherPadURL = otherPadURL;
        this.records = new HashMap<>();
        Naming.rebind(name, this);
        System.out.println("Serveur " + name + " enregistré dans le registry");
        System.out.println(name + " est démarré.");
    }

    @Override
    public void add(SRecord sr) throws RemoteException {       
        records.put(sr.getName(), sr);
        System.out.println(name + ": Ajout de " + sr.getName() + " réussi.");
    }
    @Override
    public RRecord consult(String n, boolean forward) throws RemoteException {
        System.out.println(name + ": Consultation pour " + n + " (forward=" + forward + ")");

        
        SRecord foundRecord = records.get(n);
        
        if (foundRecord != null) {
            
            return new RRecordImpl(foundRecord.getName(), foundRecord.getEmail());
        }

        if (forward) {
            System.out.println(name + ": Non trouvé localement. Propagation à " + otherPadURL + "...");
            try {
               
                if (otherPad == null) {
                    otherPad = (Pad) Naming.lookup(otherPadURL);
                }
                

                return otherPad.consult(n, false);
                
            } catch (Exception e) {
                System.err.println(name + ": Erreur lors de la propagation vers l'autre Pad: " + e.getMessage());
                
            }
        }
        
        return null; 
    }
    
   
}