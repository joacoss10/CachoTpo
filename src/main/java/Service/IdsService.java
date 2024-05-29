package Service;

import Repository.IdRepositorio;

public class IdsService {
    private static IdsService service;
    private static IdRepositorio repoId;

    private IdsService(){
        repoId=new IdRepositorio();
    }
    public static IdsService getService(){
        if(service==null){
            service=new IdsService();
        }
        return service;
    }
    public int getCatalogoId(){
        return repoId.getCatalogoId();
    }
}
