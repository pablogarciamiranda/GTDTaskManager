package uo.sdi.rest.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.infraestructure.Factories;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/rest/*" })
public class RestFilter implements Filter {
	FilterConfig config = null;

	UserService service = Factories.services.getUserService();

	/**
	 * Default constructor.
	 */
	public RestFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		config = fConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (!(request instanceof HttpServletRequest)) {
			chain.doFilter(request, response);
			return;
		}
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String login = "";
		String password = "";
		if (req.getHeader("Host").equals("localhost:8280")) {
			String authorizationBase64 = req.getHeader("Authorization");
			String[] authorizationBase64aux = authorizationBase64.split(" ");
			String authorization = decode(authorizationBase64aux[1]);

			String[] credentials = authorization.split(":");
			login = credentials[0];
			password = credentials[1];
		} else if (req.getHeader("Host").equals("10.0.2.2:8280")) {
			login = "admin1";
			password = "admin1";
		}
		User user = null;
		try {
			user = service.findLoggableUser(login);
		} catch (BusinessException e) {
			res.sendError(javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		if (user == null) {
			res.sendError(javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		if (!user.getPassword().equals(password)) {
			res.sendError(javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
		chain.doFilter(request, res);
	}

	private static String radixBase64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "abcdefghijklmnopqrstuvwxyz" + "0123456789" + "+/";

	private static String decode(String string) {
		String binary_string = "";
		for (char c : string.toCharArray()) {
			if (c == '=')
				break;
			String char_to_binary = Integer.toBinaryString(radixBase64
					.indexOf(c));
			while (char_to_binary.length() < 6)
				char_to_binary = "0" + char_to_binary;
			binary_string += char_to_binary;
		}
		if (string.endsWith("=="))
			binary_string = binary_string.substring(0,
					binary_string.length() - 4);
		else if (string.endsWith("="))
			binary_string = binary_string.substring(0,
					binary_string.length() - 2);
		string = "";
		for (int i = 0; i < binary_string.length(); i += 8) {
			String eight_binary_digits = binary_string.substring(i, i + 8);
			string += (char) Integer.parseInt(eight_binary_digits, 2);
		}
		return string;
	}
}