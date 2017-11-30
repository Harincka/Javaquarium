package com.javaquarium.util;

import java.util.Map;

public class SessionUtils {

	@SuppressWarnings("unchecked")
	public static int countNumberOfPoisson(final Object sessionUserPoisson) {
		int count = 0;
		if (sessionUserPoisson != null) {
			for (String key : ((Map<String, Integer>) sessionUserPoisson).keySet()) {
				count = count 
						+ ((Map<String, Integer>) sessionUserPoisson)
						.get(key);
			}
		}
		return count;
	}

}