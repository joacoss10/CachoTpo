package Service;

import Excepciones.ClienteExeption;
import Model.Cliente;
import Repository.ClienteRepository;

public class ClienteService {
    private static ClienteService s;
    private final ClienteRepository repoCliente;

    private ClienteService(){
        this.repoCliente=new ClienteRepository();
    }
    public static ClienteService getInstance(){
        if(s==null){
            s=new ClienteService();
        }
        return s;
    }
    public void nuevoCliente(Cliente c){
        repoCliente.guardarCLiente(c);
    }
    public void agregarPedido(int idCLiente,String idPedido){
        repoCliente.agregarPedido(idCLiente,idPedido);
    }
    public Cliente recuperarCliente(int idCliente) throws ClienteExeption {
        Cliente c=repoCliente.obtenerCliente(idCliente);
        if (c==null){
            throw new ClienteExeption("El cliente no existe");
        }else return c;
    }
}
