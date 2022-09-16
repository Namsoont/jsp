package co.micol.prj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {  //실행할 Command
	String exec(HttpServletRequest request,HttpServletResponse response);
}
