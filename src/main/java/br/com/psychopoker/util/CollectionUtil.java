package br.com.psychopoker.util;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtil {

	public static <T> String join(Collection<T> collection, String separator) {
		StringBuilder builder = new StringBuilder();
		Iterator<T> it = collection.iterator();
		
		if (it.hasNext()) {
			builder.append(it.next());
		}
		while (it.hasNext()) {
			builder.append(separator).append(it.next());
		}

		return builder.toString();
	}
}