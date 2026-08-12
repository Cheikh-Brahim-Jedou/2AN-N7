import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class RRecordImpl extends UnicastRemoteObject implements RRecord {
    private String name;
    private String email;

   
    public RRecordImpl(String name, String email) throws RemoteException {
        super(); 
        this.name = name;
        this.email = email;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public String getEmail() throws RemoteException {
        return email;
    }
    
    
    @Override
    public String toString() {
        return "Nom: " + name + ", Email: " + email;
    }
}