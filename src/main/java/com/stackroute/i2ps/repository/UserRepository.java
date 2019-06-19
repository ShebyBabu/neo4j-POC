package com.stackroute.i2ps.repository;

import com.stackroute.i2ps.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository  extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();



   @Query("CREATE (u:User) SET u.id={userId},u.name={userName},u.age={age} RETURN u")
    public User saveNode(Long userId, String userName, int age);


    @Query("MATCH (u:User) WHERE u.id={id} DETACH DELETE u RETURN 'node deleted' ")

    public void delete(Long id);


    @Query("MATCH (u:User) WHERE u.name={userName} RETURN u")
    public User findByName(@Param("userName") String userName);


 @Query("MATCH (User) DETACH DELETE User")
public void deleteAll();


 @Query("MATCH (u:User)-[r:LIKES]->(m:Movie) RETURN u,r,m")
    public User getActedMoviesList();


    //query creating relationship between all user and movie nodes
 @Query("MATCH (a:User),(b:Movie) WHERE a.id > 0 CREATE (a)-[r:LIKES]->(b) RETURN r")
 public User createRelationship();

    @Query("MATCH (a:User)-[r:LIKES]->(m:Movie) DELETE r")
    public void deleteRelationship();

// @Query("MATCH (a:User),(b:Movie) WHERE a.id = {userId} CREATE (a) SET a.id={userId})-[r:LIKES]->(b) SET b.id={userId}) RETURN r")

@Query("MATCH (u:User) WHERE u.id={userId} SET u.name={userName},u.age={age} RETURN u")
 User updateUser(long userId,String userName,int age);
}
