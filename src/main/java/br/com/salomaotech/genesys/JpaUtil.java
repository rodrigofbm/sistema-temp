package br.com.salomaotech.genesys;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory factory;

    static {

        factory = Persistence.createEntityManagerFactory("Conexao");

    }

    public static EntityManagerFactory getFactory() {
        return factory;
    }

}
