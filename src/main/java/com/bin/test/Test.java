package com.bin.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	static List<Invocation> invocations = new ArrayList<>() ;
	static {
		invocations.add(new Invocation()) ;
		invocations.add(new Invocation()) ;
		invocations.add(new Invocation()) ;
	}
	
	public static void main(String[] args) {
		new Test().ActionExcute();;
	}

	public boolean ActionExcute() {
		return true ;
	}
}
