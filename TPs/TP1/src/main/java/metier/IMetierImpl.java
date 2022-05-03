package metier;

import dao.IDaoImpl;
import org.springframework.beans.factory.annotation.Qualifier;

public class IMetierImpl implements IMetier{


    // la declaration de constructeur :
    //    public IMetierImpl(IDaoImpl dao) {
    //        this.dao = dao;
    //    }

    public IMetierImpl(){}
    IDaoImpl dao; // eq : dao = null
    @Override
    public double calcule() {
        double result = dao.getData()*2 ;
        return result ;
    }
    public void setDao(IDaoImpl dao) {
        this.dao = dao;
    }
}
