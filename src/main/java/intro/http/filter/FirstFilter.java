package intro.http.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class FirstFilter
 */
@WebFilter(filterName="firstFilter", urlPatterns={"/*"})
public class FirstFilter implements Filter {

	private final Logger logger = LoggerFactory.getLogger(FirstFilter.class);
	
	private List<Locale> supportedLanguages = new LinkedList<>();
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		logger.trace("ENTER destroy()");
		logger.trace("EXIT destory()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	throws IOException, ServletException {
		logger.trace("ENTER doFilter(request,response)");
		
		if (logger.isDebugEnabled()) {
			logger.debug("Default Locale: {}", request.getLocale());
			
			Enumeration<Locale> locales = request.getLocales();
			while (locales.hasMoreElements()) {
				logger.debug("Browser other locales: {}", locales.nextElement());
			}
		}
		
		final String lang = request.getParameter("lang");
		final Locale workingLang;
		
		if (lang == null) {
			workingLang = supportedLanguages.get(0);
		} else if (supportedLanguages.contains(new Locale(lang))) {
			workingLang = new Locale(lang);
		} else {
			workingLang = supportedLanguages.get(0);
		}
		
		request.setAttribute("workingLang", workingLang);
		
		// pass the request along the filter chain
		try {
			
			chain.doFilter(request, response);
		} finally {
			logger.trace("EXIT doFilter(request,response)");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		logger.trace("ENTER init(fConfig)");
		
		supportedLanguages.add(new Locale("en_CA"));
		supportedLanguages.add(new Locale("en_US"));
		supportedLanguages.add(Locale.ENGLISH);
		
		logger.trace("EXIT init(fConfig)");
	}
}
