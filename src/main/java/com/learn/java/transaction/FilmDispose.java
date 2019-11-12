package com.learn.java.transaction;

import com.learn.db.JdbcUtils;
import com.lm.po.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/7/31
 * @Time:10:07
 */
public class FilmDispose {

    /**
     * 根据id查询电影
     * @param filmId
     * @return
     */
    public Film selectFilmById(Long filmId){
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from film where film_id = ?";
        Film film = new Film();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,filmId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                film.setFilmId(resultSet.getLong("film_id"));
                film.setStatus(resultSet.getString("STATUS"));
                film.setObjectVersionNumber(resultSet.getLong("OBJECT_VERSION_NUMBER"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  film;
    }

    /**
     * 根据id更新电影状态
     * @param filmId
     * @return
     */
    public int updateFilmStatusById(Long filmId,String status){
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        String sql = "update film set status = ?,object_version_number = object_version_number+1 where film_id = ?";
        Film film = new Film();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,status);
            preparedStatement.setLong(2,filmId);
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
