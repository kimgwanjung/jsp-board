package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import DTO.MBDto;
import DAO.MBDao;

public class MBDao {
    
    private String url = "jdbc:oracle:thin:@192.168.119.119:1521:db";
    private String username = "scott";
    private String password = "tiger";
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    
    public MBDao() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(Exception e) {
            e.printStackTrace();
        }    
    }
    
   
/*
 * 
 * 게시글 리스트
 * */
    public  ArrayList<MBDto> getBoardList(int page, int limit) {
        ArrayList<MBDto> dtos = new ArrayList<>();
        String board_list_sql="SELECT * FROM board START WITH board_re_ref = 0 CONNECT BY PRIOR board_num = board_re_ref ORDER SIBLINGS BY board_re_lev ASC ";
        
        try{
            con = DriverManager.getConnection(url, username, password);
            pstmt = con.prepareStatement(board_list_sql); 
            rs = pstmt.executeQuery(); //가져온 레코드 값을 rs에 담고.. 담은 객체들을 하나하나 뿌려준다. 
             
            while(rs.next()){ 
                int num = rs.getInt("BOARD_NUM");
                String name = rs.getString("BOARD_NAME");
                String subject = rs.getString("BOARD_SUBJECT");
                String content = rs.getString("BOARD_CONTENT");
                int re_ref = rs.getInt("BOARD_RE_REF");
                int re_lev = rs.getInt("BOARD_RE_LEV");
                int re_seq = rs.getInt("BOARD_RE_SEQ");
                int readCount = rs.getInt("BOARD_READCOUNT");
                Date date = rs.getDate("BOARD_DATE");
                
                MBDto board = new MBDto(num, name, subject, content, re_ref, re_lev, re_seq, readCount, date); 
                dtos.add(board); 
            }             
            return dtos; 
        }catch(Exception ex){ 
            System.out.println("getBoardList 에러 : " + ex); 
        }finally{ 
            if(rs!=null) try{rs.close();}catch(SQLException ex){} 
            if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){} 
        } 
        return null; 
    }
    
    
/*
 * 게시글 삽입
 * */
    public ArrayList<MBDto> insertBoard(MBDto member) {
        ArrayList<MBDto> dtos = new ArrayList<>();

        // Retrieve the necessary values from the member object
        String boardName = member.getBOARD_NAME();
        String boardSubject = member.getBOARD_SUBJECT();
        String boardContent = member.getBOARD_CONTENT();
        System.out.println(boardName);

        try {
            // Establish the database connection
            con = DriverManager.getConnection(url, username, password);
            
            String insert_sql = "INSERT INTO board (BOARD_NUM, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE) VALUES (board_seq.NEXTVAL, ?, ?, ?, ?, ?, re_seq.NEXTVAL, ?, SYSDATE)";
            pstmt = con.prepareStatement(insert_sql);
            pstmt.setString(1, boardName);
            pstmt.setString(2, boardSubject);
            pstmt.setString(3, boardContent);
            pstmt.setInt(4, 0); // Set boardReRef to 0 if it's null
            pstmt.setInt(5, 0); // Set boardReadCount to 0 if it's null
            pstmt.setInt(6, 0); 
            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
           
        }

        return dtos;
    }
    
/*
 * 
 * 게시글 수정
 * */
    public ArrayList<MBDto> updateBoard(MBDto member) {
        ArrayList<MBDto> dtos = new ArrayList<>();

        // Retrieve the necessary values from the member object
        int boardNum = member.getBOARD_NUM();
        String boardName = member.getBOARD_NAME();
        String boardSubject = member.getBOARD_SUBJECT();
        String boardContent = member.getBOARD_CONTENT();
        System.out.println(boardName);

        try {
            // Establish the database connection
            con = DriverManager.getConnection(url, username, password);
            
            // SQL query to update the board
            String update_sql = "UPDATE board SET BOARD_NAME = ?, BOARD_SUBJECT = ?, BOARD_CONTENT = ? WHERE BOARD_NUM = ?";
            pstmt = con.prepareStatement(update_sql);
            pstmt.setString(1, boardName);
            pstmt.setString(2, boardSubject);
            pstmt.setString(3, boardContent);
            pstmt.setInt(4, boardNum);
            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close the resources
            // TODO: Implement closing of resources
        }

        return dtos;
    }
    
