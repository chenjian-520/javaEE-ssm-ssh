
package filter;
 
import java.io.IOException;
import java.util.Map;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
 
/**
 * 从application中获取Map
 * 从request中得到当前客户端的IP
 * 进行统计工作，结果保存到Map中
 * @author pp
 *
 */
public class Myfilter implements Filter {
 
	private FilterConfig config;//config.getServletContext();//获取上下文             
 
	/**
	 * 在服务器启动时就会执行本方法，而且本方法只执行一次！
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/**
		 * 1.得到application中的map
		 * 2.从request中获取当前客户端的IP地址
		 * 3.查看map中是否存在这个ip对应访问次数，如果存在，把次数+1再保存到map中
		 * 4.如果不存在这个Ip，那么说明是第一次访问本站，设置方位次数为1
		 */
		//1.得到application
		ServletContext application = config.getServletContext();//获取上下文                    
		//从application中把map拿出来	  这个map是在AListener监听器里面											   map
		Map<String,Integer> map = (Map<String, Integer>)application.getAttribute("map");
		//2.获取客户端的ip地址
		String ip = request.getRemoteAddr();//不用强转为HttpServletRequest,因为getRemoteAddr就在ServletRequest中
		//3.进行判断
		if(map.containsKey(ip)){//这个ip在map中存在，说明不是第一次访问
			int count = map.get(ip);//通过键ip获得对应的值count
			count++;//加1
			map.put(ip, count);//把加1后的count和ip存入map中
		} else{//这个ip在map中不存在，说明是第一次访问
			map.put(ip, 1);//第一次访问的ip记为1了
		}
		
		//application.setAttribute("map", map);//可不存？! 引用!再把map放回到application中
		chain.doFilter(request, response);//放行
	}
 
	public void destroy() {
		//
	}
 
}