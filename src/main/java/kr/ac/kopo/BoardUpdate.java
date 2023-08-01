package kr.ac.kopo;

import java.util.ArrayList;
import DAO.MBDao;
import DTO.MBDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardUpdate implements Service  {

    @Override
    public ArrayList<MBDto> execute(HttpServletRequest request, HttpServletResponse response, MBDto mbdto) {
        // TODO Auto-generated method stub
        MBDao mbdao = new MBDao();
        return mbdao.updateBoard(mbdto);    
        }

    @Override
    public ArrayList<MBDto> execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        return null;
    }
    

}
