package br.com.dynamicdev.gerenciadorfinanceiro.utils.jpa;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * Esta e a classe responsave pela anotacao @Transactional
 * quer sera anotada em todo metodo que fizer uma transacao
 * no banco de dados
 * @author renan
 *
 */
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Transactional {

}
