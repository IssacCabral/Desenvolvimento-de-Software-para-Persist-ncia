package dspersist.ui;

import dspersist.dao.CidadeDAOJDBC;
import dspersist.dao.CidadeDao;
import dspersist.model.Cidade;

import java.util.List;

public class App {
    public static void main(String[] args){
        CidadeDao cidadeDao = new CidadeDAOJDBC();
        List<Cidade> cidadeList = cidadeDao.findAll();
        for(Cidade c: cidadeList){
            System.out.println(c);
        }
    }
}
