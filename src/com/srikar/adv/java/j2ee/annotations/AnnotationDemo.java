package com.srikar.adv.java.j2ee.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

// An Annotation type declaration
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
	String str();
	int val();
}

public class AnnotationDemo {
	
	@MyAnno(str="This is an Annotation", val = 100)
	public static void foo() {
		AnnotationDemo ad = new AnnotationDemo();
		try {
			Class<?> c = ad.getClass();
			Method m = c.getMethod("foo");
			MyAnno anno = m.getAnnotation(MyAnno.class);
			System.out.println("MyAnno str: " + anno.str() + ", val: " + anno.val());
		}
		catch(NoSuchMethodException ex) {
			System.err.println(ex);
		}
	}
	public static void main(String[] args) {
		foo();
	}
}
