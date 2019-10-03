package com.invillia.member_jdbc;

import org.postgresql.ds.PGSimpleDataSource;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberDAO {
    private DataSource dataSource;

    public MemberDAO() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("tiago");
        dataSource.setPassword("123123");
        dataSource.setDatabaseName("incubadora");
        this.dataSource = dataSource;
    }

    public void insert(Member member){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(
                        "insert into member (name, team_id) values (?,?);");
                ){
            stmt.setString(1, member.getName());
            stmt.setLong(2,member.getTeam_id());
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Ocorreu um erro!");
            throw new RuntimeException(e);
        }
    }

    public List<Member> listAll(){
        try(
                Connection connection = dataSource.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select * from member;");
                ){
            List<Member> members = new ArrayList<>();

            while (rs.next()){
                Member member = new Member(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getLong("team_id"));
                members.add(member);
            }

            return members;
        }catch (SQLException e){
            System.out.println("Ocorreu um erro!");
            throw new RuntimeException(e);
        }
    }

    public Optional<Member> findById(long id){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(
                        "select id, name, team_id from member where id = ?");

                ){
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                return Optional.of(
                        new Member(rs.getLong("id"), rs.getString("name"), rs.getLong("team_id")) );
            }else{
                return Optional.empty();
            }
        }catch (SQLException e){
            System.out.println("Ocorreu um erro!");
            throw new RuntimeException(e);
        }
    }

    public void update(long id, UpdateMemberRequest updateMemberRequest){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(
                        "update member set name = ?, team_id = ? where id = ?;")
                ){
            stmt.setString(1, updateMemberRequest.getName());
            stmt.setLong(2, updateMemberRequest.getTeam_id());
            stmt.setLong(3, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Ocorreu um erro!");
            throw new RuntimeException(e);
        }
    }

    public void deleteById(long id){
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(
                        "delete from member where id = ?"
                )
                ){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Ocorreu um erro!");
            throw new RuntimeException(e);
        }
    }
}
