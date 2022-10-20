package com.example.repository.impl;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository implements ISongRepository {
    @Override
    public List<Song> findAll() {
        Session session = null;
        List<Song> songList;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            songList = session.createQuery("FROM Song ").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return songList;
    }

    @Override
    public void save(Song song) {
        Session session = null;
        Transaction transaction = null;

        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(song);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            if(session !=null){
                session.close();
            }

        }
    }

    @Override
    public void update(Song song) {
        Session session = null;
        Transaction transaction = null;

        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(song);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            if(session !=null){
                session.close();
            }

        }
    }

    @Override
    public Song findById(int id) {
        Session session = null;
        Song song;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            song = (Song) session.createQuery("FROM Song WHERE id = :id").setParameter("id", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return song;
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;

        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(findById(id));
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            if(session !=null){
                session.close();
            }

        }
    }
}
