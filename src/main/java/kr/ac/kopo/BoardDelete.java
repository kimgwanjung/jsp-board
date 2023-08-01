package kr.ac.kopo;

import java.util.ArrayList;
import DAO.MBDao;
import DTO.MBDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardDelete implements Service {

    @Override
    public ArrayList<MBDto> execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<MBDto> execute(HttpServletRequest request, HttpServletResponse response,
            MBDto mbdto) {
        MBDao mbdao = new MBDao();
        return mbdao.deleteBoard(mbdto);
    }

}
