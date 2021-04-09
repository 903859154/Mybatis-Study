package utils;

import org.junit.Test;

import java.beans.Transient;
import java.util.UUID;

public class IDutils {

	public static String getId(){
		return UUID.randomUUID().toString().replace("-","");
	}

	@Test
	public void test(){
		System.out.println(IDutils.getId());
		System.out.println(IDutils.getId());
		System.out.println(IDutils.getId());
	}
}
