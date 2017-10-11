package com.foodkhana.utilities;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class NullGuard {

	public static <T> List<T> forList(List<T> list) {
	    if (list == null) {
	        return Collections.emptyList();
	    }
	    return list;
	}
	
	
	public static <T> Set<T> forSet(Set<T> set) {
	    if (set == null) {
	        return Collections.emptySet();
	    }
	    return set;
	}
}