/*
 * 게시글 조회
 * */
    public ArrayList<MBDto> readBoard(MBDto mbdto) {
        ArrayList<MBDto> dtos = new ArrayList<>();
        int boardNum = mbdto.getBOARD_NUM();

        try {
            con = DriverManager.getConnection(url, username, password);


            String select_sql = "SELECT BOARD_READCOUNT FROM board WHERE BOARD_NUM = ?";
            pstmt = con.prepareStatement(select_sql);
            pstmt.setInt(1, boardNum);
            ResultSet rs = pstmt.executeQuery();

 
            if (rs.next()) {
                System.out.println(rs.getInt("BOARD_READCOUNT"));
                int currentReadCount = rs.getInt("BOARD_READCOUNT");
                int newReadCount = currentReadCount + 1;
                System.out.println(newReadCount);
   
                String update_sql = "UPDATE board SET BOARD_READCOUNT = ? WHERE BOARD_NUM = ?";
                pstmt = con.prepareStatement(update_sql);
                
                pstmt.setInt(1, newReadCount);
                pstmt.setInt(2, boardNum);
                pstmt.executeUpdate();
            } else {
                
            }

            dtos = getBoardList(1, 10); // getBoardList() 메서드가 존재한다고 가정
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            
        }

        return dtos;
    }
/*
 * 게시글 삭제
 * */
    public ArrayList<MBDto> deleteBoard(MBDto mbdto) {
        ArrayList<MBDto> dtos = new ArrayList<>();
        int boardNum = mbdto.getBOARD_NUM();

        try {   
            con = DriverManager.getConnection(url, username, password);
           
            String select_sql = "SELECT BOARD_NUM FROM board WHERE BOARD_NUM = ?";
            pstmt = con.prepareStatement(select_sql);
            pstmt.setInt(1, boardNum);
            ResultSet rs = pstmt.executeQuery();

            
            if (rs.next()) {
                String delete_sql = "DELETE FROM board WHERE BOARD_NUM = ?";
                pstmt = con.prepareStatement(delete_sql);
                pstmt.setInt(1, boardNum);
                pstmt.executeUpdate();
            } else {
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close the resources
            // TODO: Implement closing of resources
        }

        return dtos;
    }
    /*
     * 게시글 답글
     * */
    public ArrayList<MBDto> replyBoard(MBDto mbdto, int beforeId) {
        ArrayList<MBDto> dtos = new ArrayList<>();

        int boardNum = mbdto.getBOARD_NUM();
        String boardName = mbdto.getBOARD_NAME();             
        String boardContent = mbdto.getBOARD_CONTENT();
        String boardSubject = mbdto.getBOARD_SUBJECT();
        System.out.println(boardSubject);
        int boardLev = mbdto.getBOARD_RE_LEV();

        System.out.println("boardLev" + boardLev);
        String select_sql = "SELECT BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT " +
                            "FROM board WHERE BOARD_NUM = ?";
        String insert_sql = "INSERT INTO board (BOARD_NUM, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE) " +
                            "VALUES (board_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, 0, SYSDATE)";

        try {
            con = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = con.prepareStatement(select_sql);
            pstmt.setInt(1, boardNum);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int currentReadCount = rs.getInt("BOARD_RE_LEV");
                int newReadCount = currentReadCount + 1;
                int parentRef = rs.getInt("BOARD_RE_REF");
                int parentSeq = rs.getInt("BOARD_RE_SEQ");
                

                parentRef++;
                pstmt = con.prepareStatement(insert_sql);
                pstmt.setString(1, boardName);
                pstmt.setString(2, boardSubject);
                pstmt.setString(3, boardContent);
                // 상위 게시글의 id를 참조하기 위해 상위 id의 값을 넣는다.
                pstmt.setInt(4, beforeId);
                pstmt.setInt(5, newReadCount);
                System.out.println("newReadCount " +newReadCount);
                pstmt.setInt(6, parentSeq);
                pstmt.executeUpdate();
            } else {
                // BOARD_NUM does not exist, handle accordingly
                // TODO: Implement appropriate error handling or logic
            }

            dtos = getBoardList(1, 10); // getBoardList() 메서드가 존재한다고 가정
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close the resources
            // TODO: Implement closing of resources
        }

        return dtos;
    }


    

}
