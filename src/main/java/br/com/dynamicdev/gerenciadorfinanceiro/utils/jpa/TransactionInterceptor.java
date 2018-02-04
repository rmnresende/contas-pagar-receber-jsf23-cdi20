package br.com.dynamicdev.gerenciadorfinanceiro.utils.jpa;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


/**
 * Quando encontrar a anotação @Transactional essa classe intercepta
 * @author renan
 *
 */
@Priority(value = 1000)
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	// com essa anotação, executa o método abaixo sempre antes de qualquer
    // método que possui a anotação @Transactional
    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {

        EntityTransaction transaction = manager.getTransaction();
        boolean owner = false;

        try {
            if (!transaction.isActive()) {
                /*truque para fazer rollback no que já passou
                (senão, um futuro commit, confirmaria até mesmo
                operações sem transação)*/
                transaction.begin();
                transaction.rollback();

                // agora sim inicia a transação
                transaction.begin();

                owner = true;
            }
            // aqui volta a executar o método que tem a anotação @Transactional
            return context.proceed();
            // quando o método termina volta neste ponto, para fazer o rollback ou o commit
        } catch (Exception e) {
            if (transaction != null && owner) {
                transaction.rollback();
            }

            throw e;
        } finally {
            if (transaction != null && transaction.isActive() && owner) {
                transaction.commit();
            }
        }
    }

}
