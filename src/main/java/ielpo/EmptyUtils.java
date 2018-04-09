package ielpo; 

import java.util.ArrayList;
import java.util.Collection;

public class EmptyUtils {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> Collection<T> emptyIfNull(final Collection<T> collection) {        
		return collection == null ? new ArrayList() : collection;
    }
}
