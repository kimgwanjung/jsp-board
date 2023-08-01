package kr.ac.kopo;

import java.util.ArrayList;
import DAO.MBDao;
import DTO.MBDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardSelect implements Service {
    public ArrayList<MBDto> execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        MBDao mbdao = new MBDao();
        int page = 1;
        int limit = 10;
  
        
        return mbdao.getBoardList(page, limit);
    }

    @Override
    public ArrayList<MBDto> execute(HttpServletRequest request, HttpServletResponse response,
            MBDto member) {
        // TODO Auto-generated method stub
        return null;
    }
}
