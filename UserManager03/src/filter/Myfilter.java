
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
 * ��application�л�ȡMap
 * ��request�еõ���ǰ�ͻ��˵�IP
 * ����ͳ�ƹ�����������浽Map��
 * @author pp
 *
 */
public class Myfilter implements Filter {
 
	private FilterConfig config;//config.getServletContext();//��ȡ������             
 
	/**
	 * �ڷ���������ʱ�ͻ�ִ�б����������ұ�����ִֻ��һ�Σ�
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/**
		 * 1.�õ�application�е�map
		 * 2.��request�л�ȡ��ǰ�ͻ��˵�IP��ַ
		 * 3.�鿴map���Ƿ�������ip��Ӧ���ʴ�����������ڣ��Ѵ���+1�ٱ��浽map��
		 * 4.������������Ip����ô˵���ǵ�һ�η��ʱ�վ�����÷�λ����Ϊ1
		 */
		//1.�õ�application
		ServletContext application = config.getServletContext();//��ȡ������                    
		//��application�а�map�ó���	  ���map����AListener����������											   map
		Map<String,Integer> map = (Map<String, Integer>)application.getAttribute("map");
		//2.��ȡ�ͻ��˵�ip��ַ
		String ip = request.getRemoteAddr();//����ǿתΪHttpServletRequest,��ΪgetRemoteAddr����ServletRequest��
		//3.�����ж�
		if(map.containsKey(ip)){//���ip��map�д��ڣ�˵�����ǵ�һ�η���
			int count = map.get(ip);//ͨ����ip��ö�Ӧ��ֵcount
			count++;//��1
			map.put(ip, count);//�Ѽ�1���count��ip����map��
		} else{//���ip��map�в����ڣ�˵���ǵ�һ�η���
			map.put(ip, 1);//��һ�η��ʵ�ip��Ϊ1��
		}
		
		//application.setAttribute("map", map);//�ɲ��棿! ����!�ٰ�map�Żص�application��
		chain.doFilter(request, response);//����
	}
 
	public void destroy() {
		//
	}
 
}