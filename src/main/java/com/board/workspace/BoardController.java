package com.board.workspace;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.workspace.BoardService;
import com.board.workspace.BoardVO;

@Controller //컨트롤러임을 명시
@RequestMapping(value= "/") //주소 패턴
public class BoardController {
	
	@Inject //주입임을 명시
	private BoardService service; //Service 호출을 위한 객체 생성 
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET) //주소 호출 명시.호출하려는 주소와 REST방식 설정(GET)
	public void listAll(Model model) throws Exception { //메소드 인자값은 model인터페이스(jsp를 전달하는 심부름꾼)
		model.addAttribute("list", service.listAll()); //jsp에 심부름할 내역(서비스 호출) 
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public void registerGET(BoardVO board,Model model)throws Exception{
		
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST) //post방식으로 내용 전송
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception{ //인자값으로 redirect사용 
		service.regist(board); //글작성 서비스 호출
		return "redirect:/listAll"; //작성이 완료된 후 목록 페이지로 리턴
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)//GET방식으로 페이지 호출 
	public void read(@RequestParam("bno")int bno, Model model) throws Exception{
		//인자값은 파라미터 값으로 기본키인 글번호를 기준으로 Model을 사용하여 불러옴
		model.addAttribute(service.read(bno)); //read서비스 호출
	}
	
	
}
