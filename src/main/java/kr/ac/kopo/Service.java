package kr.ac.kopo;

import java.util.ArrayList;
import DTO.MBDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Service {
    
      public ArrayList<MBDto> execute(HttpServletRequest request, HttpServletResponse response);
      public ArrayList<MBDto> execute(HttpServletRequest request, HttpServletResponse response, MBDto member);
}
