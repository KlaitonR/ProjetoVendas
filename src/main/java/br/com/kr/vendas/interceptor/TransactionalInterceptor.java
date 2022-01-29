package br.com.kr.vendas.interceptor;

import br.com.kr.vendas.anotation.Transactional;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

@Interceptor
@Transactional
public class TransactionalInterceptor implements Serializable {

    @Inject
    private EntityManager em;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception{
        EntityTransaction transction = em.getTransaction();
        Object result = null;

        try{
            if(!transction.isActive()){
                transction.begin();
                result = context.proceed();
                if(!transction.getRollbackOnly()){
                    transction.commit();
                }else{
                    transction.rollback();
                }
            }
        }catch (Exception e){
            if(transction.isActive()){
                e.printStackTrace();
                transction.rollback();
                System.out.println("Transação não efetuada, rollbck executado");
            }
        }

        return result;
    }

}
