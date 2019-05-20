package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.User;

/**
 * ���û�������صĺ�˿�����
 */
@Controller
public class UserContoller {

	//�����뷽��ӳ��
	//����ֵ  ��ͼ����    /show.jsp
	/*@RequestMapping("/user.do")
	public String login(User user,String[] hobby){
		System.out.println(user);
		System.out.println(Arrays.toString(hobby));
		return "show";
	}*/
	
	@RequestMapping("/user.do")
	public String login(User user,Model model){
		model.addAttribute("user",user);
		return "forward:toshow.do";
	}
	
	@RequestMapping("/toshow.do")
	public String toShow(){
		System.out.println("show");
		return "show";
	}
}
