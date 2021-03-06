package presentation;

import dao.IDaoImpl;
import metier.Calcule;
import metier.IMetierImpl;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
//        System.out.println("La version Statique !!");
//        IDaoImpl dao = new IDaoImpl();
//        IMetierImpl metier = new IMetierImpl(dao);
//        metier.setDao(dao);
//        System.out.println(metier.calcule());
        /*
           Pour eviter l'initialisation statique
           on peut le faire d'une facon dynamique presenter comme suit:
         */
        // la declaration de la class DAO:
        Scanner scanner = new Scanner(new File("classes.txt"));
        String ClassNameDao = scanner.nextLine();
        Class DAO = Class.forName(ClassNameDao) ;
        IDaoImpl dao1 =(IDaoImpl) DAO.newInstance() ;
        // la declaration de la class Metier :
        Class METIER = Class.forName("metier.IMetierImpl") ;
        IMetierImpl metier1 = (IMetierImpl) METIER.newInstance() ;
        Method methode = metier1.getClass().getMethod("setDao", IDaoImpl.class);
        methode.invoke(metier1, dao1);
        System.out.println("La version Dynamique !!");
        System.out.println(metier1.calcule());
        /************************************************/
        System.out.println("Les Tests !");
    }
}
