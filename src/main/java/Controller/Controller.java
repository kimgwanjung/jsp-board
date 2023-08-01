package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.BoardDelete;
import kr.ac.kopo.BoardInsert;
import kr.ac.kopo.BoardRead;
import kr.ac.kopo.BoardReply;
import kr.ac.kopo.BoardSelect;
import kr.ac.kopo.BoardUpdate;
import kr.ac.kopo.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import DAO.MBDao;
import DTO.MBDto;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    System.out.println("get");
	    actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    System.out.println("post");
	    
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("actionDo");
	    
	    String viewPage = null;
	    
	    String uri = request.getRequestURI();
	    String comPath = request.getContextPath();
	    String command = uri.substring(comPath.length());
	    
	    System.out.println(command);
	    
	    if(command.equals("/memberAll.do")){
	        
	        
	        
	    }else if(command.equals("/write_view.do") || command.equals("/View/write_view.do")) {
	        Service svc = new BoardSelect();
	        viewPage = "viewPage.jsp";
	        System.out.println("test");
	        
	        ArrayList<MBDto> board = svc.execute(request, response);
	        
	        for(int i = 0; i < board.size(); i++) {
	            MBDto mbdto = board.get(i);
	            
	            int num = mbdto.getBOARD_NUM();
                String name = mbdto.getBOARD_NAME();
                String subject = mbdto.getBOARD_SUBJECT();
                String content = mbdto.getBOARD_CONTENT();
                int re_ref = mbdto.getBOARD_RE_REF();
                int re_lev = mbdto.getBOARD_RE_LEV();
                int re_seq = mbdto.getBOARD_RE_SEQ();
                int readCount = mbdto.getBOARD_READCOUNT();
                Date date = mbdto.getBOARD_DATE();

	        }
	        request.setAttribute("board", board);
	        
 	    }else if (command.equals("/write.do")) {
 	      viewPage = "/write_view.do";
 	        
 	      String boardName = request.getParameter("BOARD_NAME");
 	      String boardSubject = request.getParameter("BOARD_SUBJECT");
 	      String boardContent = request.getParameter("BOARD_CONTENT");
 	      System.out.println(boardName);
 	      System.out.println(boardSubject);
 	      System.out.println(boardContent);
 	    
 	      // Create a new instance of MBDto and set the values
 	      MBDto member = new MBDto();
 	      member.setBOARD_NAME(boardName);
 	      member.setBOARD_SUBJECT(boardSubject);
 	      member.setBOARD_CONTENT(boardContent);

 	     
 	      Service svc = new BoardInsert();

 	     
 	      ArrayList<MBDto> result = svc.execute(request, response, member);

 	      
 	      request.setAttribute("insert", result);

 	     
 	  }else if (command.equals("/update.do")) {
 	     viewPage = "/write_view.do";
 	     
 	     int boardNum = Integer.parseInt(request.getParameter("boardNum"));
 	     String boardName = request.getParameter("boardName");
         String boardSubject = request.getParameter("boardSubject");
         String boardContent = request.getParameter("boardContent");
         
         MBDto member = new MBDto();
         member.setBOARD_NUM(boardNum);
         member.setBOARD_NAME(boardName);
         member.setBOARD_SUBJECT(boardSubject);
         member.setBOARD_CONTENT(boardContent);
         
         Service svc = new BoardUpdate();

         
         ArrayList<MBDto> result = svc.execute(request, response, member);

         
         request.setAttribute("update", result);
         
 	  }else if (command.equals("/read.do")) {
 	      
 	     viewPage = "/modify.jsp";
 	     
 	     int boardNum = Integer.parseInt(request.getParameter("boardNum"));
 	     String boardName =request.getParameter("boardName");
 	     int boardReadCount = Integer.parseInt(request.getParameter("boardReadCount"));
 	     String boardContent = request.getParameter("boardContent");
 	     String boardSubject = request.getParameter("boardSubject");
 	     int boardLev = Integer.parseInt(request.getParameter("boardLev"));
 	    
 	     System.out.println(boardNum);
 	     MBDto member = new MBDto();
         member.setBOARD_NUM(boardNum);
         member.setBOARD_NAME(boardName);
         member.setBOARD_CONTENT(boardContent);
         member.setBOARD_READCOUNT(boardReadCount);
         member.setBOARD_SUBJECT(boardSubject);
         member.setBOARD_RE_LEV(boardLev);
         
         Service svc = new BoardRead();
     	 
         ArrayList<MBDto> result = svc.execute(request, response, member);
         
         request.setAttribute("read", result);
         
 	  }else if(command.equals("/delete.do")) {
     	    viewPage = "/write_view.do";
     	     
     	    int boardNum = Integer.parseInt(request.getParameter("boardNum"));
         	     
     	    MBDto member = new MBDto();
     	    
          	member.setBOARD_NUM(boardNum);
    
            
            Service svc = new BoardDelete();

        
        ArrayList<MBDto> result = svc.execute(request, response, member);
        request.setAttribute("delete", result);
        
 	  }else if(command.equals("/delete2.do")) {
 	     viewPage = "/write_view.do";

 	    // boardNum 값을 배열로 받아옵니다.
 	    String[] boardNumArray = request.getParameterValues("boardNum[]");

 	    Service svc = new BoardDelete();

 	    ArrayList<MBDto> result = new ArrayList<>();

 	    if (boardNumArray != null) {
 	        for(String boardNum : boardNumArray) {
 	            MBDto member = new MBDto();
 	            member.setBOARD_NUM(Integer.parseInt(boardNum));
 	            result.addAll(svc.execute(request, response, member));
 	        }
 	    }

 	    request.setAttribute("delete2", result);
 	}
 	  else if(command.equals("/reply.do")) {
 	      viewPage = "/write_view.do";
 	      
 	      int boardNum = Integer.parseInt(request.getParameter("boardNum"));
 	      String boardName =request.getParameter("boardName");
          String boardContent = request.getParameter("boardContent");
          String boardSubject = request.getParameter("boardSubject");
          int boardLev = Integer.parseInt(request.getParameter("boardLev"));
          
     	  MBDto member = new MBDto();
          member.setBOARD_NUM(boardNum);
          member.setBOARD_NAME(boardName);
          member.setBOARD_CONTENT(boardContent);
          member.setBOARD_SUBJECT(boardSubject);
          member.setBOARD_RE_LEV(boardLev);
          
          Service svc = new BoardReply();
          ArrayList<MBDto> result = svc.execute(request, response, member);
          request.setAttribute("reply", result);
 	  }
	    
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);
	}
	

}
