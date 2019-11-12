package com.learn.java.transaction;

import com.lm.po.Film;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/7/26
 * @Time:17:10
 * @Description:本代码测试三只松鼠中的一个事务问题
 */
public class TransactionTest {

    public static void main(String[] args) {
        TransactionTest transactionTest = new TransactionTest();
        transactionTest.updateFilmStatus();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateFilmStatus(){
        FilmDispose filmDispose = new FilmDispose();

        for (long i=1;i<=2;i++){
            Film film = filmDispose.selectFilmById(i);
            Film film1 = new Film();
            film1.setStatus("Q");
            film1.setFilmId(i);
            updateFilmStatusWithAtom(film1);
            film = filmDispose.selectFilmById(i);
            System.out.println(film);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    protected void updateFilmStatusWithAtom(Film film){
        FilmDispose filmDispose = new FilmDispose();
        filmDispose.updateFilmStatusById(film.getFilmId(),film.getStatus());
    }
}
